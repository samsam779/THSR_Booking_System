package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tcg.json.JSONUtils;

import ticket.Train_Exception;
import ticket.ticketBooked;

public class ticketBookedGui {
	private JFrame frame;
	private JPanel p0, p1, p2, p3, p4, p5, p6, p7;
	private JButton done, cancel;
	private String strMonth, strDay, strTime;
	private int normalN, elderN, disabledN, kidN, totalN, paymentN, paymentN2;

	private String START, DESTINATION, CARTYPE, SEATTYPE, TICKETTYPE, uid, choosedTrainNoGo, choosedTrainNoBack;
	private String payment, payment2;
	private Date date;

	public ticketBookedGui(String uid, String START, String DESTINATION, String CARTYPE, String SEATTYPE,
			String TICKETTYPE, int normalN, int elderN, int disabledN, int kidN, Date date, String choosed)
			throws Train_Exception {
		this.START = START;
		this.DESTINATION = DESTINATION;
		this.CARTYPE = CARTYPE;
		this.SEATTYPE = SEATTYPE;
		this.TICKETTYPE = TICKETTYPE;
		this.uid = uid;
		this.normalN = normalN;
		this.elderN = elderN;
		this.disabledN = disabledN;
		this.kidN = kidN;
		this.date = date;
		totalN = normalN + elderN + disabledN + kidN;
		choosedTrainNoGo = choosed.substring(0, 4);
		String[] tmpS = choosed.split("/|:");
		String goHour = tmpS[5];
		String goMin = tmpS[6];//將選取的列車字串作相對應的拆解

		ticketBooked t = new ticketBooked(this.uid, this.SEATTYPE, totalN, choosedTrainNoGo, CARTYPE);

		t.stationID(START, DESTINATION);
		String m = t.getStartID();
		int priceEach = 0;
		JSONArray price = JSONUtils.getJSONArrayFromFile("/price.json");
		if (CARTYPE.equals("標準車廂")) {//取得標準車廂的全票價格
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(t.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(t.getArriveID())) {
							priceEach = arrive.getJSONArray("Fares").getJSONObject(0).getInt("Price");
							break;
						}
					}
				}
			}
		} else if (CARTYPE.equals("商業車廂")) {//取得商業車廂的全票價格
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(t.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(t.getArriveID())) {
							priceEach = arrive.getJSONArray("Fares").getJSONObject(1).getInt("Price");
							break;
						}
					}
				}
			}
		}

		paymentN = (int) (priceEach * normalN + priceEach * (elderN + disabledN + kidN) * 0.5);//三者優待票都為五折計算，全票則為原價
		payment = String.valueOf(paymentN);
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -3);//繳費期限為前三天
		Date payDeadLine = cal.getTime();
		String payDeadLineS = fd.format(payDeadLine);
		String dateString = fd.format(date);

		t.adddata(dateString, payDeadLineS, payment);//將資料加於json資料中

		String seatarrS = "";
		String[] seatarr = new String[10];//用來暫存所有位置，因只能同時訂最多10張票，故位置至最多十個
		seatarr = t.getSeatArray();
		for (int k = 0; k < 10; k++) {
			seatarrS = seatarrS + seatarr[k] + "  ";
			if (seatarr[k + 1] == null) {
				break;
			}
		}
		frame = new JFrame("訂票系統");
		/*
		 * 建立一個名為"訂票系統"的JFrame 內有七個JButton
		 */
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p0.add(new JLabel("訂票代號:" + t.getTicketCode()));
		p1.add(new JLabel("列車號碼:" + choosedTrainNoGo));
		p2.add(new JLabel("起站:" + START));
		p2.add(new JLabel("迄站:" + DESTINATION));
		p3.add(new JLabel("金額:" + paymentN));
		p4.add(new JLabel("時間:" + dateString + "  " + goHour + ":" + goMin));
		p5.add(new JLabel("你的座位:" + seatarrS));
		p6.add(new JLabel("繳費期限:" + payDeadLineS));

		cancel = new JButton("取消");
		p7.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				t.cancel(); // 取消訂票
				t.canceldata();
				frame.setVisible(false);
				System.exit(0);
			}
		});
		done = new JButton("完成");
		p7.add(done);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				frame.setVisible(false); // 完成訂票
				System.exit(0);
			}
		});
		if (priceEach <= 0 || t.isSeatEnough() == false) {//如果位置不夠則無法購票
			String strf = "訂票失敗(指定票種無法購買或位置不夠)";
			JOptionPane.showMessageDialog(null, strf);
			frame.setVisible(false);
			System.exit(0);
		} else {
			frame.add(p0);
			frame.add(p1);
			frame.add(p2);
			frame.add(p3);
			frame.add(p4);
			frame.add(p5);
			frame.add(p6);
			frame.add(p7);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setLayout(new GridLayout(0, 1));
			frame.setBounds(500, 200, 700, 500);
		}

	}

	public ticketBookedGui(String uid, String START, String DESTINATION, String CARTYPE, String SEATTYPE,
			String TICKETTYPE, int normalN, int elderN, int disabledN, int kidN, Date date, Date backDate,
			String choosedGo, String choosedBack) throws Train_Exception {//和上述第一個單程的constructor概念相同，只是所有動作分別對去程和回程各做一次
		this.START = START;
		this.DESTINATION = DESTINATION;
		this.CARTYPE = CARTYPE;
		this.SEATTYPE = SEATTYPE;
		this.TICKETTYPE = TICKETTYPE;
		this.uid = uid;
		this.normalN = normalN;
		this.elderN = elderN;
		this.disabledN = disabledN;
		this.kidN = kidN;
		this.date = date;
		totalN = normalN + elderN + disabledN + kidN;
		choosedTrainNoGo = choosedGo.substring(0, 4);
		String[] tmpS = choosedGo.split("/|:");
		String goHour = tmpS[5];
		String goMin = tmpS[6];

		choosedTrainNoBack = choosedBack.substring(0, 4);
		String[] tmpSS = choosedBack.split("/|:");
		String backHour = tmpSS[5];
		String backMin = tmpSS[6];

		ticketBooked go = new ticketBooked(this.uid, this.SEATTYPE, totalN, choosedTrainNoGo, CARTYPE);
		ticketBooked back = new ticketBooked(this.uid, this.SEATTYPE, totalN, choosedTrainNoGo, CARTYPE);

		go.stationID(START, DESTINATION);
		back.stationID(DESTINATION, START);
		String m = go.getStartID();
		String n = back.getStartID();
		int priceEach1 = 0;
		int priceEach2 = 0;
		JSONArray price = JSONUtils.getJSONArrayFromFile("/price.json");
		if (CARTYPE.equals("標準車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(go.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(go.getArriveID())) {
							priceEach1 = arrive.getJSONArray("Fares").getJSONObject(0).getInt("Price");
							break;
						}
					}
				}
			}
		} else if (CARTYPE.equals("商業車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(back.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(back.getArriveID())) {
							priceEach1 = arrive.getJSONArray("Fares").getJSONObject(1).getInt("Price");
							break;
						}
					}
				}
			}
		}

		if (CARTYPE.equals("標準車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(back.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(back.getArriveID())) {
							priceEach2 = arrive.getJSONArray("Fares").getJSONObject(0).getInt("Price");
							break;
						}
					}
				}
			}
		}

		else if (CARTYPE.equals("商業車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(back.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(back.getArriveID())) {
							priceEach2 = arrive.getJSONArray("Fares").getJSONObject(1).getInt("Price");
							break;
						}
					}
				}
			}
		}

		paymentN = (int) (priceEach1 * normalN + priceEach1 * (elderN + disabledN + kidN) * 0.5);
		paymentN2 = (int) (priceEach2 * normalN + priceEach2 * (elderN + disabledN + kidN) * 0.5);
		payment = String.valueOf(paymentN);
		payment2 = String.valueOf(paymentN2);
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -3);
		Date payDeadLine = cal.getTime();
		String payDeadLineS = fd.format(payDeadLine);
		String dateString = fd.format(date);

		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.setTime(backDate);
		cal2.add(Calendar.DATE, -3);
		Date payDeadLine2 = cal2.getTime();
		String payDeadLineS2 = fd.format(payDeadLine2);
		String dateString2 = fd.format(backDate);

		go.adddata(dateString, payDeadLineS, payment);
		back.adddata(dateString2, payDeadLineS2, payment2);

		String seatarrS = "";
		String[] seatarr = new String[10];
		seatarr = go.getSeatArray();
		for (int k = 0; k < 10; k++) {
			seatarrS = seatarrS + seatarr[k] + "  ";
			if (seatarr[k + 1] == null) {
				break;
			}
		}

		String seatarrS2 = "";
		String[] seatarr2 = new String[10];
		seatarr2 = back.getSeatArray();
		for (int k = 0; k < 10; k++) {
			seatarrS2 = seatarrS2 + seatarr2[k] + "  ";
			if (seatarr2[k + 1] == null) {
				break;
			}
		}

		frame = new JFrame("訂票系統");
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p0.add(new JLabel("去程訂票代號:" + go.getTicketCode() + "   回程訂票代碼:" + back.getTicketCode()));
		p1.add(new JLabel("去程列車號碼:" + choosedTrainNoGo + "   回程列車號碼" + choosedTrainNoBack));
		p2.add(new JLabel("去程起站(回程迄站):" + START));
		p2.add(new JLabel("去程迄站(回程起站):" + DESTINATION));
		int totalPay = paymentN + paymentN2;
		p3.add(new JLabel("去程金額:" + paymentN + "  回程金額" + paymentN2 + "  加總:" + totalPay));
		p4.add(new JLabel("去程時間:" + dateString + "  " + goHour + ":" + goMin + "  回程時間:" + dateString2 + "  " + backHour
				+ ":" + backMin));
		p5.add(new JLabel("去程座位:" + seatarrS + "   回程座位" + seatarrS2));
		p6.add(new JLabel("去程繳費期限:" + payDeadLineS + "   回程繳費期限:" + payDeadLineS2));

		cancel = new JButton("取消");
		p7.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				go.cancel();
				go.canceldata();
				back.cancel();
				back.canceldata();
				frame.setVisible(false);
				System.exit(0);
			}
		});
		done = new JButton("完成");
		p7.add(done);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				frame.setVisible(false);
				System.exit(0);
			}
		});
		if (priceEach1 <= 0 || priceEach2 <= 0 || go.isSeatEnough() == false || back.isSeatEnough() == false) {
			String strf = "訂票失敗(指定票種無法購買)";
			JOptionPane.showMessageDialog(null, strf);
			frame.setVisible(false);
			System.exit(0);
		} else {
			frame.add(p0);
			frame.add(p1);
			frame.add(p2);
			frame.add(p3);
			frame.add(p4);
			frame.add(p5);
			frame.add(p6);
			frame.add(p7);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setLayout(new GridLayout(0, 1));
			frame.setBounds(500, 200, 700, 500);
		}

	}

	public ticketBookedGui(String uid, String START, String DESTINATION, String CARTYPE, String SEATTYPE,
			String TICKETTYPE, int normalN, Date date, String choosed, String earlyOrStu) throws Train_Exception {//和第一個constructor概念相同，僅票種只有一種，折價會根據該列車的折數計算
		this.START = START;
		this.DESTINATION = DESTINATION;
		this.CARTYPE = CARTYPE;
		this.SEATTYPE = SEATTYPE;
		this.TICKETTYPE = TICKETTYPE;
		this.uid = uid;
		this.normalN = normalN;
		this.date = date;

		choosedTrainNoGo = choosed.substring(0, 4);
		String[] tmpS = choosed.split("/|:");
		String goHour = tmpS[7];
		String goMin = tmpS[8];
		double discount = Double.parseDouble(tmpS[2]);

		ticketBooked t = new ticketBooked(this.uid, this.SEATTYPE, normalN, choosedTrainNoGo, CARTYPE);

		t.stationID(START, DESTINATION);
		String m = t.getStartID();
		int priceEach = 0;
		JSONArray price = JSONUtils.getJSONArrayFromFile("/price.json");
		if (CARTYPE.equals("標準車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(t.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(t.getArriveID())) {
							priceEach = arrive.getJSONArray("Fares").getJSONObject(0).getInt("Price");
							break;
						}
					}
				}
			}
		} else if (CARTYPE.equals("商業車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(t.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(t.getArriveID())) {
							priceEach = arrive.getJSONArray("Fares").getJSONObject(1).getInt("Price");
							break;
						}
					}
				}
			}
		}

		paymentN = (int) (priceEach * normalN * discount);
		payment = String.valueOf(paymentN);
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -3);
		Date payDeadLine = cal.getTime();
		String payDeadLineS = fd.format(payDeadLine);
		String dateString = fd.format(date);

		t.adddata(dateString, payDeadLineS, payment);

		String seatarrS = "";
		String[] seatarr = new String[10];
		seatarr = t.getSeatArray();
		for (int k = 0; k < 10; k++) {
			seatarrS = seatarrS + seatarr[k] + "  ";
			if (seatarr[k + 1] == null) {
				break;
			}
		}
		frame = new JFrame("訂票系統");
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p0.add(new JLabel("訂票代號:" + t.getTicketCode()));
		p1.add(new JLabel("列車號碼:" + choosedTrainNoGo));
		p2.add(new JLabel("起站:" + START));
		p2.add(new JLabel("迄站:" + DESTINATION));
		p3.add(new JLabel("金額:" + paymentN));
		p4.add(new JLabel("時間:" + dateString + "  " + goHour + ":" + goMin));
		p5.add(new JLabel("你的座位:" + seatarrS));
		p6.add(new JLabel("繳費期限:" + payDeadLineS));

		cancel = new JButton("取消");
		p7.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				t.cancel();
				t.canceldata();
				frame.setVisible(false);
				System.exit(0);
			}
		});
		done = new JButton("完成");
		p7.add(done);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				frame.setVisible(false);
				System.exit(0);
			}
		});
		if (priceEach <= 0 || t.isSeatEnough() == false) {
			String strf = "訂票失敗(指定票種無法購買)";
			JOptionPane.showMessageDialog(null, strf);
			frame.setVisible(false);
			System.exit(0);
		} else {
			frame.add(p0);
			frame.add(p1);
			frame.add(p2);
			frame.add(p3);
			frame.add(p4);
			frame.add(p5);
			frame.add(p6);
			frame.add(p7);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setLayout(new GridLayout(0, 1));
			frame.setBounds(500, 200, 700, 500);
		}

	}

	public ticketBookedGui(String uid, String START, String DESTINATION, String CARTYPE, String SEATTYPE,
			String TICKETTYPE, int normalN, Date date, Date backDate, String choosedGo, String choosedBack)//和第三個constructor相同，只是對去程和回程各做一次
			throws Train_Exception {
		this.START = START;
		this.DESTINATION = DESTINATION;
		this.CARTYPE = CARTYPE;
		this.SEATTYPE = SEATTYPE;
		this.TICKETTYPE = TICKETTYPE;
		this.uid = uid;
		this.normalN = normalN;

		this.date = date;
		choosedTrainNoGo = choosedGo.substring(0, 4);
		String[] tmpS = choosedGo.split("/|:");
		String goHour = tmpS[7];
		String goMin = tmpS[8];
		double discount = Double.parseDouble(tmpS[2]);

		choosedTrainNoBack = choosedBack.substring(0, 4);
		String[] tmpSS = choosedBack.split("/|:");
		String backHour = tmpSS[5];
		String backMin = tmpSS[6];
		double discount2 = Double.parseDouble(tmpSS[2]);

		ticketBooked go = new ticketBooked(this.uid, this.SEATTYPE, normalN, choosedTrainNoGo, CARTYPE);
		ticketBooked back = new ticketBooked(this.uid, this.SEATTYPE, normalN, choosedTrainNoGo, CARTYPE);

		go.stationID(START, DESTINATION);
		back.stationID(DESTINATION, START);
		String m = go.getStartID();
		String n = back.getStartID();
		int priceEach1 = 0;
		int priceEach2 = 0;
		JSONArray price = JSONUtils.getJSONArrayFromFile("/price.json");
		if (CARTYPE.equals("標準車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(go.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(go.getArriveID())) {
							priceEach1 = arrive.getJSONArray("Fares").getJSONObject(0).getInt("Price");
							break;
						}
					}
				}
			}
		} else if (CARTYPE.equals("商業車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(back.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(back.getArriveID())) {
							priceEach1 = arrive.getJSONArray("Fares").getJSONObject(1).getInt("Price");
							break;
						}
					}
				}
			}
		}

		if (CARTYPE.equals("標準車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(back.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(back.getArriveID())) {
							priceEach2 = arrive.getJSONArray("Fares").getJSONObject(0).getInt("Price");
							break;
						}
					}
				}
			}
		}

		else if (CARTYPE.equals("商業車廂")) {
			for (int i = 0; i < price.length(); i++) {
				JSONObject origin = price.getJSONObject(i);
				if (origin.getString("OriginStationID").equals(back.getStartID())) {
					JSONArray des = price.getJSONObject(i).getJSONArray("DesrinationStations");
					for (int j = 0; j < des.length(); j++) {
						JSONObject arrive = des.getJSONObject(j);
						if (arrive.getString("ID").equals(back.getArriveID())) {
							priceEach2 = arrive.getJSONArray("Fares").getJSONObject(1).getInt("Price");
							break;
						}
					}
				}
			}
		}

		paymentN = (int) (priceEach1 * normalN * discount);
		paymentN2 = (int) (priceEach2 * normalN * discount2);
		payment = String.valueOf(paymentN);
		payment2 = String.valueOf(paymentN2);
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -3);
		Date payDeadLine = cal.getTime();
		String payDeadLineS = fd.format(payDeadLine);
		String dateString = fd.format(date);

		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.setTime(backDate);
		cal2.add(Calendar.DATE, -3);
		Date payDeadLine2 = cal2.getTime();
		String payDeadLineS2 = fd.format(payDeadLine2);
		String dateString2 = fd.format(backDate);

		go.adddata(dateString, payDeadLineS, payment);
		back.adddata(dateString2, payDeadLineS2, payment2);

		String seatarrS = "";
		String[] seatarr = new String[10];
		seatarr = go.getSeatArray();
		for (int k = 0; k < 10; k++) {
			seatarrS = seatarrS + seatarr[k] + "  ";
			if (seatarr[k + 1] == null) {
				break;
			}
		}

		String seatarrS2 = "";
		String[] seatarr2 = new String[10];
		seatarr2 = back.getSeatArray();
		for (int k = 0; k < 10; k++) {
			seatarrS2 = seatarrS2 + seatarr2[k] + "  ";
			if (seatarr2[k + 1] == null) {
				break;
			}
		}

		frame = new JFrame("訂票系統");
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p0.add(new JLabel("去程訂票代號:" + go.getTicketCode() + "   回程訂票代碼:" + back.getTicketCode()));
		p1.add(new JLabel("去程列車號碼:" + choosedTrainNoGo + "   回程列車號碼" + choosedTrainNoBack));
		p2.add(new JLabel("去程起站(回程迄站):" + START));
		p2.add(new JLabel("去程迄站(回程起站):" + DESTINATION));
		int totalPay = paymentN + paymentN2;
		p3.add(new JLabel("去程金額:" + paymentN + "  回程金額" + paymentN2 + "  加總:" + totalPay));
		p4.add(new JLabel("去程時間:" + dateString + "  " + goHour + ":" + goMin + "  回程時間:" + dateString2 + "  " + backHour
				+ ":" + backMin));
		p5.add(new JLabel("去程座位:" + seatarrS + "   回程座位" + seatarrS2));
		p6.add(new JLabel("去程繳費期限:" + payDeadLineS + "   回程繳費期限:" + payDeadLineS2));

		cancel = new JButton("取消");
		p7.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				go.cancel();
				go.canceldata();
				back.cancel();
				back.canceldata();
				frame.setVisible(false);
				System.exit(0);
			}
		});
		done = new JButton("完成");
		p7.add(done);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				frame.setVisible(false);
				System.exit(0);
			}
		});
		if (priceEach1 <= 0 || priceEach2 <= 0 || go.isSeatEnough() == false || back.isSeatEnough() == false) {
			String strf = "訂票失敗(指定票種無法購買)";
			JOptionPane.showMessageDialog(null, strf);
			frame.setVisible(false);
			System.exit(0);
		} else {
			frame.add(p0);
			frame.add(p1);
			frame.add(p2);
			frame.add(p3);
			frame.add(p4);
			frame.add(p5);
			frame.add(p6);
			frame.add(p7);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setLayout(new GridLayout(0, 1));
			frame.setBounds(500, 200, 700, 500);
		}

	}

}
