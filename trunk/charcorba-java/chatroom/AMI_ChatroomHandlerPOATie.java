package chatroom;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "AMI_ChatroomHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class AMI_ChatroomHandlerPOATie
	extends AMI_ChatroomHandlerPOA
{
	private AMI_ChatroomHandlerOperations _delegate;

	private POA _poa;
	public AMI_ChatroomHandlerPOATie(AMI_ChatroomHandlerOperations delegate)
	{
		_delegate = delegate;
	}
	public AMI_ChatroomHandlerPOATie(AMI_ChatroomHandlerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AMI_ChatroomHandler _this()
	{
		return AMI_ChatroomHandlerHelper.narrow(_this_object());
	}
	public AMI_ChatroomHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_ChatroomHandlerHelper.narrow(_this_object(orb));
	}
	public AMI_ChatroomHandlerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(AMI_ChatroomHandlerOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		else
		{
			return super._default_POA();
		}
	}
	public void get_message_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.get_message_excep(excep_holder);
	}

	public void get_message(java.lang.String[] ami_return_val)
	{
_delegate.get_message(ami_return_val);
	}

	public void ajouter_message_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.ajouter_message_excep(excep_holder);
	}

	public void ajouter_message(boolean ami_return_val)
	{
_delegate.ajouter_message(ami_return_val);
	}

}
