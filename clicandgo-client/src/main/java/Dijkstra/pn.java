package Dijkstra;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class pn extends JPanel{
@Override 
	protected void paintComponent(Graphics g)
	{
	Graphics2D gr=(Graphics2D)g;
	
	gr.setColor(Color.red);
	
	gr.fillOval(10, 120,10,10);
	gr.fillOval(100,60,10,10);
	gr.fillOval(150,20,10,10);
	gr.fillOval(200, 60,10,10);
	gr.fillOval(280,10,10,10);
	
	gr.setColor(Color.black);
	gr.drawLine(15, 125, 105, 65);
	gr.drawLine(105, 65, 155, 25);
	gr.drawLine(155, 25, 205, 65);
	gr.drawLine(155, 25, 285, 15);
	
	}
	
}
