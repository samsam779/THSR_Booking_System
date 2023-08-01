package GUI;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class seatingChart6 {
 private JFrame frame;
 private JPanel p0,p1,p3,p4,p5,p6,p7;
 private JButton lastStep,a1,c1,d1,e1,a2,c2,d2,e2,a3,c3,d3,e3,a4,c4,d4,e4,a5,c5,d5,e5,a6,c6,d6,e6,a7,c7,d7,e7,a8,c8,d8,e8,a9,c9,d9,e9,a10,c10,d10,e10;
 private JButton prevTrain,nextTrain,a11,c11,d11,e11,a12,c12,d12,e12,a13,c13,d13,e13,a14,c14,d14,e14,a15,c15,d15,e15,a16,c16,d16,e16,a17,c17,d17,e17,a18,c18,d18,e18;
 
 public seatingChart6() {
	 frame=new JFrame("6號車座位表");
	 /*
	  * 建立一個名為"6號車座位表"的JFrame
	  * 內有75個JButton
	  */
	 p0=new JPanel();
	 p0.add(new JLabel("商務車廂(共66席)"));
	 
	 p1=new JPanel();
	 a1=new JButton("行李區");
	 a2=new JButton("2A");
	 a3=new JButton("3A");
	 a4=new JButton("4A");
	 a5=new JButton("5A");
	 a6=new JButton("6A");
	 a7=new JButton("7A");
	 a8=new JButton("8A");
	 a9=new JButton("9A");
	 a10=new JButton("10A");
	 a11=new JButton("11A");
	 a12=new JButton("12A");
	 a13=new JButton("13A");
	 a14=new JButton("14A");
	 a15=new JButton("15A");
	 a16=new JButton("16A");
	 a17=new JButton("17A");
	 a18=new JButton("行李區");
	 p1.add(a1);
	 p1.add(a2);
	 p1.add(a3);
	 p1.add(a4);
	 p1.add(a5);
	 p1.add(a6);
	 p1.add(a7);
	 p1.add(a8);
	 p1.add(a9);
	 p1.add(a10);
	 p1.add(a11);
	 p1.add(a12);
	 p1.add(a13);
	 p1.add(a14);
	 p1.add(a15);
	 p1.add(a16);
	 p1.add(a17);
	 p1.add(a18);
	 
	 p3=new JPanel();
	 c1=new JButton("行李區");
     c2=new JButton("2C");
     c3=new JButton("3C");
	 c4=new JButton("4C");
	 c5=new JButton("5C");
	 c6=new JButton("6C");
	 c7=new JButton("7C");
	 c8=new JButton("8C");
	 c9=new JButton("9C");
	 c10=new JButton("10C");
	 c11=new JButton("11C");
	 c12=new JButton("12C");
	 c13=new JButton("13C");
	 c14=new JButton("14C");
	 c15=new JButton("15C");
	 c16=new JButton("16C");
	 c17=new JButton("17C");
	 c18=new JButton("行李區");
	 p3.add(c1);
	 p3.add(c2);
	 p3.add(c3);
	 p3.add(c4);
	 p3.add(c5);
	 p3.add(c6);
	 p3.add(c7);
	 p3.add(c8);
	 p3.add(c9);
	 p3.add(c10);
	 p3.add(c11);
	 p3.add(c12);
	 p3.add(c13);
	 p3.add(c14);
	 p3.add(c15);
	 p3.add(c16);
	 p3.add(c17);
	 p3.add(c18);
	
	 p4=new JPanel();
	 prevTrain=new JButton(" ← 往5號車");
	 p4.add(prevTrain);
	 prevTrain.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart5 n=new seatingChart5();	//進入"5號車座位表"介面
	         frame.setVisible(false);
	        }
	      });
	 nextTrain=new JButton(" → 往7號車");
	 p4.add(nextTrain);
	 nextTrain.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart7 n=new seatingChart7();	//進入"7號車座位表"介面
	         frame.setVisible(false);
	        }
	      });
	  
	 p5=new JPanel();
	 d1=new JButton("1D");
	 d2=new JButton("2D");
     d3=new JButton("3D");
	 d4=new JButton("4D");
	 d5=new JButton("5D");
	 d6=new JButton("6D");
	 d7=new JButton("7D");
	 d8=new JButton("8D");
	 d9=new JButton("9D");
	 d10=new JButton("10D");
	 d11=new JButton("11D");
	 d12=new JButton("12D");
	 d13=new JButton("13D");
	 d14=new JButton("14D");
	 d15=new JButton("15D");
	 d16=new JButton("16D");
	 d17=new JButton("17D");
	 d18=new JButton("行李區");
	 p5.add(d1);
	 p5.add(d2);
	 p5.add(d3);
	 p5.add(d4);
	 p5.add(d5);
	 p5.add(d6);
	 p5.add(d7);
	 p5.add(d8);
	 p5.add(d9);
	 p5.add(d10);
	 p5.add(d11);
	 p5.add(d12);
	 p5.add(d13);
	 p5.add(d14);
	 p5.add(d15);
	 p5.add(d16);
	 p5.add(d17);
	 p5.add(d18);
	 
	 p6=new JPanel();
     e1=new JButton("1E");
	 e2=new JButton("2E");
	 e3=new JButton("3E");
	 e4=new JButton("4E");
	 e5=new JButton("5E");
	 e6=new JButton("6E");
	 e7=new JButton("7E");
	 e8=new JButton("8E");
	 e9=new JButton("9E");
	 e10=new JButton("10E");
	 e11=new JButton("11E");
	 e12=new JButton("12E");
	 e13=new JButton("13E");
	 e14=new JButton("14E");
	 e15=new JButton("15E");
	 e16=new JButton("16E");
	 e17=new JButton("17E");
	 e18=new JButton("行李區");
	 p6.add(e1);
	 p6.add(e2);
	 p6.add(e3);
	 p6.add(e4);
	 p6.add(e5);
	 p6.add(e6);
	 p6.add(e7);
	 p6.add(e8);
	 p6.add(e9);
	 p6.add(e10);
	 p6.add(e11);
	 p6.add(e12);
	 p6.add(e13);
	 p6.add(e14);
	 p6.add(e15);
	 p6.add(e16);
	 p6.add(e17);
	 p6.add(e18);
	 
	 p7=new JPanel();
	 p7.add(new JLabel(""));
	 lastStep=new JButton("上一頁");
	 p7.add(lastStep);
	 lastStep.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	    
	          seatingChart.frame.setVisible(true);	//回到"座位表"介面
	             frame.setVisible(false);
	           
	         }
	       });
	 
	 frame.add(p0);
	 frame.add(p1);
	 frame.add(p3);
	 frame.add(p4);
	 frame.add(p5);
	 frame.add(p6);
	 frame.add(p7);
	
	 frame.setVisible(true);
	 frame.setLocationRelativeTo(null);
	 frame.setLayout(new GridLayout(0,1));
	 frame.setBounds(0,200,1700,500);
	  
 }
}