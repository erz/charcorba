package annuaire;

/**
 *	Generated from IDL interface "AMI_AnnuaireHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class AMI_AnnuaireHandlerHelper
{
	public static void insert (final org.omg.CORBA.Any any, final AMI_AnnuaireHandler s)
	{
			any.insert_Object(s);
	}
	public static AMI_AnnuaireHandler extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:AMI_AnnuaireHandler:1.0", "AMI_AnnuaireHandler");
	}
	public static String id()
	{
		return "IDL:AMI_AnnuaireHandler:1.0";
	}
	public static AMI_AnnuaireHandler read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final AMI_AnnuaireHandler s)
	{
		_out.write_Object(s);
	}
	public static AMI_AnnuaireHandler narrow(final java.lang.Object obj)
	{
		if (obj instanceof AMI_AnnuaireHandler)
		{
			return (AMI_AnnuaireHandler)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static AMI_AnnuaireHandler narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (AMI_AnnuaireHandler)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:AMI_AnnuaireHandler:1.0"))
			{
				_AMI_AnnuaireHandlerStub stub;
				stub = new _AMI_AnnuaireHandlerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static AMI_AnnuaireHandler unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (AMI_AnnuaireHandler)obj;
		}
		catch (ClassCastException c)
		{
				_AMI_AnnuaireHandlerStub stub;
				stub = new _AMI_AnnuaireHandlerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
