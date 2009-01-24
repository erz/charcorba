package Client;

import ihm_swt.Chatroom_Accueil;
import ihm_swt.Chatroom_Fenetre;


import java.util.ArrayList;
import java.util.HashMap;

/*import org.jacorb.orb.ORB;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.DoubleHolder;
import org.omg.CORBA.ShortHolder;
import org.omg.CORBA.StringHolder;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
*/
import orb_pkge.COrb;


import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import chatroom.Chatroom;
import chatroom.Chatroom_impl;
import chatroom.Message;

import annuaire.Annuaire;
import annuaire.AnnuaireHelper;
import IHM.JFrameClient;


public class Client
{
	///////////////////////////
	//	ATTRIBUTS
	///////////////////////////
	
	//Notre client
	public static Client singleton_client;
	
	//Gestion des messages entrants
	Standard_impl m_standard;
	
	//Annuaire
	Annuaire m_service_annuaire ;
	
	//Pseudo
	String m_pseudo;
	
	//Listes
	ArrayList<String> liste_amis = new ArrayList<String>();
	ArrayList<String> liste_tags = new ArrayList<String>();
	
	//Chatrooms
	HashMap<String,Chatroom_impl> m_liste_chatrooms_locales;  
	HashMap<String,Chatroom> m_liste_chatrooms_distantes;
	
	//Constructeur
	Client(String[] args) throws InvalidName, AdapterInactive
	{
		//Création de l'ORB
		new COrb(args);

		m_pseudo = "Anonymous";
		m_standard = new Standard_impl();
		
		m_liste_chatrooms_locales = new HashMap<String,Chatroom_impl> ();  
		m_liste_chatrooms_distantes = new HashMap<String,Chatroom> ();
		
		singleton_client = this;
	}
	
	//Modifier son pseudonyme
	public void set_pseudo(String pseudo) throws org.omg.CosNaming.NamingContextPackage.InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive
	{
		m_pseudo = pseudo ; 
		COrb.static_orb.ajout_service(m_standard, pseudo);
	}
	
	//Joindre l'annuaire
	public void joindre_annuaire() throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName
	{
		System.out.println("Connexion a l'annuaire");
		Object service = COrb.static_orb.connecter_service("Annuaire");
	  	
		m_service_annuaire = AnnuaireHelper.narrow(service) ;
	  	m_service_annuaire.joindre_annuaire(m_pseudo);
	}
	
	//Ajout d'un Tag
	public void ajouter_tag(String tag)
	{
		m_service_annuaire.ajouter_tag(m_pseudo,tag);
		liste_tags.add(tag);  
	}
	
	//Enlever un Tag
	public void enlever_tag(String tag)
	{
		liste_tags.remove(tag);
	}
	  
	//Obtenir liste d'amis par tag
	public void get_amis_par_tag(String tag)
	{
		String[] retval = m_service_annuaire.get_amis_par_tag(tag) ;
		
		for (int i=0;i< retval.length;++i)
		{
			String ami = retval[i] ;
			if (ami != m_pseudo) 
			{
				ajouter_ami(ami);
			}
		}  
	}
	
	//Ajouter un ami
	public void ajouter_ami(String ami)
	{
		liste_amis.add(ami); 
		signal_ajout_ami(ami);
	}
	  
	// Afficher simplement un message chez le client
	public void afficher_message (String pseudo_client, String message) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName 
	{
		  Object service_distant = COrb.static_orb.connecter_service(pseudo_client);
		  Standard standard_distant = StandardHelper.narrow(service_distant);
		  standard_distant.afficher_message(m_pseudo, message);
	}

	//Demarrer le client et l'ORB
	public void demarrer ()
	{
		//Demarrage de l'ORB
		COrb.static_orb.demarrer();
	}
	
	//Arreter tout
	public void arreter ()
	{
		COrb.static_orb.arreter();
	}
	
	//Creer une Chatroom
	public void creer_chatroom(String nom_chatroom) throws org.omg.CosNaming.NamingContextPackage.InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive
	{
		Chatroom_impl chatroom =  new Chatroom_impl(nom_chatroom);
		m_liste_chatrooms_locales.put(nom_chatroom, chatroom);
		COrb.static_orb.ajout_service(chatroom, nom_chatroom);
	}
	
	// Invite le client à participer à une chatroom
	public void inviter_client_chatroom (String pseudo,String nom_chatroom) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName 
	{
		m_liste_chatrooms_locales.get(nom_chatroom).inviter_client(pseudo);
	}
	  
	//ajouter un message
	public void ajouter_message(String nom_chatroom,String message)
	{
		if (m_liste_chatrooms_distantes.get(nom_chatroom) != null)
		{
			//System.out.println("hop");
			m_liste_chatrooms_distantes.get(nom_chatroom).ajouter_message(m_pseudo, message);
		}
		else
		{
			//System.out.println("hip");
			m_liste_chatrooms_locales.get(nom_chatroom).ajouter_message(m_pseudo, message);
		}
	}
	
	/////////////
	// SIGNAUX
	/////////////

	public void signal_ajout_ami(String ami)
	{
		//IHM : Ajouter ami
	}
	
	public void message_recu(String pseudo, String message)
	{
		//IHM : Ecrire le message recu
		System.out.println("Message de "+pseudo+" : "+message);
	}

	public void signal_invitation_chatroom(String chatroom)
	{
		//IHM ouvrir la chatroom
		Chatroom_Accueil.singleton_ihm.liste_chatrooms_fenetres.put(chatroom, new Chatroom_Fenetre(chatroom));
	}

	public void signal_chatroom(String chatroom, int idmess)
	{
		//IHM : recuperer le message et l'afficher
		Message mess = singleton_client.get_message(chatroom, idmess);
		Chatroom_Accueil.singleton_ihm.liste_chatrooms_fenetres.get(chatroom).ecrireMessage(mess.auteur, mess.message);
	}
	
	//Recuperer un message
	Message get_message (String nom_chatroom, int idmessage)
	{
		String [] retval;
		if (m_liste_chatrooms_distantes.get(nom_chatroom) != null)
			retval = m_liste_chatrooms_distantes.get(nom_chatroom).get_message(idmessage) ;
		else
			retval = m_liste_chatrooms_locales.get(nom_chatroom).get_message(idmessage) ;
		
		String auteur = retval[0] ;
		String message = retval[1] ;

		Message msg = new Message();
		msg.auteur = auteur;
		msg.message = message;
		return msg ;
	}
	
	  
	////////////////
	/////  MAIN  
	///////////////
	public static void main(String args[]) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, AdapterInactive, ServantAlreadyActive, WrongPolicy, InterruptedException, ServantNotActive
	{

		  //Création et demarrage du client 
		  new Client(args);//).demarrer();
		  new Chatroom_Accueil();
		  new Chatroom_Accueil();
		  
		  //////////////////////////////
		  ///	AUTOTEST (lol)
		  /////////////////////////////
		  /*
		  singleton_client.set_pseudo("Aurelien");
		  singleton_client.joindre_annuaire();
		  
		  singleton_client.ajouter_tag("Pedophile");
		  singleton_client.ajouter_tag("Asiatiques");
		  singleton_client.ajouter_tag("Fetching");
		  

		  singleton_client.creer_chatroom("Roomtest");
		  singleton_client.ajouter_message("Roomtest", "Boooonjooour");

	 
		  singleton_client.afficher_message("Aurelien", "SALUT");
		  

		  Message msg = singleton_client.get_message("Roomtest", 0);

		  
		  System.out.println("Message de "+msg.auteur+" : "+msg.message);
		
		  //new Chatroom_Fenetre(new Chatroom_impl("HOP"));
		   */
		  
		  Thread.sleep(1000);

		//while(true);

	}		
}


