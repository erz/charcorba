package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Client.Client;

@SuppressWarnings("serial")
public class JMenuBarreMenu extends JMenuBar 
{
	
	private JFrameClient frame_client;
	
	public JMenuBarreMenu(JFrameClient client)
	{
		this.frame_client = client;
		
		JMenu menuConnexion = new JMenu("Connexion");
		
		JMenuItem itemConnexion = new JMenuItem("Lancer");
		itemConnexion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Connection à l'ORB
				////////////Client.singleton_client.demarrer();
				
				
			}
		});
		JMenuItem itemDeconnexion = new JMenuItem("Quitter");
		itemDeconnexion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				///////////Client.singleton_client.arreter();
				frame_client.dispose();
			}
		});
		
		menuConnexion.add(itemConnexion);
		menuConnexion.add(itemDeconnexion);
		
		this.add(menuConnexion);
		
		//Affichage des contacts selon leur tags
		JMenu menuTags = new JMenu("Tags");
		this.add(menuTags);
		
	}

}

