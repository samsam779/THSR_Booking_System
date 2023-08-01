package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import search.timeTable;

public class search3 {
	public static JFrame frame;
	private JPanel p0,p1,p2,p3,p4,p5;
	private String format1 ="[1-9]";
	private String format2 ="[1-9]"+"[0-9]";
	private JButton north,south,lastStep;
	private int YEAR,MONTH,DAY;
	private String uid;
	search3(String uid){
		this.uid=uid;
		frame=new JFrame("時刻表查詢");
		p0=new JPanel();
		  /*
		   * 建立一個名為"時刻表查詢"的JFrame
		   * 內有三個JButton
		   * 兩個JTextField
		   */
		p0.add(new JLabel("時刻表查詢")); 
		p1=new JPanel();
		p1.add(new JLabel("請輸入日期"));
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
		north=new JButton("北上");
		p3.add(north);
		p4=new JPanel();
		north.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		        	 /* 
		             * 日期格式錯誤
		             * 則跳出錯誤訊息
		             * 若一切正確 顯示北上時刻表
		             */
		        	String strf = "";
		            String str1 = new String(month.getText());
		            String str2 = new String(day.getText());
		            int int1 = Integer.parseInt(str1);
		            int int2 = Integer.parseInt(str2);
		            YEAR=2021;
		            MONTH=int1;
		            DAY=int2;
		            
		            if ((str1.matches(format1)||str1.matches(format2))&&(str2.matches(format1)||str2.matches(format2))) {
		          	
		            if (int1==1||int1==3||int1==5||int1==7||int1==8||int1==10||int1==12) {
		          	if(int2<=31&&int2>=1) {
		          		
		          		timeTable t =new timeTable(YEAR,MONTH,DAY);
		          		System.out.println(YEAR+"年"+MONTH+"月"+DAY+"日");
		          		System.out.println(t.gettimeTable2());
		          		//searchTimeTable1 s=new searchTimeTable1(YEAR,MONTH,DAY);
		          	}
		          	else {
		          		strf = "請輸入正確的日期格式";
		          	}
		            }
		            else if(int1==2){
		          	if(int2<=28&&int2>=1) {
		          		
		          		timeTable t =new timeTable(YEAR,MONTH,DAY);
		          		System.out.println(YEAR+"年"+MONTH+"月"+DAY+"日");
		          		System.out.println(t.gettimeTable2());
		          		//searchTimeTable1 s=new searchTimeTable1(YEAR,MONTH,DAY);
		          	}
		          	else {
		          		strf = "請輸入正確的日期格式";
		              }
		            }
		            else if(int1==4||int1==6||int1==9||int1==11) {
		              if(int2<=30&&int2>=1) {
		            		
		            		timeTable t =new timeTable(YEAR,MONTH,DAY);
		            		System.out.println(YEAR+"年"+MONTH+"月"+DAY+"日");
		            		System.out.println(t.gettimeTable2());
		            		//searchTimeTable1 s=new searchTimeTable1(YEAR,MONTH,DAY);
		            	}
		            	else {
		            		strf = "請輸入正確的日期格式";
		              }
		            }
		            else {
		          	  strf = "請輸入正確的日期格式";
		            }
		            }
		            else {
		          	  strf = "請輸入正確的日期格式";
		            }
		            JOptionPane.showMessageDialog(null,strf);
		            System.exit(0);
		          }
		        	
		            
		         
		         
		        
		});
		
		south=new JButton("南下");
		p3.add(south);
		south.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		        	
		        	 /* 
		             * 日期格式錯誤
		             * 則跳出錯誤訊息
		             * 若一切正確 顯示南下時刻表
		             */
		            String strf = "";
		            String str1 = new String(month.getText());
		            String str2 = new String(day.getText());
		            int int1 = Integer.parseInt(str1);
		            int int2 = Integer.parseInt(str2);
		            YEAR=2021;
		            MONTH=int1;
		            DAY=int2;
		            
		            if ((str1.matches(format1)||str1.matches(format2))&&(str2.matches(format1)||str2.matches(format2))) {
		          	
		            if (int1==1||int1==3||int1==5||int1==7||int1==8||int1==10||int1==12) {
		          	if(int2<=31&&int2>=1) {
		          		
		          		timeTable t =new timeTable(YEAR,MONTH,DAY);
		          		System.out.println(YEAR+"年"+MONTH+"月"+DAY+"日");
		          		System.out.println(t.gettimeTable1());
		          		
		          	}
		          	else {
		          		strf = "請輸入正確的日期格式";
		          	}
		            }
		            else if(int1==2){
		          	if(int2<=28&&int2>=1) {
		          		
		          		timeTable t =new timeTable(YEAR,MONTH,DAY);
		          		System.out.println(YEAR+"年"+MONTH+"月"+DAY+"日");
		          		System.out.println(t.gettimeTable1());
		          		//searchTimeTable1 s=new searchTimeTable1(YEAR,MONTH,DAY);
		          	}
		          	else {
		          		strf = "請輸入正確的日期格式";
		              }
		            }
		            else if(int1==4||int1==6||int1==9||int1==11) {
		              if(int2<=30&&int2>=1) {
		            		
		            		timeTable t =new timeTable(YEAR,MONTH,DAY);
		            		System.out.println(YEAR+"年"+MONTH+"月"+DAY+"日");
		            		System.out.println(t.gettimeTable1());
		            		//searchTimeTable1 s=new searchTimeTable1(YEAR,MONTH,DAY);
		            	}
		            	else {
		            		strf = "請輸入正確的日期格式";
		              }
		            }
		            else {
		          	  strf = "請輸入正確的日期格式";
		            }
		            }
		            else {
		          	  strf = "請輸入正確的日期格式";
		            }
		            JOptionPane.showMessageDialog(null,strf);
		            System.exit(0);
		          
		        }
		});
		lastStep=new JButton("上一步");
		  p4.add(lastStep);
		  lastStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		          search i=new search(uid);	//回到"查詢"介面
		          frame.setVisible(false); 
		        }
		      });
		  frame.add(p0);
		  frame.add(p1);
		  frame.add(p2);
		  frame.add(p3);
		  frame.add(p4);
		  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
		  frame.setLayout(new GridLayout(0,1));
		  frame.setLocationRelativeTo(null);
		  frame.setBounds(500,200,350,250);
	}
	
	

}