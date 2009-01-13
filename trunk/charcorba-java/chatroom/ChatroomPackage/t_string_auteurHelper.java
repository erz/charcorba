package chatroom.ChatroomPackage;

/**
 *	Generated from IDL definition of alias "t_string_auteur"
 *	@author JacORB IDL compiler 
 */

public final class t_string_auteurHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, java.lang.String[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static java.lang.String[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(chatroom.ChatroomPackage.t_string_auteurHelper.id(), "t_string_auteur",org.omg.CORBA.ORB.init().create_sequence_tc(2, org.omg.CORBA.ORB.init().create_string_tc(0)));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:Chatroom/t_string_auteur:1.0";
	}
	public static java.lang.String[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		java.lang.String[] _result;
		int _l_result0 = _in.read_long();
		if (_l_result0 > 2)
			throw new org.omg.CORBA.MARSHAL("Sequence length incorrect!");
		_result = new java.lang.String[_l_result0];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=_in.read_string();
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, java.lang.String[] _s)
	{
				if (_s.length > 2)
			throw new org.omg.CORBA.MARSHAL("Incorrect sequence length");
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			_out.write_string(_s[i]);
		}

	}
}
