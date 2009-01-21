package Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

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

import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import chatroom.Chatroom_impl;

import annuaire.Annuaire;
import annuaire.AnnuaireHelper;
import annuaire.AnnuairePackage.t_liste_stringHelper;

import IHM.JFrameClient;


public class Client implements Runnable
{
	//Notre client
	public static Client singleton_client;
	
	//IHM 
	JFrameClient ihm_client;

	Standard_impl m_standard;
	
	String m_pseudo;
	ArrayList<String> liste_amis = new ArrayList<String>();
	ArrayList<String> liste_tags = new ArrayList<String>();
	
	//Annuaire
	Annuaire m_service_annuaire ;
	
	HashMap<String,Chatroom_impl> m_liste_chatrooms_locales;  
	
	//Constructeur
	Client()
	{
		
		//ihm_client = new JFrameClient();
		m_pseudo = "Aurelien";
		m_standard = new Standard_impl();
		singleton_client = this;
	}	
		
	// Afficher simplement un message chez le client
	
	  public void afficher_message (String pseudo_client, String message) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
		  Object service_distant = COrb.static_orb.connecter_service(pseudo_client);
		  Standard standard_distant = StandardHelper.narrow(service_distant);
		  standard_distant.afficher_message(m_pseudo, message);
	  }

	  // Prévient le client que la chatroom a recu un message
	  public void signal_chatroom(String chatroom) {
		
	  }
	  
	  //Prévient le client qu'un ami a ouvert une chatroom
	  public void signal_invitation_chatroom(String chatroom){
		  
	  }

	  // Invite le client à participer à une chatroom
	  public void inviter_client (String chatroom) {
		  
	  }
	  
	  //Modifier son pseudonyme
	  
	  
	  public void set_pseudo(String pseudo) throws org.omg.CosNaming.NamingContextPackage.InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive
	  {
			m_pseudo = pseudo ; 
			COrb.static_orb.ajout_service(m_standard, pseudo);
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
	  }
	  
	  //Creer une Chatroom
	  public void creer_chatroom(String nom_chatroom){
		  Chatroom_impl chatroom = new Chatroom_impl(nom_chatroom);
		  //m_liste_chatrooms_locales.add(pair<String,Chatroom_impl>("nom_chatroom",chatroom));
		  //COrb.static_orb.ajout_service(chatroom, nom_chatroom);
	  }
	  
	  //ajouter un message
	  public void ajouter_message(String nom_chatroom,String message){
		  
	  }
	  
	  public void joindre_annuaire() throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName
	  {
		System.out.println("Connexion a l'annuaire");
		Object service = COrb.static_orb.connecter_service("Annuaire");
	  	
		m_service_annuaire = AnnuaireHelper.narrow(service) ;
	  	m_service_annuaire.joindre_annuaire(m_pseudo);
	  }
	  
	  
	  public static void main(String args[]) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, AdapterInactive, ServantAlreadyActive, WrongPolicy, InterruptedException, ServantNotActive
	  {
		  
		  //Lancement de l'ORB
		  new COrb(args);
		  
		  //Création du client 
		  new Client();
		  
		  new Thread (singleton_client).start();
		  
		  singleton_client.set_pseudo("Aurelien");
		  
		  
		  singleton_client.joindre_annuaire();
		  
		  
		  
		  while(true);
		  
		    	  /*
	    	int status = 0;
	  
	    	// The ORB doit être initialiser.
	    	org.omg.CORBA.ORB orb = null;
	  
		   try
		   {
			   Properties props = new Properties();
			   props.put("org.omg.CORBA.ORBInitialPort", "10809");
			   props.put("org.omg.CORBA.ORBInitialHost", "localhost");
			   orb = ORB.init(args, props);
			   status = run(orb);
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
			   status = 1;
		   }
	  
		   // Si l'ORB est créé avec succès, il sera détruit. Cela libère les ressources utilisées par l'ORB
		   if(orb != null)
		   {
			   try
			   {
				   orb.destroy();
			   }
			   catch(Exception ex)
			   {
				   ex.printStackTrace();
				   status = 1;
			   }
		   }
		  
		   // Le status de sortie est retourné. Si il n'y a pas d'erreur on retourne 0 ou sinon 1.
		  	System.exit(status);
		  	*/
		}

	public void run() 
	{
		// TODO Auto-generated method stub
		COrb.static_orb.orb.run();
	}
		  /*
		static int run(org.omg.CORBA.ORB orb)
		{
			   org.omg.CORBA.Object obj = null;
		  
		   // The stringified object reference is read and converted to an object.
		   try
		   {
			   String refFile = "C:/EXEMPLEFILE.ref";
			   java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(refFile));
			   String ref = in.readLine();
			   obj = orb.string_to_object(ref);
		   }
		   catch(java.io.IOException ex)
		   {
			   ex.printStackTrace();
			   return 1;
		   }
		  
		   // L'objet référencé est "narrowed" vers une réference vers un objet trivial. Un simple cast java n'est 
		   // pas autorisé ici, parce que c'est possible que le client ait besoin de demander au serveur
		   // si oui ou non l'objet est réellement du type trivial.
		   	Standard standardImpl = StandardHelper.narrow(obj);
		  
		   System.out.println(standardImpl.setValues(new StringHolder("a"), new DoubleHolder(1.2),new ShortHolder((short)5), new BooleanHolder(true)));
		  
		   return 0;
	  } */
			
}


