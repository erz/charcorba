package Client;

import java.util.ArrayList;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Client {

	String m_pseudo;
	ArrayList<String> liste_amis = new ArrayList<String>();
	ArrayList<String> liste_tags = new ArrayList<String>();
	
	  // Afficher simplement un message chez le client
	  public void afficher_message (String pseudo, String message) {
	}

	  // Prévient le client que la chatroom a recu un message
	  public void signal_chatroom(String chatroom) {
	}

	  // Invite le client à participer à une chatroom
	  public void inviter_client (String chatroom) {
	}
	

	public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
		// Initialise ORB
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		// récupére le serveur de nom
		org.omg.CosNaming.NamingContext ns = org.omg.CosNaming. NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
		// Récupération de la souche depuis le serveur de nom
		org.omg.CORBA.Object obj_ref = ns.resolve(new org.omg.CosNaming.NameComponent[] {new NameComponent("ObjClient","")});
		Standard standard = StandardHelper.narrow(obj_ref);
		// Invocation de l'objet distant
		standard.doStandard();
	}

}
