package chatroom;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "Chatroom"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class ChatroomPOATie
	extends ChatroomPOA
{
	private ChatroomOperations _delegate;

	private POA _poa;
	public ChatroomPOATie(ChatroomOperations delegate)
	{
		_delegate = delegate;
	}
	public ChatroomPOATie(ChatroomOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public Chatroom _this()
	{
		return ChatroomHelper.narrow(_this_object());
	}
	public Chatroom _this(org.omg.CORBA.ORB orb)
	{
		return ChatroomHelper.narrow(_this_object(orb));
	}
	public ChatroomOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(ChatroomOperations delegate)
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
	public java.lang.String[] get_message(int idmessage)
	{
		return _delegate.get_message(idmessage);
	}

	public boolean ajouter_message(java.lang.String pseudo_client, java.lang.String message)
	{
		return _delegate.ajouter_message(pseudo_client,message);
	}

}
