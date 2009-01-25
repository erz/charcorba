package ihm_swt;

import java.util.HashMap;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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
	
	public List listeAmis;


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
	   

	    final Button creation = new Button(shell, SWT.CENTER);
	    creation.setBounds(75, 50, 150, 30);
	    creation.setText("&Créez votre profil");

	    // Interface une fois connecté :
	    final Group groupChatRoom = new Group(shell, SWT.NONE);
	    
		final Text nomChatroom = new Text(groupChatRoom, SWT.BORDER);
		nomChatroom.setBounds(10, 20, 160, 30); 
		nomChatroom.setText("Chatroom1");
		   
	    final Button creerChatroom = new Button(groupChatRoom, SWT.NONE);
	    creerChatroom.setBounds(200, 20, 70, 30);
	    creerChatroom.setText("&Créer");

	    groupChatRoom.setText("Créer une chatroom");
	    groupChatRoom.setBounds(5, 18, 280, 70);
	    
	    groupChatRoom.setVisible(false);
	    
	    final Group groupAmis = new Group(shell, SWT.NONE);
	    
	    Text tagRecherche = new Text(groupAmis, SWT.BORDER);
	    tagRecherche.setBounds(10, 20, 130, 30); 
	    tagRecherche.setText("tag");
	    
	    Button rechercherTag = new Button(groupAmis, SWT.NONE);
	    rechercherTag.setBounds(145, 20, 130, 30);
	    rechercherTag.setText("&Rechercher par tag");
	    
	    listeAmis = new List(groupAmis, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	    listeAmis.setBounds(10, 60, 260, 180);
		
	    groupAmis.setText("Amis");
	    groupAmis.setBounds(5, 90, 280, 250);
	    
	    groupAmis.setVisible(false);
	    
	    creation.addListener(SWT.MouseDown, new Listener() 
	    {
	    	public void handleEvent(Event e)
	    	{
	    		shell.setVisible(false); 
	    		new Chatroom_profil(display);
	    		shell.setVisible(true); 
	    		creation.setVisible(false);
	    		groupAmis.setVisible(true);
	    		groupChatRoom.setVisible(true);
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
	    
	    rechercherTag.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) 
	        {
	        	//Client.sin
	        }
	      });
	    
	    quitter.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) 
	        {
	        	
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
	    if (Client.singleton_client != null)
	    	Client.singleton_client.arreter();
	    display.dispose();
	    
  }
	

	public void ajouterChatroom(String nom_chatroom) throws InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive 
	{
		liste_chatrooms_fenetres.put(nom_chatroom, new Chatroom_Fenetre(nom_chatroom));
		Client.singleton_client.creer_chatroom(nom_chatroom);
	}
	
	
	public static void main(String[] args) 
	{
		   new Chatroom_Accueil();
	}

}
