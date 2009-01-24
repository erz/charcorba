package Client;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import chatroom.Chatroom;
import chatroom.ChatroomHelper;
import orb_pkge.COrb;

public class Standard_impl extends StandardPOA
{
	public static Standard_impl static_standard;
	
	public Standard_impl()
	{
		static_standard = this;
	}
	
	public boolean afficher_message(String pseudo_client, String message) 
	{
		boolean retval = true;
	    Client.singleton_client.message_recu(pseudo_client,message);
		return retval; 
	}
	
	public boolean inviter_client(String chatroom) 
	{
		boolean retval = true ;
		
		org.omg.CORBA.Object service = null;
		try {
			service = COrb.static_orb.connecter_service(chatroom);
		} catch (NotFound e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (CannotProceed e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} catch (InvalidName e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		
		Chatroom service_chatroom = ChatroomHelper.narrow(service) ;

		Client.singleton_client.m_liste_chatrooms_distantes.put(chatroom,service_chatroom);
		
		Client.singleton_client.signal_invitation_chatroom(chatroom);
		return retval;
	}

	public boolean signal_chatroom(String chatroom) 
	{
		boolean retval = true;
		Client.singleton_client.signal_chatroom(chatroom, 0);
		return retval;
	}
	
	public boolean ping() 
	{
		boolean retval = true;
		return retval;
	}

	public boolean signal_chatroom(String chatroom, int idpixel) 
	{
		boolean retval = true;
		
		Client.singleton_client.signal_chatroom(chatroom, idpixel);
		return retval;
	}

	public boolean signal_tableaublanc(String tableau, int idpixel) {
		// TODO Auto-generated method stub
		return false;
	}

}
