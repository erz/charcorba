package ihm_swt;

import java.util.HashMap;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import Client.Client;

public class Chatroom_Accueil 
{
	static public Chatroom_Accueil singleton_ihm;
	
	public HashMap<String,Chatroom_Fenetre> liste_chatrooms_fenetres;


	static public Display display;
	
	public Chatroom_Accueil()
	{
		singleton_ihm = this;
		liste_chatrooms_fenetres = new HashMap<String,Chatroom_Fenetre>();
		
		display = new Display();

	    final Shell shell = new Shell(display);
	    shell.setText("CHARCORBA");
	    
	    Menu menuBar = new Menu(shell, SWT.BAR);
	    MenuItem menu = new MenuItem(menuBar, SWT.CASCADE);
	    menu.setText("Menu");
	
	    Menu sousMenu = new Menu(shell, SWT.DROP_DOWN);
	    menu.setMenu(sousMenu);
	
	    MenuItem quitter = new MenuItem(sousMenu, SWT.PUSH);
	    quitter.setText("Quitter");
	   
/*
	    final Button button = new Button(shell, SWT.CENTER);
	    button.setBounds(75, 50, 150, 30);
	    button.setText("&Connexion");
*/
	    final Button creation = new Button(shell, SWT.CENTER);
	    creation.setBounds(75, 50, 150, 30);
	    creation.setText("&Créez votre profil");


	    
	    final Button creerChatroom = new Button(shell, SWT.BOTTOM);
	    creerChatroom.setBounds(75, 100, 150, 30);
	    creerChatroom.setText("&Créer une chatroom");
	    creerChatroom.setVisible(false);
	    
	   /* 
	    button.addListener(SWT.Selection, new Listener() 
	    {
	        public void handleEvent(Event e) 
	        {
	        	Client.singleton_client.demarrer();
	        	
	        	try {
					Client.singleton_client.set_pseudo("Aurelien");
				} catch (InvalidName e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (ServantAlreadyActive e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (WrongPolicy e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (CannotProceed e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (NotFound e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (ServantNotActive e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				}
	        	try {
					Client.singleton_client.joindre_annuaire();
				} catch (NotFound e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (CannotProceed e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (InvalidName e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				}
				
				
				//Cacher le bouton connexion
				button.setVisible(false);
				creerChatroom.setVisible(true);
	        }
	    });
	    */
	    
	    creation.addListener(SWT.MouseDown, new Listener() 
	    {
	    	public void handleEvent(Event e)
	    	{
	    		shell.setVisible(false); 
	    		new Chatroom_profil(display);
	    		shell.setVisible(true); 
	    		creation.setVisible(false);
	    		creerChatroom.setVisible(true);
	    	}
	    });
	    
	    creerChatroom.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) 
	        {
				try {
					singleton_ihm.ajouterChatroom("Roomtest");
				} catch (InvalidName e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (ServantAlreadyActive e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (WrongPolicy e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (CannotProceed e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (NotFound e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				} catch (ServantNotActive e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				}
	        }
	      });
	    
	    quitter.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) 
	        {
	        	Client.singleton_client.arreter();
	        	shell.close();
	        }
	      });

	    
	    shell.setMenuBar(menuBar);
	    shell.pack();
	    shell.setSize(300, 400);
	    shell.open();
	    
	    
	    while (!shell.isDisposed())
	    {
	        if (!display.readAndDispatch())
	          display.sleep();
	    }   
	    display.dispose();
	    
  }
	


	public void ajouterChatroom(String nom_chatroom) throws InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive 
	{
		liste_chatrooms_fenetres.put(nom_chatroom, new Chatroom_Fenetre(nom_chatroom));
		Client.singleton_client.creer_chatroom(nom_chatroom);
	}

}
