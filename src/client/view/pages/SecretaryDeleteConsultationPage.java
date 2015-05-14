package client.view.pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.data.ConsultationData;

public class SecretaryDeleteConsultationPage extends Window {
	private JButton clear, submit;
	private JTextField id;

	public SecretaryDeleteConsultationPage() {
		clear = new JButton("Clear");
		submit = new JButton("Delete");
		id = new JTextField();
		JLabel operation = new JLabel(
				"<html><font size=5 color='white'>Delete patient</font></html>");
		JLabel idLabel = new JLabel("ID: ");
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(400, 160, 50, 30);
		id.setBounds(450, 160, 160, 30);
		submit.setBounds(385, 220, 80, 30);
		clear.setBounds(490, 220, 80, 30);
		operation.setBounds(420, 90, 140, 50);
		panel.add(id);
		panel.add(submit);
		panel.add(clear);
		panel.add(operation);
		panel.add(idLabel);
		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id.setText("");
			}
		});

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConsultationData storage = new ConsultationData();
				try {
					storage.deleteConsultation(Integer.parseInt(id.getText()));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Consultation was deleted!");
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

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}
}
