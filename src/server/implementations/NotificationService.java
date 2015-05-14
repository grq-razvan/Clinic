package server.implementations;

import javax.jws.WebService;

import persistance.layer.Doctor;
import persistance.layer.Notification;
import server.endPoints.NotificationServiceInterface;

@WebService(endpointInterface = "server.endPoints.NotificationServiceInterface")
public class NotificationService implements NotificationServiceInterface {
	@Override
	public Notification[] retrieveNotifications(String username) {
		Doctor doctor = new Doctor(username);
		return doctor.getNotifications();
	}

	@Override
	public void deleteNotifcation(int idNotification) {
		Doctor doctor = new Doctor(null);
		doctor.deleteNotification(idNotification);
	}
}
