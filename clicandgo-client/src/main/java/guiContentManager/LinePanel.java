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

import model.LineModel;
import model.MeanOfTransportModel;
import BusinessDelegator.LineServicesDelegate;
import BusinessDelegator.MeansOfTransportDelegate;
import BusinessDelegator.StationLineManagementDelegate;
import entities.Line;
import entities.MeanOfTransport;

public class LinePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableMot;
	private JTextField searchText;
	private JTextField Name;
	private JSpinner numberOfStation;
	//private JSpinner nbWagons;
	private JComboBox<String> comboBoxLine;

	/**
	 * Create the application.
	 */
	public LinePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Line Management",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 14))); // NOI18N
		setLayout(null);

		JPanel panelMOTList = new JPanel();
		panelMOTList.setBounds(10, 125, 324, 226);
		add(panelMOTList);

		panelMOTList.setLayout(null);
		panelMOTList.setBorder(javax.swing.BorderFactory.createTitledBorder(
				null, "List of Line",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 14))); // NOI18N

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 304, 191);
		panelMOTList.add(scrollPane);

		tableMot = new JTable();
		tableMot.setModel(new LineModel());
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
				.setText("Type the Name of line ");

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
				tableMot.setModel(new LineModel(searchText.getText()));
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
						51, 0, 0)), "Add Line",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N
		jpanelAdd.setLayout(null);

		JLabel lblRegistrationNumber = new JLabel();
		lblRegistrationNumber.setText("Name");
		lblRegistrationNumber.setBounds(10, 29, 109, 23);
		jpanelAdd.add(lblRegistrationNumber);

		JLabel lblnumberOfStation = new JLabel();
		lblnumberOfStation.setText("Number of Stations");
		lblnumberOfStation.setBounds(10, 63, 109, 23);
		jpanelAdd.add(lblnumberOfStation);

//		

		Name = new JTextField();
		Name.setBounds(200, 30, 95, 20);
		jpanelAdd.add(Name);

		numberOfStation = new JSpinner();
		numberOfStation.setBounds(230, 64, 29, 20);
		jpanelAdd.add(numberOfStation);

//		nbWagons = new JSpinner();
//		nbWagons.setBounds(230, 101, 29, 20);
//		jpanelAdd.add(nbWagons);

		JButton buttonAdd = new JButton();
		buttonAdd.setBounds(515, 63, 137, 23);
		jpanelAdd.add(buttonAdd);
		buttonAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Line line=new Line();
			line.setName(Name.getText());
								
				line.setNbStations((Integer) numberOfStation.getValue());
			//	meanOfTransport.setNbOfWagons((Integer) nbWagons.getValue());
			 StationLineManagementDelegate.doAddLine(line);
				tableMot.setModel(new LineModel());
			}
		});
		buttonAdd.setText("Add");

		JPanel panelAssign = new JPanel();
		panelAssign.setBounds(382, 190, 297, 123);
		add(panelAssign);

		panelAssign.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Assign Mean of Transport to Line",
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
				.setText("Select a mean of transport and assign it to a selected line\r\n");
		lblSelectAMean.setBounds(10, 29, 277, 23);
		panelAssign.add(lblSelectAMean);

		JLabel lblLine = new JLabel();
		lblLine.setText("Line");
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
				MeanOfTransport meanOfTransport = MeansOfTransportDelegate
						.doFindMeanOfTransportById(x);
				Line line = LineServicesDelegate.doFindLineByName(comboBoxLine
						.getSelectedItem().toString().trim());
				MeansOfTransportDelegate.doAssignMeanOfTransportToLine(
						meanOfTransport.getRegistrationNumber(),
						line.getLineId());
				tableMot.setModel(new MeanOfTransportModel());

			}
		});
		assign.setText("assign");
		assign.setBounds(150, 89, 137, 23);
		panelAssign.add(assign);

//		JPanel panelDelete = new JPanel();
//		panelDelete.setBounds(375, 261, 297, 90);
//		add(panelDelete);
//
//		panelDelete.setBorder(javax.swing.BorderFactory.createTitledBorder(
//				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
//						51, 0, 0)), "Remove from circuit",
//				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
//				javax.swing.border.TitledBorder.DEFAULT_POSITION,
//				new java.awt.Font("Arial", 2, 12),
//				new java.awt.Color(102, 0, 0))); // NOI18N
//		panelDelete.setLayout(null);
//
//		JLabel lblSelectAMean_1 = new JLabel();
//		lblSelectAMean_1
//				.setText("Remove a mean of transport from circuit\r\n\r\n");
//		lblSelectAMean_1.setBounds(10, 22, 277, 23);
//		panelDelete.add(lblSelectAMean_1);
//
//		JButton buttonDelete = new JButton();
//		buttonDelete.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				String x = (String) tableMot.getValueAt(
//						tableMot.getSelectedRow(), 0);
//
//				MeanOfTransport meanOfTransport = MeansOfTransportDelegate
//						.doFindMeanOfTransportById(x);
//
//				MeansOfTransportDelegate
//						.DoDeleteMeanOfTransportById(meanOfTransport
//								.getRegistrationNumber());
//				tableMot.setModel(new MeanOfTransportModel());
//
//			}
//		});
//		buttonDelete.setText("delete");
//		buttonDelete.setBounds(150, 56, 137, 23);
//		panelDelete.add(buttonDelete);
	}
}
