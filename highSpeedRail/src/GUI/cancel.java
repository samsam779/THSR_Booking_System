
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

public class cancel {
	public static JFrame frame;
	private JPanel p0, p1, p2, p3, p4, p5, p6;
	private JButton b1, b2, lastStep, nextStep;
	private JTextField userID, ticketNumber;
	private String format2 = "[0-9]{9}";
	private String format1 = "[A-Z]" + "[0-9]{9}";
	private String uid;

	public cancel(String uid) {
		this.uid = uid;
		frame = new JFrame("退票/減少人數");

		  /*
		   * 建立一個名為"退票/減少人數"的JFrame
		   * 內有兩個JButton
		   * 兩個JTextField
		   * 兩個JRadioButton
		   */
		 
		p0 = new JPanel();
		

		p1 = new JPanel();
		

		p2 = new JPanel();
		p2.add(new JLabel("請輸入訂位代號"));

		p3 = new JPanel();
		JTextField ticketNumber = new JTextField(20);
		p3.add(ticketNumber);

		p4 = new JPanel();
		p4.add(new JLabel("請選擇功能"));

		p5 = new JPanel();
		JRadioButton r1 = new JRadioButton("退票");
		JRadioButton r2 = new JRadioButton("減少人數");
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		p5.add(r1);
		p5.add(r2);

		p6 = new JPanel();
		lastStep = new JButton("上一步");
		p6.add(lastStep);
		lastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				gui2 i = new gui2(uid);	//回到"功能"介面
				frame.setVisible(false);

			}
		});
		nextStep = new JButton("下一步");
		p6.add(nextStep);
		nextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				/* 
	             * 身分證字號不符合格式
	             * 訂票代碼不符合格式
	             * 則跳出錯誤訊息
	             * 若一切正確 
	             * 選擇退票 跳出退票成功訊息
	             * 選擇減少人數 進入"減少人數"介面
	             */
				String strf = "";

				String str2 = new String(ticketNumber.getText());

				if (str2.matches(format2)) {
					if (r1.isSelected()) {
						bookingChange b = new bookingChange(uid, str2);
						b.cancel();
						frame.setVisible(false);
						strf = "退票成功，已取消您的訂位紀錄";
						JOptionPane.showMessageDialog(null, strf);
					} else if (r2.isSelected()) {

						cancel1 i = new cancel1(uid, str2);
						frame.setVisible(false);
					}
				} else {
					strf = "請輸入正確的訂票代碼格式";
					JOptionPane.showMessageDialog(null, strf);
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(0, 1));
		frame.setLocationRelativeTo(null);
		frame.setBounds(500, 200, 350, 500);
	}

}