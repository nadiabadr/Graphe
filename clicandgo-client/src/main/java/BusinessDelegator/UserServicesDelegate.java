package BusinessDelegator;

import java.util.List;

import services.interfaces.UserServicesRemote;
import ServiceLocator.ServiceLocator;
import entities.User;

public class UserServicesDelegate {

	public static final String jndiName = "clicandgo-ejb/UserServices!services.interfaces.UserServicesRemote";

	public static UserServicesRemote getProxy() {
		return (UserServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddUser(User user) {
		return getProxy().addUser(user);

	}

	public static boolean doDeleteUserById(int id) {
		return getProxy().deleteUserById(id);
	}

	public static User updateUser(int id) {
		return getProxy().updateUser(id);
	}

	public static List<User> doFindAllUsers() {
		return getProxy().findAllUsers();
	}

	public static User findUserById(int id) {
		return getProxy().findUserById(id);
	}

	public static User doAuthenticate(String name, String password) {
		return getProxy().authenticate(name, password);
	}
	
	
	public static User doUpdateReadingSpeed(int id,int speed)
	{
		return getProxy().updateReadingSpeed(id, speed);
	}
	public static List<User> doFindUserByName(String name)
	{
		return getProxy().findUserByName(name);
	}
}