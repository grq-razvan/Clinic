package server.endPoints;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import persistance.layer.User;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UserServiceInterface {
	
	@WebMethod
	User[] retrieveAllUsers();

	@WebMethod
	User[] findUsernamePassword(String username, String password);

	@WebMethod
	User[] login(String username, String password);

	@WebMethod
	void addUser(User user);

	@WebMethod
	void deleteUser(String username);

	@WebMethod
	void updateUser(User user);

}
