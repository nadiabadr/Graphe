package guiContentManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

//import model.StationModel;
import model.StationTableModel;
import BusinessDelegator.LineServicesDelegate;
import BusinessDelegator.StationDelegate;
import BusinessDelegator.StationLineManagementDelegate;
import entities.Line;
import entities.Station;

public class StationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableMot;
	private JTextField searchText;
	private JTextField Name;
	private JSpinner x;
	private JSpinner y;
	private JComboBox<String> comboBoxLine;

	/**
	 * Create the application.
	 */
	public StationPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Station_Line Management",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 14))); // NOI18N
		setLayout(null);

		JPanel panelMOTList = new JPanel();
		panelMOTList.setBounds(20, 125, 324, 226);
		add(panelMOTList);

		panelMOTList.setLayout(null);
		panelMOTList.setBorder(javax.swing.BorderFactory.createTitledBorder(
				null, "Station List",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 14))); // NOI18N

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 304, 191);
		panelMOTList.add(scrollPane);

		tableMot = new JTable();
		tableMot.setModel(new StationTableModel());
		scrollPane.setColumnHeaderView(tableMot);
		scrollPane.setViewportView(tableMot);

		JPanel jPanelSearch = new JPanel();
		jPanelSearch.setBounds(10, 46, 662, 68);
		add(jPanelSearch);
		jPanelSearch.setLayout(null);

		JLabel lblTypeTheRegistration = new JLabel();
		lblTypeTheRegistration.setBounds(10, 34, 309, 23);
		jPanelSearch.add(lblTypeTheRegistration);
		lblTypeTheRegistration
				.setText("Type the registration number of the mean of transport");

		searchText = new JTextField();
		searchText.setBounds(412, 35, 95, 20);
		jPanelSearch.add(searchText);

		JButton SearchBtn = new JButton();
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SearchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StationLineManagementDelegate.doFindLineByName(searchText
						.getText());
				tableMot.setModel(new StationTableModel(searchText.getText()));

			}
		});
		SearchBtn.setText("Search");
		SearchBtn.setBounds(517, 34, 135, 23);
		jPanelSearch.add(SearchBtn);

		jPanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Search",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N
		jPanelSearch.setLayout(null);

		JPanel jpanelAdd = new JPanel();
		jpanelAdd.setBounds(10, 362, 662, 154);
		add(jpanelAdd);
		jpanelAdd.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Add Mean of Transport",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N
		jpanelAdd.setLayout(null);

		JLabel lblRegistrationNumber = new JLabel();
		lblRegistrationNumber.setText("Registration Number");
		lblRegistrationNumber.setBounds(10, 29, 109, 23);
		jpanelAdd.add(lblRegistrationNumber);

		JLabel lblx = new JLabel();
		lblx.setText("Longitude");
		lblx.setBounds(20, 70, 109, 23);
		jpanelAdd.add(lblx);

		JLabel lblNumberOfWagons = new JLabel();
		lblNumberOfWagons.setText("Latitude");
		lblNumberOfWagons.setBounds(20, 100, 109, 23);
		jpanelAdd.add(lblNumberOfWagons);

		Name = new JTextField();
		Name.setBounds(200, 30, 95, 20);
		jpanelAdd.add(Name);

		x = new JSpinner();
		x.setBounds(230, 64, 74, 29);
		jpanelAdd.add(x);

		y = new JSpinner();
		y.setBounds(230, 101, 74, 29);
		jpanelAdd.add(y);

		JButton buttonAdd = new JButton();
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAdd.setBounds(515, 63, 137, 23);
		jpanelAdd.add(buttonAdd);
		buttonAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Station meanOfTransport = new Station();
				meanOfTransport.setName((Name.getText()));

				meanOfTransport.setX((Integer) x.getValue());
				meanOfTransport.setY((Integer) y.getValue());
				StationDelegate.DoaddStation(meanOfTransport);
				tableMot.setModel(new StationTableModel());
			}
		});
		buttonAdd.setText("Add");

		JPanel panelAssign = new JPanel();
		panelAssign.setBounds(375, 125, 297, 123);
		add(panelAssign);

		panelAssign.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Assign Station to Line",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N
		panelAssign.setLayout(null);

		comboBoxLine = new JComboBox<String>();
		comboBoxLine.setBounds(150, 63, 137, 20);

		panelAssign.add(comboBoxLine);
		List<Line> lines = LineServicesDelegate.doFindAllLines();
		for (Line l : lines) {
			comboBoxLine.addItem(l.getName());
		}

		JLabel lblSelectAMean = new JLabel();
		lblSelectAMean
				.setText("Select station and assign it to a selected line\r\n");
		lblSelectAMean.setBounds(10, 29, 277, 23);
		panelAssign.add(lblSelectAMean);

		JLabel lblLine = new JLabel();
		lblLine.setText("Station");
		lblLine.setBounds(10, 63, 159, 23);
		panelAssign.add(lblLine);

		JButton assign = new JButton();
		assign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		assign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = (String) tableMot.getValueAt(
						tableMot.getSelectedRow(), 0);

				Station meanOfTransport = (Station) StationLineManagementDelegate
						.doFindStationByName(x);

				Line line = LineServicesDelegate.doFindLineByName(comboBoxLine
						.getSelectedItem().toString().trim());
				Integer duration = 5;
				Integer distance = 5;
				StationLineManagementDelegate.doAssignStationToLine(
						meanOfTransport.getStationId(), line.getLineId(), 5,
						duration, distance);
				tableMot.setModel(new StationTableModel());
			}
		});
		assign.setText("assign");
		assign.setBounds(150, 89, 137, 23);
		panelAssign.add(assign);

		JPanel panelDelete = new JPanel();
		panelDelete.setBounds(375, 261, 297, 90);
		add(panelDelete);

		panelDelete.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Remove from circuit",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N
		panelDelete.setLayout(null);

		JLabel lblSelectAMean_1 = new JLabel();
		lblSelectAMean_1
				.setText("Remove a mean of transport from circuit\r\n\r\n");
		lblSelectAMean_1.setBounds(10, 22, 277, 23);
		panelDelete.add(lblSelectAMean_1);

		JButton buttonDelete = new JButton();
		buttonDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = (String) tableMot.getValueAt(
						tableMot.getSelectedRow(), 0);

				Station meanOfTransport = (Station) StationLineManagementDelegate
						.doFindStationByName(x);

				StationDelegate.doDeleteStationById((meanOfTransport
						.getStationId()));
				tableMot.setModel(new StationTableModel());

			}
		});
		buttonDelete.setText("delete");
		buttonDelete.setBounds(150, 56, 137, 23);
		panelDelete.add(buttonDelete);
	}
}
