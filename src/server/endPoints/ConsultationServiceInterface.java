package server.endPoints;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import persistance.layer.Consultation;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ConsultationServiceInterface {
	@WebMethod
	Consultation[] retrieveAllConsultations();

	@WebMethod
	void addConsultation(Consultation consultation);

	@WebMethod
	void deleteConsultation(int idConsultation);

	@WebMethod
	void updateConsultation(Consultation consultation);
}
