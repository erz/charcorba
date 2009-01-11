package by_mr19cm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class JMenuBarreMenu extends JMenuBar {
	
	private JFrameClient client;
	
	public JMenuBarreMenu(JFrameClient client)
	{
		this.client = client;
		
		JMenu menuConnexion = new JMenu("Connexion");
		JMenuItem itemConnexion = new JMenuItem("Connexion");
		itemConnexion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				JMenuBarreMenu.this.client.getContacts();
			}
		});
		JMenuItem itemDeconnexion = new JMenuItem("Deconnexion");
		
		menuConnexion.add(itemConnexion);
		menuConnexion.add(itemDeconnexion);
		
		this.add(menuConnexion);
		
		//Affichage des contacts selon leur tags
		JMenu menuTags = new JMenu("Tags");
		for(int i = 0; i < JMenuBarreMenu.this.client.getListeContacts().length;++i)
		{
			for (int j = 0; j < JMenuBarreMenu.this.client.getListeContacts()[i].getTags().size(); ++j)
			{
				menuTags.add(new JCheckBox(JMenuBarreMenu.this.client.getListeContacts()[i].getTags().get(j)));
			}
		}
		this.add(menuTags);
		
	}

}
