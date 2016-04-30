package Dijkstra;


import java.awt.Component;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import BusinessDelegator.SessionDelegate;
import BusinessDelegator.StationDelegate;
import BusinessDelegator.StationLineManagementDelegate;
import entities.Station;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Navigation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation frame = new Navigation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Navigation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(59, 73, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 73, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(46, 47, 69, 14);
		contentPane.add(lblDeparture);
		
		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(272, 48, 46, 14);
		contentPane.add(lblArrival);
		
		JButton btnVisualize = new JButton("Visualize");
		btnVisualize.setBounds(170, 122, 89, 23);
		contentPane.add(btnVisualize);
		
		textArea = new JTextArea();
		textArea.setBounds(26, 186, 373, 64);
		contentPane.add(textArea);
		textArea.setVisible(false);
		
//		textField_2 = new JTextField();
//		textField_2.setBounds(10, 166, 414, 84);
//		contentPane.add(textField_2);
//		textField_2.setColumns(10);
//		textField_2.setVisible(false);
		btnVisualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int N = Graphe.ALPHA_NOTDEF;
				int[][] matDuree =//StationLineManagementDelegate.doRemplirMatrice();
					{ 
						{ N ,5 ,N ,N ,N ,N ,N ,N ,N ,N ,N ,N  }, 
						{ 5 ,N ,4 ,N ,N ,N ,N ,N ,N ,N ,N ,N }, 
						{ N ,4 ,N ,2 ,N ,N ,N ,N ,N ,N ,N ,N   }, 
						{ N ,N ,2 ,N ,2 ,N ,N ,N ,N ,8 ,N ,N  }, 
						{ N ,N ,N ,2 ,N ,10 ,N ,N ,N ,N ,N ,15  }, 
						{ N ,N ,N ,N ,10 ,N ,5 ,N ,N ,N ,N ,N  }, 
						{ N ,N ,N ,N ,N ,5 ,N ,5 ,N ,N ,N ,N  }, 
						{ N ,N ,N ,N ,N ,N ,5,N ,7 ,N ,N ,N  }, 
						{ N ,N ,N ,N ,N ,N ,N ,7 ,N ,N ,N ,N  }, 
						{ N ,N ,N ,8 ,N ,N ,N ,N ,N ,N ,3 ,N }, 
						{ N ,N ,N ,N ,N ,N ,N ,N ,N ,3 ,N ,N  }, 
						{ N ,N ,N ,N ,15 ,N ,N ,N ,N ,N ,N ,N }, 

				};
			String depart=textField.getText();
			String arrival=textField_1.getText();
			Station stationdepart = StationDelegate
					.findStationByStationName(depart);
			Graphe g0 = new Graphe(matDuree);
			Dijkstra dij=new Dijkstra(stationdepart.getReference(), g0);
			dij.AfficherDestinationEtCout(depart,arrival);
//			SessionDelegate.doSetDeparture(depart);
//			SessionDelegate.doSetArrival(arrival);
			//textField_2.setVisible(true);
			//textField_2.setText(dij.AfficherDestinationEtCout(depart, arrival));
			textArea.setVisible(true);
			textArea.setText(dij.AfficherDestinationEtCout(depart, arrival));
			
			
			}
		});
		
		
		
		
	}
}
