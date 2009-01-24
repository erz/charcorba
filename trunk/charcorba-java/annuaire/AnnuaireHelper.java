package annuaire;

/**
 *	Generated from IDL interface "Annuaire"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class AnnuaireHelper
{
	public static void insert (final org.omg.CORBA.Any any, final Annuaire s)
	{
			any.insert_Object(s);
	}
	public static Annuaire extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:Annuaire:1.0", "Annuaire");
	}
	public static String id()
	{
		return "IDL:Annuaire:1.0";
	}
	public static Annuaire read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final Annuaire s)
	{
		_out.write_Object(s);
	}
	public static Annuaire narrow(final java.lang.Object obj)
	{
		if (obj instanceof Annuaire)
		{
			return (Annuaire)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static Annuaire narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (Annuaire)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:Annuaire:1.0"))
			{
				_AnnuaireStub stub;
				stub = new _AnnuaireStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static Annuaire unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (Annuaire)obj;
		}
		catch (ClassCastException c)
		{
				_AnnuaireStub stub;
				stub = new _AnnuaireStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
