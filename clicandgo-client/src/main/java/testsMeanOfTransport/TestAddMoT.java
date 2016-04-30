package testsMeanOfTransport;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.interfaces.MeanOfTransportServicesRemote;
import entities.MeanOfTransport;;

public class TestAddMoT {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/clicandgo-ejb/MeanOfTransportServices!services.interfaces.MeanOfTransportServicesRemote";
		
		MeanOfTransportServicesRemote proxy = (MeanOfTransportServicesRemote) context
				.lookup(jndiName);
		
		MeanOfTransport MeanOfTransport = new MeanOfTransport();
		MeanOfTransport.setRegistrationNumber("47A"); 
		MeanOfTransport.setCapacity(5);
		MeanOfTransport.setNbOfWagons(55);
		MeanOfTransport MeanOfTransport1 = new MeanOfTransport();
		MeanOfTransport.setRegistrationNumber("20A"); 
		MeanOfTransport.setCapacity(5);
		

		 
		System.out.println(proxy.addMeanOfTransport(MeanOfTransport));
	}
}



