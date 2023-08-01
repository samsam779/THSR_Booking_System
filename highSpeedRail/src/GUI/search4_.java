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

import ticket.ticket;

public class search4_ {
	 public static JFrame frame;
	 private JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16;
	 private JButton lastStep;
	 private String uid;
	public search4_(Date date,String uid,String start,String destination) throws ParseException{
		frame=new JFrame("查詢優惠車次");
		/*
		   * 建立一個名為"查詢優惠車次"的JFrame
		   * 內有一個JButton
		   */
		ticket stu=new ticket(date,uid,start,destination,"student",1);
		ticket early=new ticket(date,uid,start,destination,"early",1);
		String stuS=stu.toSearch();
		String[] stuArr=stuS.split(" ");
		String earlyS=early.toSearch();
		String[] earlyArr=earlyS.split(" ");
		p0=new JPanel();
		p0.add(new JLabel("學生優惠票:"));
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p8.add(new JLabel("早鳥優惠票:"));
		p9=new JPanel();
		p10=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		p13=new JPanel();
		p14=new JPanel();
		p15=new JPanel();
		p16=new JPanel();
		int k=0;
		 for(int i=0;i<stuArr.length;i++) {
			 switch(k) {
			 case 0:
				 p1.add(new JLabel(stuArr[i]));
				 break;
			 case 1:
				 p2.add(new JLabel(stuArr[i]));
				 break;
			 case 2:
				 p3.add(new JLabel(stuArr[i]));
				 break;
			 case 3:
				 p4.add(new JLabel(stuArr[i]));
				 break;
			 case 4:
				 p5.add(new JLabel(stuArr[i]));
				 break;
			 case 5:
				 p6.add(new JLabel(stuArr[i]));
				 break;
			 case 6:
				 p7.add(new JLabel(stuArr[i]));
				 break;
			 }
			 k++;
		 }
		 int j=0;
		 for(int i=0;i<earlyArr.length;i++) {
			 switch(j) {
			 case 0:
				 p9.add(new JLabel(earlyArr[i]));
				 break;
			 case 1:
				 p10.add(new JLabel(earlyArr[i]));
				 break;
			 case 2:
				 p11.add(new JLabel(earlyArr[i]));
				 break;
			 case 3:
				 p12.add(new JLabel(earlyArr[i]));
				 break;
			 case 4:
				 p13.add(new JLabel(earlyArr[i]));
				 break;
			 case 5:
				 p14.add(new JLabel(earlyArr[i]));
				 break;
			 case 6:
				 p15.add(new JLabel(earlyArr[i]));
				 break;
			 }
			 j++;
		 }
		 lastStep=new JButton("上一步");
		  p16.add(lastStep);
		  lastStep.addActionListener( new ActionListener() {
		        public void actionPerformed(ActionEvent ev) {
		          search4 i=new search4(uid);	//	回到"查詢優惠車次"介面
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
		  frame.add(p15);
		  frame.add(p16);
		  
		  frame.setVisible(true);
		  frame.setLocationRelativeTo(null);
		  frame.setLayout(new GridLayout(0,1));
		  frame.setBounds(500,200,350,500);
	}

}