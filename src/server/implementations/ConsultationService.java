package server.implementations;

import java.util.List;

import javax.jws.WebService;

import persistance.layer.Consultation;
import persistance.layer.Secretary;
import persistance.layer.mappers.ConsultationMapper;
import server.endPoints.ConsultationServiceInterface;

@WebService(endpointInterface = "server.endPoints.ConsultationServiceInterface")
public class ConsultationService implements ConsultationServiceInterface {

	@Override
	public Consultation[] retrieveAllConsultations() {
		ConsultationMapper consultationMapper = new ConsultationMapper();
		List<Consultation> consultations = consultationMapper
				.findAllConsultations();
		return consultations.toArray(new Consultation[consultations.size()]);

	}

	@Override
	public void addConsultation(Consultation consultation) {
		new Secretary().scheduleConsultation(consultation);
	}

	@Override
	public void updateConsultation(Consultation consultation) {
		ConsultationMapper consultationMapper = new ConsultationMapper();
		consultationMapper.updateConsultation(consultation);
	}

	@Override
	public void deleteConsultation(int idConsultation) {
		ConsultationMapper consultationMapper = new ConsultationMapper();
		consultationMapper.deleteConsultation(idConsultation);
	}

}
