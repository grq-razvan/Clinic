package server.implementations;

import java.util.List;

import javax.jws.WebService;

import persistance.layer.Patient;
import persistance.layer.mappers.PatientMapper;
import server.endPoints.PatientServiceInterface;

@WebService(endpointInterface = "server.endPoints.PatientServiceInterface")
public class PatientService implements PatientServiceInterface{

	@Override
	public Patient[] retrieveAllPatients() {
		PatientMapper patientMapper = new PatientMapper();
		List<Patient> patients = patientMapper.findAllPatients();
		return patients.toArray(new Patient[patients.size()]);
	}

	@Override
	public void addPatient(Patient patient) {
		PatientMapper patientMapper = new PatientMapper();
		patientMapper.addPatient(patient);
	}

	@Override
	public void updatePatient(Patient patient) {
		PatientMapper patientMapper = new PatientMapper();
		patientMapper.updatePatient(patient);
	}

	@Override
	public void deletePatient(String cnp) {
		PatientMapper patientMapper = new PatientMapper();
		patientMapper.deletePatient(cnp);
	}
	
}
