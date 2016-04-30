package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import model.EbookTableModel;
import BusinessDelegator.SessionDelegate;
import BusinessDelegator.UserServicesDelegate;
import entities.User;
import javax.swing.JButton;

//import model.DiscountModelTable;

public class ReadingPanel extends JPanel {

	/**
	 * 
	 */
	public User authentifiedUser;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public ReadingPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("1");
		authentifiedUser = UserServicesDelegate.doAuthenticate(
				SessionDelegate.doGetLogin(), SessionDelegate.doGetPwd());

		jPanelSearch = new javax.swing.JPanel();
		jPanelSearch.setBounds(10, 20, 684, 73);
		DescriptionTextSearch = new javax.swing.JLabel();
		searchText = new javax.swing.JTextField();
		SearchBtn = new javax.swing.JButton();
		jPannelLibrary = new javax.swing.JPanel();
		jPannelLibrary.setBounds(10, 108, 482, 484);
		jScrollLibrary = new javax.swing.JScrollPane();
		jScrollLibrary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getComponent());

			}
		});
		jTable1 = new javax.swing.JTable();
		jPanelOptions = new javax.swing.JPanel();
		jPanelOptions.setBounds(499, 108, 195, 118);
		DownloadBtn = new javax.swing.JButton();
		DownloadBtn.setBounds(82, 34, 103, 23);

		setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"E-Library",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 14)));

		jPanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Search",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N
		jPanelSearch.setLayout(null);

		DescriptionTextSearch.setText("Type the name of an author or a book:");
		jPanelSearch.add(DescriptionTextSearch);
		DescriptionTextSearch.setBounds(10, 28, 309, 23);

		searchText.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				descriptionTextActionPerformed(evt);
			}
		});
		jPanelSearch.add(searchText);
		searchText.setBounds(444, 29, 95, 20);

		SearchBtn.setText("Search");
		SearchBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTable1.setModel(new EbookTableModel(searchText.getText()));
			}

		});
		setLayout(null);
		jPanelSearch.add(SearchBtn);
		SearchBtn.setBounds(569, 28, 102, 23);

		add(jPanelSearch);

		jPannelLibrary.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "List Of Ebooks and Articles",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0))); // NOI18N

		jTable1.setModel(new EbookTableModel());
		jScrollLibrary.setViewportView(jTable1);

		javax.swing.GroupLayout gl_jPannelLibrary = new javax.swing.GroupLayout(
				jPannelLibrary);
		jPannelLibrary.setLayout(gl_jPannelLibrary);
		gl_jPannelLibrary
				.setHorizontalGroup(gl_jPannelLibrary
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_jPannelLibrary
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollLibrary,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												490, Short.MAX_VALUE)
										.addContainerGap()));
		gl_jPannelLibrary
				.setVerticalGroup(gl_jPannelLibrary
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_jPannelLibrary
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollLibrary,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												286, Short.MAX_VALUE)
										.addContainerGap()));

		add(jPannelLibrary);

		jPanelOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						51, 0, 0)), "Option",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Arial", 2, 12),
				new java.awt.Color(102, 0, 0)));
		DownloadBtn.setText("Download");

		DownloadBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				// int x = (int) jTable1.getValueAt(jTable1.getSelectedRow(),
				// 0);
				//
				// Discount category = DiscountDelegate.findDiscountById(x);
				// category.setDate_fin(datexy.getDate());
				// DiscountDelegate.updateDiscountDelegate(category);
				// jTable1.setModel(new DiscountModelTable());
			}
		});

		add(jPanelOptions);
		jPanelOptions.setLayout(null);
		jPanelOptions.add(DownloadBtn);

		JLabel labelDownload = new JLabel();
		labelDownload.setHorizontalAlignment(SwingConstants.LEFT);
		labelDownload.setText("Select to download");
		labelDownload.setBounds(10, 11, 140, 32);
		jPanelOptions.add(labelDownload);
		
		lblShowBooksDepending = new JLabel();
		lblShowBooksDepending.setText("show books depending on my trip");
		lblShowBooksDepending.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowBooksDepending.setBounds(10, 50, 195, 32);
		jPanelOptions.add(lblShowBooksDepending);
		
		buttonRefresh = new JButton();
		buttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(SessionDelegate.doGetDuration());
				jTable1.setModel(new EbookTableModel("sa"));
			}
		});
		buttonRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		buttonRefresh.setText("Refresh ");
		buttonRefresh.setBounds(82, 84, 103, 23);
		jPanelOptions.add(buttonRefresh);

		jPanelReaderSpeed = new JPanel();
		jPanelReaderSpeed.setBounds(502, 237, 195, 355);
		jPanelReaderSpeed.setBorder(javax.swing.BorderFactory
				.createTitledBorder(javax.swing.BorderFactory
						.createLineBorder(new java.awt.Color(51, 0, 0)),
						"Reader Speed",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Arial", 2, 12), new java.awt.Color(
								102, 0, 0)));
		add(jPanelReaderSpeed);
		jPanelReaderSpeed.setLayout(null);

		// ********************************
		if (authentifiedUser.getNbOfWordsPerMinute() == null) {
			JRadioButton rdbtnLecteurMoyen = new JRadioButton("Average Reader");
			rdbtnLecteurMoyen.setBounds(10, 131, 144, 23);
			jPanelReaderSpeed.add(rdbtnLecteurMoyen);
			rdbtnLecteurMoyen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserServicesDelegate.doUpdateReadingSpeed(
							authentifiedUser.getUserId(), 250);
					jPanelReaderSpeed.removeAll();
					jPanelReaderSpeed.updateUI();
					lblSpeed = new JLabel();
					System.out.println(authentifiedUser);
					lblSpeed.setText("250 Words/Min");
					lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
					lblSpeed.setBounds(10, 34, 144, 270);
					jPanelReaderSpeed.add(lblSpeed);

				}
			});

			JRadioButton rdbtnLecteurLent = new JRadioButton("Slow Reader");
			rdbtnLecteurLent.setBounds(10, 64, 144, 30);
			jPanelReaderSpeed.add(rdbtnLecteurLent);

			rdbtnLecteurLent.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					UserServicesDelegate.doUpdateReadingSpeed(
							authentifiedUser.getUserId(), 150);
					jPanelReaderSpeed.removeAll();
					jPanelReaderSpeed.updateUI();
					lblSpeed = new JLabel();
					System.out.println(authentifiedUser);
					lblSpeed.setText("150 Words/Min");
					lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
					lblSpeed.setBounds(10, 34, 144, 270);
					jPanelReaderSpeed.add(lblSpeed);

				}
			});

			JRadioButton rdbtnLecteurRapide = new JRadioButton("Good Reader");
			rdbtnLecteurRapide.setBounds(10, 191, 144, 23);
			jPanelReaderSpeed.add(rdbtnLecteurRapide);

			rdbtnLecteurRapide.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					UserServicesDelegate.doUpdateReadingSpeed(
							authentifiedUser.getUserId(), 400);
					jPanelReaderSpeed.removeAll();
					jPanelReaderSpeed.updateUI();
					lblSpeed = new JLabel();
					System.out.println(authentifiedUser);
					lblSpeed.setText("400 Words/Min");
					lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
					lblSpeed.setBounds(10, 34, 144, 270);
					jPanelReaderSpeed.add(lblSpeed);
				}
			});

			JLabel lblVitesseDuNiveau = new JLabel();
			lblVitesseDuNiveau.setHorizontalAlignment(SwingConstants.LEFT);
			lblVitesseDuNiveau.setText("elementary school level");
			lblVitesseDuNiveau.setBounds(10, 101, 144, 23);
			jPanelReaderSpeed.add(lblVitesseDuNiveau);

			JLabel lblVitesseDuNiveau_1 = new JLabel();
			lblVitesseDuNiveau_1.setText("middle school level");
			lblVitesseDuNiveau_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblVitesseDuNiveau_1.setBounds(10, 161, 144, 23);
			jPanelReaderSpeed.add(lblVitesseDuNiveau_1);

			JLabel lblHighSchoolLevel = new JLabel();
			lblHighSchoolLevel.setText("high school level");
			lblHighSchoolLevel.setHorizontalAlignment(SwingConstants.LEFT);
			lblHighSchoolLevel.setBounds(10, 221, 140, 23);
			jPanelReaderSpeed.add(lblHighSchoolLevel);

			JRadioButton rdbtnNewRadioButton = new JRadioButton(
					"Fast Reader\r\n");
			rdbtnNewRadioButton.setBounds(10, 251, 109, 23);
			jPanelReaderSpeed.add(rdbtnNewRadioButton);

			rdbtnNewRadioButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					UserServicesDelegate.doUpdateReadingSpeed(
							authentifiedUser.getUserId(), 1000);
					jPanelReaderSpeed.removeAll();
					jPanelReaderSpeed.updateUI();
					lblSpeed = new JLabel();
					System.out.println(authentifiedUser);
					lblSpeed.setText("1000 Words/Min");
					lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
					lblSpeed.setBounds(10, 34, 144, 270);
					jPanelReaderSpeed.add(lblSpeed);
				}
			});

			lblTrainedToFast = new JLabel();
			lblTrainedToFast.setText("trained to fast reading\r\n");
			lblTrainedToFast.setHorizontalAlignment(SwingConstants.LEFT);
			lblTrainedToFast.setBounds(6, 281, 148, 23);
			jPanelReaderSpeed.add(lblTrainedToFast);

			lblPleaseSelectYour = new JLabel();
			lblPleaseSelectYour.setText("Please select your speed\r\n");
			lblPleaseSelectYour.setHorizontalAlignment(SwingConstants.LEFT);
			lblPleaseSelectYour.setBounds(6, 34, 144, 23);
			jPanelReaderSpeed.add(lblPleaseSelectYour);

		} else {
			lblSpeed = new JLabel();
			lblSpeed.setText(authentifiedUser.getNbOfWordsPerMinute()
					+ " Words/Min");
			lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpeed.setBounds(10, 34, 144, 270);
			jPanelReaderSpeed.add(lblSpeed);
		}

	}

	private void descriptionTextActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {

		jTable1.setModel(new EbookTableModel(searchText.getText()));

	}

	// Variables declaration - do not modify
	private javax.swing.JButton SearchBtn;
	// private com.toedter.calendar.JDateChooser datexyzz;
	private javax.swing.JTextField searchText;
	private javax.swing.JLabel DescriptionTextSearch;
	private javax.swing.JPanel jPanelSearch;
	private javax.swing.JPanel jPannelLibrary;
	private javax.swing.JPanel jPanelOptions;
	private javax.swing.JScrollPane jScrollLibrary;
	private javax.swing.JTable jTable1;
	private javax.swing.JButton DownloadBtn;
	private JPanel jPanelReaderSpeed;
	private JLabel lblTrainedToFast;
	private JLabel lblPleaseSelectYour;
	private JLabel lblSpeed;
	private JLabel lblShowBooksDepending;
	private JButton buttonRefresh;
}
