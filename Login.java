package PasswordManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	HashMap<String, String> correctData = new HashMap<String, String>();
	
	JFrame login = new JFrame();
	JLabel TopText = new JLabel();
	JPanel TopPanel = new JPanel(); 
	JPanel TopPanel2 = new JPanel();
	JButton loginAttempt = new JButton();
	JButton addLoginInfo = new JButton();
	JLabel Usn = new JLabel();
	JLabel Psw = new JLabel();
	JTextField eUsn = new JTextField();
	JPasswordField ePsw = new JPasswordField();
	JButton clearFields = new JButton();
	Font myFont = new Font("New Helvetica", Font.PLAIN, 30);
	Font headLine = new Font("New Helvetica", Font.PLAIN, 40);
	Font buttonFont = new Font("New Helvetica", Font.PLAIN, 25);
	
	Login(){
		
		correctData.put("", "");
		//login frame arguments
		login.setVisible(true);
		login.setResizable(false);
		login.setLocation(400, 110);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setLayout(new GridLayout(0, 1));
		login.setPreferredSize(new Dimension(800, 600));
		login.setTitle("Login: PasswordManager");
		
		//top panel arguments
		TopText.setText("PasswordManager");
		TopText.setFont(headLine);
		TopText.setHorizontalTextPosition(JLabel.LEFT);
		TopText.setVerticalTextPosition(JLabel.CENTER);
		TopPanel.setBackground(Color.red);
		TopPanel.add(TopText);
		login.add(TopPanel);
		
		TopPanel2.setBackground(Color.red);
		login.add(TopPanel2);
		
		//Usn&Psn arguments
		Usn.setText("Username: ");
		Usn.setFont(myFont);
		login.add(Usn);
		
		eUsn.setFont(myFont);
		eUsn.setText("");
		login.add(eUsn);
		
		Psw.setText("Password: ");
		Psw.setFont(myFont);
		login.add(Psw);
		
		ePsw.setFont(myFont);
		login.add(ePsw);
		
		loginAttempt.setText("Login");
		loginAttempt.setFont(buttonFont);
		loginAttempt.setBackground(Color.green);
		loginAttempt.addActionListener(this);
		login.add(loginAttempt);
		
		addLoginInfo.setBackground(Color.CYAN);
		addLoginInfo.setText("Set new password and username");
		addLoginInfo.setFont(buttonFont);
		addLoginInfo.addActionListener(this);
		login.add(addLoginInfo);
		
		clearFields.setText("Clear");
		clearFields.setBackground(new Color(40, 150, 100));
		clearFields.setFont(buttonFont);
		login.add(clearFields);
		
		login.pack();
	}

	public static void main(String[] args) {
		Login login = new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginAttempt) {
			String UEU = eUsn.getText();
			String UEP = String.valueOf(ePsw.getPassword());
		
			if(correctData.containsKey(UEU) && correctData.containsValue(UEP)) {
				login.dispose();
				
				JLabel domain = new JLabel();
				JLabel username = new JLabel();
				JLabel password = new JLabel();
				JLabel email = new JLabel();
				JLabel others = new JLabel();
				
				JPanel domainPanel = new JPanel();
				JPanel usernamePanel  = new JPanel();
				JPanel passwordPanel = new JPanel();
				JPanel emailPanel = new JPanel();
				JPanel othersPanel = new JPanel();
				
				JTextField enterNewDomain = new JTextField();
				JTextField enterNewUsername = new JTextField();
				JTextField enterNewPassword = new JTextField();
				JTextField enterNewEmail = new JTextField();
				JTextField enterNewOthers = new JTextField();
				
				GridBagLayout g = new GridBagLayout();
				GridBagConstraints gbc = new GridBagConstraints();
				
				gbc.fill = GridBagConstraints.FIRST_LINE_START;
				gbc.gridx = 6;
				gbc.gridy = 5;
				
				JFrame PswTable = new JFrame();
				PswTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				PswTable.setTitle("PasswordManager");
				PswTable.setResizable(true);
				PswTable.setLayout(new GridBagLayout());
				PswTable.setPreferredSize(new Dimension(1200, 800));
				PswTable.setResizable(false);
				PswTable.setLocation(150, 0);
				PswTable.getContentPane().setBackground(new Color(20, 140, 90));	
				
				JLabel label = new JLabel();
				JPanel top = new JPanel();
				JPanel top2 = new JPanel();
				JLabel top2text = new JLabel();
				JPanel lower = new JPanel();
				JPanel tablePanel = new JPanel(new BorderLayout());
				
				label.setText("PasswordManager");
				label.setVerticalTextPosition(JLabel.TOP);
				label.setFont(headLine);
				top.setBackground(new Color(20, 140, 90));
				top.setBounds(0, 0, 1200, 60);
				top.setBackground(Color.yellow);
				top.add(label);
				
				top2.setBackground(Color.yellow);
				top2text.setText("© Julian Rieder");
				top2.add(top2text);
				
				
				lower.setBackground(new Color(20, 140, 90));
				lower.setBounds(0, 60, 1200, 740);
				PswTable.add(top);
				PswTable.add(top2);
				
				PswTable.add(lower);
				
				
				String[] rows = {"Domain", "Benutzename", "Password", "E-Mail", "Sonstige"};
				String[][] data = {{"Minecraft", "Baerki", "Lemming4611", "info@rieder.me", "nothing"}};
				
				domain.setText("Domain: ");
				domainPanel.add(domain);
				domainPanel.setBackground(new Color(20, 140, 90));
				PswTable.add(domainPanel);
				
				
				PswTable.setVisible(true);
				PswTable.pack();
				
			
			}else {
				JOptionPane.showMessageDialog(login, "Wrong Password");
			}
			if(e.getSource() == clearFields) {
				eUsn.setText("");
				ePsw.setText("");
			}
		}
	}
}
