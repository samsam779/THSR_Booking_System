package ticket;

public class Train_Exception extends Exception{
	private String str;
	Train_Exception(String str){
		this.str=str;
	}
	
	public String getMessage() {
		return str;
	}
}