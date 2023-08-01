package ticket;

import java.util.Date;
//booking是ticket的parent class 用來幫變觀察ticket中的變數有哪些，協助在寫程式時能夠透過此class理解參數的意義
public class booking {
	
	public Date date;
	
	private String uid;
	private String month;
	private String day;
	private String time;
	private String start;
	private String destination;
	private int number;
	enum seatType{window,aisle,NO};
	private String seatT;
	enum ticketType{normal,kid,elder,disabled,early,student};
	private String ticketT;
	private String earlyDiscount;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTicketT() {
		return ticketT;
	}
	public void setTicketT(String ticketT) {
		this.ticketT = ticketT;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSeatT() {
		return seatT;
	}
	public void setSeatT(String seatT2) {
		this.seatT = seatT2;
	}
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getEarlyDiscount() {
		return earlyDiscount;
	}
	public void setEarlyDiscount(String earlyDiscount) {
		this.earlyDiscount = earlyDiscount;
	}

}
