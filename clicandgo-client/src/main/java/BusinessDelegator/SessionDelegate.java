package BusinessDelegator;

import services.interfaces.SessionRemote;
import ServiceLocator.ServiceLocator;

public class SessionDelegate {

	public static final String jndiName = "/clicandgo-ejb/Session!services.interfaces.SessionRemote";

	public static SessionRemote getProxy() {
		return (SessionRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static String doGetLogin() {
		return getProxy().getLogin();
	}

	public static void doSetLogin(String login) {
		getProxy().setLogin(login);
	}

	public static String doGetPwd() {
		return getProxy().getPwd();
	}

	public static void doSetPwd(String pwd) {
		getProxy().setPwd(pwd);
	}
	
	public static String doGetArrival() {
		return getProxy().getArrival();
	}

	public static void doSetArrival(String arrival) {
		getProxy().setArrival(arrival);
	}
	
	public static String doGetDeparture() {
		return getProxy().getDeparture();
	}

	public static void doSetDeparture(String departure) {
		getProxy().setDeparture(departure);;
	}
	
	
	public static Integer doGetDuration() {
		return getProxy().getDuration();
	}

	public static void doSetDuration(Integer duration) {
		getProxy().setDuration(duration);
	}
	
	
	


	public static void doStopSession() {
		getProxy().stopSession();
	}

	public static void doExit() {
		getProxy().exit();
	}
	
	
	
}
