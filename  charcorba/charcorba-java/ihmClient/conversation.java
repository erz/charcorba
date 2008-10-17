package ihmClient;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class conversation extends JFrame implements ActionListener{
	
	public conversation(){
		JFrame salon = new JFrame("Salon de discussion");
		JPanel panel = new JPanel();
		JMenuBar Menu1 = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		JMenuItem item1;
		salon.setLayout(null);
		JTextArea afficherMessage = new JTextArea();
		JTextArea entrerMessage = new JTextArea();
		JButton envoyer = new JButton("Envoyer");
		menu1.add(item1 = new JMenuItem("Nouvelle conversation"));
		item1.addActionListener(this);
		menu1.add(item1 = new JMenuItem("Quitter application"));
		item1.addActionListener(this);
		Menu1.add(menu1);
		salon.setJMenuBar (Menu1);
		salon.add(afficherMessage);
		afficherMessage.setBounds(0,0, 600, 500);
		salon.add(entrerMessage);
		entrerMessage.setBounds(0, 510, 500, 150);
		salon.add(envoyer);
		envoyer.setBounds(500, 550, 85, 45);
		salon.pack();
		salon.setSize(700, 700);
		salon.setVisible(true);
		
		salon.add(panel);
		panel.setBounds(0, 0, 700, 700);
		panel.setBackground(Color.ORANGE);
	}
	
	public void actionPerformed(ActionEvent e) {
	}	
	
}



