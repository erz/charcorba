package chatroom;

import java.util.HashMap;
import java.util.Vector;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Client.Standard;

public class Chatroom_impl extends ChatroomPOA
{
	public String m_nom_chatroom;
	public Vector<Message> m_liste_messages ;
	public HashMap <String,Standard> m_liste_participants;

	public Chatroom_impl(String nom_chatroom) 
	{
		// TODO Auto-generated constructor stub
		m_nom_chatroom = nom_chatroom;
	}

	public boolean ajouter_message(String pseudo_client, String message) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] get_message(int idmessage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void inviter_client (String pseudo) throws NotFound, CannotProceed, InvalidName
	{
		org.omg.CORBA.Object service_distant = orb_pkge.COrb.static_orb.connecter_service(pseudo);

		Client.Standard standard_distant = Client.StandardHelper.narrow(service_distant) ;
		standard_distant.inviter_client(m_nom_chatroom);
		
		m_liste_participants.put(pseudo, standard_distant);
	}

}
