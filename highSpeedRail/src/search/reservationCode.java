package search;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tcg.json.JSONUtils;

public class reservationCode {
	
	private String UID;
	private String code;
	//constructor
	public reservationCode(String UID,String code) {
		this.UID = UID;
		this.code = code;
	}
	//取得此訂單所有資料
	public String gettrainformation() {
		String information = "";
		String a = "車次:";
		String b = "\n日期:";
		String c = "\n起站:";
		String d = "\n迄站:";
		String e = "\n出發:";
		String f = "\n到達:";
		String g = "\n行車時間:";
		String h = "分鐘\n座位資訊:";
		String space = "\n\n";
		JSONObject o = JSONUtils.getJSONObjectFromFile("/booking.json");
		JSONArray timeTable = JSONUtils.getJSONArrayFromFile("/timeTable.json");
		JSONArray arr1 = o.getJSONArray("book");
		//跑過所有已訂位資料
		for(int i = 0 ; i < arr1.length(); i++) {
			JSONObject book = arr1.getJSONObject(i);
			//找到同樣uid和code的
			if(UID.equals(book.getString("uid"))&& code.equals(book.getString("code"))) {
				JSONArray ticketInfo = book.getJSONArray("ticketInfo");
				//輸出所有ticketInfo
				for(int j = 0 ; j < ticketInfo.length() ; j++) {
					JSONObject numberOfTicket = ticketInfo.getJSONObject(j);
					String trainNo = numberOfTicket.getString("trainNo");
					String date = numberOfTicket.getString("date");
					String startStationID = numberOfTicket.getString("start");
					String endStationID = numberOfTicket.getString("end");
					String startStation = "";
					String endStation = "";
					JSONArray seats = numberOfTicket.getJSONArray("seats");
					String seat = seats.getString(0); 
					//把站的序號轉成站名
					switch(startStationID) {
					case"0990":
						startStation = "南港";
						break;
					case"1000":
						startStation = "台北";
						break;
					case"1010":
						startStation = "板橋";
						break;
					case"1020":
						startStation = "桃園";
						break;
					case"1030":
						startStation = "新竹";
						break;
					case"1035":
						startStation = "苗栗";
						break;
					case"1040":
						startStation = "台中";
						break;
					case"1043":
						startStation = "彰化";
						break;
					case"1047":
						startStation = "雲林";
						break;
					case"1050":
						startStation = "嘉義";
						break;
					case"1060":
						startStation = "台南";
						break;
					case"1070":
						startStation = "左營";
						break;
					}
					switch(endStationID) {
					case"0990":
						endStation = "南港";
						break;
					case"1000":
						endStation = "台北";
						break;
					case"1010":
						endStation = "板橋";
						break;
					case"1020":
						endStation = "桃園";
						break;
					case"1030":
						endStation = "新竹";
						break;
					case"1035":
						endStation = "苗栗";
						break;
					case"1040":
						endStation = "台中";
						break;
					case"1043":
						endStation = "彰化";
						break;
					case"1047":
						endStation = "雲林";
						break;
					case"1050":
						endStation = "嘉義";
						break;
					case"1060":
						endStation = "台南";
						break;
					case"1070":
						endStation = "左營";
						break;
					}
					information = information.concat(a);
					information = information.concat(trainNo);
					information = information.concat(b);
					information = information.concat(date);
					information = information.concat(c);
					information = information.concat(startStation);
					information = information.concat(d);
					information = information.concat(endStation);
					information = information.concat(e);
					String startTime = "";
					String endTime = "";
					String time = "";
					//計算行車時間
					for(int k=0;k<timeTable.length();k++) {
						JSONObject obj = timeTable.getJSONObject(k);
						String tableTrainNo = obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo");
						if(tableTrainNo.equals(trainNo)) {
							JSONArray stopTimes = obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes");
							
							for(int l=0;l<stopTimes.length();l++) {
								JSONObject stop = stopTimes.getJSONObject(l);
								String stationID = stop.getString("StationID");
								if(startStationID.equals(stationID)) {
									startTime = stop.getString("DepartureTime");
								}
								if(endStationID.equals(stationID)) {
									endTime = stop.getString("DepartureTime");
								}		
							}
							DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
							LocalTime start = LocalTime.parse(startTime, timeFormat);
							LocalTime end = LocalTime.parse(endTime, timeFormat);
							Duration duration = Duration.between(start, end);
							long t = duration.toMinutes();
							time = Long.toString(t);
						}
					}
					information = information.concat(startTime);
					information = information.concat(f);
					information = information.concat(endTime);
					information = information.concat(g);
					information = information.concat(time);
					information = information.concat(h);
					information = information.concat(seat);
					information = information.concat(space);
				}
			
			}
		}
		return information;
	}
	
	
}