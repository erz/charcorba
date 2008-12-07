package by_mr19cm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMenuBarreMenu.this.client.getContacts();
			}
		});
		JMenuItem itemDeconnexion = new JMenuItem("Déconnexion");
		
		menuConnexion.add(itemConnexion);
		menuConnexion.add(itemDeconnexion);
		
		this.add(menuConnexion);
	}

}
