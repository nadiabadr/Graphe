package guiContentManager;

import gui.Authentification;
import gui.TravelerGI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import BusinessDelegator.SessionDelegate;

public class ContentManagerGui extends JFrame {

	private javax.swing.JPanel bodyPanel;
	// private JPanel meanOfTransportPanel;
	// private JPanel stationPanel;
	private javax.swing.JButton ItineraryBtn;
	private JButton btnMeanoftransport;
	private javax.swing.JButton logoutBtn;
	public static javax.swing.JPanel panelContent;
	private javax.swing.JPanel panelGeneral;
	private javax.swing.JPanel panelMenu;
	private JButton btnNewButton;
	UserPanel userpanel = new UserPanel();
	LinePanel linepanel = new LinePanel();
	MeanOfTransportPanel meanOfTransportPanel = new MeanOfTransportPanel();
	StationPanel stationPanel = new StationPanel();
	/**
 * 
 */
	private static final long serialVersionUID = 1L;
	// private JFrame frame;
	Authentification authentification = new Authentification();
	private JLabel label;
	private JLabel lblMan;

	/**
	 * Create the application.
	 */
	public ContentManagerGui() {
		this.setBounds(180, 20, 30, 30);
		initComponents();
		setResizable(false);
	}

	private void initComponents() {
		setTitle("Content Manager Interface");
		panelGeneral = new javax.swing.JPanel();
		bodyPanel = new javax.swing.JPanel();
		panelMenu = new javax.swing.JPanel();
		ItineraryBtn = new javax.swing.JButton();
		logoutBtn = new javax.swing.JButton();
		btnMeanoftransport = new JButton();

		logoutBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panelContent = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.CardLayout());

		panelMenu.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(102, 0, 0)));

		ItineraryBtn.setText("Station & Line");
		ItineraryBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				StationLineBtnActionPerformed(evt);
			}
		});

		logoutBtn.setText("Logout");

		btnMeanoftransport.setText("MeanOfTransport");
		btnMeanoftransport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMeanoftransportActionPerformed(e);
			}
		});

		JButton btnLine = new JButton();
		btnLine.setText("Line");
		btnLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LineBtnActionPerformed(e);

			}
		});

		JButton btnUser = new JButton();
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContent.removeAll();
				panelContent.add(userpanel);
				panelContent.repaint();
				panelContent.revalidate(); // TODO add your handling code here:
			}// GEN-LAST:event_gestionCategorieBtnActionPerformed

		});
		btnUser.setText("User");

		javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(
				panelMenu);
		panelMenuLayout
				.setHorizontalGroup(panelMenuLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								panelMenuLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panelMenuLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																panelMenuLayout
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				ItineraryBtn,
																				GroupLayout.DEFAULT_SIZE,
																				137,
																				Short.MAX_VALUE)
																		.addComponent(
																				logoutBtn,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																btnMeanoftransport,
																GroupLayout.PREFERRED_SIZE,
																137,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnLine,
																GroupLayout.PREFERRED_SIZE,
																137,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnUser,
																GroupLayout.PREFERRED_SIZE,
																137,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(43, Short.MAX_VALUE)));
		panelMenuLayout.setVerticalGroup(panelMenuLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				panelMenuLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(ItineraryBtn, GroupLayout.PREFERRED_SIZE,
								66, GroupLayout.PREFERRED_SIZE)
						.addGap(34)
						.addComponent(btnMeanoftransport,
								GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE)
						.addGap(35)
						.addComponent(btnLine, GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE)
						.addGap(38)
						.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 174,
								Short.MAX_VALUE)
						.addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE,
								46, GroupLayout.PREFERRED_SIZE).addGap(19)));
		panelMenu.setLayout(panelMenuLayout);

		panelContent.setBackground(new java.awt.Color(255, 255, 255));
		panelContent.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(102, 0, 0)));
		panelContent.setLayout(new java.awt.CardLayout());

		label = new JLabel();
		label.setText("Hi, " + SessionDelegate.doGetLogin());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.BOLD, 16));

		javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(
				bodyPanel);
		bodyPanelLayout.setHorizontalGroup(bodyPanelLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				bodyPanelLayout
						.createSequentialGroup()
						.addGap(4)
						.addGroup(
								bodyPanelLayout
										.createParallelGroup(Alignment.LEADING,
												false)
										.addComponent(label,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(panelMenu,
												GroupLayout.DEFAULT_SIZE, 162,
												Short.MAX_VALUE))
						.addGap(18)
						.addComponent(panelContent, GroupLayout.DEFAULT_SIZE,
								780, Short.MAX_VALUE).addContainerGap()));
		bodyPanelLayout
				.setVerticalGroup(bodyPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								bodyPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												bodyPanelLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																bodyPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				label,
																				GroupLayout.DEFAULT_SIZE,
																				92,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				panelMenu,
																				GroupLayout.PREFERRED_SIZE,
																				520,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																panelContent,
																GroupLayout.DEFAULT_SIZE,
																623,
																Short.MAX_VALUE))
										.addContainerGap()));

		lblMan = new JLabel("");
		lblMan.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/man.jpg")));
		lblMan.setText("");
		panelContent.add(lblMan, "name_255224931389993");

		bodyPanel.setLayout(bodyPanelLayout);

		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));

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

	private void LineBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gestionFournisseursBtnActionPerformed
		panelContent.removeAll();
		panelContent.add(linepanel);
		panelContent.repaint();
		panelContent.revalidate();
	}

	private void StationLineBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gestionFournisseursBtnActionPerformed
		panelContent.removeAll();
		panelContent.add(stationPanel);
		panelContent.repaint();
		panelContent.revalidate(); // TODO add your handling code here:
	}// GEN-LAST:event_gestionFournisseursBtnActionPerformed

	private void btnMeanoftransportActionPerformed(ActionEvent e) {// GEN-FIRST:event_gestionFournisseursBtnActionPerformed
		panelContent.removeAll();
		panelContent.add(meanOfTransportPanel);
		panelContent.repaint();
		panelContent.revalidate(); // TODO add your handling code here:
	}// GEN-LAST:event_gestionFournisseursBtnActionPerformed

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
				new ContentManagerGui().setVisible(true);
			}
		});

	}
}