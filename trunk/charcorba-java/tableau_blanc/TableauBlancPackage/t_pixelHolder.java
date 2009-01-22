package tableau_blanc.TableauBlancPackage;

/**
 *	Generated from IDL definition of alias "t_pixel"
 *	@author JacORB IDL compiler 
 */

public final class t_pixelHolder
	implements org.omg.CORBA.portable.Streamable
{
	public short[] value;

	public t_pixelHolder ()
	{
	}
	public t_pixelHolder (final short[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return t_pixelHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = t_pixelHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		t_pixelHelper.write (out,value);
	}
}
