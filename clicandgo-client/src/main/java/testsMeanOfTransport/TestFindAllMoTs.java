package testsMeanOfTransport;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.MeanOfTransportServicesRemote;
import entities.MeanOfTransport;

public class TestFindAllMoTs {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/clicandgo-ejb/MeanOfTransportServices!services.interfaces.MeanOfTransportServicesRemote";
		MeanOfTransportServicesRemote proxy = (MeanOfTransportServicesRemote) context
				.lookup(jndiName);

		List<MeanOfTransport> MeanOfTransports = proxy.findAllMeanOfTransports();

		System.out.println(MeanOfTransports.size());
		for (MeanOfTransport e : MeanOfTransports) {
			System.out.println(e.toString());
		}
	}

}




