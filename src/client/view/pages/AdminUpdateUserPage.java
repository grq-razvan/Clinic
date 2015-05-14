package client.view.pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import persistance.layer.User;
import client.data.UserData;

public class AdminUpdateUserPage extends Window {
	private JButton clear, submit;
	private JTextField username;
	private JPasswordField password;
	private JTextField role;

	public AdminUpdateUserPage() {
		clear = new JButton("Clear");
		submit = new JButton("Submit");
		username = new JTextField();
		password = new JPasswordField();
		role = new JTextField();

		JLabel userLabel = new JLabel("Username: ");
		JLabel passLabel = new JLabel("Password: ");
		JLabel roleLabel = new JLabel("Role: ");

		JLabel operation = new JLabel(
				"<html><font size=5 color='white'>Add employee</font></html>");

		userLabel.setBounds(360, 200, 80, 30);
		userLabel.setForeground(Color.WHITE);
		passLabel.setBounds(360, 240, 80, 30);
		passLabel.setForeground(Color.WHITE);
		roleLabel.setBounds(360, 280, 50, 30);
		roleLabel.setForeground(Color.WHITE);
		username.setBounds(460, 200, 160, 30);
		password.setBounds(460, 240, 160, 30);
		role.setBounds(460, 280, 130, 30);
		operation.setBounds(460, 90, 140, 50);

		submit.setBounds(430, 380, 80, 30);
		clear.setBounds(530, 380, 80, 30);

		panel.add(clear);
		panel.add(submit);
		panel.add(username);
		panel.add(password);
		panel.add(role);
		panel.add(userLabel);
		panel.add(passLabel);
		panel.add(roleLabel);
		panel.add(operation);
		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username.setText("");
				password.setText("");
				role.setText("");
			}
		});
		
		submit.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserData storage = new UserData();
				try {
					storage.updateUser(new User(username.getText(),password.getText(),role.getText()));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"User "+username.getText() + " was updated successfully!");
				username.setText("");
				password.setText("");
				role.setText("");
			}
		});
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JTextField getRole() {
		return role;
	}

	public void setRole(JTextField role) {
		this.role = role;
	}
}
