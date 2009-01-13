package chatroom;

/**
 *	Generated from IDL interface "Chatroom"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class ChatroomHolder	implements org.omg.CORBA.portable.Streamable{
	 public Chatroom value;
	public ChatroomHolder()
	{
	}
	public ChatroomHolder (final Chatroom initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return ChatroomHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ChatroomHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		ChatroomHelper.write (_out,value);
	}
}
