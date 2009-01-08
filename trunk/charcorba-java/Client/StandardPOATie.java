package Client;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class StandardPOATie
	extends StandardPOA
{
	private StandardOperations _delegate;

	private POA _poa;
	public StandardPOATie(StandardOperations delegate)
	{
		_delegate = delegate;
	}
	public StandardPOATie(StandardOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public Standard _this()
	{
		return StandardHelper.narrow(_this_object());
	}
	public Standard _this(org.omg.CORBA.ORB orb)
	{
		return StandardHelper.narrow(_this_object(orb));
	}
	public StandardOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(StandardOperations delegate)
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
	public boolean afficher_message(java.lang.String pseudo_client, java.lang.String message)
	{
		return _delegate.afficher_message(pseudo_client,message);
	}

	public boolean ping()
	{
		return _delegate.ping();
	}

	public boolean inviter_client(java.lang.String chatroom)
	{
		return _delegate.inviter_client(chatroom);
	}

	public boolean signal_chatroom(java.lang.String chatroom)
	{
		return _delegate.signal_chatroom(chatroom);
	}

}
