package tableau_blanc;

/**
 *	Generated from IDL interface "TableauBlanc"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class TableauBlancPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, TableauBlancOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "get_pixel", new java.lang.Integer(0));
		m_opsHash.put ( "ajouter_pixel", new java.lang.Integer(1));
	}
	private String[] ids = {"IDL:TableauBlanc:1.0"};
	public TableauBlanc _this()
	{
		return TableauBlancHelper.narrow(_this_object());
	}
	public TableauBlanc _this(org.omg.CORBA.ORB orb)
	{
		return TableauBlancHelper.narrow(_this_object(orb));
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
			case 0: // get_pixel
			{
				int _arg0=_input.read_ulong();
				_out = handler.createReply();
				s_pixelHelper.write(_out,get_pixel(_arg0));
				break;
			}
			case 1: // ajouter_pixel
			{
				s_pixel _arg0=s_pixelHelper.read(_input);
				_out = handler.createReply();
				_out.write_boolean(ajouter_pixel(_arg0));
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
