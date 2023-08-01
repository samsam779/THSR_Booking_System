package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;

public class earlyTicket2 {
	private JFrame frame;
	private JPanel p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
	private JButton lastStep, nextStep;
	private JComboBox time1, time2, number1, number2, number3, number4;
	private JTextField month1, day1, month2, day2;
	private String format1 = "[1-9]";
	private String format2 = "[1-9]" + "[0-9]";
	private String strGoMonth, strGoDay, strGoTime, strBackMonth, strBackDay, strBackTime;
	private int normalN;
	private String START, DESTINATION, CARTYPE, SEATTYPE, TICKETTYPE, uid;
	private Date goDate, backDate;

	public earlyTicket2(String START, String DESTINATION, String CARTYPE, String SEATTYPE, String TICKETTYPE,
			String uid) {
		this.START = START;
		this.DESTINATION = DESTINATION;
		this.CARTYPE = CARTYPE;
		this.SEATTYPE = SEATTYPE;
		this.TICKETTYPE = TICKETTYPE;
		this.uid = uid;

		frame = new JFrame("早鳥購票");
		/*
		 * 建立一個名為"早鳥購票"的JFrame(來回購票) 內有兩個JButton 六個JComboBox 四個JTextField
		 */
		p0 = new JPanel();
		p0.add(new JLabel("來回購票"));

		p1 = new JPanel();
		p1.add(new JLabel("去程日期"));

		p2 = new JPanel();
		p2.add(new JLabel("2021年"));
		JTextField month1 = new JTextField();
		month1.setColumns(2);
		p2.add(month1);
		p2.add(new JLabel("月"));
		JTextField day1 = new JTextField();
		day1.setColumns(2);
		p2.add(day1);
		p2.add(new JLabel("日"));

		p3 = new JPanel();
		p3.add(new JLabel("去程時間"));

		p4 = new JPanel();
		p4.add(new JLabel(""));
		time1 = new JComboBox();
		time1.addItem("00:00");
		time1.addItem("00:30");
		time1.addItem("05:00");
		time1.addItem("05:30");
		time1.addItem("06:00");
		time1.addItem("06:30");
		time1.addItem("07:00");
		time1.addItem("07:30");
		time1.addItem("08:00");
		time1.addItem("08:30");
		time1.addItem("09:00");
		time1.addItem("09:30");
		time1.addItem("10:00");
		time1.addItem("10:30");
		time1.addItem("11:00");
		time1.addItem("11:30");
		time1.addItem("12:00");
		time1.addItem("12:30");
		time1.addItem("13:00");
		time1.addItem("13:30");
		time1.addItem("14:00");
		time1.addItem("14:30");
		time1.addItem("15:00");
		time1.addItem("15:30");
		time1.addItem("16:00");
		time1.addItem("16:30");
		time1.addItem("17:00");
		time1.addItem("17:30");
		time1.addItem("18:00");
		time1.addItem("18:30");
		time1.addItem("19:00");
		time1.addItem("19:30");
		time1.addItem("20:00");
		time1.addItem("20:30");
		time1.addItem("21:00");
		time1.addItem("21:30");
		time1.addItem("22:00");
		time1.addItem("22:30");
		time1.addItem("23:00");
		time1.addItem("23:30");
		p4.add(time1);

		p5 = new JPanel();
		p5.add(new JLabel("回程日期"));

		p6 = new JPanel();
		p6.add(new JLabel("2021年"));
		JTextField month2 = new JTextField();
		month2.setColumns(2);
		p6.add(month2);
		p6.add(new JLabel("月"));
		JTextField day2 = new JTextField();
		day2.setColumns(2);
		p6.add(day2);
		p6.add(new JLabel("日"));

		p7 = new JPanel();
		p7.add(new JLabel("回程時間"));

		p8 = new JPanel();
		p8.add(new JLabel(""));
		time2 = new JComboBox();
		time2.addItem("00:00");
		time2.addItem("00:30");
		time2.addItem("05:00");
		time2.addItem("05:30");
		time2.addItem("06:00");
		time2.addItem("06:30");
		time2.addItem("07:00");
		time2.addItem("07:30");
		time2.addItem("08:00");
		time2.addItem("08:30");
		time2.addItem("09:00");
		time2.addItem("09:30");
		time2.addItem("10;00");
		time2.addItem("10:30");
		time2.addItem("11:00");
		time2.addItem("11:30");
		time2.addItem("12:00");
		time2.addItem("12:30");
		time2.addItem("13:00");
		time2.addItem("13:30");
		time2.addItem("14:00");
		time2.addItem("14:30");
		time2.addItem("15:00");
		time2.addItem("15:30");
		time2.addItem("16:00");
		time2.addItem("16:30");
		time2.addItem("17:00");
		time2.addItem("17:30");
		time2.addItem("18:00");
		time2.addItem("18:30");
		time2.addItem("19:00");
		time2.addItem("19:30");
		time2.addItem("20:00");
		time2.addItem("20:30");
		time2.addItem("21:00");
		time2.addItem("21:30");
		time2.addItem("22:00");
		time2.addItem("22:30");
		time2.addItem("23:00");
		time2.addItem("23:30");
		p8.add(time2);

		p9 = new JPanel();
		p9.add(new JLabel("票數"));

		p10 = new JPanel();
		p10.add(new JLabel("全票"));
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
		p10.add(number1);

		p11 = new JPanel();
		p11.add(new JLabel(""));
		lastStep = new JButton("上一步");
		nextStep = new JButton("下一步");

		p11.add(lastStep);
		lastStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				normalTicket.frame.setVisible(true); // 回到"早鳥購票"介面
				frame.setVisible(false);

			}
		});
		p11.add(nextStep);
		nextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				String strf = "";
				String str1 = new String(month1.getText());
				String str2 = new String(day1.getText());
				String str3 = new String(month2.getText());
				String str4 = new String(day2.getText());

				strGoMonth = (String) (month1.getText());
				strGoDay = (String) (day1.getText());
				strGoTime = new String((String) time1.getSelectedItem());

				strBackMonth = (String) (month2.getText());
				strBackDay = (String) (day2.getText());
				strBackTime = new String((String) time2.getSelectedItem());

				normalN = (int) number1.getSelectedIndex();
				goDate = new Date("2021/" + str1 + "/" + str2 + " " + strGoTime);
				backDate = new Date("2021/" + str3 + "/" + str4 + " " + strBackTime);
				Date now = new Date();
				long diff = backDate.getTime() - now.getTime();
				long dayDiff = diff / (1000 * 60 * 60 * 24);

				/*
				 * 票數不在1~10張範圍內 日期不符合格式 回程日期早於去程日期 則跳出錯誤訊息 若一切正確 進入"車號"介面
				 */

				if ((str1.matches(format1) || str1.matches(format2)) && (str2.matches(format1) || str2.matches(format2))
						&& (str3.matches(format1) || str3.matches(format2))
						&& (str4.matches(format1) || str4.matches(format2))) {

					int int1 = Integer.parseInt(str1);
					int int2 = Integer.parseInt(str2);
					int int3 = Integer.parseInt(str3);
					int int4 = Integer.parseInt(str4);
					int n1 = number1.getSelectedIndex();

					int t1 = time1.getSelectedIndex();
					int t2 = time2.getSelectedIndex();
					if (n1 == 0) {
						strf = "票數至少需一張";
					} else if (n1 > 10) {
						strf = "票數最多為10張";
					} else if (int1 == 1 || int1 == 3 || int1 == 5 || int1 == 7 || int1 == 8 || int1 == 10
							|| int1 == 12) {
						if (int2 <= 31 && int2 >= 1) {

							if (int3 == 1 || int3 == 3 || int3 == 5 || int3 == 7 || int3 == 8 || int3 == 10
									|| int3 == 12) {

								if (int4 <= 31 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {//如果日期不是未來28天內則不予訂票
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
									}
								} else {
									strf = "請輸入正確的日期格式";
								}
							} else if (int3 == 2) {
								if (int4 <= 28 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
									}
								} else {
									strf = "請輸入正確的日期格式";
								}
							} else if (int3 == 4 || int3 == 6 || int3 == 9 || int3 == 11) {
								if (int4 <= 30 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
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
					} else if (int1 == 2) {
						if (int2 <= 28 && int2 >= 1) {

							if (int3 == 1 || int3 == 3 || int3 == 5 || int3 == 7 || int3 == 8 || int3 == 10
									|| int3 == 12) {

								if (int4 <= 31 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
									}
								} else {
									strf = "請輸入正確的日期格式";
								}
							} else if (int3 == 2) {
								if (int4 <= 28 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
									}
								} else {
									strf = "請輸入正確的日期格式";
								}
							} else if (int3 == 4 || int3 == 6 || int3 == 9 || int3 == 11) {
								if (int4 <= 30 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
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
					} else if (int1 == 4 || int1 == 6 || int1 == 9 || int1 == 11) {
						if (int2 <= 30 && int2 >= 1) {

							if (int3 == 1 || int3 == 3 || int3 == 5 || int3 == 7 || int3 == 8 || int3 == 10
									|| int3 == 12) {

								if (int4 <= 31 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
									}
								} else {
									strf = "請輸入正確的日期格式";
								}
							} else if (int3 == 2) {
								if (int4 <= 28 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
									}
								} else {
									strf = "請輸入正確的日期格式";
								}
							} else if (int3 == 4 || int3 == 6 || int3 == 9 || int3 == 11) {
								if (int4 <= 30 && int4 >= 1) {
									if (int1 > int3) {
										strf = "回程日期需晚於去程日期";
									} else if (int1 == int3) {
										if (int2 > int4) {
											strf = "回程日期需晚於去程日期";
										} else if (int2 == int4) {
											if (t1 >= t2) {
												strf = "回程日期需晚於去程日期";
											} else {
												frame.setVisible(false);

												if(diff>0&&dayDiff<28) {
													try {
														testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
																TICKETTYPE, uid, normalN, goDate, backDate, "early");
													} catch (ParseException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
												else {
													strf="只能訂購28日內之車票";
												}
											}
										} else {
											frame.setVisible(false);

											if(diff>0&&dayDiff<28) {
												try {
													testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
															TICKETTYPE, uid, normalN, goDate, backDate, "early");
												} catch (ParseException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else {
												strf="只能訂購28日內之車票";
											}
										}
									} else {
										frame.setVisible(false);

										if(diff>0&&dayDiff<28) {
											try {
												testticket t = new testticket(START, DESTINATION, CARTYPE, SEATTYPE,
														TICKETTYPE, uid, normalN, goDate, backDate, "early");
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										else {
											strf="只能訂購28日內之車票";
										}
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
		frame.add(p8);
		frame.add(p9);
		frame.add(p10);
		frame.add(p11);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(0, 1));
		frame.setBounds(500, 200, 700, 500);
	}
}