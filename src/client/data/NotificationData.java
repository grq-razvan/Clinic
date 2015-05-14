package client.data;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import persistance.layer.Notification;
import server.endPoints.NotificationServiceInterface;

public class NotificationData {

	public Notification[] retrieveNotifications(String username)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/notification?wsdl");
		QName qname = new QName("http://implementations.server/",
				"NotificationServiceService");
		Service service = Service.create(wsdlUrl, qname);
		NotificationServiceInterface serviceInterface = service
				.getPort(NotificationServiceInterface.class);
		return serviceInterface.retrieveNotifications(username);

	}

	public void deleteNotification(int idNotification) throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/notification?wsdl");
		QName qname = new QName("http://implementations.server/",
				"NotificationServiceService");
		Service service = Service.create(wsdlUrl, qname);
		NotificationServiceInterface serviceInterface = service
				.getPort(NotificationServiceInterface.class);
		serviceInterface.deleteNotifcation(idNotification);
	}

	
	
}
