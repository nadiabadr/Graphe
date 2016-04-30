package guiContentManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.UserTableModel;
import BusinessDelegator.UserServicesDelegate;

//import model.DiscountModelTable;

public class UserPanel extends JPanel {
	private JTable table;
	private JTextField txtSearch;
	private javax.swing.JLabel lblimage;

	public UserPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(null);

		table = new JTable();
		table.setBounds(109, 310, 506, 213);
		add(table);
		table.setModel(new UserTableModel());

		JButton btnSubmit = new JButton("List Users");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new UserTableModel());

			}
		});
		btnSubmit.setBounds(200, 279, 89, 23);
		add(btnSubmit);

		txtSearch = new JTextField();
		txtSearch.setBounds(529, 280, 86, 20);
		add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearchByName = new JButton("Search By Name");
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserServicesDelegate.doFindUserByName(txtSearch.getText());
				table.setModel(new UserTableModel(txtSearch.getText()));
			}
		});
		btnSearchByName.setBounds(409, 279, 110, 23);
		add(btnSearchByName);

		JLabel lblImg = new JLabel("Img");
		lblImg.setBounds(36, 35, 675, 202);
		lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/trainImg.png")));
		lblImg.setText("");
		add(lblImg);

	}
}