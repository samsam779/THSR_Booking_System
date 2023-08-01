package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import search.searchCode;

public class search2 {
	private JFrame frame;
	private JPanel p0, p1, p2, p3, p5, p6, p61, p62, p7;
	private JButton lastStep, nextStep;
	private JTextField userID, ticketNumber;
	private JComboBox start, destination;
	private String format1 = "[1-9]";
	private String format2 = "[0-9]" + "[0-9]";
	private String format3 = "[A-Z]" + "[0-9]{9}";
	private String format4 = "[0-9]{4}";
	private String uid;

	public search2(String uid) {
		this.uid = uid;
		frame = new JFrame("查詢訂位代號");
		/*
		 * 建立一個名為"查詢訂位代號"的JFrame 內有兩個JButton 兩個JTextField 兩個JComboBox
		 */

		p0 = new JPanel();

		p1 = new JPanel();

		p2 = new JPanel();
		p2.add(new JLabel("請選擇起迄站"));
		p2 = new JPanel();
		p2.add(new JLabel("起程站"));
		start = new JComboBox();
		start.addItem("南港");
		start.addItem("台北");
		start.addItem("板橋");
		start.addItem("桃園");
		start.addItem("新竹");
		start.addItem("苗栗");
		start.addItem("台中");
		start.addItem("彰化");
		start.addItem("雲林");
		start.addItem("嘉義");
		start.addItem("台南");
		start.addItem("左營");
		p2.add(start);

		p3 = new JPanel();
		p3.add(new JLabel("到達站"));
		destination = new JComboBox();
		destination.addItem("南港");
		destination.addItem("台北");
		destination.addItem("板橋");
		destination.addItem("桃園");
		destination.addItem("新竹");
		destination.addItem("苗栗");
		destination.addItem("台中");
		destination.addItem("彰化");
		destination.addItem("雲林");
		destination.addItem("嘉義");
		destination.addItem("台南");
		destination.addItem("左營");
		p3.add(destination);

		p5 = new JPanel();
		p5.add(new JLabel("請輸入日期(需補0)"));

		p6 = new JPanel();
		p6.add(new JLabel("2021年"));
		JTextField month = new JTextField();
		month.setColumns(2);
		p6.add(month);
		p6.add(new JLabel("月"));
		JTextField day = new JTextField();
		day.setColumns(2);
		p6.add(day);
		p6.add(new JLabel("日"));

		p61 = new JPanel();
		p61.add(new JLabel("請輸入車次號碼"));

		p62 = new JPanel();
		JTextField car = new JTextField();
		car.setColumns(4);
		p62.add(car);

		p7 = new JPanel();
		p7.add(new JLabel(""));
		lastStep = new JButton("上一步");
		p7.add(lastStep);
		lastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				search i = new search(uid); // 回到"查詢"介面
				frame.setVisible(false);

			}
		});
		nextStep = new JButton("下一步");
		p7.add(nextStep);
		nextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				/*
				 * 身分證格式錯誤 車次格式錯誤 日期格式錯誤 啟程站等於到達站 則跳出錯誤訊息 若一切正確 顯示訂票代碼
				 */

				String strf = "";

				String str1 = new String(month.getText());
				String str2 = new String(day.getText());
				String str3 = new String(car.getText());

				String START = (String) start.getSelectedItem();
				String DESTINATION = (String) destination.getSelectedItem();
				String CAR = new String(car.getText());

				String date = ("2021-" + str1 + "-" + str2);

				int i1 = start.getSelectedIndex();
				int i2 = destination.getSelectedIndex();

				if ((str1.matches(format1) || str1.matches(format2))
						&& (str2.matches(format1) || str2.matches(format2))) {

					int int1 = Integer.parseInt(str1);
					int int2 = Integer.parseInt(str2);
					int int3 = Integer.parseInt(str3);

					if (i1 == i2) {
						strf = "起程站不可等於到達站";

					}

					else if (uid.matches(format3) && str3.matches(format4)) {

						if (int1 == 1 || int1 == 3 || int1 == 5 || int1 == 7 || int1 == 8 || int1 == 10 || int1 == 12) {
							if (int2 <= 31 && int2 >= 1) {

								searchCode s = new searchCode(uid, START, DESTINATION, date, CAR);
								String out = s.getInformation();
								frame.setVisible(false);
								strf = out;
							} else {
								strf = "請輸入正確的日期格式";
							}
						}

						else if (int1 == 2) {
							if (int2 <= 28 && int2 >= 1) {
								searchCode s = new searchCode(uid, START, DESTINATION, date, CAR);
								String out = s.getInformation();
								frame.setVisible(false);
								strf = out;
							} else {
								strf = "請輸入正確的日期格式";
							}
						}

						else if (int1 == 4 || int1 == 6 || int1 == 9 || int1 == 11) {
							if (int2 <= 30 && int2 >= 1) {
								searchCode s = new searchCode(uid, START, DESTINATION, date, CAR);
								String out = s.getInformation();
								frame.setVisible(false);
								strf = out;
							} else {
								strf = "請輸入正確的日期格式";
							}
						}

						else {
							strf = "請輸入正確的日期格式";
						}

					}

					else if (uid.matches(format3)) {
						strf = "請輸入正確的車次格式";
					} else if (str3.matches(format4)) {
						strf = "請輸入正確的身分證格式";
					} else {
						strf = "請輸入正確的車次及身分證格式";
					}
				} else {
					strf = "請輸入正確的日期格式";
				}
				JOptionPane.showMessageDialog(null, strf);
				System.exit(0);
			}

		});

		frame.add(p0);
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p5);
		frame.add(p6);
		frame.add(p61);
		frame.add(p62);
		frame.add(p7);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(0, 1));
		frame.setBounds(500, 200, 500, 500);
	}
}