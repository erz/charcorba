package chatroom;

/**
 *	Generated from IDL interface "Chatroom"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class ChatroomHelper
{
	public static void insert (final org.omg.CORBA.Any any, final Chatroom s)
	{
			any.insert_Object(s);
	}
	public static Chatroom extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:Chatroom:1.0", "Chatroom");
	}
	public static String id()
	{
		return "IDL:Chatroom:1.0";
	}
	public static Chatroom read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final Chatroom s)
	{
		_out.write_Object(s);
	}
	public static Chatroom narrow(final java.lang.Object obj)
	{
		if (obj instanceof Chatroom)
		{
			return (Chatroom)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static Chatroom narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (Chatroom)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:Chatroom:1.0"))
			{
				_ChatroomStub stub;
				stub = new _ChatroomStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static Chatroom unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (Chatroom)obj;
		}
		catch (ClassCastException c)
		{
				_ChatroomStub stub;
				stub = new _ChatroomStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
