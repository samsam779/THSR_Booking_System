package GUI;



import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.Reader;

public class gui {
 private JFrame frame;
 private JPanel p0,p1,p2,p3;
 private JPasswordField passWord;
 private JButton login;
 private String format ="[A-Z]"+"[0-9]{9}";
 private String uid;
 public gui() {
	 
/*
 * 建立一個"登入介面"的JFrame
 * 內有一個JButton
 * 與一個JPasswordField
 */
  frame=new JFrame("登入介面");	

  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  
  p0=new JPanel();
  p0.add(new JLabel("高鐵訂票系統登入"));
  
  frame.add(p0);
  
  p1=new JPanel();  
  p1.add(new JLabel("身分證字號:"));  
  
  passWord=new JPasswordField(20);	
  
  p1.add(passWord);
  
  p2=new JPanel();
  p2.add(new JLabel(""));
  
  login=new JButton("登入");	
  
  login.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        
          String strf = "";
          String str = new String(passWord.getPassword());
          uid=str;
          //檢查使用者的身分證字號
          if (str.matches(format)) {

            gui2 g=new gui2(uid);	//若符合格式則進入"功能"介面
            frame.setVisible(false);
          }
          else {
            strf = "請輸入正確的身分證格式";	//若不符合格式則跳出錯誤訊息
          }
          JOptionPane.showMessageDialog(null,strf);
        }
      });
  
  p2.add(login);
  
  
   
  frame.add(p1);  
  frame.add(p2);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setLayout(new GridLayout(0,1));
  frame.setLocationRelativeTo(null);
  frame.setBounds(500,200,350,250);
  
  
 }
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
}