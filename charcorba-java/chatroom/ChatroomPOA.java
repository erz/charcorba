package chatroom;

/**
 *	Generated from IDL interface "Chatroom"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class ChatroomPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, ChatroomOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "get_message", new java.lang.Integer(0));
		m_opsHash.put ( "ajouter_message", new java.lang.Integer(1));
	}
	private String[] ids = {"IDL:Chatroom:1.0"};
	public Chatroom _this()
	{
		return ChatroomHelper.narrow(_this_object());
	}
	public Chatroom _this(org.omg.CORBA.ORB orb)
	{
		return ChatroomHelper.narrow(_this_object(orb));
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
			case 0: // get_message
			{
				int _arg0=_input.read_ulong();
				_out = handler.createReply();
				chatroom.ChatroomPackage.t_string_auteurHelper.write(_out,get_message(_arg0));
				break;
			}
			case 1: // ajouter_message
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(ajouter_message(_arg0,_arg1));
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
