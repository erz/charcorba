package Client;

/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class StandardHolder	implements org.omg.CORBA.portable.Streamable{
	 public Standard value;
	public StandardHolder()
	{
	}
	public StandardHolder (final Standard initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return StandardHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = StandardHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		StandardHelper.write (_out,value);
	}
}
