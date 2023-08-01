package search;

import java.time.*;
import org.json.JSONArray;
import org.json.JSONObject;
import com.tcg.json.JSONUtils;

public class timeTable {
	
		private int year;
		private int month;
		private int dayOfMonth;
		
		//constructor
		public timeTable(int year,int month,int dayOfMonth) {
			this.year = year;
			this.month = month;
			this.dayOfMonth = dayOfMonth;
			
		}
		
		//輸出南下時刻表
		public String gettimeTable1() {
			String timeTable1 = "";//南下時刻表
			LocalDate date = LocalDate.of(year, month, dayOfMonth);//把日期轉成LocalDate型態
			DayOfWeek dayOfWeek = date.getDayOfWeek();//取得星期幾
			String dayOfWeek1 = String.valueOf(dayOfWeek);//轉成string型態
			String dayOfWeek2 = dayOfWeek1.substring(0, 1)+dayOfWeek1.substring(1).toLowerCase();//把輸入轉成跟json檔一樣格式
			JSONArray arr = JSONUtils.getJSONArrayFromFile("/timeTable.json");
			String direction = "南下\n";
			timeTable1 = timeTable1.concat(direction);
			String station = "";
			station = String.format("%-6s%-5s%-5s%-6s%-5s%-5s%-5s%-5s%-5s%-6s%-5s%-5s%-5s\n","車次","南港","台北","板橋","桃園","新竹","苗栗","台中","彰化","雲林","嘉義","台南","左營");
			timeTable1 = timeTable1.concat(station);
		
			//輸出所有當天車次的時刻表
			for(int i = 0; i <arr.length(); i++) {
				JSONObject obj=arr.getJSONObject(i);
				JSONArray arr1 = obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes");
				String trainNo = obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo");
				String nangang = "*";
				String taipei = "*";
				String banciao = "*";
				String taoyuan = "*";
				String hsinchu = "*";
				String miaoli = "*";
				String taichung = "*";
				String changhua = "*";
				String yunlin = "*";
				String chiayi = "*";
				String tainan = "*";
				String zuoying = "*";
				String times = "";
				//輸出一個車次的時刻表
				for(int j = 0; j<arr1.length(); j++) {
					JSONObject obj1 = arr1.getJSONObject(j);
					String stationID = obj1.getString("StationID");
					//取得發車時間
					switch(stationID) {
					case"0990":
						nangang = obj1.getString("DepartureTime");
						break;
					case"1000":
						taipei = obj1.getString("DepartureTime");
						break;
					case"1010":
						banciao = obj1.getString("DepartureTime");
						break;
					case"1020":
						taoyuan = obj1.getString("DepartureTime");
						break;
					case"1030":
						hsinchu = obj1.getString("DepartureTime");
						break;
					case"1035":
						miaoli = obj1.getString("DepartureTime");
						break;
					case"1040":
						taichung = obj1.getString("DepartureTime");
						break;
					case"1043":
						changhua = obj1.getString("DepartureTime");
						break;
					case"1047":
						yunlin = obj1.getString("DepartureTime");
						break;
					case"1050":
						chiayi = obj1.getString("DepartureTime");
						break;
					case"1060":
						tainan = obj1.getString("DepartureTime");
						break;
					case"1070":
						zuoying = obj1.getString("DepartureTime");
						break;
					
					}
				
				}
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").getInt(dayOfWeek2) == 1 && obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getInt("Direction") == 0) {
					times = String.format("%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s\n",trainNo,nangang,taipei,banciao,taoyuan,hsinchu,miaoli,taichung,changhua,yunlin,chiayi,tainan,zuoying);
					timeTable1 = timeTable1.concat(times);
					}
		
			}
			return timeTable1;
		}
		
		//輸出所有當天車次的時刻表
		public String gettimeTable2() {
			String timeTable2 = "";
			LocalDate date = LocalDate.of(year, month, dayOfMonth);
			DayOfWeek dayOfWeek = date.getDayOfWeek();
			String dayOfWeek1 = String.valueOf(dayOfWeek);
			String dayOfWeek2 = dayOfWeek1.substring(0, 1)+dayOfWeek1.substring(1).toLowerCase();
			JSONArray arr = JSONUtils.getJSONArrayFromFile("/timeTable.json");
			String direction = "北上\n";
			timeTable2 = timeTable2.concat(direction);
			String station = "";
			station = String.format("%-6s%-5s%-5s%-6s%-5s%-5s%-5s%-5s%-5s%-6s%-5s%-5s%-5s\n","車次","左營","台南","嘉義","雲林","彰化","台中","苗栗","新竹","桃園","板橋","臺北","南港");
			timeTable2 = timeTable2.concat(station);
			//輸出一個車次的時刻表
			for(int i = 0; i <arr.length(); i++) {
				JSONObject obj=arr.getJSONObject(i);
				JSONArray arr1 = obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes");
				String trainNo = obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo");
				String nangang = "*";
				String taipei = "*";
				String banciao = "*";
				String taoyuan = "*";
				String hsinchu = "*";
				String miaoli = "*";
				String taichung = "*";
				String changhua = "*";
				String yunlin = "*";
				String chiayi = "*";
				String tainan = "*";
				String zuoying = "*";
				String times = "";
				for(int j = 0; j<arr1.length(); j++) {
					JSONObject obj1 = arr1.getJSONObject(j);
					String stationID = obj1.getString("StationID");
					//取得發車時間
					switch(stationID) {
					case"0990":
						nangang = obj1.getString("DepartureTime");
						break;
					case"1000":
						taipei = obj1.getString("DepartureTime");
						break;
					case"1010":
						banciao = obj1.getString("DepartureTime");
						break;
					case"1020":
						taoyuan = obj1.getString("DepartureTime");
						break;
					case"1030":
						hsinchu = obj1.getString("DepartureTime");
						break;
					case"1035":
						miaoli = obj1.getString("DepartureTime");
						break;
					case"1040":
						taichung = obj1.getString("DepartureTime");
						break;
					case"1043":
						changhua = obj1.getString("DepartureTime");
						break;
					case"1047":
						yunlin = obj1.getString("DepartureTime");
						break;
					case"1050":
						chiayi = obj1.getString("DepartureTime");
						break;
					case"1060":
						tainan = obj1.getString("DepartureTime");
						break;
					case"1070":
						zuoying = obj1.getString("DepartureTime");
						break;
					
					}
				
				}
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").getInt(dayOfWeek2) == 1 && obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getInt("Direction") == 1) {
					times = String.format("%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s\n",trainNo,zuoying,tainan,chiayi,yunlin,changhua,taichung,miaoli,hsinchu,taoyuan,banciao,taipei,nangang);
					timeTable2 = timeTable2.concat(times);
					}
		
			}
			return timeTable2;
		}
		
		
		
		
		
	
	}