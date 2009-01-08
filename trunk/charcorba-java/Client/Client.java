package Client;

import java.util.ArrayList;
import java.util.Properties;

import org.jacorb.orb.ORB;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.DoubleHolder;
import org.omg.CORBA.ShortHolder;
import org.omg.CORBA.StringHolder;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Client {

	String m_pseudo;
	ArrayList<String> liste_amis = new ArrayList<String>();
	ArrayList<String> liste_tags = new ArrayList<String>();
	
	  // Afficher simplement un message chez le client
	  public void afficher_message (String pseudo_client, String message) {
	}

	  // Prévient le client que la chatroom a recu un message
	  public void signal_chatroom(String chatroom) {
	}

	  // Invite le client à participer à une chatroom
	  public void inviter_client (String chatroom) {
	}
	

	public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
		int status = 0;
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		
		 try
		 {
			 status = run(orb);
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
			 status = 1;
		 }
		
		 //Si l'orb a été créé avec succès, alors on le détruit.
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
		
		 // Le status "exit" est retourné. Si il n'y a pas d'erreur, on retourne 0, ou 1 sinon.
		 System.exit(status);
		 }
		
		 static int run(org.omg.CORBA.ORB orb)
		 {
			 org.omg.CORBA.Object obj = null;
		
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
		
		 // L'objet référencé est "narrowed" vers un objet de référence trivial. Un cast n'est pas autorisé ici parce que il est possible que le client est besoin de demander au serveur si oui ou non
		 // l'objet est de type trivial.
		 Standard standardImpl = StandardHelper.narrow(obj);
		
		 System.out.println(standardImpl.setValues(new StringHolder("a"), new DoubleHolder(1.2),new ShortHolder((short)5), new BooleanHolder(true)));
		
		 return 0;
		 } 
			
}


