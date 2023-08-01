package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ticket.Train_Exception;
import ticket.ticket;

public class testticket {
	 private JFrame frame;
	 private JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
	 private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,lastStep,nextStep;
	 private JComboBox goCom,backCom;
	 private int normalN,elderN,disabledN,kidN;
	 private String START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,uid,earlyOrStu;
	 private Date date,backDate;
	 public testticket(String START,String DESTINATION,String CARTYPE,String SEATTYPE,String TICKETTYPE,String uid,int normalN,int elderN,int disabledN,int kidN,Date date) throws ParseException  {
		 this.START=START;
		 this.DESTINATION=DESTINATION;
		 this.CARTYPE=CARTYPE;
		 this.SEATTYPE=SEATTYPE;
		 this.TICKETTYPE=TICKETTYPE;
		 this.uid=uid;
		 this.normalN=normalN;
		 this.elderN=elderN;
		 this.disabledN=disabledN;
		 this.kidN=kidN;
		 this.date=date;
		 frame=new JFrame("車號");
		 /*
		   * 建立一個名為"車號"的JFrame
		   * 內有12個JButton
		   * 2個JComboBox
		   */
		/*
		 *按上一步後 回到"功能"介面
		 *
		 *選擇欲訂購之班次後
		 *按下一步後 出現訂票資訊
		 */
		 goCom=new JComboBox();
		 p0=new JPanel();
		 p1=new JPanel();
		 p2=new JPanel();
		 p3=new JPanel();
		 p4=new JPanel();
		 p5=new JPanel();
		 p7=new JPanel();
		 b0=new JButton();
		 b1=new JButton();
		 b2=new JButton();
		 b3=new JButton();
		 b4=new JButton();
		 ticket t=new ticket(date,uid,START,DESTINATION,"normal",normalN);
		 String s=t.to();
		 String[] sarr=s.split(" ");//將符合的列車字串拆解
		 int k=0;
		 for(int i=0;i<sarr.length;i++) {//將列車選項顯示於介面上，並提供選擇
			 switch(k) {
			 case 0:
				 b0.add(new JLabel(sarr[i]));
				 p0.add(b0);
				 goCom.addItem(sarr[i]);
				 break;
			 case 1:
				 b1.add(new JLabel(sarr[i]));
				 p1.add(b1);
				 goCom.addItem(sarr[i]);
				 break;
			 case 2:
				 b2.add(new JLabel(sarr[i]));
				 p2.add(b2);
				 goCom.addItem(sarr[i]);
				 break;
			 case 3:
				 b3.add(new JLabel(sarr[i]));
				 p3.add(b3);
				 goCom.addItem(sarr[i]);
				 break;
			 case 4:
				 b4.add(new JLabel(sarr[i]));
				 p4.add(b4);
				 goCom.addItem(sarr[i]);
				 break;
			 }
			 k++;
		 }
		 p5.add(goCom);
		  lastStep=new JButton("上一步");
		  p7.add(lastStep);
		  lastStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		      
		          gui2.frame.setVisible(true);	
		          frame.setVisible(false);
		          
		        }
		      });
		  nextStep=new JButton("下一步");
		  p7.add(nextStep);
		  nextStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		        	
		        	String choosed=(String) goCom.getSelectedItem();
		        	System.out.println(choosed);
		        	try {//根據所選的列車進入到下個介面
						ticketBookedGui j =new ticketBookedGui(uid,START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,normalN,elderN,disabledN,kidN,date,choosed);
					} catch (Train_Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      
		          
		          frame.setVisible(false);
		          
		        }
		      });
		 
		 frame.add(p0);
		 frame.add(p1);
		 frame.add(p2);
		 frame.add(p3);
		 frame.add(p4);
		 frame.add(p5);
		 frame.add(p7);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  frame.setLayout(new GridLayout(0,1));
		  frame.setLocationRelativeTo(null);
		  frame.setBounds(500,200,350,250);
	 }
	 
	 //後面三個constructor概念和第一個相同，第二個改為一般訂票來回票，故一樣的動作做兩次，第三個則為學生或早鳥票的單程票，會額外再顯示折數，第四個則為早鳥或學生票的來回票
	 public testticket(String START,String DESTINATION,String CARTYPE,String SEATTYPE,String TICKETTYPE,String uid,int normalN,int elderN,int disabledN,int kidN,Date date,Date backDate) throws ParseException  {
		 this.START=START;
		 this.DESTINATION=DESTINATION;
		 this.CARTYPE=CARTYPE;
		 this.SEATTYPE=SEATTYPE;
		 this.TICKETTYPE=TICKETTYPE;
		 this.uid=uid;
		 this.normalN=normalN;
		 this.elderN=elderN;
		 this.disabledN=disabledN;
		 this.kidN=kidN;
		 this.date=date;
		 this.backDate=backDate;
		 
		 frame=new JFrame("車號");
		 
		 goCom=new JComboBox();
		 backCom=new JComboBox();
		 p0=new JPanel();
		 p1=new JPanel();
		 p2=new JPanel();
		 p3=new JPanel();
		 p4=new JPanel();
		 p5=new JPanel();
		 p6=new JPanel();
		 p7=new JPanel();
		 p8=new JPanel();
		 p9=new JPanel();
		 p10=new JPanel();
		 p11=new JPanel();
		 p12=new JPanel();
		 p13=new JPanel();
		 p14=new JPanel();
		 
		 b0=new JButton();
		 b1=new JButton();
		 b2=new JButton();
		 b3=new JButton();
		 b4=new JButton();
		 b5=new JButton();
		 b6=new JButton();
		 b7=new JButton();
		 b8=new JButton();
		 b9=new JButton();
		 b10=new JButton();
		 
		 ticket go=new ticket(date,uid,START,DESTINATION,"normal",normalN);
		 ticket back=new ticket(backDate,uid,DESTINATION,START,"normal",normalN);
		 String goString=go.to();
		 String backString=back.to();
		 String[] goArr=goString.split(" ");
		 String[] backArr=backString.split(" ");
		 int k=0;
		 int m=0;
		 for(int i=0;i<goArr.length;i++) {
			 switch(k) {
			 case 0:
				 b0.add(new JLabel(goArr[i]));
				 p1.add(b0);
				 goCom.addItem(goArr[i]);
				 break;
			 case 1:
				 b1.add(new JLabel(goArr[i]));
				 p2.add(b1);
				 goCom.addItem(goArr[i]);
				 break;
			 case 2:
				 b2.add(new JLabel(goArr[i]));
				 p3.add(b2);
				 goCom.addItem(goArr[i]);
				 break;
			 case 3:
				 b3.add(new JLabel(goArr[i]));
				 p4.add(b3);
				 goCom.addItem(goArr[i]);
				 break;
			 case 4:
				 b4.add(new JLabel(goArr[i]));
				 p5.add(b4);
				 goCom.addItem(goArr[i]);
				 break;
			 }
			 k++;
		 }
		 
		 for(int i=0;i<backArr.length;i++) {
			 switch(m) {
			 case 0:
				 b5.add(new JLabel(backArr[i]));
				 p8.add(b5);
				 backCom.addItem(backArr[i]);
				 break;
			 case 1:
				 b6.add(new JLabel(backArr[i]));
				 p9.add(b6);
				 backCom.addItem(backArr[i]);
				 break;
			 case 2:
				 b7.add(new JLabel(backArr[i]));
				 p10.add(b7);
				 backCom.addItem(backArr[i]);
				 break;
			 case 3:
				 b8.add(new JLabel(backArr[i]));
				 p11.add(b8);
				 backCom.addItem(backArr[i]);
				 break;
			 case 4:
				 b9.add(new JLabel(backArr[i]));
				 p12.add(b9);
				 backCom.addItem(backArr[i]);
				 break;
			 }
			 m++;
		 }
		 p6.add(goCom);
		 p13.add(backCom);
		 
		 p0.add(new JLabel("去程"));
		 p7.add(new JLabel("回程"));
		  lastStep=new JButton("上一步");
		  p14.add(lastStep);
		  lastStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		      
		          gui2.frame.setVisible(true);	
		          frame.setVisible(false);
		          
		        }
		      });
		  
		  nextStep=new JButton("下一步");
		  p14.add(nextStep);
		  nextStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		        	String choosed=(String) goCom.getSelectedItem();
		        	String choosed2=(String) backCom.getSelectedItem();
		          try {
					ticketBookedGui t=new ticketBookedGui(uid,START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,normalN,elderN,disabledN,kidN,date,backDate,choosed,choosed2);
				} catch (Train_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          frame.setVisible(false);
		          
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
		 frame.add(p8);
		 frame.add(p9);
		 frame.add(p10);
		 frame.add(p11);
		 frame.add(p12);
		 frame.add(p13);
		 frame.add(p14);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  frame.setLayout(new GridLayout(0,1));
		  frame.setLocationRelativeTo(null);
		  frame.setBounds(500,200,350,250);
	 }
	 
	 public testticket(String START,String DESTINATION,String CARTYPE,String SEATTYPE,String TICKETTYPE,String uid,int normalN,Date date,String earlyOrStu) throws ParseException  {
		 this.START=START;
		 this.DESTINATION=DESTINATION;
		 this.CARTYPE=CARTYPE;
		 this.SEATTYPE=SEATTYPE;
		 this.TICKETTYPE=TICKETTYPE;
		 this.uid=uid;
		 this.normalN=normalN;
		 this.date=date;
		 this.earlyOrStu=earlyOrStu;
		 frame=new JFrame("車號");
		 goCom=new JComboBox();
		 
		 p0=new JPanel();
		 p1=new JPanel();
		 p2=new JPanel();
		 p3=new JPanel();
		 p4=new JPanel();
		 p5=new JPanel();
		 p7=new JPanel();
		 b0=new JButton();
		 b1=new JButton();
		 b2=new JButton();
		 b3=new JButton();
		 b4=new JButton();
		 ticket t=new ticket(date,uid,START,DESTINATION,earlyOrStu,normalN);
		 String s=t.to();
		 String[] sarr=s.split(" ");
		 int k=0;
		 for(int i=0;i<sarr.length;i++) {
			 switch(k) {
			 case 0:
				 b0.add(new JLabel(sarr[i]));
				 p0.add(b0);
				 goCom.addItem(sarr[i]);
				 break;
			 case 1:
				 b1.add(new JLabel(sarr[i]));
				 p1.add(b1);
				 goCom.addItem(sarr[i]);
				 break;
			 case 2:
				 b2.add(new JLabel(sarr[i]));
				 p2.add(b2);
				 goCom.addItem(sarr[i]);
				 break;
			 case 3:
				 b3.add(new JLabel(sarr[i]));
				 p3.add(b3);
				 goCom.addItem(sarr[i]);
				 break;
			 case 4:
				 b4.add(new JLabel(sarr[i]));
				 p4.add(b4);
				 goCom.addItem(sarr[i]);
				 break;
			 }
			 k++;
		 }
		 p5.add(goCom);
		  lastStep=new JButton("上一步");
		  p7.add(lastStep);
		  lastStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		      
		          gui2.frame.setVisible(true);
		          frame.setVisible(false);
		          
		        }
		      });
		  
		  nextStep=new JButton("下一步");
		  p7.add(nextStep);
		  nextStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		      
		        	String choosed=(String) goCom.getSelectedItem();
		        	System.out.println(choosed);
		        	try {
						ticketBookedGui j =new ticketBookedGui(uid,START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,normalN,date,choosed,earlyOrStu);
					} catch (Train_Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		          frame.setVisible(false);
		          
		        }
		      });
		 
		 frame.add(p0);
		 frame.add(p1);
		 frame.add(p2);
		 frame.add(p3);
		 frame.add(p4);
		 frame.add(p5);
		 frame.add(p7);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  frame.setLayout(new GridLayout(0,1));
		  frame.setLocationRelativeTo(null);
		  frame.setBounds(500,200,350,250);
	 }
	 public testticket(String START,String DESTINATION,String CARTYPE,String SEATTYPE,String TICKETTYPE,String uid,int normalN,Date goDate,Date backDate,String earlyOrStu) throws ParseException  {
		 this.START=START;
		 this.DESTINATION=DESTINATION;
		 this.CARTYPE=CARTYPE;
		 this.SEATTYPE=SEATTYPE;
		 this.TICKETTYPE=TICKETTYPE;
		 this.uid=uid;
		 this.normalN=normalN;
		 this.date=goDate;
		 this.backDate=backDate;
		 
		 frame=new JFrame("車號");
		 
		 goCom=new JComboBox();
		 backCom=new JComboBox();
		 p0=new JPanel();
		 p1=new JPanel();
		 p2=new JPanel();
		 p3=new JPanel();
		 p4=new JPanel();
		 p5=new JPanel();
		 p6=new JPanel();
		 p7=new JPanel();
		 p8=new JPanel();
		 p9=new JPanel();
		 p10=new JPanel();
		 p11=new JPanel();
		 p12=new JPanel();
		 p13=new JPanel();
		 p14=new JPanel();
		 
		 b0=new JButton();
		 b1=new JButton();
		 b2=new JButton();
		 b3=new JButton();
		 b4=new JButton();
		 b5=new JButton();
		 b6=new JButton();
		 b7=new JButton();
		 b8=new JButton();
		 b9=new JButton();
		 b10=new JButton();
		 
		 ticket go=new ticket(date,uid,START,DESTINATION,earlyOrStu,normalN);
		 ticket back=new ticket(backDate,uid,DESTINATION,START,earlyOrStu,normalN);
		 String goString=go.to();
		 String backString=back.to();
		 String[] goArr=goString.split(" ");
		 String[] backArr=backString.split(" ");
		 int k=0;
		 int m=0;
		 for(int i=0;i<goArr.length;i++) {
			 switch(k) {
			 case 0:
				 b0.add(new JLabel(goArr[i]));
				 p1.add(b0);
				 goCom.addItem(goArr[i]);
				 break;
			 case 1:
				 b1.add(new JLabel(goArr[i]));
				 p2.add(b1);
				 goCom.addItem(goArr[i]);
				 break;
			 case 2:
				 b2.add(new JLabel(goArr[i]));
				 p3.add(b2);
				 goCom.addItem(goArr[i]);
				 break;
			 case 3:
				 b3.add(new JLabel(goArr[i]));
				 p4.add(b3);
				 goCom.addItem(goArr[i]);
				 break;
			 case 4:
				 b4.add(new JLabel(goArr[i]));
				 p5.add(b4);
				 goCom.addItem(goArr[i]);
				 break;
			 }
			 k++;
		 }
		 
		 for(int i=0;i<backArr.length;i++) {
			 switch(m) {
			 case 0:
				 b5.add(new JLabel(backArr[i]));
				 p8.add(b5);
				 backCom.addItem(backArr[i]);
				 break;
			 case 1:
				 b6.add(new JLabel(backArr[i]));
				 p9.add(b6);
				 backCom.addItem(backArr[i]);
				 break;
			 case 2:
				 b7.add(new JLabel(backArr[i]));
				 p10.add(b7);
				 backCom.addItem(backArr[i]);
				 break;
			 case 3:
				 b8.add(new JLabel(backArr[i]));
				 p11.add(b8);
				 backCom.addItem(backArr[i]);
				 break;
			 case 4:
				 b9.add(new JLabel(backArr[i]));
				 p12.add(b9);
				 backCom.addItem(backArr[i]);
				 break;
			 }
			 m++;
		 }
		 p6.add(goCom);
		 p13.add(backCom);
		 
		 p0.add(new JLabel("去程"));
		 p7.add(new JLabel("回程"));
		  lastStep=new JButton("上一步");
		  p14.add(lastStep);
		  lastStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		      
		          gui2.frame.setVisible(true);
		          frame.setVisible(false);
		          
		        }
		      });
		  
		  nextStep=new JButton("下一步");
		  p14.add(nextStep);
		  nextStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		        	String choosed=(String) goCom.getSelectedItem();
		        	String choosed2=(String) backCom.getSelectedItem();
		      
		          try {
					ticketBookedGui t=new ticketBookedGui(uid,START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,normalN,date,backDate,choosed,choosed2);
				} catch (Train_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		          frame.setVisible(false);
		          
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
		 frame.add(p8);
		 frame.add(p9);
		 frame.add(p10);
		 frame.add(p11);
		 frame.add(p12);
		 frame.add(p13);
		 frame.add(p14);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  frame.setLayout(new GridLayout(0,1));
		  frame.setLocationRelativeTo(null);
		  frame.setBounds(500,200,350,250);
	 }

}