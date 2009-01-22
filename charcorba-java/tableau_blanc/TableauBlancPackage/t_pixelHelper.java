package tableau_blanc.TableauBlancPackage;

/**
 *	Generated from IDL definition of alias "t_pixel"
 *	@author JacORB IDL compiler 
 */

public final class t_pixelHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, short[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static short[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(tableau_blanc.TableauBlancPackage.t_pixelHelper.id(), "t_pixel",org.omg.CORBA.ORB.init().create_sequence_tc(6, org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2))));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:TableauBlanc/t_pixel:1.0";
	}
	public static short[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		short[] _result;
		int _l_result0 = _in.read_long();
		if (_l_result0 > 6)
			throw new org.omg.CORBA.MARSHAL("Sequence length incorrect!");
		_result = new short[_l_result0];
	_in.read_short_array(_result,0,_l_result0);
		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, short[] _s)
	{
				if (_s.length > 6)
			throw new org.omg.CORBA.MARSHAL("Incorrect sequence length");
		_out.write_long(_s.length);
		_out.write_short_array(_s,0,_s.length);
	}
}
