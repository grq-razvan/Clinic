package persistance.layer.mappers

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

import persistance.layer.User
import persistance.layer.connection.ConnectionManager

class UserMapper {

	private static final String FIND_ALL = 'SELECT * FROM user'
	private static final String FIND_CREDENTIALS = 'SELECT * FROM user WHERE username=? and password=?'
	private static final String FIND_USER = 'SELECT * FROM user WHERE username=?'
	private static final String FIND_TYPE = 'SELECT * FROM user WHERE type=?'
	private static final String INSERT_USER = 'INSERT INTO user(username,password,type) VALUES(?,?,?)'
	private static final String DELETE_USER = 'DELETE FROM user WHERE username=?'
	private static final String UPDATE_USER = 'UPDATE user SET password=?, type=? where username=?'


	public List<User> findAllUsers(){
		List<User> users = []
		try{
			Connection connection = ConnectionManager.getConnection()
			Statement findQuery = connection.createStatement()
			ResultSet results = findQuery.executeQuery(FIND_ALL)
			while(results.next()){
				User user = map(results)
				users.add(user)
			}
		}catch(Exception e){
			e.printStackTrace()
		}
		return users
	}

	public List<User>findByUsernameAndPassword(String username,String password){
		List<User> users = []
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(FIND_CREDENTIALS)
			statement.setString(1,username)
			statement.setString(2,password)
			ResultSet results = statement.executeQuery()
			while(results.next()){
				User user = map(results)
				users.add(user)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
		return users
	}

	public User findByUsername(String username){
		User user = null
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(FIND_USER)
			statement.setString(1,username)
			ResultSet results = statement.executeQuery()
			while(results.next()){
			user = map(results)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
		return user
	}

	public User findByType(String type){
		User user=null
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(FIND_TYPE)
			statement.setString(1,type)
			ResultSet results = statement.executeQuery()
			while(results.next()){
			user = map(results)
			}
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	public void updateUser(User user){
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(UPDATE_USER)
			statement.setString(3,user.username)
			statement.setString(1,user.password)
			statement.setString(2,user.type)
			statement.execute()
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	public void deleteUser(String username){
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(DELETE_USER)
			statement.setString(1,username)
			statement.execute()
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	public void addUser(User user){
		try{
			Connection connection = ConnectionManager.getConnection()
			PreparedStatement statement = connection.prepareStatement(INSERT_USER)
			statement.setString(1,user.username)
			statement.setString(2,user.password)
			statement.setString(3,user.type)
			statement.execute()
		}catch(SQLException e){
			e.printStackTrace()
		}
	}

	private User map(ResultSet resultSet){
		User user = null;
		try {
			user = new User(
					username : resultSet.getString("username"),
					password : resultSet.getString("password"),
					type 			: resultSet.getString("type")
					);
		}catch(SQLException e){
			e.printStackTrace()
		}
		return user
	}
}