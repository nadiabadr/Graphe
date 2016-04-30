package BusinessDelegator;

import java.util.List;

import services.interfaces.StationLineManagementRemote;
import ServiceLocator.ServiceLocator;
import entities.Line;
import entities.Station;
import entities.StationLine;

public class StationLineManagementDelegate {

	public static final String jndiName = "/clicandgo-ejb/StationLineManagement!services.interfaces.StationLineManagementRemote";

	public static StationLineManagementRemote getProxy() {
		return (StationLineManagementRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public static Boolean doAssignNewStationToLine(Station newStation,
			Integer lineId, Integer position, Integer duration, Integer distance) {
		return getProxy().assignNewStationToLine(newStation, lineId, position,
				duration, distance);
	}

	public static Boolean doAssignStationToLine(Integer stationId,
			Integer lineId, Integer position, Integer duration, Integer distance) {
		return getProxy().assignStationToLine(stationId, lineId, position,
				duration, distance);
	}

	public static Station doFindStationById(Integer id) {
		return getProxy().findStationById(id);
	}

	public static Object doFindStationByName(String name) {
		return getProxy().findStationByName(name);
	}

	public static Object doFindLineByName(String name) {
		return getProxy().findLineByName(name);
	}

	public static Line doFindLineById(Integer id) {
		return getProxy().findLineById(id);
	}

	public static List<Station> doFindAllStations() {
		return getProxy().findAllStations();
	}

	public static List<Line> doFindAllLines() {
		return getProxy().findAllLines();
	}

	public static List<Station> doFindAllStationsByLineId(Integer id) {
		return getProxy().findAllStationsByLineId(id);
	}

	public static StationLine doFindStationLineByLineAndStation(Line line,
			Station station) {
		return getProxy().findStationLineByLineAndStation(line, station);
	}

	public static Boolean doAddLine(Line line) {
		return getProxy().addLine(line);
	}

	public static List<Line> doFindAllLinesByStationId(Integer stationId) {
		return getProxy().findAllLinesByStationId(stationId);
	}

	public static Line doFindLineOfTwoStations(Integer stationId,
			Integer stationId1) {
		return getProxy().findLineOfTwoStations(stationId, stationId1);
	}

	public static StationLine doFindStationLineOfOneStationInTheSameLineOfAnotherStation(
			Station station, Station station1) {
		return getProxy()
				.findStationLineOfOneStationInTheSameLineOfAnotherStation(
						station, station1);
	}

	public static Integer doAntecedentInTheSameLine(Station station,
			Station station1) {
		return getProxy().AntecedentInTheSameLine(station, station1);
	}

	public static int[][] doRemplirMatrice() {
		return getProxy().RemplirMatrice();
	}

	public static Line dofindoutLIneBynName(String name) {
		return getProxy().findoutLIneBynName(name);

	}

	public static List<Line> dolookUpLinet(String name) {
		return getProxy().lookUpLinet(name);
	}

	public static List<Station> doLookUpStation(String id) {
		return getProxy().lookUpStation(id);

	}

}
