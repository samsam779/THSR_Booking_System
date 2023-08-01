package GUI;

import javax.swing.*;

import ticket.bookingChange;

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.Reader;
public class cancel1 {
 public static JFrame frame;
 private JPanel p1,p6;
 private JButton lastStep,nextStep;
 private JTextField number;
 private String uid,ticketCode;
 public cancel1(String uid,String ticketCode) {
	 this.uid=uid;
	 this.ticketCode=ticketCode;
  frame=new JFrame("減少人數");
  /*
   * 建立一個名為"減少人數"的JFrame
   * 內有兩個JButton
   * 一個JTextField
   */
  p1=new JPanel();
  p1.add(new JLabel("請輸入欲更改之人數(需小於原本):"));
  
  
  JTextField number=new JTextField(3); 
  p1.add(number);
  
  
  p6=new JPanel(); 
  lastStep=new JButton("上一步");
  
  p6.add(lastStep);
  lastStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          cancel i=new cancel(uid);		//回到"退票/減少人數"介面
          frame.setVisible(false);
          
        }
      });
  nextStep=new JButton("下一步");
  p6.add(nextStep);
  nextStep.addActionListener( new ActionListener() {
	  
        public void actionPerformed(ActionEvent ev) {
        	  /*
        	   * 若欲減少人數超出原訂票人數
        	   * 跳出"更改失敗"
        	   * 反之跳出"更改成功"
        	   */
        	try {
        		String s=number.getText();
            	int num=Integer.valueOf(s);
            	bookingChange b= new bookingChange(uid,ticketCode);
            	b.numberChange(num);
            	String strf = "更改成功";
       		 	JOptionPane.showMessageDialog(null,strf);
            	frame.setVisible(false);
        	}catch(Exception e){
        		String strf = "更改失敗";
       		 	JOptionPane.showMessageDialog(null,strf);
            	frame.setVisible(false);
        	}
        	
        }
      });
  
  frame.add(p1);
  frame.add(p6);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setLayout(new GridLayout(0,1));
  frame.setLocationRelativeTo(null);
  frame.setBounds(500,300,300,200);
 }
 
}