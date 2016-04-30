package testsUser;

import javax.naming.NamingException;

import entities.Traveler;
import BusinessDelegator.UserServicesDelegate;


public class testAuthentificate {
public static void main(String[] args) throws NamingException{
	

	System.out.println(UserServicesDelegate.doAuthenticate("houcem", "bargouga"));
		

	}

	
}
