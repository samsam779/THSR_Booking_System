package ticket;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tcg.json.JSONUtils;

public class bookingChange {// 用來更改人數和退票的class
	private String uid, ticketCode;
	private int payment;
	public JSONObject seatStoring = JSONUtils.getJSONObjectFromFile("/seat_1.json");

	public bookingChange(String uid, String ticketCode) {
		this.uid = uid;
		this.ticketCode = ticketCode;
	}

	JSONObject booking = JSONUtils.getJSONObjectFromFile("/booking.json");
	JSONArray cusInfo = booking.getJSONArray("book");

	public void cancel() {// cancel將符合uid和ticketCode的訂單刪除

		for (int i = 0; i < cusInfo.length(); i++) {

			if (((JSONObject) cusInfo.get(i)).getString("uid").equals(uid)
					&& ((JSONObject) cusInfo.get(i)).getString("code").equals(ticketCode)) {
				cancelSeat();// 將位置從seat_1的json檔案中移除
			}
			canceldata();// 將訂票資料從booking json檔案中移除
		}

	}

	public void numberChange(int m) {// 改變人數，僅能小於原本之訂票數
		try {
			try {
				int originN = 0;

				for (int i = 0; i < cusInfo.length(); i++) {
					String canceledSeat;
					if (((JSONObject) cusInfo.get(i)).getString("uid").equals(uid)
							&& ((JSONObject) cusInfo.get(i)).getString("code").equals(ticketCode)) {
						payment = (int) ((JSONObject) cusInfo.get(i)).get("payment");// 取得原本價格
						originN = (int) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").length();// 取得原本之票數

					}
				}

				for (int y = 0; y < (originN - m); y++) {
					for (int i = 0; i < cusInfo.length(); i++) {
						String canceledSeat;// 暫存將被刪除的位置資訊
						if (((JSONObject) cusInfo.get(i)).getString("uid").equals(uid)
								&& ((JSONObject) cusInfo.get(i)).getString("code").equals(ticketCode)) {

							int tmp = (int) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").length();
							String trainNo = ((JSONObject) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo")
									.get(tmp - 1)).getString("trainNo");// 取得列車號碼
							canceledSeat = ((JSONObject) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo")
									.get(tmp - 1)).getJSONArray("seats").getString(0);// 暫存將被刪除的位置資訊
							((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").remove(tmp - 1);// 將訂單中最後一個個別資料從booking
																										// json中刪除

							for (int k = 0; k < seatStoring.getJSONArray(trainNo).length(); k++) {

								if (seatStoring.getJSONArray(trainNo).get(k).equals(canceledSeat)) {
									seatStoring.getJSONArray(trainNo).remove(k);// 將被移除的資料中的位置從seat_1 json中移除
								}

							}
						}
					}
				}

				payment = (payment / originN) * m;// 設定新payment
				try {
					try {
						for (int y = 0; y < (originN - m); y++) {
							for (int i = 0; i < cusInfo.length(); i++) {
								String canceledSeat;
								if (((JSONObject) cusInfo.get(i)).getString("uid").equals(uid)
										&& ((JSONObject) cusInfo.get(i)).getString("code").equals(ticketCode)) {

									((JSONObject) cusInfo.get(i)).remove("payment");// 移除原本的payment
									((JSONObject) cusInfo.get(i)).put("payment", payment);// 新增更改後的payment

								}
							}
						}
						String ws = booking.toString();
						BufferedWriter bw = new BufferedWriter(new FileWriter("assets/booking.json"));
						bw.write(ws);
						bw.newLine();
						bw.flush();
						bw.close();
					} catch (JSONException e) {
						e.printStackTrace();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

				String ws = booking.toString();
				BufferedWriter bw = new BufferedWriter(new FileWriter("assets/booking.json"));
				bw.write(ws);
				bw.newLine();
				bw.flush();
				bw.close();
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void canceldata() {// 將訂單資料從booking json中移除
		try {
			try {

				for (int i = 0; i < cusInfo.length(); i++) {
					JSONObject tmp1 = new JSONObject(cusInfo.get(i).toString());
					if (tmp1.get("code").equals(ticketCode) && tmp1.get("uid").equals(uid)) {
						cusInfo.remove(i);// 將檔案移除
					}
				}
				String ws = booking.toString();
				BufferedWriter bw = new BufferedWriter(new FileWriter("assets/booking.json"));
				bw.write(ws);
				bw.newLine();
				bw.flush();
				bw.close();
			} catch (JSONException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void cancelSeat() {// 將特定位置資料從seat_1.json中移除

		for (int i = 0; i < cusInfo.length(); i++) {

			if (((JSONObject) cusInfo.get(i)).getString("uid").equals(uid)
					&& ((JSONObject) cusInfo.get(i)).getString("code").equals(ticketCode)) {
				int tmp = (int) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").length();

				for (int j = 0; j < ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").length(); j++) {
					String trainNo = ((JSONObject) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").get(j))
							.getString("trainNo");// 暫存列車號碼
					String seatString = ((JSONObject) ((JSONObject) cusInfo.get(i)).getJSONArray("ticketInfo").get(j))
							.getJSONArray("seats").getString(0);// 暫存座位資訊
					do {
						for (int k = 0; k < seatStoring.getJSONArray(trainNo).length(); k++) {

							if (seatStoring.getJSONArray(trainNo).get(k).equals(seatString)) {
								seatStoring.getJSONArray(trainNo).remove(k);// 將位置資料移除
							}

						}
						tmp--;
					} while (tmp > 0);
				}
			}
		}
		seatupdate();// 更新seat_1.json的資料

	}

	private void seatupdate() {// 更新seat_1.json的資料
		try {
			String ws;
			ws = seatStoring.toString();
			BufferedWriter bw = new BufferedWriter(new FileWriter("assets/seat_1.json"));
			bw.write(ws);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
