package chatroom;

/**
 *	Generated from IDL interface "AMI_ChatroomHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class AMI_ChatroomHandlerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AMI_ChatroomHandlerOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "get_message_excep", new java.lang.Integer(0));
		m_opsHash.put ( "get_message", new java.lang.Integer(1));
		m_opsHash.put ( "ajouter_message_excep", new java.lang.Integer(2));
		m_opsHash.put ( "ajouter_message", new java.lang.Integer(3));
	}
	private String[] ids = {"IDL:AMI_ChatroomHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public AMI_ChatroomHandler _this()
	{
		return AMI_ChatroomHandlerHelper.narrow(_this_object());
	}
	public AMI_ChatroomHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_ChatroomHandlerHelper.narrow(_this_object(orb));
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
			case 0: // get_message_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				get_message_excep(_arg0);
				break;
			}
			case 1: // get_message
			{
				java.lang.String[] _arg0=chatroom.ChatroomPackage.t_string_auteurHelper.read(_input);
				_out = handler.createReply();
				get_message(_arg0);
				break;
			}
			case 2: // ajouter_message_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				ajouter_message_excep(_arg0);
				break;
			}
			case 3: // ajouter_message
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				ajouter_message(_arg0);
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
