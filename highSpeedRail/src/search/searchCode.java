package search;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tcg.json.JSONUtils;

public class searchCode {
	
	private String UID;
	private String startStation;
	private String endStation;
	private String date;
	private String trainNo;
	//constructor
	public searchCode(String UID,String startStation,String endStation,String date,String trainNo) {
		this.UID = UID;
		this.startStation = startStation;
		this.endStation = endStation;
		this.date = date;
		this.trainNo = trainNo;
	}
	//取得搜尋到的資訊
	public String getInformation() {
		String information = "查無紀錄";//預設是查無紀錄
		String a = "訂位代號:";
		String b = "\nUID:";
		String c = "\n車次:";
		String d = "\n日期:";
		String e = "\n起站時間:";
		String f = "\n迄站時間:";
		String g = "\n座位:";
		String h = "\n票種:";
		String i = "\n總價:";
		String space = "\n";
		JSONObject o = JSONUtils.getJSONObjectFromFile("/booking.json");
		JSONArray timeTable = JSONUtils.getJSONArrayFromFile("/timeTable.json");
		JSONArray arr = o.getJSONArray("book");
		//跑過所有的已訂位醫訊
		for(int s = 0;s<arr.length();s++) {
			JSONObject book = arr.getJSONObject(s);
			String UID1 = book.getString("uid");
			String code1 = book.getString("code");
			int payment0 = book.getInt("payment");
			String payment = String.valueOf(payment0);
			//找到相同uid的資料
			if(UID.equals(UID1)) {
				JSONArray ticketInfo = book.getJSONArray("ticketInfo");
				//輸出這個uid所有的ticketInfo
				for(int t=0; t<ticketInfo.length(); t++) {
					JSONObject numberOfTicket = ticketInfo.getJSONObject(t);
					String trainNo1 = numberOfTicket.getString("trainNo");
					String date1 = numberOfTicket.getString("date");
					String startStation1 = numberOfTicket.getString("start");
					String endStation1 = numberOfTicket.getString("end");
					String ticketsType = numberOfTicket.getString("ticketsType");
					JSONArray seats = numberOfTicket.getJSONArray("seats");
					String seat = seats.getString(0); 
					String startStation2 = "";
					String endStation2 = "";
					switch(startStation1) {
					case"0990":
						startStation2 = "南港";
						break;
					case"1000":
						startStation2 = "台北";
						break;
					case"1010":
						startStation2 = "板橋";
						break;
					case"1020":
						startStation2 = "桃園";
						break;
					case"1030":
						startStation2 = "新竹";
						break;
					case"1035":
						startStation2 = "苗栗";
						break;
					case"1040":
						startStation2 = "台中";
						break;
					case"1043":
						startStation2 = "彰化";
						break;
					case"1047":
						startStation2 = "雲林";
						break;
					case"1050":
						startStation2 = "嘉義";
						break;
					case"1060":
						startStation2 = "台南";
						break;
					case"1070":
						startStation2 = "左營";
						break;
					}
					switch(endStation1) {
					case"0990":
						endStation2 = "南港";
						break;
					case"1000":
						endStation2 = "台北";
						break;
					case"1010":
						endStation2 = "板橋";
						break;
					case"1020":
						endStation2 = "桃園";
						break;
					case"1030":
						endStation2 = "新竹";
						break;
					case"1035":
						endStation2 = "苗栗";
						break;
					case"1040":
						endStation2 = "台中";
						break;
					case"1043":
						endStation2 = "彰化";
						break;
					case"1047":
						endStation2 = "雲林";
						break;
					case"1050":
						endStation2 = "嘉義";
						break;
					case"1060":
						endStation2 = "台南";
						break;
					case"1070":
						endStation2 = "左營";
						break;
					}
					//比對輸入資料是否符合
					if(startStation.equals(startStation2)&&endStation.equals(endStation2)&&date.equals(date1)&&trainNo.equals(trainNo1)) {
						
						information = a;
						information = information.concat(code1);
						information = information.concat(b);
						information = information.concat(UID1);
						information = information.concat(space);
						information = information.concat(c);
						information = information.concat(trainNo1);
						information = information.concat(d);
						information = information.concat(date1);
						String startTime = "";
						String endTime = "";
						//取得發車時間和抵達時間
						for(int k=0;k<timeTable.length();k++) {
							JSONObject obj = timeTable.getJSONObject(k);
							String tableTrainNo = obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo");
							if(tableTrainNo.equals(trainNo)) {
								JSONArray stopTimes = obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes");
								
								for(int l=0;l<stopTimes.length();l++) {
									JSONObject stop = stopTimes.getJSONObject(l);
									String stationID = stop.getString("StationID");
									if(startStation1.equals(stationID)) {
										startTime = stop.getString("DepartureTime");
									if(endStation1.equals(stationID)) {
										endTime = stop.getString("DepartureTime");
										}	
									}
									
								}
							}
						}
						information = information.concat(e);
						information = information.concat(startTime);
						information = information.concat(f);
						information = information.concat(endTime);
						information = information.concat(g);
						information = information.concat(seat);
						information = information.concat(h);
						information = information.concat(ticketsType);
						information = information.concat(space);
						information = information.concat(i);
						information = information.concat(payment);
						
					}
				}
				
			}
			
		}
		
		return information;
	}

}