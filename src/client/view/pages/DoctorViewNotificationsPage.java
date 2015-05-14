package client.view.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistance.layer.Notification;
import client.data.NotificationData;

public class DoctorViewNotificationsPage extends Window {
	private static final Object[] TABLE_HEADERS = { "ID", "DOC_NAME", "MESSAGE" };
	private JTable table;
	private JButton button;
	private String temp;

	public DoctorViewNotificationsPage(String username) {
		button = new JButton("Show");
		DefaultTableModel model = new DefaultTableModel(TABLE_HEADERS, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(200, 100, 480, 240);
		button.setBounds(100, 60, 80, 30);
		panel.add(scroll);
		panel.add(button);
		temp = username;
		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NotificationData storage = new NotificationData();
				Notification[] notifs = null;
				try {
					notifs = storage.retrieveNotifications(temp);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.getDataVector().clear();
				for (Notification notif : notifs) {
					Object[] row = { String.valueOf(notif.getId()),
							notif.getUsername(), notif.getMessage() };
					model.addRow(row);
				}
			}
		});
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
}
