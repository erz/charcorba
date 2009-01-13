package chatroom.ChatroomPackage;

/**
 *	Generated from IDL definition of alias "t_string_auteur"
 *	@author JacORB IDL compiler 
 */

public final class t_string_auteurHolder
	implements org.omg.CORBA.portable.Streamable
{
	public java.lang.String[] value;

	public t_string_auteurHolder ()
	{
	}
	public t_string_auteurHolder (final java.lang.String[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return t_string_auteurHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = t_string_auteurHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		t_string_auteurHelper.write (out,value);
	}
}
