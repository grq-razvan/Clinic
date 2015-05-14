package persistance.layer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistance.layer.mappers.ConsultationMapper;
import persistance.layer.mappers.PatientMapper;
import persistance.layer.mappers.UserMapper;

public class Secretary implements SecretaryInterface {

	private List<DoctorInterface> list = new ArrayList<DoctorInterface>();

	public Secretary() {
		for (User user : new UserMapper().findAllUsers()) {
			if ("doctor".equals(user.getType())) {
				Doctor observer = new Doctor(user.getUsername());
				registerDoctor(observer);
			}
		}
	}

	public void scheduleConsultation(Consultation consultation) {
		Patient patient = new PatientMapper().findPatient(consultation
				.getPatientCnp());
		ConsultationMapper consulationMapper = new ConsultationMapper();
		consulationMapper.addConsultation(consultation);
		String message = "Consultation for  " + patient.getName()
				+ "scheduled on " + new Date();
		notifyDoctor(consultation.getDoctorName(), message);
	}

	@Override
	public void registerDoctor(DoctorInterface doctor) {
		// TODO Auto-generated method stub
		list.add(doctor);
	}

	@Override
	public void unregisterDoctor(DoctorInterface doctor) {
		// TODO Auto-generated method stub
		list.remove(doctor);
	}

	@Override
	public void notifyDoctor(String doctorUsername, String message) {
		// TODO Auto-generated method stub
		for(DoctorInterface doctor : list){
			if(doctorUsername.equals(doctor.getUsername())){
				Doctor doc = (Doctor) doctor;
				doc.notifyDoctor(doctorUsername,message);
			}
		}
	}

	public List<DoctorInterface> getList() {
		return list;
	}

}
