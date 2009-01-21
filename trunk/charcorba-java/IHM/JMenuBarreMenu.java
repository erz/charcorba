package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class JMenuBarreMenu extends JMenuBar 
{
	
	private JFrameClient client;
	
	public JMenuBarreMenu(JFrameClient client)
	{
		this.client = client;
		
		JMenu menuConnexion = new JMenu("Connexion");
		JMenuItem itemConnexion = new JMenuItem("Connexion");
		JMenuItem itemDeconnexion = new JMenuItem("Deconnexion");
		
		menuConnexion.add(itemConnexion);
		menuConnexion.add(itemDeconnexion);
		
		this.add(menuConnexion);
		
		//Affichage des contacts selon leur tags
		JMenu menuTags = new JMenu("Tags");
		this.add(menuTags);
		
	}

}

