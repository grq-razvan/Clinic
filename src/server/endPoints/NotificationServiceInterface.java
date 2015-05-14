package server.endPoints;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import persistance.layer.Notification;

@WebService
@SOAPBinding(style = Style.RPC)
public interface NotificationServiceInterface {

	@WebMethod
	Notification[] retrieveNotifications(String username);

	@WebMethod
	void deleteNotifcation(int idNotification);
	
}
