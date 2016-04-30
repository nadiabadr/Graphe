package testsMeanOfTransport;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.MeanOfTransportServicesRemote;
public class TestDeleteMoTById {
	
	
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/clicandgo-ejb/MeanOfTransportServices!services.interfaces.MeanOfTransportServicesRemote";
		MeanOfTransportServicesRemote proxy = (MeanOfTransportServicesRemote) context
				.lookup(jndiName);

		System.out.println(proxy.deleteMeanOfTransportById("lol"));
	}

}
