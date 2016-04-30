package gui;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import BusinessDelegator.MeansOfTransportDelegate;
import entities.MeanOfTransport;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TimeTablePanel extends JPanel {
	private JTable table;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TimeTablePanel() {
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setLayout(null);


		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		panel.setBounds(408, 373, -312, -367);
		add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 104, 129, 50);
		add(comboBox);
		
		JButton btnShowTables = new JButton("show tables");
		btnShowTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m=comboBox.getSelectedItem().toString();
				int n=comboBox.getSelectedIndex();
				System.out.println("\n : le comcom "+m);
				System.out.println(n);
				if(n==1)
					table.setVisible(true);
				//initialize();

				if(n==2){
					table.setVisible(true);

					
					//initialize();
				}

				
			}
		});
		btnShowTables.setBounds(126, 217, 89, 23);
		add(btnShowTables);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Departure", "Hour", "Arrival", "Hour"},
				{"Ariana", "15", "Cit\u00E9 olympique", "15:15"},
				{"Cit\u00E9 olympique", "15:20", "Med 5", "15:30"},
				{"Med5", "15:35", "Passage", "15:45"},
				{"Passage", "15:50", "Manar 2 ", "16:05"},
				{"Passage", "15:50", "Barcelone", "16:00"},
				{"Barcelone", "16:05", "Megrine", "16:20"},
				{"Manar 2", "16:10", "Menzeh 9", "16:15"},
				{"Megrine", "16:25", "Hammam Lif", null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(66);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(76);
		table.setBounds(155, 280, 491, 171);
		
		add(table);
		table.setVisible(false);

		List<MeanOfTransport> meanOfTransports = MeansOfTransportDelegate.doFindAllMeanOfTransports();
		for(MeanOfTransport m : meanOfTransports)
		{
			comboBox.addItem(m.getRegistrationNumber());
		}
	
	
	}
}
