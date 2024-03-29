package Client;

/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class StandardHelper
{
	public static void insert (final org.omg.CORBA.Any any, final Standard s)
	{
			any.insert_Object(s);
	}
	public static Standard extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:Standard:1.0", "Standard");
	}
	public static String id()
	{
		return "IDL:Standard:1.0";
	}
	public static Standard read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final Standard s)
	{
		_out.write_Object(s);
	}
	public static Standard narrow(final java.lang.Object obj)
	{
		if (obj instanceof Standard)
		{
			return (Standard)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static Standard narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (Standard)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:Standard:1.0"))
			{
				_StandardStub stub;
				stub = new _StandardStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static Standard unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (Standard)obj;
		}
		catch (ClassCastException c)
		{
				_StandardStub stub;
				stub = new _StandardStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
