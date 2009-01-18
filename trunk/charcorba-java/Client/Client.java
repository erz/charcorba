package Client;

import java.util.ArrayList;
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
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;


public class Client 
{
	//Notre client
	static Client singleton_client;

	String m_pseudo;
	ArrayList<String> liste_amis = new ArrayList<String>();
	ArrayList<String> liste_tags = new ArrayList<String>();
	
	  // Afficher simplement un message chez le client
	  public void afficher_message (String pseudo_client, String message) {
		  
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
	  public void set_pseudo(String pseudo){
		  
	  }
	  
	  //Joindre l'annuaire
	  public void joindre_annuaire(){
		  
	  }
	
	  //Ajout d'un Tag
	  public void ajouter_tag(String tag){
		  
	  }
	  
	  //Enlever un Tag
	  public void enlever_tag(String tag){
		  
	  }
	  
	  //Obtenir liste d'amis par tag
	  public void get_amis_par_tag(String tag){
		  
	  }
	  
	  //Ajouter un ami
	  public void ajouter_ami(String ami){
		  
	  }
	  
	  //Creer une Chatroom
	  public void creer_chatroom(String nom_chatroom){
		  
	  }
	  
	  //ajouter un message
	  public void ajouter_message(String nom_chatroom,String message){
		  
	  }
	  
	  
	  
	  public static void main(String args[]) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName
	  {
		// Create an object request broker
		    ORB orb = ORB.init(args, null);

		    // Obtain object reference for name service ...
	            org.omg.CORBA.Object object = 
	            orb.resolve_initial_references("NameService");
	            
	            // ... and narrow it to a NameContext
	            NamingContext namingContext = 
	            NamingContextHelper.narrow(object);

	            // Create a name component array
	            NameComponent nc_array[] =
	            { new NameComponent("address_book","") };

	            // Get an address book object reference ...
	            org.omg.CORBA.Object objectReference = 
	            namingContext.resolve(nc_array);
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
	  } 
			
}


