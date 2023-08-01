package GUI;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.Reader;
public class search {
 public static JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5;
 private JButton search1,search2,search3,search4,lastStep;
 private String uid;
 public search(String uid) {
	 this.uid=uid;
  frame=new JFrame("查詢");
  p0=new JPanel();
  p0.add(new JLabel("選擇功能"));
  /*
   * 建立一個名為"查詢"的JFrame
   * 內有五個JButton
   */
  
  p1=new JPanel();
  
  p2=new JPanel();
  
  p3=new JPanel();
  
  p4=new JPanel();
  
  p5=new JPanel();
  
  search1=new JButton("查詢訂票-有訂位代號");
  p1.add(search1);
  search1.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         search1 n=new search1(uid);	//進入"查詢訂票-有訂位代號"介面
         frame.setVisible(false);
        }
      });
  
  search2=new JButton("查詢訂位代號");
  p2.add(search2);
  search2.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         search2 n=new search2(uid);	//進入"查詢訂位代號"介面
         frame.setVisible(false);
        }
      });
  
  search3=new JButton("當日時刻表查詢");
  p3.add(search3);
  search3.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         search3 n=new search3(uid);	//進入"當日時刻表查詢"介面
         frame.setVisible(false);
        }
      });
  
  search4=new JButton("查詢優惠車次");
  p4.add(search4);
  search4.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         search4 n=new search4(uid);	//進入"查詢優惠車次"介面
         frame.setVisible(false);
        }
      });
  
  
  
  lastStep=new JButton("上一步");
  p5.add(lastStep);
  lastStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          gui2 i=new gui2(uid);
          frame.setVisible(false);	//回到"功能"介面
          
        }
      });
  
  frame.add(p0);
  frame.add(p1);
  frame.add(p2);
  frame.add(p3);
  frame.add(p4);
  frame.add(p5);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setLayout(new GridLayout(0,1));
  frame.setLocationRelativeTo(null);
  frame.setBounds(500,200,350,500);
 }
 
}