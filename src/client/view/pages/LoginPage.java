package client.view.pages;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import persistance.layer.User;
import client.data.UserData;
import client.view.Frame;
import client.view.menu.Menu;

public class LoginPage extends Window {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton submit, exit;

	public LoginPage() {
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		submit = new JButton("Submit");
		exit = new JButton("Exit");
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		usernameField.setBounds(680, 220, 140, 29);
		passwordField.setBounds(680, 265, 140, 29);
		usernameLabel.setBounds(580, 220, 140, 29);
		passwordLabel.setBounds(580, 265, 140, 29);
		usernameLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.WHITE);
		submit.setBounds(635, 325, 85, 30);
		exit.setBounds(745, 325, 80, 30);

		panel.add(usernameField);
		panel.add(usernameLabel);
		panel.add(passwordField);
		panel.add(passwordLabel);
		panel.add(submit);
		panel.add(exit);
		addListeners();
	}

	private void addListeners() {
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		submit.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserData users = new UserData();
				User temp = null;
				try {
					if ((temp = users.login(usernameField.getText(),
							passwordField.getText())) != null) {
						Frame.getFrame().setJMenuBar(new Menu(temp).getMenuBar());
						Container container = Frame.getFrame().getContentPane();
						container.removeAll();
						container.add(new IndexPage().getPanel());
						container.repaint();
						container.revalidate();
					} else {
						JOptionPane.showMessageDialog(null,
								"Login failed! Retry");
						usernameField.setText("");
						passwordField.setText("");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

}
