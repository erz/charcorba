package tableau_blanc;

/**
 *	Generated from IDL interface "AMI_TableauBlancHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface AMI_TableauBlancHandlerOperations
	extends org.omg.Messaging.ReplyHandlerOperations
{
	/* constants */
	/* operations  */
	void ajouter_pixel(boolean ami_return_val);
	void ajouter_pixel_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void get_pixel(s_pixel ami_return_val);
	void get_pixel_excep(org.omg.Messaging.ExceptionHolder excep_holder);
}
