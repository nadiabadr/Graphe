package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import BusinessDelegator.SessionDelegate;
import Dijkstra.Mapy;

public class TravelerGI extends JFrame {

	// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JPanel bodyPanel;
	private javax.swing.JButton logoutBtn;
	public static javax.swing.JPanel panelContent;
	private javax.swing.JPanel panelGeneral;
	private javax.swing.JPanel panelMenu;
	private JPanel TimeTablePanel;

	private JButton btnNewButton;
	private JButton itineraryBtn;
	// private JButton mapBtn_1;
	private JButton mapBtn;
	private JButton mapBtn_1;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JFrame frame;
	// Authentification authentification = new Authentification();
	ReadingPanel readingPanel = new ReadingPanel();
	TicketingPanel ticketingPanel = new TicketingPanel();
	NavigationPanel navigationPanel = new NavigationPanel();
	TimeTablePanel timeTablePanel = new TimeTablePanel();

	private JLabel lblbackk;

	Mapy MapPanel = new Mapy();

	// MapyInitial MapPanelInitial = new MapyInitial();

	/**
	 * Create the application.
	 */
	public TravelerGI() {
		this.setBounds(180, 20, 30, 30);
		initComponents();
		setResizable(false);
	}

	private void initComponents() {
		setTitle("Traveler Interface");
		panelGeneral = new javax.swing.JPanel();
		bodyPanel = new javax.swing.JPanel();
		panelMenu = new javax.swing.JPanel();

		mapBtn = new JButton();
		mapBtn.setText("See On Map");
		mapBtn.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// if((SessionDelegate.doGetDeparture()==null)&&(SessionDelegate.doGetArrival()==null))
				// seeOnmap2BtnActionPerformed(e);
				seeOnmapBtnActionPerformed(e);
			}
		});

		logoutBtn = new javax.swing.JButton();
		logoutBtn.setText("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SessionDelegate.doExit();
				System.out.println("ena deconnectit: session login "
						+ SessionDelegate.doGetLogin() + " Session Pwd "
						+ SessionDelegate.doGetPwd());
			}
		});

		panelContent = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.CardLayout());

		panelMenu.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(102, 0, 0)));

		// readingBtn.setText("Reading    ");
		// readingBtn.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// readingBtnActionPerformed(evt);
		// }
		// });

		// ticketingBtn.setText("Ticketing  ");
		// ticketingBtn.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// ticketingBtnActionPerformed(evt);
		// }
		// });

		itineraryBtn = new JButton();
		itineraryBtn.setIcon(new ImageIcon(TravelerGI.class
				.getResource("/images/er.png")));
		itineraryBtn.setForeground(new Color(255, 102, 51));
		itineraryBtn.setFont(new Font("DialogInput", Font.BOLD, 16));
		itineraryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContent.removeAll();
				panelContent.add(navigationPanel);
				panelContent.repaint();
				panelContent.revalidate();

			}
		});
		itineraryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelContent.removeAll();
				panelContent.add(navigationPanel);
				panelContent.repaint();
				panelContent.revalidate();
			}
		});
		itineraryBtn.setText("Itinerary  ");

		mapBtn_1 = new JButton();
		mapBtn_1.setIcon(new ImageIcon(TravelerGI.class
				.getResource("/images/Apps-Google-Maps-icon.png")));
		mapBtn_1.setForeground(new Color(0, 0, 102));
		mapBtn_1.setFont(new Font("DialogInput", Font.BOLD, 16));
		mapBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				seeOnmapBtnActionPerformed(e);

			}
		});
		mapBtn_1.setText("See Map    ");

		JLabel lblUSER = new JLabel();

		lblUSER.setHorizontalAlignment(SwingConstants.CENTER);
		lblUSER.setText("Hi, " + SessionDelegate.doGetLogin());
		lblUSER.setFont(new Font("Arial Black", Font.BOLD, 16));

		javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(
				panelMenu);
		panelMenuLayout
				.setHorizontalGroup(panelMenuLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								panelMenuLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panelMenuLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																logoutBtn,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																201,
																Short.MAX_VALUE)
														.addComponent(
																lblUSER,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																201,
																Short.MAX_VALUE)
														.addComponent(
																itineraryBtn,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																201,
																Short.MAX_VALUE)
														.addComponent(
																mapBtn_1,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		panelMenuLayout.setVerticalGroup(panelMenuLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				panelMenuLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblUSER, GroupLayout.PREFERRED_SIZE, 50,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(itineraryBtn, GroupLayout.PREFERRED_SIZE,
								62, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mapBtn_1, GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 427,
								Short.MAX_VALUE)
						.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE,
								38, GroupLayout.PREFERRED_SIZE).addGap(24)));
		panelMenu.setLayout(panelMenuLayout);

		panelContent.setBackground(new java.awt.Color(255, 255, 255));
		panelContent.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(102, 0, 0)));
		panelContent.setLayout(new java.awt.CardLayout());

		javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(
				bodyPanel);
		bodyPanelLayout.setHorizontalGroup(bodyPanelLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				bodyPanelLayout
						.createSequentialGroup()
						.addGap(4)
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panelContent, GroupLayout.DEFAULT_SIZE,
								780, Short.MAX_VALUE).addGap(18)));
		bodyPanelLayout
				.setVerticalGroup(bodyPanelLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								bodyPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												bodyPanelLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panelContent,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																682,
																Short.MAX_VALUE)
														.addComponent(
																panelMenu,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																682,
																Short.MAX_VALUE))
										.addContainerGap()));

		lblbackk = new JLabel("");
		lblbackk.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/traffic.jpeg")));
		lblbackk.setText("");
		panelContent.add(lblbackk, "name_253067401558896");

		bodyPanel.setLayout(bodyPanelLayout);

		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		// btnNewButton.setIcon(new ImageIcon(
		// "C:\\Users\\Mourad\\Desktop\\PI\\logofinal.png"));
		// panelContent.add(btnNewButton, "name_551560228642910");

		javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(
				panelGeneral);
		panelGeneral.setLayout(panelGeneralLayout);
		panelGeneralLayout.setHorizontalGroup(panelGeneralLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		panelGeneralLayout.setVerticalGroup(panelGeneralLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		getContentPane().add(panelGeneral, "card2");

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void readingBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gestionFournisseursBtnActionPerformed
		panelContent.removeAll();
		panelContent.add(readingPanel);
		panelContent.repaint();
		panelContent.revalidate(); // TODO add your handling code here:
	}// GEN-LAST:event_gestionFournisseursBtnActionPerformed

	private void ticketingBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gestionCategorieBtnActionPerformed
		panelContent.removeAll();
		panelContent.add(ticketingPanel);
		panelContent.repaint();
		panelContent.revalidate(); // TODO add your handling code here:
	}// GEN-LAST:event_gestionCategorieBtnActionPerformed

	public void seeOnmapBtnActionPerformed(ActionEvent e) {// GEN-FIRST:event_gestionCategorieBtnActionPerformed
		panelContent.removeAll();
		panelContent.add(MapPanel);
		panelContent.repaint();
		panelContent.revalidate(); // TODO add your handling code here:
	}// GEN-LAST:event_gestionCategorieBtnActionPerformed

	// public void seeOnmap2BtnActionPerformed(ActionEvent e) {//
	// GEN-FIRST:event_gestionCategorieBtnActionPerformed
	// panelContent.removeAll();
	// panelContent.add(MapPanelInitial);
	// panelContent.repaint();
	// panelContent.revalidate(); // TODO add your handling code here:
	// }
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TravelerGI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TravelerGI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TravelerGI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TravelerGI.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TravelerGI().setVisible(true);
			}
		});

	}
}
