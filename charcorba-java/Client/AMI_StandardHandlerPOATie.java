package Client;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "AMI_StandardHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class AMI_StandardHandlerPOATie
	extends AMI_StandardHandlerPOA
{
	private AMI_StandardHandlerOperations _delegate;

	private POA _poa;
	public AMI_StandardHandlerPOATie(AMI_StandardHandlerOperations delegate)
	{
		_delegate = delegate;
	}
	public AMI_StandardHandlerPOATie(AMI_StandardHandlerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AMI_StandardHandler _this()
	{
		return AMI_StandardHandlerHelper.narrow(_this_object());
	}
	public AMI_StandardHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_StandardHandlerHelper.narrow(_this_object(orb));
	}
	public AMI_StandardHandlerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(AMI_StandardHandlerOperations delegate)
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
	public void afficher_message_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.afficher_message_excep(excep_holder);
	}

	public void ping_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.ping_excep(excep_holder);
	}

	public void inviter_client_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.inviter_client_excep(excep_holder);
	}

	public void inviter_client(boolean ami_return_val)
	{
_delegate.inviter_client(ami_return_val);
	}

	public void ping(boolean ami_return_val)
	{
_delegate.ping(ami_return_val);
	}

	public void signal_chatroom(boolean ami_return_val)
	{
_delegate.signal_chatroom(ami_return_val);
	}

	public void signal_chatroom_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.signal_chatroom_excep(excep_holder);
	}

	public void afficher_message(boolean ami_return_val)
	{
_delegate.afficher_message(ami_return_val);
	}

}
