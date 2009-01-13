package chatroom;

/**
 *	Generated from IDL interface "Chatroom"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface ChatroomOperations
{
	/* constants */
	/* operations  */
	boolean ajouter_message(java.lang.String pseudo_client, java.lang.String message);
	java.lang.String[] get_message(int idmessage);
}
