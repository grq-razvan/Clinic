package server.endPoints;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import persistance.layer.Patient;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PatientServiceInterface {

	@WebMethod
	Patient[] retrieveAllPatients();

	@WebMethod
	void addPatient(Patient patient);

	@WebMethod
	void deletePatient(String cnp);

	@WebMethod
	void updatePatient(Patient patient);
}
