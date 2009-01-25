package tableau_blanc;

/**
 *	Generated from IDL definition of struct "s_pixel"
 *	@author JacORB IDL compiler 
 */

public final class s_pixelHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc(s_pixelHelper.id(),"s_pixel",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("x", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("y", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("rouge", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("vert", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("bleu", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(2)), null),new org.omg.CORBA.StructMember("est_continu", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(8)), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final s_pixel s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static s_pixel extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:s_pixel:1.0";
	}
	public static s_pixel read (final org.omg.CORBA.portable.InputStream in)
	{
		s_pixel result = new s_pixel();
		result.x=in.read_short();
		result.y=in.read_short();
		result.rouge=in.read_short();
		result.vert=in.read_short();
		result.bleu=in.read_short();
		result.est_continu=in.read_boolean();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final s_pixel s)
	{
		out.write_short(s.x);
		out.write_short(s.y);
		out.write_short(s.rouge);
		out.write_short(s.vert);
		out.write_short(s.bleu);
		out.write_boolean(s.est_continu);
	}
}
