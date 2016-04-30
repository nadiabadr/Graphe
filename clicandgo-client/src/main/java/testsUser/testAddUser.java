package testsUser;

import javax.naming.NamingException;

import BusinessDelegator.UserServicesDelegate;
import entities.Traveler;

public class testAddUser {

	public static void main(String[] args) throws NamingException{
	
		
		Traveler traveler=new Traveler();
		traveler.setName("houcem");
		traveler.setPassword("bargouga");
		UserServicesDelegate.getProxy().addUser(traveler);
		
		Traveler traveler2=new Traveler();
		traveler2.setName("sana");
		traveler2.setPassword("sana38");
		UserServicesDelegate.getProxy().addUser(traveler2);
		
		Traveler traveler3=new Traveler();
		traveler3.setName("yosr");
		traveler3.setPassword("yosr38");
		UserServicesDelegate.getProxy().addUser(traveler3);

	}

}