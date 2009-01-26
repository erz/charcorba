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

import tableau_blanc.Pixel;
import tableau_blanc.TableauBlanc;
import tableau_blanc.TableauBlanc_impl;
import tableau_blanc.s_pixel;

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
	public String m_pseudo;
	
	//Listes
	ArrayList<String> liste_amis = new ArrayList<String>();
	ArrayList<String> liste_tags = new ArrayList<String>();
	
	//Chatrooms
	HashMap<String,Chatroom_impl> m_liste_chatrooms_locales;  
	HashMap<String,Chatroom> m_liste_chatrooms_distantes;
	
	//Tableau blanc
	// Liste des tableaux blancs locaux
	HashMap<String,TableauBlanc_impl> m_liste_tableauxblancs_locaux ;
	HashMap<String,TableauBlanc> m_liste_tableauxblancs_distants ;
	
	//Constructeur
	Client(String[] args) throws InvalidName, AdapterInactive
	{
		//Création de l'ORB
		new COrb(args);

		m_pseudo = "Anonymous";
		m_standard = new Standard_impl();
		
		m_liste_chatrooms_locales = new HashMap<String,Chatroom_impl> ();  
		m_liste_chatrooms_distantes = new HashMap<String,Chatroom> ();
		
		m_liste_tableauxblancs_locaux = new HashMap<String,TableauBlanc_impl> ();
		m_liste_tableauxblancs_distants = new HashMap<String,TableauBlanc> ();
		
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
			if (ami.compareTo(m_pseudo) != 0) 
			{
				ajouter_ami(ami);
			}
		}  
	}
	
	//Ajouter un ami
	public void ajouter_ami(String ami)
	{
		boolean estDeja = false;
		for (int i = 0; i < liste_amis.size(); ++i)
		{
			if (liste_amis.get(i).compareTo(ami) == 0)
			{
				estDeja = true;
				break;
			}
				
		}
		
		if (estDeja == false)
		{
			liste_amis.add(ami); 
			signal_ajout_ami(ami);
		}
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
		//if (m_service_annuaire != null)
		//	m_service_annuaire.quitter_annuaire(m_pseudo);
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
			System.out.println("On envoie "+message+" Sur une chatroom distante");
			m_liste_chatrooms_distantes.get(nom_chatroom).ajouter_message(m_pseudo, message);
			Chatroom_Accueil.singleton_ihm.liste_chatrooms_fenetres.get(nom_chatroom).ecrireMessage(m_pseudo, message);
			
		}
		else
		{
			System.out.println("On envoie "+message+" Sur une chatroom locale");
			m_liste_chatrooms_locales.get(nom_chatroom).ajouter_message(m_pseudo, message);
		}
	}
	
	/////////////
	// SIGNAUX
	/////////////

	public void signal_ajout_ami(String ami)
	{
		//IHM : Ajouter ami
		Chatroom_Accueil.singleton_ihm.listeAmis.add(ami);
	}
	
	public void message_recu(String pseudo, String message)
	{
		//IHM : Ecrire le message recu
		System.out.println("Message de "+pseudo+" : "+message);
	}

	public void signal_invitation_chatroom(String chatroom)
	{
		//IHM ouvrir la chatroom
		Chatroom_Accueil.singleton_ihm.ajouterChatroom_Distante(chatroom);
	}

	public void signal_chatroom(String chatroom, int idmess)
	{
		//IHM : recuperer le message et l'afficher
		
		Message mess = singleton_client.get_message(chatroom, idmess-1);
		
		System.out.println("Affichage iminnent de "+mess.auteur+" : "+mess.message);
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
	
	//TABLEAU BLANC
	public void creer_tableau_blanc (String nom_tableau) throws org.omg.CosNaming.NamingContextPackage.InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive
	{
		TableauBlanc_impl tableau = new TableauBlanc_impl (nom_tableau);
		m_liste_tableauxblancs_locaux.put(nom_tableau, tableau);
		COrb.static_orb.ajout_service(tableau, nom_tableau);
		System.out.println("tableau blanc "+tableau.m_nom_tableau+ " créé.");
	}
	
	public void ajouter_pixel (String nom_tableau, tableau_blanc.s_pixel pix)
	{
		if (m_liste_tableauxblancs_distants.get(nom_tableau) != null)
		{
			System.out.println("On envoie un pixel "+pix.x+" "+pix.y+" sur un tableau distant");
			m_liste_tableauxblancs_distants.get(nom_tableau).ajouter_pixel(pix);
				
		}/*
		else
		{
			System.out.println("On envoie un pixel "+pix.x+" "+pix.y+" sur un tableau local");
			m_liste_tableauxblancs_locaux.get(nom_tableau).ajouter_pixel(pix);
		}*/
	}
	
	public void inviter_client_tableaublanc (String pseudo, String nom_tableau) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName
	{
		m_liste_tableauxblancs_locaux.get(nom_tableau).inviter_client(pseudo);
	}
	
	//A REVOIR
	/*Pixel get_pixel (String nom_tableau,unsigned idpixel)
	{
		short[]  pixel = m_liste_tableauxblancs_locaux.get(nom_tableau).get_pixel(idpixel) ;	
		return Pixel() ;
	}*/
	
	public void participer_tableau_blanc(String tableau) 
	{
		// TODO Auto-generated method stub
		try {
			Chatroom_Accueil.singleton_ihm.ajouterTableau_Distant(tableau);
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (ServantAlreadyActive e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (CannotProceed e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (ServantNotActive e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		
	}	

	//A REVOIR
	public void sync_tableau_blanc(String tableau, int idpixel) 
	{
		s_pixel pix = null;
		if (m_liste_tableauxblancs_distants.get(tableau) != null)
		{
			pix = m_liste_tableauxblancs_distants.get(tableau).get_pixel(idpixel-1);		
		}/*
		else
		{
			pix = m_liste_tableauxblancs_locaux.get(tableau).get_pixel(idpixel-1);
		}*/

		System.out.println("Pour synchroniser, on ajoute le pixel "+pix.x+" "+pix.y);
		Chatroom_Accueil.singleton_ihm.liste_tableaublanc_fenetres.get(tableau).ajouterPixelDistant(pix);
	}
	
	////////////////
	/////  MAIN  
	///////////////
	public static void main(String args[]) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, AdapterInactive, ServantAlreadyActive, WrongPolicy, InterruptedException, ServantNotActive
	{
		
		  //Création et demarrage du client 
		  new Client(args).demarrer();
		  new Chatroom_Accueil();
		  singleton_client.arreter();
		  
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
		  
		  //Thread.sleep(1000);

		//while(true);

	}	
}


