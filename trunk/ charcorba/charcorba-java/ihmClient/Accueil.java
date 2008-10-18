package ihmClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Accueil implements ActionListener{
	
	public String listePersonnesConnectees;
	public String identifiant;
	public String tags;
	
	public void getListePersonnesConnectees(){
		
	}
	
	public void envoyerMessage(String m){
		
	}
	
	public void getPersonnesTags(String tags){
		
	}
	
	public Accueil(){
		super();
		JFrame accueil = new JFrame("Accueil Chat");
		JMenuBar Menu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem item;
		menu.add(item = new JMenuItem("Nouvelle conversation"));
		item.addActionListener(this);
		menu.add(item = new JMenuItem("Quitter application"));
		item.addActionListener(this);
		Menu.add(menu);
		accueil.setJMenuBar (Menu);
		accueil.setSize(400, 500);
		accueil.setVisible(true);
	}
	
	public static void main(String[] args){
		Accueil objet = new Accueil();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println (e.getActionCommand());
		
	}
}
