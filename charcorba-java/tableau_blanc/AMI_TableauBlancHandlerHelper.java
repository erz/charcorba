package tableau_blanc;

/**
 *	Generated from IDL interface "AMI_TableauBlancHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class AMI_TableauBlancHandlerHelper
{
	public static void insert (final org.omg.CORBA.Any any, final AMI_TableauBlancHandler s)
	{
			any.insert_Object(s);
	}
	public static AMI_TableauBlancHandler extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:AMI_TableauBlancHandler:1.0", "AMI_TableauBlancHandler");
	}
	public static String id()
	{
		return "IDL:AMI_TableauBlancHandler:1.0";
	}
	public static AMI_TableauBlancHandler read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final AMI_TableauBlancHandler s)
	{
		_out.write_Object(s);
	}
	public static AMI_TableauBlancHandler narrow(final java.lang.Object obj)
	{
		if (obj instanceof AMI_TableauBlancHandler)
		{
			return (AMI_TableauBlancHandler)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static AMI_TableauBlancHandler narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (AMI_TableauBlancHandler)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:AMI_TableauBlancHandler:1.0"))
			{
				_AMI_TableauBlancHandlerStub stub;
				stub = new _AMI_TableauBlancHandlerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static AMI_TableauBlancHandler unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (AMI_TableauBlancHandler)obj;
		}
		catch (ClassCastException c)
		{
				_AMI_TableauBlancHandlerStub stub;
				stub = new _AMI_TableauBlancHandlerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
