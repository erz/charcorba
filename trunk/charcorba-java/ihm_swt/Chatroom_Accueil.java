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

import tableau_blanc.Tableau_swt;

import Client.Client;

public class Chatroom_Accueil 
{
	static public Chatroom_Accueil singleton_ihm;
	
	public HashMap<String,Chatroom_Fenetre> liste_chatrooms_fenetres;
	public HashMap<String,Tableau_swt> liste_tableaublanc_fenetres;
	
	public List listeAmis;

	public Label pseudo;

	Display display;
	
	Shell shell;
	
	public Chatroom_Accueil()
	{
		singleton_ihm = this;
		liste_chatrooms_fenetres = new HashMap<String,Chatroom_Fenetre>();
		liste_tableaublanc_fenetres = new HashMap<String, Tableau_swt>();
		
		display = new Display();

	    shell = new Shell(display);
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
	    
	    pseudo = new Label(shell, SWT.CENTER);
	    pseudo.setBounds(130, 5, 140, 50);
	    pseudo.setVisible(false);
	    
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
	    
	    final Text tagRecherche = new Text(groupAmis, SWT.BORDER);
	    tagRecherche.setBounds(10, 20, 130, 30); 
	    tagRecherche.setText("tag");
	    
	    Button rechercherTag = new Button(groupAmis, SWT.NONE);
	    rechercherTag.setBounds(145, 20, 130, 30);
	    rechercherTag.setText("&Rechercher par tag");
	    
	    listeAmis = new List(groupAmis, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
	    listeAmis.setBounds(10, 60, 260, 180);
		
	    groupAmis.setText("Amis");
	    groupAmis.setBounds(5, 90, 280, 250);
	    
	    groupAmis.setVisible(false);
	    
	    creation.addListener(SWT.MouseDown, new Listener() 
	    {
	    	public void handleEvent(Event e)
	    	{
	    		shell.setVisible(false); 
	    		new Chatroom_profil();
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
					singleton_ihm.ajouterChatroom(nomChatroom.getText());
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
				
				/*/A COMMENTER SI EXCEPTION A FERMETURE TABLEAU ET FENETRE
				try {
					singleton_ihm.ajouterTableau(nomChatroom.getText());
				} catch (InvalidName e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ServantAlreadyActive e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (WrongPolicy e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (CannotProceed e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NotFound e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ServantNotActive e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
				
				//On invite a la chatroom les amis selectionnés
				for(int i = 0; i < listeAmis.getSelection().length; ++i)
				{
					try {
						Client.singleton_client.inviter_client_chatroom((listeAmis.getSelection())[i], nomChatroom.getText());
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
				}
				
				//On invite au tableau blanc les amis sélectionnés
				/*for(int j = 0; j< listeAmis.getSelection().length; ++j)
				{
					try {
						Client.singleton_client.inviter_client_tableaublanc((listeAmis.getSelection())[j], nomChatroom.getText());
					} catch (NotFound e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CannotProceed e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvalidName e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}*/
				
	        }
	      });
	    
	    rechercherTag.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) 
	        {
	        	Client.singleton_client.get_amis_par_tag(tagRecherche.getText());
	        }
	      });
	    
	    quitter.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) 
	        {
	        	//Client.singleton_client.signal_invitation_chatroom("Chatroom1");
	        	//shell.close();
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
	
	public void ajouterTableau(String nom_tableau) throws InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive
	{
		liste_tableaublanc_fenetres.put(nom_tableau, new Tableau_swt(display));
		Client.singleton_client.creer_tableau_blanc(nom_tableau);
	}
	/*
	public static void main(String[] args) 
	{
		   new Chatroom_Accueil();
	}*/


	public void ajouterChatroom_Distante(final String chatroom) 
	{
		display.syncExec(new Runnable() 
		{
			   public void run() 
			   {
				   liste_chatrooms_fenetres.put(chatroom, new Chatroom_Fenetre(chatroom));
			   }
			});
		
	}

}
