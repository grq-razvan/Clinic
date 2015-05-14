package client.view.pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistance.layer.Patient;
import client.data.PatientData;

public class SecretaryUpdatePatientPage extends Window {
	private static final int OFFSET_Y = 30;
	private JButton clear, submit;
	private JTextField name, cnp, address, date, cardNumber;

	public SecretaryUpdatePatientPage() {
		clear = new JButton("Clear");
		submit = new JButton("Submit");
		name = new JTextField();
		cnp = new JTextField();
		date = new JTextField();
		address = new JTextField();
		cardNumber = new JTextField();

		JLabel nameLabel = new JLabel("Name: ");
		JLabel cnpLabel = new JLabel("CNP: ");
		JLabel dateLabel = new JLabel("Date: ");
		JLabel addressLabel = new JLabel("Address: ");
		JLabel cardLabel = new JLabel("Card number: ");

		Component[] labels = { nameLabel, cnpLabel, dateLabel, addressLabel,
				cardLabel };
		Component[] textFields = { name, cnp, date, address, cardNumber };

		for (int i = 0; i < labels.length; i++) {
			labels[i].setForeground(Color.WHITE);
			labels[i].setBounds(300, 180 + i * OFFSET_Y, 100, 30);
			textFields[i].setBounds(410, 180 + i * OFFSET_Y, 100, 30);
		}
		
		clear.setBounds(360,400,100,30);
		submit.setBounds(480,400,100,30);

		panel.add(clear);
		panel.add(submit);
		panel.add(name);
		panel.add(cnp);
		panel.add(cardNumber);
		panel.add(address);
		panel.add(date);
		panel.add(nameLabel);
		panel.add(cnpLabel);
		panel.add(dateLabel);
		panel.add(addressLabel);
		panel.add(cardLabel);
		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Component[] textFields = { name, cnp, date, address, cardNumber };
				for (Component textField : textFields) {
					((JTextField) textField).setText("");
				}
			}
		});

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PatientData storage = new PatientData();
				try {
					storage.updatePatient(new Patient(Integer
							.parseInt(cardNumber.getText()), cnp.getText(),
							name.getText(), address.getText(),
							new SimpleDateFormat("dd/MM/yyyy").parse(date
									.getText())));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Patient " + name.getText()
						+ " updated successfully!");
				Component[] textFields = { name, cnp, date, address, cardNumber };
				for (Component textField : textFields) {
					((JTextField) textField).setText("");
				}
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

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getCnp() {
		return cnp;
	}

	public void setCnp(JTextField cnp) {
		this.cnp = cnp;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getDate() {
		return date;
	}

	public void setDate(JTextField date) {
		this.date = date;
	}

	public JTextField getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(JTextField cardNumber) {
		this.cardNumber = cardNumber;
	}
}
