package ticket;

import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONArray;
import com.tcg.json.JSONUtils;

public class ticketBooked {
	private String trainNo;							//車次
	private int car;								//車廂
	private String line;							//排數
	private String actualSeatType;					//座位編號A,B,C,D,E
	private String uid;
	private String seatString;						//座位，格式:car-line-actualSeatType
	private String seatString2;						//座位，格式:car-line-actualSeatType
	private String[] seatArray=new String[10] ;		//儲存seatString的陣列
	private int number;								//票數
	private int ticketCode;							//訂票代碼
	private String ticketType;						//票種
	private String seatType;						//靠窗、走道、無
	private boolean seatEnough;						//座位數是否足夠
	public JSONObject seatStoring=JSONUtils.getJSONObjectFromFile("/seat_1.json");	//記錄已訂購座位
	JSONObject sj = JSONUtils.getJSONObjectFromFile("/seat.json");

	

	public ticketBooked(String uid, String seatType, int number, String trainNo, String ticketType) throws Train_Exception {
		this.uid = uid;
		this.number = number;
		this.trainNo = trainNo;
		this.ticketType = ticketType;
		this.seatType = seatType;
		seatEnough=true;
		seatString2 = "";
		try {
			check();
		}catch(Train_Exception e) {
			System.out.println(e.getMessage());
		}
		int tmp = (int) (Math.random() * 1000000000);
		ticketCode = ticketCode + tmp; // 隨機產生訂票代號
		this.seatAllocate(number);
	}
	private void check() throws Train_Exception{	//檢查座位數是否足夠
		if (seatStoring.isNull(trainNo)) {	//為確保所有車次內容皆為陣列，在建立時先放入兩個預設物件。
			seatStoring.accumulate(trainNo, "001");
			seatStoring.accumulate(trainNo, "002");
		}
		else {
			JSONArray train = seatStoring.getJSONArray(this.trainNo);
			if(989-(train.length()-2)<number) {
				seatEnough=false;
				throw new Train_Exception("Insufficient remaining tickets");
			}
		}
		
	}

	private void carType(String cartype) {	//依照需求產生car、line
		if (ticketType.equals("商業車廂")) {
			car = 6;
		} else if (ticketType.equals("標準車廂")) {
			do {
				car = (int) (Math.random() * 12) + 1;
			} while (car == 6);

		}
		switch (car) {

		case 1:
			line = String.valueOf((int) (Math.random() * 13) + 1);
			break;
		case 2, 4, 8, 10:
			line = String.valueOf((int) (Math.random() * 20) + 1);
			break;
		case 3, 9, 11:
			line = String.valueOf((int) (Math.random() * 18) + 1);
			break;
		case 5, 6:
			line = String.valueOf((int) (Math.random() * 17) + 1);
			break;
		case 7:
			line = String.valueOf((int) (Math.random() * 12) + 1);
			break;
		case 12:
			line = String.valueOf((int) (Math.random() * 14) + 1);
			break;
		}
	}

	private void seatType(String seattype) {	//依照需求產生actualSeatType
		int i = 0;
		i = (int) (Math.random() * ((JSONObject) (sj.getJSONArray("cars").get(car - 1))).getJSONObject("seats")
				.getJSONArray(line).length());
		actualSeatType = (String) ((JSONObject) (sj.getJSONArray("cars").get(car - 1))).getJSONObject("seats")
				.getJSONArray(line).get(i);
		if (seattype.equals("靠走道") && (!(actualSeatType.equals("C") || actualSeatType.equals("D")))) {
			seatType(seattype);
		} else if (seattype.equals("靠窗") && (!(actualSeatType.equals("A") || actualSeatType.equals("E")))) {
			seatType(seattype);
		}
	}

	private boolean compare(String seatstr) {	//檢查產生位置是否已有訂購紀錄
		boolean repeatSeat = false;
		if (!(seatStoring.isNull(trainNo))) {
			for (int j = 0; j < seatStoring.getJSONArray(trainNo).length(); j++) {
				if (((seatStoring.getJSONArray(trainNo).get(j)).equals(seatstr))) {
					repeatSeat = true;
					break;
				}
			}
		}
		return repeatSeat;
	}

	private String booked() {	//執行產生座位程序，若無重複狀況則產生seatString
		do {
			carType(ticketType);
			seatType(seatType);
			seatString = car + "-" + line + "-" + actualSeatType;
		} while (compare(seatString) == true);
		return seatString;
	}

	private String secondseat(String firstseat) {	//取得第一個座位，將第二個座位分配在第一個座位旁
		String seat2="";
		String line2;
		String car2;
		String[] str = firstseat.split("-");
		car2 = str[0];
		line2 = str[1];
		switch (str[2]) {
		case "A":
			seat2 = "B";
			break;
		case "D":
			seat2 = "E";
			break;
		case "E":
			seat2 = "D";
			break;
		case "C":
			seat2 = "B";
			break;
		case "B":
			if (car2 == "6") {
				seat2 = "A";
			} else {
				seat2 = "A";
				if (compare(car2 + "-" + line2 + "-" + seat2) == true) {
					seat2 = "C";
				}
			}
			break;
		}
		seatString2 = car2 + "-" + line2 + "-" + seat2;
		return seatString2;
	}

	public void seatAllocate(int n) {	//將訂購成功座位加入seatStoring中
		if (seatStoring.isNull(trainNo)) {
			seatStoring.accumulate(trainNo, "001");
			seatStoring.accumulate(trainNo, "002");
		}
		if (n == 1) {
			seatArray[0]=booked();
			seatStoring.accumulate(trainNo, seatArray[0]);
		}
		if (n == 2) {
			do {
				secondseat(booked());
			} while (compare(secondseat(booked())));
			seatArray[0]=booked();
			seatArray[1]=(secondseat(seatArray[0]));
			seatStoring.accumulate(trainNo, seatArray[0]);
			seatStoring.accumulate(trainNo, seatArray[1]);
		}
		if (n > 2) {
			for (int i = 0; i < n; i++) {
				seatArray[i]=booked();
				seatStoring.accumulate(trainNo, seatArray[i]);
			}
		}
		seatupdate();
	}

	public void cancel() {	//將取消座位移除自seatStoring
		int tmp = number;
		do {
			for (int i = 0; i < seatStoring.getJSONArray(trainNo).length(); i++) {

				if (seatStoring.getJSONArray(trainNo).get(i).equals(seatString)
						|| seatStoring.getJSONArray(trainNo).get(i).equals(seatString2)) {
					seatStoring.getJSONArray(trainNo).remove(i);
				}

			}
			tmp--;
		} while (tmp > 0);
		seatupdate();
	}
	
	private void seatupdate() {		//更新seatStoring，並複寫至外部檔案
		try {
			String ws;
			ws = seatStoring.toString();
			BufferedWriter bw = new BufferedWriter(new FileWriter("assets/seat_1.json"));
			bw.write(ws);
			bw.newLine();
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private String startID = "";
	private String arriveID = "";
	
	public void stationID(String start,String arrive) {		//依中文站名取得其StationID
		JSONArray arr = JSONUtils.getJSONArrayFromFile("/station.json");

			for (int j = 0; j < arr.length(); j++) {
				JSONObject obj = arr.getJSONObject(j);
				if (start.equals(obj.getJSONObject("StationName").getString("Zh_tw"))) {
					startID = obj.getString("StationID");
				} else if (arrive.equals(obj.getJSONObject("StationName").getString("Zh_tw"))) {
					arriveID = obj.getString("StationID");
				}
			}
	}
	
	
	
	public void adddata(String date, String paydeadline, String payment) {		//將訂購成功之訂單加入booking
		try {
			try {
				JSONObject booking = JSONUtils.getJSONObjectFromFile("/booking.json");
				 JSONArray cusInfo= booking.getJSONArray("book");
				 String tmp="";
				 tmp= "    {\r\n"
				 		+ "        \"code\": \""+ticketCode+"\",\r\n"
				 		+ "        \"uid\": \""+uid+"\",\r\n"
				 		+ "        \"ticketInfo\":[],\r\n"
				 		+ "        \"payDeadline\" : \""+paydeadline+"\",\r\n"
				 		+ "        \"payment\" : "+payment+"\r\n"
				 		+ "    }";
					 
				 JSONObject tmp1 = new JSONObject(tmp);
				 JSONArray ticketInfo = tmp1.getJSONArray("ticketInfo");
					 for(int i=0;i<number;i++) {
						 String tmpInfo;
						 tmpInfo="            {\r\n"
							 		+ "                \"date\" : \""+date+"\",\r\n"
							 		+ "                \"ticketsType\" : \""+ticketType+"\",\r\n"
							 		+ "                \"trainNo\" : \""+trainNo+"\",\r\n"
							 		+ "                \"ticketsCount\" : 1,\r\n"
							 		+ "                \"start\" : \""+startID+"\",\r\n"
							 		+ "                \"end\" : \""+arriveID+"\",\r\n"
							 		+ "                \"seats\": [\""+seatArray[i]+"\"]\r\n"
							 		+ "            }";
						 JSONObject tmp2 = new JSONObject(tmpInfo);
						 ticketInfo.put(tmp2);
					 }	 
				 cusInfo.put(tmp1);
				 String ws=booking.toString();
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
	
	public void canceldata() {		//將取消之訂單移除自booking
		try {
			try {
				JSONObject booking = JSONUtils.getJSONObjectFromFile("/booking.json");
				JSONArray cusInfo = booking.getJSONArray("book");
				for (int i = 0; i < cusInfo.length(); i++) {
					JSONObject tmp1 = new JSONObject(cusInfo.get(i).toString());
					if (tmp1.get("code").equals(ticketCode)) {
						cusInfo.remove(i);
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

	public void numberChange(int num) {		//換訂單票數
		this.cancel();
		this.seatAllocate(num);

	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getSeatString() {
		return seatString;
	}

	public void setSeatString(String seatString) {
		this.seatString = seatString;
	}

	public String getSeatString2() {
		return seatString2;
	}

	public void setSeatString2(String seatString2) {
		this.seatString2 = seatString2;
	}
	public int getTicketCode() {
		return ticketCode;
	}
	public String[] getSeatArray() {
		return seatArray;
	}
	public void setSeatArray(String[] seatArray) {
		this.seatArray = seatArray;
	}
	public void setTicketCode(int ticketCode) {
		this.ticketCode = ticketCode;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public String getStartID() {
		return startID;
	}
	public String getArriveID() {
		return arriveID;
	}
	public void setStartID(String startID) {
		this.startID = startID;
	}
	public void setArriveID(String arriveID) {
		this.arriveID = arriveID;
	}
	public boolean isSeatEnough() {
		return seatEnough;
	}
	public void setSeatEnough(boolean seatEnough) {
		this.seatEnough = seatEnough;
	}

}