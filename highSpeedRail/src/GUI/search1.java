


package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import search.reservationCode;
public class search1 {
 private JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5,p6,p7;
 private JButton lastStep,nextStep;
 private JTextField userID,ticketNumber;
 private String format2 ="[0-9]{9}";
 private String format1 ="[A-Z]"+"[0-9]{9}";
 
 public search1(String uid) {
  frame=new JFrame("查詢訂票-有訂位代號");
  /*
   * 建立一個名為"查詢訂票-有訂位代號"的JFrame
   * 內有兩個JButton
   * 兩個JTextField
   */
  p0=new JPanel();
  
  
  p1=new JPanel();  
  
  
  p2=new JPanel();
  p2.add(new JLabel("請輸入訂位代號"));
  
  p3=new JPanel();  
  JTextField ticketNumber=new JTextField(20); 
  p3.add(ticketNumber);
  
  p7=new JPanel();
  p7.add(new JLabel(""));
  lastStep=new JButton("上一步");
  lastStep=new JButton("上一步");
  p7.add(lastStep);
  lastStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          search i=new search(uid);	//回到"查詢"介面
          frame.setVisible(false);
          
        }
      });
  nextStep=new JButton("下一步");
  p7.add(nextStep);
  nextStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        	 /* 
             * 身分證格式錯誤
             * 訂票代碼格式錯誤
             * 則跳出錯誤訊息
             * 若一切正確 顯示訂票資訊
             */
        	 String strf = "";

             String str2 = new String(ticketNumber.getText());
             if (uid.matches(format1)) {
            	 if(str2.matches(format2)) {
            		 reservationCode t =new reservationCode(uid,str2);
            		 String out=t.gettrainformation();
            		 if(out.equals("")) {
            			 frame.setVisible(false);
                         strf = "查無資訊";
            		 }
            		 else {
            			 frame.setVisible(false);
                         strf = out;
            		 }
            		 
            	 }
            	 else {
            		 strf = "請輸入正確的訂票代碼格式";
            	 }
               }
             
             else {
                 strf = "請輸入正確的身分證及訂票代碼格式";
               }
               JOptionPane.showMessageDialog(null,strf);
               System.exit(0);
             
        }
      });
  

 
  
  frame.add(p0);
  frame.add(p1);
  frame.add(p2);
  frame.add(p3);
  frame.add(p7);
  frame.setVisible(true);
  frame.setLocationRelativeTo(null);
  frame.setLayout(new GridLayout(0,1));
  frame.setBounds(500,200,500,500);
 }
}