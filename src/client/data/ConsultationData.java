package client.data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import persistance.layer.Consultation;
import server.endPoints.ConsultationServiceInterface;

public class ConsultationData {
	public List<Consultation> retrieveAllConsultations() throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://implementations.server/", "ConsultationServiceService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		Consultation[] consultations = serviceInterface.retrieveAllConsultations();
		return Arrays.asList(consultations);
	}

	public void addConsultation(Consultation consultation)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://implementations.server/", "ConsultationServiceService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		serviceInterface.addConsultation(consultation);
	}

	public void updateConsultation(Consultation consultation)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://implementations.server/", "ConsultationServiceService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		serviceInterface.updateConsultation(consultation);
	}

	public void deleteConsultation(int idConsultation)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://implementations.server/", "ConsultationServiceService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		serviceInterface.deleteConsultation(idConsultation);
	}
}
