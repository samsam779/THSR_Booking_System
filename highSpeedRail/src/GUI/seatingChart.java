package GUI;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class seatingChart{
 public static JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5;
 private JButton car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12,lastStep;
 
 public seatingChart() {
	 frame=new JFrame("座位表");
	 /*
	  * 建立一個名為"座位表"的JFrame
	  * 內有十三個JButton
	  */
	 p0=new JPanel();
	 p0.add(new JLabel("請選擇車廂(6號車為商務車廂)"));
	 
	 p1=new JPanel();
	 p1.add(new JLabel(""));
	  
	 p2=new JPanel();
	 p2.add(new JLabel(""));
	  
	 p3=new JPanel();
	 p3.add(new JLabel(""));
	  
	 p4=new JPanel();
	 p4.add(new JLabel(""));
	  
	 p5=new JPanel();
	 p5.add(new JLabel(""));
	 
	 /*
	  * 點選車廂號碼的JButton
	  * 進入對應介面
	  */
	 car1=new JButton("1號車");
	 p1.add(car1);
	 car1.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart1 n=new seatingChart1();
	         frame.setVisible(false);
	        }
	      });
	 car2=new JButton("2號車");
	 p1.add(car2);
	 car2.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart2 n=new seatingChart2();
	         frame.setVisible(false);
	        }
	      });
	 car3=new JButton("3號車");
	 p1.add(car3);
	 car3.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart3 n=new seatingChart3();
	         frame.setVisible(false);
	        }
	      });
	 car4=new JButton("4號車");
	 p2.add(car4);
	 car4.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart4 n=new seatingChart4();
	         frame.setVisible(false);
	        }
	      });
	 car5=new JButton("5號車");
	 p2.add(car5);
	 car5.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart5 n=new seatingChart5();
	         frame.setVisible(false);
	        }
	      });
	 car6=new JButton("6號車");
	 p2.add(car6);
	 car6.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart6 n=new seatingChart6();
	         frame.setVisible(false);
	        }
	      });
	 car7=new JButton("7號車");
	 p3.add(car7);
	 car7.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart7 n=new seatingChart7();
	         frame.setVisible(false);
	        }
	      });
	 car8=new JButton("8號車");
	 p3.add(car8);
	 car8.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart8 n=new seatingChart8();
	         frame.setVisible(false);
	        }
	      });
	 car9=new JButton("9號車");
	 p3.add(car9);
	 car9.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart9 n=new seatingChart9();
	         frame.setVisible(false);
	        }
	      });
	 car10=new JButton("10號車");
	 p4.add(car10);
	 car10.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart10 n=new seatingChart10();
	         frame.setVisible(false);
	        }
	      });
	 car11=new JButton("11號車");
	 p4.add(car11);
	 car11.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart11 n=new seatingChart11();
	         frame.setVisible(false);
	        }
	      });
	 car12=new JButton("12號車");
	 p4.add(car12);
	 car12.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart12 n=new seatingChart12();
	         frame.setVisible(false);
	        }
	      });
	 
	 lastStep=new JButton("上一步");
	 p5.add(lastStep);
	 lastStep.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	    
	          gui2.frame.setVisible(true);	//回到"功能"介面
	             frame.setVisible(false);
	           
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
	 frame.setLocationRelativeTo(null);
	 frame.setLayout(new GridLayout(0,1));
	 frame.setBounds(500,200,500,500);
	  
 }
}