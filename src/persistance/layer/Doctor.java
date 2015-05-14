package persistance.layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistance.layer.connection.ConnectionManager;

public class Doctor implements DoctorInterface {

	private static final String INSERT_QUERY = "INSERT INTO notify(username, message) VALUES (?,?)";
	private static final String DELETE_QUERY = "DELETE FROM notify WHERE id=?";
	private static final String SELECT_QUERY = "SELECT * FROM notify WHERE username=?";

	private final String username;

	public Doctor(String username){
		this.username = username;
	}

	public Notification[] getNotifications(){
		List<Notification> notifications = new ArrayList<Notification>();
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
			statement.setString(1,username);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				notifications.add(new Notification(result.getInt("id"),result.getString("username"),result.getString("message")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return notifications.toArray(new Notification[notifications.size()]);
	}

	public void addNotification(String username,String message){
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
			statement.setString(1,username);
			statement.setString(2,message);
			statement.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void deleteNotification(int idNotification){
		try{
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,idNotification);
			statement.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void notifyDoctor(String username, String message){
		addNotification(username,message);
	}

	public String getUsername(){
		return username;
	}
}
