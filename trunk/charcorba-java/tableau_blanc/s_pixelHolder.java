package tableau_blanc;

/**
 *	Generated from IDL definition of struct "s_pixel"
 *	@author JacORB IDL compiler 
 */

public final class s_pixelHolder
	implements org.omg.CORBA.portable.Streamable
{
	public s_pixel value;

	public s_pixelHolder ()
	{
	}
	public s_pixelHolder(final s_pixel initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return s_pixelHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = s_pixelHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		s_pixelHelper.write(_out, value);
	}
}
