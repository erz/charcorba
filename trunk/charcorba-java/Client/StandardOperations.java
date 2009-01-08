package Client;

/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface StandardOperations
{
	/* constants */
	/* operations  */
	boolean afficher_message(java.lang.String pseudo_client, java.lang.String message);
	boolean signal_chatroom(java.lang.String chatroom);
	boolean inviter_client(java.lang.String chatroom);
	boolean ping();
}
