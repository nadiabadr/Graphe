package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import BusinessDelegator.ReadingManagementDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the application.
	 */
	public testp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel j = new JPanel();
		j.setBounds(0, 0, 424, 57);
		frame.getContentPane().add(j);
		j.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadingManagementDelegate.doViewLibrary();
			}
		});
		btnNewButton.setBounds(297, 23, 89, 23);
		j.add(btnNewButton);
	}
}
