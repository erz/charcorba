package tableau_blanc;

/**
 *	Generated from IDL interface "AMI_TableauBlancHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class AMI_TableauBlancHandlerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AMI_TableauBlancHandlerOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "get_pixel", new java.lang.Integer(0));
		m_opsHash.put ( "ajouter_pixel", new java.lang.Integer(1));
		m_opsHash.put ( "ajouter_pixel_excep", new java.lang.Integer(2));
		m_opsHash.put ( "get_pixel_excep", new java.lang.Integer(3));
	}
	private String[] ids = {"IDL:AMI_TableauBlancHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public AMI_TableauBlancHandler _this()
	{
		return AMI_TableauBlancHandlerHelper.narrow(_this_object());
	}
	public AMI_TableauBlancHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_TableauBlancHandlerHelper.narrow(_this_object(orb));
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
				short[] _arg0=tableau_blanc.TableauBlancPackage.t_pixelHelper.read(_input);
				_out = handler.createReply();
				get_pixel(_arg0);
				break;
			}
			case 1: // ajouter_pixel
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				ajouter_pixel(_arg0);
				break;
			}
			case 2: // ajouter_pixel_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				ajouter_pixel_excep(_arg0);
				break;
			}
			case 3: // get_pixel_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				get_pixel_excep(_arg0);
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
