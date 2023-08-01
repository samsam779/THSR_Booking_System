package GUI;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class seatingChart4 {
 private JFrame frame;
 private JPanel p0,p1,p2,p3,p4,p5,p6,p7;
 private JButton lastStep,a1,b1,c1,d1,e1,a2,b2,c2,d2,e2,a3,b3,c3,d3,e3,a4,b4,c4,d4,e4,a5,b5,c5,d5,e5,a6,b6,c6,d6,e6,a7,b7,c7,d7,e7,a8,b8,c8,d8,e8,a9,b9,c9,d9,e9,a10,b10,c10,d10,e10;
 private JButton prevTrain,nextTrain,a11,b11,c11,d11,e11,a12,b12,c12,d12,e12,a13,b13,c13,d13,e13,a14,b14,c14,d14,e14,a15,b15,c15,d15,e15,a16,b16,c16,d16,e16,a17,b17,c17,d17,e17,a18,b18,c18,d18,e18,a19,b19,c19,d19,e19,a20,b20,c20,d20,e20;
 
 public seatingChart4() {
	 frame=new JFrame("4號車座位表");
	 /*
	  * 建立一個名為"4號車座位表"的JFrame
	  * 內有103個JButton
	  */
	 p0=new JPanel();
	 p0.add(new JLabel("標準車廂(共96席)"));
	 
	 p1=new JPanel();
	 a1=new JButton("1A");
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
	 a18=new JButton("18A");
	 a19=new JButton("19A");
	 a20=new JButton("20A");
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
	 p1.add(a19);
	 p1.add(a20);
	 
	 p2=new JPanel();
	 b1=new JButton("1B");
	 b2=new JButton("2B");
	 b3=new JButton("3B");
	 b4=new JButton("4B");
	 b5=new JButton("5B");
	 b6=new JButton("6B");
	 b7=new JButton("7B");
	 b8=new JButton("8B");
	 b9=new JButton("9B");
	 b10=new JButton("10B");
	 b11=new JButton("11B");
	 b12=new JButton("12B");
	 b13=new JButton("13B");
	 b14=new JButton("14B");
	 b15=new JButton("15B");
	 b16=new JButton("16B");
	 b17=new JButton("17B");
	 b18=new JButton("18B");
	 b19=new JButton("19B");
	 b20=new JButton("20B");
	 p2.add(b1);
	 p2.add(b2);
	 p2.add(b3);
	 p2.add(b4);
	 p2.add(b5);
	 p2.add(b6);
	 p2.add(b7);
	 p2.add(b8);
	 p2.add(b9);
	 p2.add(b10);
	 p2.add(b11);
	 p2.add(b12);
	 p2.add(b13);
	 p2.add(b14);
	 p2.add(b15);
	 p2.add(b16);
	 p2.add(b17);
	 p2.add(b18);
	 p2.add(b19);
	 p2.add(b20);
	 
	 p3=new JPanel();
	 c1=new JButton("1C");
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
	 c18=new JButton("18C");
	 c19=new JButton("19C");
	 c20=new JButton("20C");
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
	 p3.add(c19);
	 p3.add(c20);
	  
	 p4=new JPanel();
	 prevTrain=new JButton(" ← 往3號車");
	 p4.add(prevTrain);
	 prevTrain.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart3 n=new seatingChart3();	//進入"3號車座位表"介面
	         frame.setVisible(false);
	        }
	      });
	 nextTrain=new JButton(" → 往5號車");
	 p4.add(nextTrain);
	 nextTrain.addActionListener( new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	         seatingChart5 n=new seatingChart5();	//進入"5號車座位表"介面
	         frame.setVisible(false);
	        }
	      });
	  
	 p5=new JPanel();
	 d1=new JButton("行李區");
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
	 d18=new JButton("18D");
	 d19=new JButton("19D");
	 d20=new JButton("行李區");
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
	 p5.add(d19);
	 p5.add(d20);
	 
	 p6=new JPanel();
     e1=new JButton("行李區");
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
	 e18=new JButton("18E");
	 e19=new JButton("19E");
	 e20=new JButton("行李區");
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
	 p6.add(e19);
	 p6.add(e20);
	 
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
	 frame.add(p2);
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