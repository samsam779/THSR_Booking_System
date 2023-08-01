package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;

public class normalTicket1 {
	private JFrame frame;
	private JPanel p0, p1, p2, p3, p4, p5, p6, p7;
	private JButton lastStep, nextStep;
	private JComboBox time, number1, number2, number3, number4;
	private JTextField month, day;
	private String format1 = "[1-9]";
	private String format2 = "[1-9]" + "[0-9]";
	private String strMonth, strDay, strTime;
	private int normalN, elderN, disabledN, kidN;
	private String START, DESTINATION, CARTYPE, SEATTYPE, TICKETTYPE, uid;
	private Date date;

	public normalTicket1(String START, String DESTINATION, String CARTYPE, String SEATTYPE, String TICKETTYPE,
			String uid) {
		this.START = START;
		this.DESTINATION = DESTINATION;
		this.CARTYPE = CARTYPE;
		this.SEATTYPE = SEATTYPE;
		this.TICKETTYPE = TICKETTYPE;
		this.uid = uid;
		frame = new JFrame("一般購票");

		/*
		 * 建立一個名為"一般購票"的JFrame(單程購票) 內有兩個JButton 五個JComboBox 兩個JTextField
		 */
		p0 = new JPanel();
		p0.add(new JLabel("單程購票"));

		p1 = new JPanel();
		p1.add(new JLabel("日期"));

		p2 = new JPanel();
		p2.add(new JLabel("2021年"));
		JTextField month = new JTextField();
		month.setColumns(2);
		p2.add(month);
		p2.add(new JLabel("月"));
		JTextField day = new JTextField();
		day.setColumns(2);
		p2.add(day);
		p2.add(new JLabel("日"));

		p3 = new JPanel();
		p3.add(new JLabel("時間"));

		p4 = new JPanel();
		p4.add(new JLabel(""));
		time = new JComboBox();
		time.addItem("00:00");
		time.addItem("00:30");
		time.addItem("05:00");
		time.addItem("05:30");
		time.addItem("06:00");
		time.addItem("06:30");
		time.addItem("07:00");
		time.addItem("07:30");
		time.addItem("08:00");
		time.addItem("08:30");
		time.addItem("09:00");
		time.addItem("09:30");
		time.addItem("10:00");
		time.addItem("10:30");
		time.addItem("11:00");
		time.addItem("11:30");
		time.addItem("12:00");
		time.addItem("12:30");
		time.addItem("13:00");
		time.addItem("13:30");
		time.addItem("14:00");
		time.addItem("14:30");
		time.addItem("15:00");
		time.addItem("15:30");
		time.addItem("16:00");
		time.addItem("16:30");
		time.addItem("17:00");
		time.addItem("17:30");
		time.addItem("18:00");
		time.addItem("18:30");
		time.addItem("19:00");
		time.addItem("19:30");
		time.addItem("20:00");
		time.addItem("20:30");
		time.addItem("21:00");
		time.addItem("21:30");
		time.addItem("22:00");
		time.addItem("22:30");
		time.addItem("23:00");
		time.addItem("23:30");
		p4.add(time);

		p5 = new JPanel();
		p5.add(new JLabel("票數"));

		p6 = new JPanel();
		p6.add(new JLabel("全票"));
		number1 = new JComboBox();
		number1.addItem("0");
		number1.addItem("1");
		number1.addItem("2");
		number1.addItem("3");
		number1.addItem("4");
		number1.addItem("5");
		number1.addItem("6");
		number1.addItem("7");
		number1.addItem("8");
		number1.addItem("9");
		number1.addItem("10");
		p6.add(number1);
		p6.add(new JLabel("孩童票(6~11歲)"));
		number2 = new JComboBox();

		number2.addItem("0");
		number2.addItem("1");
		number2.addItem("2");
		number2.addItem("3");
		number2.addItem("4");
		number2.addItem("5");
		number2.addItem("6");
		number2.addItem("7");
		number2.addItem("8");
		number2.addItem("9");
		number2.addItem("10");
		p6.add(number2);
		p6.add(new JLabel("愛心票"));
		number3 = new JComboBox();
		number3.addItem("0");
		number3.addItem("1");
		number3.addItem("2");
		number3.addItem("3");
		number3.addItem("4");
		number3.addItem("5");
		number3.addItem("6");
		number3.addItem("7");
		number3.addItem("8");
		number3.addItem("9");
		number3.addItem("10");
		p6.add(number3);
		p6.add(new JLabel("敬老票(65歲以上)"));
		number4 = new JComboBox();
		number4.addItem("0");
		number4.addItem("1");
		number4.addItem("2");
		number4.addItem("3");
		number4.addItem("4");
		number4.addItem("5");
		number4.addItem("6");
		number4.addItem("7");
		number4.addItem("8");
		number4.addItem("9");
		number4.addItem("10");
		p6.add(number4);

		p7 = new JPanel();
		p7.add(new JLabel(""));
		lastStep = new JButton("上一步");
		nextStep = new JButton("下一步");
		p7.add(lastStep);
		lastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				normalTicket.frame.setVisible(true); // 回到"一般購票"介面
				frame.setVisible(false);

			}
		});
		p7.add(nextStep);
		nextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				String strf = "";
				String str1 = new String(month.getText());
				String str2 = new String(day.getText());

				strMonth = (String) (month.getText());
				strDay = (String) (month.getText());
				strTime = new String((String) time.getSelectedItem());
				normalN = (int) number1.getSelectedIndex();
				kidN = (int) number2.getSelectedIndex();
				disabledN = (int) number3.getSelectedIndex();
				elderN = (int) number4.getSelectedIndex();
				date = new Date("2021/" + str1 + "/" + str2 + " " + strTime);
				Date now=new Date();
				long diff=date.getTime()-now.getTime();
				long dayDiff=diff / (1000 * 60 * 60 * 24);
				

				/*
				 * 票數不在1~10張範圍內 日期不符合格式 則跳出錯誤訊息 若一切正確 進入"車號"介面
				 */
				if ((str1.matches(format1) || str1.matches(format2))
						&& (str2.matches(format1) || str2.matches(format2))) {

					int int1 = Integer.parseInt(str1);
					int int2 = Integer.parseInt(str2);
					int n1 = number1.getSelectedIndex();
					int n2 = number2.getSelectedIndex();
					int n3 = number3.getSelectedIndex();
					int n4 = number4.getSelectedIndex();
					if (n1 + n2 + n3 + n4 == 0) {
						strf = "票數至少需一張";
					} else if (n1 + n2 + n3 + n4 > 10) {
						strf = "票數最多為10張";
					} else if (int1 == 1 || int1 == 3 || int1 == 5 || int1 == 7 || int1 == 8 || int1 == 10
							|| int1 == 12) {
						if (int2 <= 31 && int2 >= 1) {
							frame.setVisible(false);

							if(diff>0&&dayDiff<28) {//如果日期不是未來28天內則不予訂票
								try {
									testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE, TICKETTYPE, uid,
											normalN, elderN, disabledN, kidN, date);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								strf = "只能訂購28日內的車票";
							}
						} else {
							strf = "請輸入正確的日期格式";
						}
					} else if (int1 == 2) {
						if (int2 <= 28 && int2 >= 1) {
							frame.setVisible(false);

							if(diff>0&&dayDiff<28) {
								try {
									testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE, TICKETTYPE, uid,
											normalN, elderN, disabledN, kidN, date);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								strf = "只能訂購28日內的車票";
							}
						} else {
							strf = "請輸入正確的日期格式";
						}
					} else if (int1 == 4 || int1 == 6 || int1 == 9 || int1 == 11) {
						if (int2 <= 30 && int2 >= 1) {
							frame.setVisible(false);

							if(diff>0&&dayDiff<28) {
								try {
									testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE, TICKETTYPE, uid,
											normalN, elderN, disabledN, kidN, date);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								strf = "只能訂購28日內的車票";
							}
						} else {
							strf = "請輸入正確的日期格式";
						}
					} else {
						strf = "請輸入正確的日期格式";
					}
				} else {
					strf = "請輸入正確的日期格式";
				}
				JOptionPane.showMessageDialog(null, strf);
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
		frame.setLayout(new GridLayout(0, 1));
		frame.setBounds(500, 200, 700, 500);
	}

	public String getStrMonth() {
		return strMonth;
	}

	public String getStrDay() {
		return strDay;
	}

	public String getStrTime() {
		return strTime;
	}

	public int getNormalN() {
		return normalN;
	}

	public int getElderN() {
		return elderN;
	}

	public int getDisabledN() {
		return disabledN;
	}

	public int getKidN() {
		return kidN;
	}

	public Date getDate() {
		return date;
	}

	public void setStrMonth(String strMonth) {
		this.strMonth = strMonth;
	}

	public void setStrDay(String strDay) {
		this.strDay = strDay;
	}

	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

	public void setNormalN(int normalN) {
		this.normalN = normalN;
	}

	public void setElderN(int elderN) {
		this.elderN = elderN;
	}

	public void setDisabledN(int disabledN) {
		this.disabledN = disabledN;
	}

	public void setKidN(int kidN) {
		this.kidN = kidN;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}