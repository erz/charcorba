package tableau_blanc;

/**
 *	Generated from IDL interface "TableauBlanc"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public final class TableauBlancHolder	implements org.omg.CORBA.portable.Streamable{
	 public TableauBlanc value;
	public TableauBlancHolder()
	{
	}
	public TableauBlancHolder (final TableauBlanc initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return TableauBlancHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = TableauBlancHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		TableauBlancHelper.write (_out,value);
	}
}
