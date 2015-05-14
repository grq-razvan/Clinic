package persistance.layer.mappers

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

import persistance.layer.Consultation
import persistance.layer.connection.ConnectionManager

class ConsultationMapper {

	private static final String FIND_ALL 				= 'SELECT * FROM consultation'
	private static final String FIND_ID 					= 'SELECT * FROM consultation WHERE id=?'
	private static final String FIND_CNP 			    = 'SELECT * FROM consultation WHERE cnp=?'
	private static final String INSERT_CONSULT  = 'INSERT INTO consultation (id,description,patientCnp,doctorName,date) VALUES (?,?,?,?,?)'
	private static final String DELETE_CONSULT  = 'DELETE FROM consultation WHERE id=?'
	private static final String UPDATE_CONSULT = 'UPDATE consultation SET description=?, patientCnp=?, doctorName=?, date=? WHERE id=?'

	public void addConsultation(Consultation consultation){
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(INSERT_CONSULT)
			statement.setInt(1,consultation.id)
			statement.setString(2,consultation.description)
			statement.setString(3,consultation.patientCnp)
			statement.setString(4,consultation.doctorName)
			statement.setDate(5, new java.sql.Date(consultation.date.getTime()))
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	public void deleteConsultation(int consultationId){
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(DELETE_CONSULT)
			statement.setInt(1,consultationId)
			statement.execute()
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	public void updateConsultation(Consultation consultation){
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(UPDATE_CONSULT)
			statement.setString(1,consultation.description)
			statement.setString(2,consultation.patientCnp)
			statement.setString(3,consultation.doctorName)
			statement.setDate(4, new java.sql.Date(consultation.date.getTime()))
			statement.setInt(5, consultation.id)
			statement.execute()
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	public List<Consultation> findAllConsultations(){
		List<Consultation> consultations = []
		try{
			Connection connection = ConnectionManager.getConnection()
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(FIND_ALL)
			while(results.next()){
				Consultation consultation = map(results)
				consultations.add(consultation)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
		return consultations
	}

	public List<Consultation> findById(Integer id){
		List<Consultation> consultations = []
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(FIND_ID);
			statement.setInt(1,id)
			ResultSet results = statement.executeQuery()
			while(results.next()){
				Consultation consultation = map(results)
				consultations.add(consultation)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
		return consultations
	}

	public List<Consultation> findByPatientCnp(String cnp){
		List<Consultation> consultations = []
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(FIND_CNP)
			statement.setString(1,cnp)
			ResultSet results = statement.executeQuery()
			while(results.next()){
				Consultation consultation = map(results)
				consultations.add(consultation)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
		return consultations
	}

	public Consultation findById(int id){
		Consultation consultation = null;
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement()
			statement.setInt(1,id)
			ResultSet result = statement.executeQuery()
			while(result.next()){
				consultation = map(result)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
		return consultation
	}

	private Consultation map(ResultSet result){
		Consultation consultation = null
		try{
			consultation = new Consultation(
					id:result.getInt('id',),
					description: result.getString('description'),
					patientCnp : result.getString('patientCnp'),
					doctorName : result.getString('doctorName'),
					date: result.getDate('date')
					)
		}
		catch(SQLException e){
			e.printStackTrace()
		}
		return consultation
	}
}
