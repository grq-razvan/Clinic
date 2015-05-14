package persistance.layer;

import java.util.Date;


public class Consultation {
	private int id;
	private String patientCnp,description,doctorName;
	private Date date;
	
	public Consultation(int id, String patientCnp, String description,
			String doctorName, Date date) {
		super();
		this.id = id;
		this.patientCnp = patientCnp;
		this.description = description;
		this.doctorName = doctorName;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientCnp() {
		return patientCnp;
	}
	public void setPatientCnp(String patientCnp) {
		this.patientCnp = patientCnp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
