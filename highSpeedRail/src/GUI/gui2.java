package GUI;



import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.Reader;
public class gui2 {
 public static JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5,p6,p7;
 private JButton normal,early,student,seat,lastStep,cancel,search;
 private String uid;
 public gui2(String uid) {
	 
/*
 * 建立一個名為"功能"的JFrame
 * 內有七個JButton
 */
	 
  this.uid=uid;
  frame=new JFrame("功能");
  p0=new JPanel();
  p0.add(new JLabel("選擇功能"));
  
  
  p1=new JPanel();
  
  
  p2=new JPanel();
  
  
  p3=new JPanel();
  
  
  p4=new JPanel();
  
  
  p5=new JPanel();
  
  
  p6=new JPanel();
  
  p7=new JPanel();
  
  normal=new JButton("一般訂票");
  p1.add(normal);
  normal.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         normalTicket n=new normalTicket(uid);	//進入"一般購票"介面
         frame.setVisible(false);
        }
      });
  
  early=new JButton("早鳥訂票");
  early.setBounds(40, 150, 100, 20);
  p2.add(early);
  early.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         earlyTicket n=new earlyTicket(uid);	//進入"早鳥購票"介面
         frame.setVisible(false);
        }
      });
  
  student=new JButton("學生訂票");
  student.setBounds(40, 200, 100, 20);
  p3.add(student);
  student.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         studentTicket n=new studentTicket(uid);	//進入"學生購票"介面
         frame.setVisible(false);
        }
      });
  
  seat=new JButton("座位表");
  seat.setBounds(40, 200, 100, 20);
  p4.add(seat);
  seat.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         seatingChart n=new seatingChart();		//進入"座位表"介面
         frame.setVisible(false);
        }
      });
  
  
  search=new JButton("查詢");
  search.setBounds(40, 200, 100, 20);
  p5.add(search);
  search.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         search n=new search(uid);	//進入"查詢"介面
         frame.setVisible(false);
        }
      });

  cancel=new JButton("退票/減少人數");
  cancel.setBounds(40, 200, 100, 20);
  p6.add(cancel);
  cancel.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        	cancel n=new cancel(uid);	//進入"退票/減少人數"介面
         frame.setVisible(false);
        }
      });
  

  
  
  lastStep=new JButton("上一步");
  
  p7.add(lastStep);
  lastStep.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          gui i=new gui();	//	回到"登入介面"
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
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setLayout(new GridLayout(0,1));
  frame.setLocationRelativeTo(null);
  frame.setBounds(500,200,350,250);
 }
 
}