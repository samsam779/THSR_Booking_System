package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;
public class search4 {
 public static JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
 private JButton lastStep,nextStep;
 private JComboBox start,destination,time;
 private String format1 ="[1-9]";
 private String format2 ="[1-9]"+"[0-9]";
 private String uid;
 public search4(String uid) {
	 this.uid=uid;
  frame=new JFrame("查詢優惠車次");
  /*
   * 建立一個名為"查詢優惠車次"的JFrame
   * 內有兩個JButton
   * 兩個JTextField
   * 三個JComboBox
   */
  p0=new JPanel();
  p0.add(new JLabel("請輸入車次資訊"));
  
  p1=new JPanel();
  p1.add(new JLabel("日期"));
  
  p2=new JPanel();
  p2.add(new JLabel("2021年"));
  JTextField month=new JTextField();  
  month.setColumns(2);
  p2.add(month);
  p2.add(new JLabel("月"));
  JTextField day=new JTextField();  
  day.setColumns(2);
  p2.add(day);
  p2.add(new JLabel("日"));
  
  p3=new JPanel();
  p3.add(new JLabel("時間"));
  
  p4=new JPanel();
  p4.add(new JLabel(""));
  time = new JComboBox();
  time.addItem("00:00");
  time.addItem("00:30");
  time.addItem("05:00");
  time.addItem("05:30");
  time.addItem("06:00");
  time.addItem("06:30");
  time.addItem("07:00");
  time.addItem("07:30");
  time.addItem("08:00");
  time.addItem("08:30");
  time.addItem("09:00");
  time.addItem("09:30");
  time.addItem("10;00");
  time.addItem("10:30");
  time.addItem("11:00");
  time.addItem("11:30");
  time.addItem("12:00");
  time.addItem("12:30");
  time.addItem("13:00");
  time.addItem("13:30");
  time.addItem("14:00");
  time.addItem("14:30");
  time.addItem("15:00");
  time.addItem("15:30");
  time.addItem("16:00");
  time.addItem("16:30");
  time.addItem("17:00");
  time.addItem("17:30");
  time.addItem("18:00");
  time.addItem("18:30");
  time.addItem("19:00");
  time.addItem("19:30");
  time.addItem("20:00");
  time.addItem("20:30");
  time.addItem("21:00");
  time.addItem("21:30");
  time.addItem("22:00");
  time.addItem("22:30");
  time.addItem("23:00");
  time.addItem("23:30");
  p4.add(time);
  
  p5=new JPanel();
  p5.add(new JLabel("起訖站"));
  
  p6=new JPanel();
  p6.add(new JLabel("起程站"));
  start = new JComboBox();
  start.addItem("南港");
  start.addItem("台北");
  start.addItem("板橋");
  start.addItem("桃園");
  start.addItem("新竹");
  start.addItem("苗栗");
  start.addItem("台中");
  start.addItem("彰化");
  start.addItem("雲林");
  start.addItem("嘉義");
  start.addItem("台南");
  start.addItem("左營");
  p6.add(start);
  
  p7=new JPanel();
  p7.add(new JLabel("到達站"));
  destination = new JComboBox();
  destination.addItem("南港");
  destination.addItem("台北");
  destination.addItem("板橋");
  destination.addItem("桃園");
  destination.addItem("新竹");
  destination.addItem("苗栗");
  destination.addItem("台中");
  destination.addItem("彰化");
  destination.addItem("雲林");
  destination.addItem("嘉義");
  destination.addItem("台南");
  destination.addItem("左營");
  p7.add(destination);
  
  
  
  
	 
  p10=new JPanel();
  p10.add(new JLabel(""));
  lastStep=new JButton("上一步");
  p10.add(lastStep);
  lastStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          search i=new search(uid);	//回到"查詢"介面
          frame.setVisible(false); 
        }
      });
  nextStep=new JButton("下一步");
  p10.add(nextStep);
  nextStep.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	        	
	        String strf = "";
	        String str1 = new String(month.getText());
	        String str2 = new String(day.getText());
	        
	        String strMonth=(String)(month.getText());
	        String strDay=(String)(month.getText());
	        String strTime=new String((String)time.getSelectedItem());
	        Date date=new Date("2021/"+str1+"/"+str2+" "+strTime);
	        String START=(String)start.getSelectedItem();
	        String DESTINATION=(String)destination.getSelectedItem();
	        int i1=start.getSelectedIndex();
	        int i2=destination.getSelectedIndex();
	        /* 
             * 日期格式錯誤
             * 啟程站等於到達站
             * 則跳出錯誤訊息
             * 若一切正確 顯示優惠車次
             */
	     if ((str1.matches(format1)||str1.matches(format2))&&(str2.matches(format1)||str2.matches(format2))) {
	          	  

	         int int1 = Integer.parseInt(str1);
	         int int2 = Integer.parseInt(str2);
	         if(i1==i2) {
	        	 strf = "起程站不可等於到達站";
	        	 
	         }
	         else if (int1==1||int1==3||int1==5||int1==7||int1==8||int1==10||int1==12) {
	           	if(int2<=31&&int2>=1) {
	           		try {
						search4_ i=new search4_(date,uid,START,DESTINATION);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           		frame.setVisible(false);
	           		strf = "查詢成功";
	           	}
	           	else {
	           		strf = "請輸入正確的日期格式";
	           	}
	             }
	              
	         else if(int1==2){
	           	if(int2<=28&&int2>=1) {
	           		try {
						search4_ i=new search4_(date,uid,START,DESTINATION);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           		frame.setVisible(false);
	           		strf = "查詢成功";
	           	  }
	           	  else {
	           		strf = "請輸入正確的日期格式";
	               }
	              }
	             
	         else if(int1==4||int1==6||int1==9||int1==11) {
	               if(int2<=30&&int2>=1) {
	            	   try {
							search4_ i=new search4_(date,uid,START,DESTINATION);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	             		frame.setVisible(false);
	             		strf = "查詢成功";
	             	}
	             	else {
	             		strf = "請輸入正確的日期格式";
	               }
	             }
	             
	         else {
	           	  strf = "請輸入正確的日期格式";
	             }
	             
	        }else {
	           	  strf = "請輸入正確的日期格式";
	             }
	     
	     JOptionPane.showMessageDialog(null,strf);
	        }
	      });
	 
  
  frame.add(p0);
  frame.add(p1);
  frame.add(p2);
  frame.add(p3);
  frame.add(p4);
  frame.add(p5);
  frame.add(p6);
  frame.add(p7);
  frame.add(p10);
  frame.setVisible(true);
  frame.setLocationRelativeTo(null);
  frame.setLayout(new GridLayout(0,1));
  frame.setBounds(500,200,350,500);
 }
}