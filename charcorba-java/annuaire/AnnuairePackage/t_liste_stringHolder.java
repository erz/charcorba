package annuaire.AnnuairePackage;

/**
 *	Generated from IDL definition of alias "t_liste_string"
 *	@author JacORB IDL compiler 
 */

public final class t_liste_stringHolder
	implements org.omg.CORBA.portable.Streamable
{
	public java.lang.String[] value;

	public t_liste_stringHolder ()
	{
	}
	public t_liste_stringHolder (final java.lang.String[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return t_liste_stringHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = t_liste_stringHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		t_liste_stringHelper.write (out,value);
	}
}
