package client.view.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistance.layer.User;
import client.data.UserData;

public class AdminUserViewPage extends Window {

	private static final Object[] TABLE_HEADERS = {"USERNAME", "PASSWORD", "ROLE"};
private JTable table;
private JButton button;

public AdminUserViewPage() {
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
    addListeners();
}

private void addListeners() {
	// TODO Auto-generated method stub
	button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.getDataVector().clear();
			UserData storage = new UserData();
			List<User> users =  new ArrayList<User>();
			try {
				users = storage.retrieveAllUsers();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            for(User user : users){
            	Object[] row = {user.getUsername(),user.getPassword(),user.getType()};
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
