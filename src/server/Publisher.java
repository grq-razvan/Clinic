package server;

import javax.xml.ws.Endpoint;

import server.implementations.ConsultationService;
import server.implementations.NotificationService;
import server.implementations.PatientService;
import server.implementations.UserService;


public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/webservice/patient",
				new PatientService());
		Endpoint.publish("http://localhost:8888/webservice/consultation",
				new ConsultationService());
		Endpoint.publish("http://localhost:8888/webservice/user",
				new UserService());
		Endpoint.publish("http://localhost:8888/webservice/notification",
				new NotificationService());

	}

}
