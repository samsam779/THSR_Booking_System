package ticket;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tcg.json.JSONUtils;

public class ticket extends booking{
	
	public ticket(Date date,String uid,String start,String destination,String ticketT,int number) {//constructor 將所有需要值初始化設定
		this.date=date;
		this.setUid(uid);
		SimpleDateFormat monthFormat= new SimpleDateFormat ("MM");
		SimpleDateFormat dayFormat= new SimpleDateFormat ("dd");
		SimpleDateFormat timeFormat= new SimpleDateFormat ("HH:mm");
		this.setMonth(monthFormat.format(date));
		this.setDay(dayFormat.format(date));
		this.setTime(timeFormat.format(date));
		this.setStart(start);
		this.setDestination(destination);
		this.setNumber(number);
		this.setTicketT(ticketT);
	}
	
	
	
	
	public String  to() throws ParseException {  //此method會輸出符合日期和所輸入時間兩小時內發車的列車資訊(至多輸出五輛列車)
		String main="";//main用以紀錄符合條件列車的資訊(至多5台車)
		JSONArray arr = JSONUtils.getJSONArrayFromFile("/timeTable.json");
		JSONObject early = JSONUtils.getJSONObjectFromFile("/earlyDiscount.json");
		JSONObject student = JSONUtils.getJSONObjectFromFile("/universityDiscount.json");
		for(int i=0;i<arr.length();i++) { //一一檢測timeTable的JSON檔中的列車是否符合條件
			String fullStartTime ;
			String fullArriveTime;
			Date arriveTimeDate=new Date();
			Date startTimeDate=new Date();
			SimpleDateFormat fd = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
			JSONObject obj=arr.getJSONObject(i);
			String weekday="";//用來記錄禮拜幾
			JSONArray arr2=obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes");
			
			
			String startTime="";
			String arriveTime="";
			boolean flag=false;//flag用以判斷當天是否有發車
			for(int j=0;j<arr2.length();j++) {  //在特定列車的停靠站資料中一一看是否有停靠起站和迄站
				
				if(getStart().equals(((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getJSONObject("StationName").getString("Zh_tw"))) {
					
					startTime=((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getString("DepartureTime");
					fullStartTime="2021-"+String.valueOf(getMonth())+"-"+String.valueOf(getDay())+" "+startTime;
					startTimeDate=fd.parse(fullStartTime);//若有停靠起站則設定startTimeDate和startTime
					
				}
				if(getDestination().equals(((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getJSONObject("StationName").getString("Zh_tw"))) {
				
					arriveTime=((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getString("DepartureTime");
					fullArriveTime="2021-"+String.valueOf(getMonth())+"-"+String.valueOf(getDay())+" "+arriveTime;
					arriveTimeDate=fd.parse(fullArriveTime);//若有停靠迄站則設定arriveTimeDate和arriveTime

				}
				
			}
			
			
			
			SimpleDateFormat weekDay= new SimpleDateFormat ("E");
			String ss=weekDay.format(date);
			switch(ss) {  //用以判斷此列車是否在當天有發車 若有發車則flag會被設置成true
			case "週一":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Monday").equals(1)) {
					flag=true;
					weekday="Monday";
				}
				else {flag=false;}
				break;
				
			case "週二":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Tuesday").equals(1)) {
					flag=true;
					weekday="Tuesday";
				}
				else {flag=false;}
				break;
			case "週三":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Wednesday").equals(1)) {
					flag=true;
					weekday="Wednesday";
				}
				else {flag=false;}
				break;
			case "週四":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Thursday").equals(1)) {
					flag=true;
					weekday="Thursday";
				}
				else {flag=false;}
				break;
			case "週五":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Friday").equals(1)) {
					flag=true;
					weekday="Friday";
				}
				else {flag=false;}
				break;
			case "週六":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Saturday").equals(1)) {
					flag=true;
					weekday="Saturday";
				}
				else {flag=false;}
				break;
			case "週日":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Sunday").equals(1)) {
					flag=true;
					weekday="Sunday";
				}
				else {flag=false;}
				break;
			}
			
			
			long diff=startTimeDate.getTime()-date.getTime();
			long dayDiff=diff / (1000 * 60 * 60 * 24);
			long hourDiff=(diff/(60*60*1000)-dayDiff*24);
			long minDiff=((diff/(60*1000))-dayDiff*24*60-hourDiff*60);//用來判斷訂票時間在現在時間之後
			
			
			long duration=arriveTimeDate.getTime()-startTimeDate.getTime();
			long dayDuration=duration / (1000 * 60 * 60 * 24);
			long hourDuration=(duration/(60*60*1000)-dayDuration*24);
			long minDuration=((duration/(60*1000))-dayDuration*24*60-hourDuration*60);//用來判斷行駛時間
			if(flag!=true) {
				
			}
			else if(arriveTime.equals("")||startTime.equals("")) {
				//用以判斷列車是否停靠起站和迄站,若未停靠arriveTime或startTime將為空字串,藉此判斷
			}
			else if(duration<0) {
				//確認列車開車時間為設定之時間後
			}
			else if(diff<0) {
				//日期須晚於訂票當下
			}
			else if(dayDiff==0&&hourDiff<2&&hourDiff>0){ //只選取2小時內開車的列車
				
				String s;
				if(getTicketT().equals("early")) { //輸出符合設定的列車，若為早鳥票字串會有一段為早鳥折數
					for(int p=0;p<early.getJSONArray("DiscountTrains").length();p++) {
						if(((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getString("TrainNo").equals(obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo"))) {
							try {
								for(int y=0;y<((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getJSONArray(weekday).length();y++) {
									if(((JSONObject) ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getJSONArray(weekday).get(y)).getInt("tickets")>0) {
										s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+"早鳥折數:"+((JSONObject) ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getJSONArray(weekday).get(y)).getDouble("discount")+"/"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
										System.out.println(s.toString());
										main=main+s;
										break;
										
									}
								}
							}
							catch(Exception e) {
								if(( ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount")).getInt(weekday)==1) {
									
									s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+"早鳥折數:"+( ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getInt(weekday))+"/"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
									System.out.println(s.toString());
									main=main+s;
									break;
									
								}
							}
							
						}
						
					}
				}
				else if(getTicketT().equals("student")) { //輸出符合設定的列車，若為學生票字串會有一段為學生折數
					for(int p=0;p<student.getJSONArray("DiscountTrains").length();p++) {
						if(((JSONObject)student.getJSONArray("DiscountTrains").get(p)).getString("TrainNo").equals(obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo"))) {
							
							s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+"大學生折數:"+((JSONObject)student.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").get(weekday)+"/"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
							System.out.println(s.toString());
							main=main+s;
							break;
						}
					}
				}
				
				else {//輸出符合設定的列車
					s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
					System.out.println(s.toString());
					main=main+s;
				}
			}
			
			
			
		}
		System.out.println(main);
		return main;//回傳所有符合設定之列車
	}
	
	//toSearch跟to幾乎完全一樣,故下面未做詳述,僅最後之時間規定不同,to列出兩小內的車,toSearch列出四小時內的車，toSearch能讓搜尋顯示較多車輛資訊
	public String  toSearch() throws ParseException {  
		String main="";
		JSONArray arr = JSONUtils.getJSONArrayFromFile("/timeTable.json");
		JSONObject early = JSONUtils.getJSONObjectFromFile("/earlyDiscount.json");
		JSONObject student = JSONUtils.getJSONObjectFromFile("/universityDiscount.json");
		for(int i=0;i<arr.length();i++) { 
			String fullStartTime ;
			String fullArriveTime;
			Date arriveTimeDate=new Date();
			Date startTimeDate=new Date();
			SimpleDateFormat fd = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
			JSONObject obj=arr.getJSONObject(i);
			String weekday="";
			JSONArray arr2=obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes");
			
			
			String startTime="";
			String arriveTime="";
			boolean flag=false;
			for(int j=0;j<arr2.length();j++) {  
				
				if(getStart().equals(((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getJSONObject("StationName").getString("Zh_tw"))) {
					
					startTime=((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getString("DepartureTime");
					fullStartTime="2021-"+String.valueOf(getMonth())+"-"+String.valueOf(getDay())+" "+startTime;
					startTimeDate=fd.parse(fullStartTime);
					
				}
				if(getDestination().equals(((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getJSONObject("StationName").getString("Zh_tw"))) {
				
					arriveTime=((JSONObject) (obj.getJSONObject("GeneralTimetable").getJSONArray("StopTimes").get(j))).getString("DepartureTime");
					fullArriveTime="2021-"+String.valueOf(getMonth())+"-"+String.valueOf(getDay())+" "+arriveTime;
					arriveTimeDate=fd.parse(fullArriveTime);

				}
				
			}
			
			
			
			SimpleDateFormat weekDay= new SimpleDateFormat ("E");
			String ss=weekDay.format(date);
			switch(ss) {  
			case "週一":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Monday").equals(1)) {
					flag=true;
					weekday="Monday";
				}
				else {flag=false;}
				break;
				
			case "週二":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Tuesday").equals(1)) {
					flag=true;
					weekday="Tuesday";
				}
				else {flag=false;}
				break;
			case "週三":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Wednesday").equals(1)) {
					flag=true;
					weekday="Wednesday";
				}
				else {flag=false;}
				break;
			case "週四":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Thursday").equals(1)) {
					flag=true;
					weekday="Thursday";
				}
				else {flag=false;}
				break;
			case "週五":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Friday").equals(1)) {
					flag=true;
					weekday="Friday";
				}
				else {flag=false;}
				break;
			case "週六":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Saturday").equals(1)) {
					flag=true;
					weekday="Saturday";
				}
				else {flag=false;}
				break;
			case "週日":
				if(obj.getJSONObject("GeneralTimetable").getJSONObject("ServiceDay").get("Sunday").equals(1)) {
					flag=true;
					weekday="Sunday";
				}
				else {flag=false;}
				break;
			}
			
			
			long diff=startTimeDate.getTime()-date.getTime();
			long dayDiff=diff / (1000 * 60 * 60 * 24);
			long hourDiff=(diff/(60*60*1000)-dayDiff*24);
			long minDiff=((diff/(60*1000))-dayDiff*24*60-hourDiff*60);
			
			
			long duration=arriveTimeDate.getTime()-startTimeDate.getTime();
			long dayDuration=duration / (1000 * 60 * 60 * 24);
			long hourDuration=(duration/(60*60*1000)-dayDuration*24);
			long minDuration=((duration/(60*1000))-dayDuration*24*60-hourDuration*60);
			if(flag!=true) {
				
			}
			else if(arriveTime.equals("")||startTime.equals("")) {
				
			}
			else if(duration<0) {
				
			}
			else if(diff<0) {
				
			}
			else if(dayDiff==0&&hourDiff<4&&hourDiff>0){ //顯示4小時內的車
				
				String s;
				if(getTicketT().equals("early")) { 
					for(int p=0;p<early.getJSONArray("DiscountTrains").length();p++) {
						if(((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getString("TrainNo").equals(obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo"))) {
							try {
								for(int y=0;y<((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getJSONArray(weekday).length();y++) {
									if(((JSONObject) ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getJSONArray(weekday).get(y)).getInt("tickets")>0) {
										s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+"早鳥折數:"+((JSONObject) ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getJSONArray(weekday).get(y)).getDouble("discount")+"/"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
										System.out.println(s.toString());
										main=main+s;
										break;
										
									}
								}
							}
							catch(Exception e) {
								if(( ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount")).getInt(weekday)==1) {
									
									s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+"早鳥折數:"+( ((JSONObject) early.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").getInt(weekday))+"/"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
									System.out.println(s.toString());
									main=main+s;
									break;
									
								}
							}
							
						}
						
					}
				}
				else if(getTicketT().equals("student")) { 
					for(int p=0;p<student.getJSONArray("DiscountTrains").length();p++) {
						if(((JSONObject)student.getJSONArray("DiscountTrains").get(p)).getString("TrainNo").equals(obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo"))) {
							
							s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+"大學生折數:"+((JSONObject)student.getJSONArray("DiscountTrains").get(p)).getJSONObject("ServiceDayDiscount").get(weekday)+"/"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
							System.out.println(s.toString());
							main=main+s;
							break;
						}
					}
				}
				
				else {
					s=obj.getJSONObject("GeneralTimetable").getJSONObject("GeneralTrainInfo").getString("TrainNo")+":"+this.getTime()+"/"+this.getStart()+"到"+this.getDestination()+"/出發:"+startTime+"/到達:"+arriveTime+"/"+"行車時間:"+hourDuration+"小時"+minDuration+"分鐘"+" ";
					System.out.println(s.toString());
					main=main+s;
				}
			}
			
			
			
		}
		System.out.println(main);
		return main;
	}
	
	
}