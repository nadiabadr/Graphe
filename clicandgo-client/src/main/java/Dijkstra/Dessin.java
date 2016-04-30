package Dijkstra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import entities.Station;
import BusinessDelegator.SessionDelegate;
import BusinessDelegator.StationLineManagementDelegate;

public class Dessin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dessin frame = new Dessin();
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
	public Dessin() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setBounds(673, 331, 89, 23);
		contentPane.add(btnDraw);
		setBackground(Color.white);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/images/réseaubusdugrandtunis.png"));
		
		lblNewLabel.setBounds(100, 100, 505, 505);
		contentPane.add(lblNewLabel);
		
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Mapy mapy=new Mapy();
			 contentPane.add(mapy);
			 
			 mapy.setBounds(150,150,500,500);
			
			
			}
		});
		
	}
}
