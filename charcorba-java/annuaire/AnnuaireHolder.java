package annuaire;

/**
 *	Generated from IDL interface "Annuaire"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class AnnuaireHolder	implements org.omg.CORBA.portable.Streamable{
	 public Annuaire value;
	public AnnuaireHolder()
	{
	}
	public AnnuaireHolder (final Annuaire initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return AnnuaireHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = AnnuaireHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		AnnuaireHelper.write (_out,value);
	}
}
