package GUI;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class earlyTicket {
 public static JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
 private JButton lastStep,nextStep;
 private JComboBox start,destination,carType,seatType,ticketType;
 private String START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,uid;
 public earlyTicket(String uid) {
	 
	 /*
	  * 建立一個名為"早鳥購票"的JFrame
	  * 內有兩個JButton
	  * 五個JComboBox
	  */
  this.uid=uid;
  frame=new JFrame("早鳥購票");
  p0=new JPanel();
  p0.add(new JLabel("早鳥購票"));
  
  p1=new JPanel();
  p1.add(new JLabel("起訖站"));
  
  p2=new JPanel();
  p2.add(new JLabel("起程站"));
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
  p2.add(start);
  
  p3=new JPanel();
  p3.add(new JLabel("到達站"));
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
  p3.add(destination);
  
  p4=new JPanel();
  p4.add(new JLabel("座位偏好"));
  
  p5=new JPanel();
  p5.add(new JLabel(""));
  seatType = new JComboBox();
  seatType.addItem("無偏好");
  seatType.addItem("靠窗");
  seatType.addItem("靠走道");
  p5.add(seatType);
  
  p6=new JPanel();
  p6.add(new JLabel("車廂種類"));
  
  p7=new JPanel();
  p7.add(new JLabel(""));
  carType = new JComboBox();
  carType.addItem("標準車廂");
  carType.addItem("商業車廂");
  p7.add(carType);
  
  p8=new JPanel();
  p8.add(new JLabel("訂購來回"));
  
  p9=new JPanel();
  p9.add(new JLabel(""));
  ticketType = new JComboBox();
  ticketType.addItem("單程");
  ticketType.addItem("來回");
  p9.add(ticketType);
  
	 
  p10=new JPanel();
  p10.add(new JLabel(""));
  lastStep=new JButton("上一步");
  p10.add(lastStep);
  lastStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          gui2.frame.setVisible(true);	//回到"功能"介面
          frame.setVisible(false); 
        }
      });
  nextStep=new JButton("下一步");
  p10.add(nextStep);
  nextStep.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         int i=ticketType.getSelectedIndex();
	         int i1=start.getSelectedIndex();
	         int i2=destination.getSelectedIndex();
	         
        	 START=(String)start.getSelectedItem();
        	 DESTINATION=(String)destination.getSelectedItem();
        	 CARTYPE=(String)carType.getSelectedItem();
        	 SEATTYPE=(String)seatType.getSelectedItem();
        	 TICKETTYPE=(String)ticketType.getSelectedItem();
        	 
	         if(i1==i2) {
	        	 String strf = "起程站不可等於到達站";	//若啟程站等於到達站 出現錯誤訊息
	        	 JOptionPane.showMessageDialog(null,strf);
	         }

	         //根據選擇"單程"或"來回"分別進入不同介面
	       
	         else if(i==0) {
	        	 earlyTicket1 n=new earlyTicket1(START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,uid);
		         frame.setVisible(false);
	         }
	         else if(i==1) {
	        	 earlyTicket2 n=new earlyTicket2(START,DESTINATION,CARTYPE,SEATTYPE,TICKETTYPE,uid);
		         frame.setVisible(false);
	         }
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
  frame.setVisible(true);
  frame.setLocationRelativeTo(null);
  frame.setLayout(new GridLayout(0,1));
  frame.setBounds(500,200,350,500);
 }
}