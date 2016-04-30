package BusinessDelegator;

import java.util.List;

import services.interfaces.LineServicesRemote;
import ServiceLocator.ServiceLocator;
import entities.Line;

public class LineServicesDelegate {

	public static final String jndiName = "/clicandgo-ejb/LineServices!services.interfaces.LineServicesRemote";

	public static LineServicesRemote getProxy() {
		return (LineServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Boolean DoaddLine(Line line) {
		return getProxy().addLine(line);
	}

	public static List<Line> doFindAllLines() {
		return getProxy().findAllLines();
	}
	public static Line doFindLineByName(String name){
		return getProxy().findLineByName(name);
	}
}
