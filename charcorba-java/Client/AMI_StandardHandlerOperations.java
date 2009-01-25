package Client;

/**
 *	Generated from IDL interface "AMI_StandardHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface AMI_StandardHandlerOperations
	extends org.omg.Messaging.ReplyHandlerOperations
{
	/* constants */
	/* operations  */
	void afficher_message(boolean ami_return_val);
	void afficher_message_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void signal_chatroom(boolean ami_return_val);
	void signal_chatroom_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void signal_tableaublanc(boolean ami_return_val);
	void signal_tableaublanc_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void inviter_client_chatroom(boolean ami_return_val);
	void inviter_client_chatroom_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void inviter_client_tableaublanc(boolean ami_return_val);
	void inviter_client_tableaublanc_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void ping(boolean ami_return_val);
	void ping_excep(org.omg.Messaging.ExceptionHolder excep_holder);
}
