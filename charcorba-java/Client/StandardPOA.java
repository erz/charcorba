package Client;

/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class StandardPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, StandardOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "afficher_message", new java.lang.Integer(0));
		m_opsHash.put ( "ping", new java.lang.Integer(1));
		m_opsHash.put ( "inviter_client", new java.lang.Integer(2));
		m_opsHash.put ( "signal_chatroom", new java.lang.Integer(3));
	}
	private String[] ids = {"IDL:Standard:1.0"};
	public Standard _this()
	{
		return StandardHelper.narrow(_this_object());
	}
	public Standard _this(org.omg.CORBA.ORB orb)
	{
		return StandardHelper.narrow(_this_object(orb));
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
			case 0: // afficher_message
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(afficher_message(_arg0,_arg1));
				break;
			}
			case 1: // ping
			{
				_out = handler.createReply();
				_out.write_boolean(ping());
				break;
			}
			case 2: // inviter_client
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(inviter_client(_arg0));
				break;
			}
			case 3: // signal_chatroom
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(signal_chatroom(_arg0));
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
