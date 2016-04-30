package Dijkstra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import BusinessDelegator.LineServicesDelegate;
import BusinessDelegator.SessionDelegate;
import BusinessDelegator.StationLineManagementDelegate;
import entities.Line;
import entities.Station;

public class Mapy extends JPanel {
	public Mapy() {
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D gr = (Graphics2D) g;
		String depart = SessionDelegate.doGetDeparture();
		String arrival = SessionDelegate.doGetArrival();
		Station sta = (Station) StationLineManagementDelegate
				.doFindStationByName(depart);
		int[][] mat = StationLineManagementDelegate.doRemplirMatrice();
		Graphe g0 = new Graphe(mat);
		Dijkstra dij = new Dijkstra(sta.getReference(), g0);

		// gr.setColor(Color.red);
		List<Line> lines = LineServicesDelegate.doFindAllLines();

		for (Line l : lines) {
			// setBackground(getBackground());

			List<Station> stations = StationLineManagementDelegate
					.doFindAllStationsByLineId(l.getLineId());

			for (Station s : stations) {
				System.out.println("" + l.getName() + "" + s.getName() + " ");
			}

			for (Station station : stations) {

				if (station.getX() != null && station.getY() != null) {
					gr.setColor(Color.red);
					gr.fillOval(station.getX() + 150, station.getY() + 150, 13,
							13);
					gr.setColor(Color.BLUE);

					gr.drawString(station.getName(), station.getX() + 150,
							station.getY() + 140);

				}

			}
			for (int i = 0; i < stations.size() - 1; i++) {
				gr.setColor(Color.GRAY);
				gr.setStroke(new BasicStroke((float) 3));
				gr.drawLine(stations.get(i).getX() + 155, stations.get(i)
						.getY() + 155, stations.get(i + 1).getX() + 155,
						stations.get(i + 1).getY() + 155);
			}

		}

		List<Station> stationtoDraw = dij.afficheListStations(depart, arrival);

		for (int i = 0; i < stationtoDraw.size() - 1; i++) {
			gr.setColor(Color.GREEN);
			gr.setStroke(new BasicStroke((float) 3.5));
			gr.drawLine(stationtoDraw.get(i).getX() + 155, stationtoDraw.get(i)
					.getY() + 158, stationtoDraw.get(i + 1).getX() + 155,
					stationtoDraw.get(i + 1).getY() + 158);

		}

	}
}
