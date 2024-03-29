package Client;

/**
 *	Generated from IDL interface "AMI_StandardHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class AMI_StandardHandlerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AMI_StandardHandlerOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "ping_excep", new java.lang.Integer(0));
		m_opsHash.put ( "inviter_client_tableaublanc", new java.lang.Integer(1));
		m_opsHash.put ( "ping", new java.lang.Integer(2));
		m_opsHash.put ( "signal_tableaublanc_excep", new java.lang.Integer(3));
		m_opsHash.put ( "inviter_client_tableaublanc_excep", new java.lang.Integer(4));
		m_opsHash.put ( "signal_tableaublanc", new java.lang.Integer(5));
		m_opsHash.put ( "afficher_message", new java.lang.Integer(6));
		m_opsHash.put ( "inviter_client_chatroom", new java.lang.Integer(7));
		m_opsHash.put ( "signal_chatroom_excep", new java.lang.Integer(8));
		m_opsHash.put ( "inviter_client_chatroom_excep", new java.lang.Integer(9));
		m_opsHash.put ( "signal_chatroom", new java.lang.Integer(10));
		m_opsHash.put ( "afficher_message_excep", new java.lang.Integer(11));
	}
	private String[] ids = {"IDL:AMI_StandardHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public AMI_StandardHandler _this()
	{
		return AMI_StandardHandlerHelper.narrow(_this_object());
	}
	public AMI_StandardHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_StandardHandlerHelper.narrow(_this_object(orb));
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // ping_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				ping_excep(_arg0);
				break;
			}
			case 1: // inviter_client_tableaublanc
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				inviter_client_tableaublanc(_arg0);
				break;
			}
			case 2: // ping
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				ping(_arg0);
				break;
			}
			case 3: // signal_tableaublanc_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				signal_tableaublanc_excep(_arg0);
				break;
			}
			case 4: // inviter_client_tableaublanc_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				inviter_client_tableaublanc_excep(_arg0);
				break;
			}
			case 5: // signal_tableaublanc
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				signal_tableaublanc(_arg0);
				break;
			}
			case 6: // afficher_message
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				afficher_message(_arg0);
				break;
			}
			case 7: // inviter_client_chatroom
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				inviter_client_chatroom(_arg0);
				break;
			}
			case 8: // signal_chatroom_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				signal_chatroom_excep(_arg0);
				break;
			}
			case 9: // inviter_client_chatroom_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				inviter_client_chatroom_excep(_arg0);
				break;
			}
			case 10: // signal_chatroom
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				signal_chatroom(_arg0);
				break;
			}
			case 11: // afficher_message_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				afficher_message_excep(_arg0);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
