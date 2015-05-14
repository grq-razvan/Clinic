package client.view.menu;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import persistance.layer.User;
import persistance.layer.UserType;
import client.view.Frame;
import client.view.pages.AdminAddUserPage;
import client.view.pages.AdminRemoveUserPage;
import client.view.pages.AdminUpdateUserPage;
import client.view.pages.AdminUserViewPage;
import client.view.pages.DoctorAddConsultationPage;
import client.view.pages.DoctorUpdateConsultationPage;
import client.view.pages.DoctorViewConsultationsPage;
import client.view.pages.DoctorViewNotificationsPage;
import client.view.pages.LoginPage;
import client.view.pages.SecretaryAddPatientPage;
import client.view.pages.SecretaryDeleteConsultationPage;
import client.view.pages.SecretaryRemovePatientPage;
import client.view.pages.SecretaryScheduleConsultationPage;
import client.view.pages.SecretaryUpdateConsultationPage;
import client.view.pages.SecretaryUpdatePatientPage;
import client.view.pages.SecretaryViewPatientsPage;
import client.view.pages.Window;

public class Menu {

	private static final String ADD = "Insert";
	private static final String DEL = "Remove";
	private static final String MOD = "Update";
	private static final String READ = "View";

	private static final String PATIENT = " Patient";
	private static final String USER = " User";
	private static final String CONSULT = " Consultation";
	private static final String NOTIF = " Notifications";

	private JMenuBar menuBar;
	private JMenu secretary, admin, doctor, exit;
	private JMenuItem adminAdd, adminDel, adminMod, adminLst;
	private JMenuItem secretaryPatientAdd, secretaryPatientView,
			secretaryPatientDel, secretaryPatientMod;
	private JMenuItem secretaryConsultAdd, secretaryConsultUpdate,
			secretaryConsultDelete;
	private JMenuItem doctorAddConsult, doctorViewConsult, doctorUpdateConsult,
			doctorViewNotif;
	private JMenuItem close, logout;
	private String username;

	public Menu(User temp) {
		menuBar = new JMenuBar();

		secretary = new JMenu("Secretary");
		admin = new JMenu("Administrator");
		doctor = new JMenu("Doctor");
		exit = new JMenu("Exit");

		close = new JMenuItem();
		logout = new JMenuItem();
		adminAdd = new JMenuItem();
		adminDel = new JMenuItem();
		adminMod = new JMenuItem();
		adminLst = new JMenuItem();
		doctorAddConsult = new JMenuItem();
		doctorUpdateConsult = new JMenuItem();
		doctorViewConsult = new JMenuItem();
		doctorViewNotif = new JMenuItem();
		secretaryPatientAdd = new JMenuItem();
		secretaryPatientDel = new JMenuItem();
		secretaryPatientMod = new JMenuItem();
		secretaryPatientView = new JMenuItem();
		secretaryConsultAdd = new JMenuItem();
		secretaryConsultDelete = new JMenuItem();
		secretaryConsultUpdate = new JMenuItem();

		close.setText("Close");
		logout.setText("Log out");
		adminAdd.setText(ADD + USER);
		adminDel.setText(DEL + USER);
		adminMod.setText(MOD + USER);
		adminLst.setText(READ + USER);
		doctorAddConsult.setText(ADD + CONSULT);
		doctorUpdateConsult.setText(MOD + CONSULT);
		doctorViewConsult.setText(READ + CONSULT);
		doctorViewNotif.setText(READ + NOTIF);
		secretaryPatientAdd.setText(ADD + PATIENT);
		secretaryPatientDel.setText(DEL + PATIENT);
		secretaryPatientMod.setText(MOD + PATIENT);
		secretaryPatientView.setText(READ + PATIENT);
		secretaryConsultAdd.setText(ADD + CONSULT);
		secretaryConsultDelete.setText(DEL + CONSULT);
		secretaryConsultUpdate.setText(MOD + CONSULT);

		if (temp.getType().equals(UserType.admin.toString())) {
			adminAdd.setEnabled(true);
			adminDel.setEnabled(true);
			adminMod.setEnabled(true);
			adminLst.setEnabled(true);
			doctorAddConsult.setEnabled(false);
			doctorUpdateConsult.setEnabled(false);
			doctorViewConsult.setEnabled(false);
			doctorViewNotif.setEnabled(false);
			secretaryPatientAdd.setEnabled(false);
			secretaryPatientDel.setEnabled(false);
			secretaryPatientMod.setEnabled(false);
			secretaryPatientView.setEnabled(false);
			secretaryConsultAdd.setEnabled(false);
			secretaryConsultDelete.setEnabled(false);
			secretaryConsultUpdate.setEnabled(false);
		} else {
			if (temp.getType().equals(UserType.secretary.toString())) {
				adminAdd.setEnabled(false);
				adminDel.setEnabled(false);
				adminMod.setEnabled(false);
				adminLst.setEnabled(false);
				doctorAddConsult.setEnabled(false);
				doctorUpdateConsult.setEnabled(false);
				doctorViewConsult.setEnabled(false);
				doctorViewNotif.setEnabled(false);
				secretaryPatientAdd.setEnabled(true);
				secretaryPatientDel.setEnabled(true);
				secretaryPatientMod.setEnabled(true);
				secretaryPatientView.setEnabled(true);
				secretaryConsultAdd.setEnabled(true);
				secretaryConsultDelete.setEnabled(true);
				secretaryConsultUpdate.setEnabled(true);
			} else {
				adminAdd.setEnabled(false);
				adminDel.setEnabled(false);
				adminMod.setEnabled(false);
				adminLst.setEnabled(false);
				doctorAddConsult.setEnabled(true);
				doctorUpdateConsult.setEnabled(true);
				doctorViewConsult.setEnabled(true);
				doctorViewNotif.setEnabled(true);
				secretaryPatientAdd.setEnabled(false);
				secretaryPatientDel.setEnabled(false);
				secretaryPatientMod.setEnabled(false);
				secretaryPatientView.setEnabled(false);
				secretaryConsultAdd.setEnabled(false);
				secretaryConsultDelete.setEnabled(false);
				secretaryConsultUpdate.setEnabled(false);
				username = temp.getUsername();
			}
		}

		admin.add(adminAdd);
		admin.add(adminDel);
		admin.add(adminMod);
		admin.add(adminLst);
		exit.add(close);
		exit.add(logout);
		doctor.add(doctorAddConsult);
		doctor.add(doctorUpdateConsult);
		doctor.add(doctorViewConsult);
		doctor.add(doctorViewNotif);
		secretary.add(secretaryConsultAdd);
		secretary.add(secretaryConsultDelete);
		secretary.add(secretaryConsultUpdate);
		secretary.add(secretaryPatientAdd);
		secretary.add(secretaryPatientDel);
		secretary.add(secretaryPatientMod);
		secretary.add(secretaryPatientView);
		menuBar.add(admin);
		menuBar.add(doctor);
		menuBar.add(secretary);
		menuBar.add(exit);

		exit.add(close);
		exit.add(logout);

		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		listenItem(logout, new LoginPage());
		listenItem(adminAdd, new AdminAddUserPage());
		listenItem(adminDel, new AdminRemoveUserPage());
		listenItem(adminMod, new AdminUpdateUserPage());
		listenItem(adminLst, new AdminUserViewPage());
		listenItem(secretaryConsultAdd, new SecretaryScheduleConsultationPage());
		listenItem(secretaryConsultDelete,
				new SecretaryDeleteConsultationPage());
		listenItem(secretaryConsultUpdate,
				new SecretaryUpdateConsultationPage());
		listenItem(secretaryPatientAdd, new SecretaryAddPatientPage());
		listenItem(secretaryPatientDel, new SecretaryRemovePatientPage());
		listenItem(secretaryPatientMod, new SecretaryUpdatePatientPage());
		listenItem(secretaryPatientView, new SecretaryViewPatientsPage());
		listenItem(doctorAddConsult, new DoctorAddConsultationPage());
		listenItem(doctorUpdateConsult, new DoctorUpdateConsultationPage());
		listenItem(doctorViewConsult, new DoctorViewConsultationsPage());
		listenItem(doctorViewConsult, new DoctorViewNotificationsPage(username));
	}

	private void assignWindow(Window window) {
		Container container = Frame.getFrame().getContentPane();
		container.removeAll();
		container.repaint();
		container.add(window.getPanel());
		container.revalidate();
		container.repaint();
	}

	private void listenItem(JMenuItem item, Window window) {
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				assignWindow(window);
			}
		});
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getSecretary() {
		return secretary;
	}

	public void setSecretary(JMenu secretary) {
		this.secretary = secretary;
	}

	public JMenu getAdmin() {
		return admin;
	}

	public void setAdmin(JMenu admin) {
		this.admin = admin;
	}

	public JMenu getDoctor() {
		return doctor;
	}

	public void setDoctor(JMenu doctor) {
		this.doctor = doctor;
	}

}
