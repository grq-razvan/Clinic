package persistance.layer.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistance.layer.Patient;
import persistance.layer.connection.ConnectionManager;

public class PatientMapper {

	private static final String SELECT_QUERY = "SELECT * FROM patient";
	private static final String FIND_PATIENT = "SELECT * FROM patient WHERE cnp=?";
	private static final String DELETE_PATIENT = "DELETE FROM patient WHERE cnp=?";
	private static final String INSERT_PATIENT = "INSERT INTO patient(patientName, cnp,dateOfBirth,address, cardNumber) VALUES (?,?,?,?,?)";
	private static final String UPDATE_PATIENT = "UPDATE patient SET patientName=?, cardNumber=?, address=?, dateOfBirth=? where cnp=?";

	public List<Patient> findAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			Connection connection = ConnectionManager.getConnection();
			Statement selectStatement = connection.createStatement();
			ResultSet results = selectStatement.executeQuery(SELECT_QUERY);
			while (results.next()) {
				Patient patient = map(results);
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patients;
	}

	public Patient findPatient(String cnp) {
		Patient result = null;
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement findStatement = connection
					.prepareStatement(FIND_PATIENT);
			findStatement.setString(1, cnp);
			ResultSet patient = findStatement.executeQuery();
			while (patient.next()) {
				result = map(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void addPatient(Patient patient) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement addStatement = connection
					.prepareStatement(INSERT_PATIENT);
			addStatement.setString(2, patient.getCnp());
			addStatement.setString(1, patient.getName());
			addStatement.setString(4, patient.getAddress());
			addStatement.setInt(5, patient.getCardNumber());
			addStatement.setDate(3, new java.sql.Date(patient.getDateOfBirth()
					.getTime()));
			addStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error insert in table");
		}
	}

	public void updatePatient(Patient patient) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement updateStatement = connection
					.prepareStatement(UPDATE_PATIENT);
			updateStatement.setString(1, patient.getName());
			updateStatement.setString(3, patient.getAddress());
			updateStatement.setInt(2, patient.getCardNumber());
			updateStatement.setDate(4, new java.sql.Date(patient
					.getDateOfBirth().getTime()));
			updateStatement.setString(5, patient.getCnp());
			updateStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePatient(String cnp) {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement deleteStatement = connection
					.prepareStatement(DELETE_PATIENT);
			deleteStatement.setString(1, cnp);
			deleteStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Patient map(ResultSet result) {
		Patient patient = null;
		try {
			patient = new Patient(result.getInt("cardNumber"),
					result.getString("cnp"), result.getString("patientName"),
					result.getString("address"), result.getDate("dateOfBirth"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patient;
	}
}
