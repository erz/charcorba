package chatroom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
		m_liste_messages = new Vector<Message>();
		m_liste_participants = new HashMap <String,Standard> ();
		m_nom_chatroom = nom_chatroom;
	}

	public boolean ajouter_message(String pseudo_client, String message) 
	{
		System.out.println("On va afficher le message "+message+" de "+pseudo_client);
		boolean retval = true ;
		Message msg = new Message();
		msg.auteur =  pseudo_client;
		msg.message = message;
		m_liste_messages.add(msg);
		
		if (pseudo_client.compareTo(Client.Client.singleton_client.m_pseudo) == 0)
		{
			Collection<Standard> participants = m_liste_participants.values();
			Iterator <Standard> it = participants.iterator();
			while (it.hasNext())
			{
				
				it.next().signal_chatroom(m_nom_chatroom,m_liste_messages.size()-1);
				
			}
		}
		Client.Client.singleton_client.signal_chatroom(m_nom_chatroom, m_liste_messages.size()-1);
		
		return retval;
	}

	public String[] get_message(int idmessage) 
	{
		  String [] retval = new String [2];
		  
		  String c_auteur = m_liste_messages.get(idmessage).auteur;
		  //CORBA::String s_auteur (c_auteur);

		  String c_message = m_liste_messages.get(idmessage).message;
		  //CORBA::String_var s_message (c_message);  

		  retval[0] = c_auteur ;
		  retval[1] = c_message ;
		  return retval; 
	}
	
	public void inviter_client (String pseudo) throws NotFound, CannotProceed, InvalidName
	{
		org.omg.CORBA.Object service_distant = orb_pkge.COrb.static_orb.connecter_service(pseudo);

		Client.Standard standard_distant = Client.StandardHelper.narrow(service_distant) ;
		
		System.out.println("HOOOOOOOO");
		standard_distant.inviter_client_chatroom(m_nom_chatroom);
		
		m_liste_participants.put(pseudo, standard_distant);
	}

}
