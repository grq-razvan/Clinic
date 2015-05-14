package client.view.pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistance.layer.Consultation;
import client.data.ConsultationData;

public class DoctorAddConsultationPage extends Window {
	private final static int OFFSET_Y = 30;
	private JTextField cnp, doctorName, date, message, id;
	private JButton clear, submit;

	public DoctorAddConsultationPage() {
		cnp = new JTextField();
		id = new JTextField();
		doctorName = new JTextField();
		message = new JTextField();
		date = new JTextField();
		clear = new JButton("Clear");
		submit = new JButton("Submit");

		JLabel cnpLabel = new JLabel("CNP: ");
		JLabel idLabel = new JLabel("ID: ");
		JLabel doctorLabel = new JLabel("Doctor name: ");
		JLabel messageLabel = new JLabel("Description: ");
		JLabel dateLabel = new JLabel("Date: ");

		JTextField[] fields = { id, cnp, doctorName, date, message };
		JLabel[] labels = { idLabel, cnpLabel, doctorLabel, dateLabel,
				messageLabel };

		for (int i = 0; i < labels.length; i++) {
			labels[i].setForeground(Color.WHITE);
			labels[i].setBounds(300, 180 + i * OFFSET_Y, 120, 30);
			fields[i].setBounds(435, 180 + i * OFFSET_Y, 120, 30);
		}
		clear.setBounds(400, 400, 100, 30);
		submit.setBounds(510, 400, 100, 30);

		for (int i = 0; i < labels.length; i++) {
			panel.add(labels[i]);
			panel.add(fields[i]);
		}

		panel.add(clear);
		panel.add(submit);

		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField[] fields = { id, cnp, doctorName, date, message };
				for (JTextField field : fields) {
					field.setText("");
				}
			}
		});

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConsultationData storage = new ConsultationData();
				try {
					storage.addConsultation(new Consultation(Integer
							.parseInt(id.getText()), cnp.getText(), message
							.getText(), doctorName.getText(),
							new SimpleDateFormat("dd/MM/yyyy").parse(date
									.getText())));
				} catch (NumberFormatException | MalformedURLException
						| ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Consultation scheduled!");
				JTextField[] fields = { id, cnp, doctorName, date, message };
				for (JTextField field : fields) {
					field.setText("");
				}
			}
		});

	}

	public JTextField getCnp() {
		return cnp;
	}

	public void setCnp(JTextField cnp) {
		this.cnp = cnp;
	}

	public JTextField getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(JTextField doctorName) {
		this.doctorName = doctorName;
	}

	public JTextField getDate() {
		return date;
	}

	public void setDate(JTextField date) {
		this.date = date;
	}

	public JTextField getMessage() {
		return message;
	}

	public void setMessage(JTextField message) {
		this.message = message;
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
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
}
