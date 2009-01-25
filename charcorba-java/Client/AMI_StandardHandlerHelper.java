package Client;

/**
 *	Generated from IDL interface "AMI_StandardHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class AMI_StandardHandlerHelper
{
	public static void insert (final org.omg.CORBA.Any any, final AMI_StandardHandler s)
	{
			any.insert_Object(s);
	}
	public static AMI_StandardHandler extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:AMI_StandardHandler:1.0", "AMI_StandardHandler");
	}
	public static String id()
	{
		return "IDL:AMI_StandardHandler:1.0";
	}
	public static AMI_StandardHandler read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final AMI_StandardHandler s)
	{
		_out.write_Object(s);
	}
	public static AMI_StandardHandler narrow(final java.lang.Object obj)
	{
		if (obj instanceof AMI_StandardHandler)
		{
			return (AMI_StandardHandler)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static AMI_StandardHandler narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (AMI_StandardHandler)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:AMI_StandardHandler:1.0"))
			{
				_AMI_StandardHandlerStub stub;
				stub = new _AMI_StandardHandlerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static AMI_StandardHandler unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (AMI_StandardHandler)obj;
		}
		catch (ClassCastException c)
		{
				_AMI_StandardHandlerStub stub;
				stub = new _AMI_StandardHandlerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
