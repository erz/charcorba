package chatroom;

/**
 *	Generated from IDL interface "AMI_ChatroomHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface AMI_ChatroomHandlerOperations
	extends org.omg.Messaging.ReplyHandlerOperations
{
	/* constants */
	/* operations  */
	void ajouter_message(boolean ami_return_val);
	void ajouter_message_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void get_message(java.lang.String[] ami_return_val);
	void get_message_excep(org.omg.Messaging.ExceptionHolder excep_holder);
}
