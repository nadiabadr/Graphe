package testsMeanOfTransport;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.MeanOfTransportServicesRemote;
import entities.MeanOfTransport;

public class TestUpdateMoT {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/clicandgo-ejb/MeanOfTransportServices!services.interfaces.MeanOfTransportServicesRemote";
		MeanOfTransportServicesRemote proxy = (MeanOfTransportServicesRemote) context
				.lookup(jndiName);

		MeanOfTransport MeanOfTransport = proxy.findMeanOfTransportById("lol");
		MeanOfTransport.setCapacity(3);

		System.out.println(proxy.updateMeanOfTransport(MeanOfTransport));
	}
}


//
//}
