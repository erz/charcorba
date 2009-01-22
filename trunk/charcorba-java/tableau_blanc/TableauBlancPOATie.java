package tableau_blanc;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "TableauBlanc"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class TableauBlancPOATie
	extends TableauBlancPOA
{
	private TableauBlancOperations _delegate;

	private POA _poa;
	public TableauBlancPOATie(TableauBlancOperations delegate)
	{
		_delegate = delegate;
	}
	public TableauBlancPOATie(TableauBlancOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public TableauBlanc _this()
	{
		return TableauBlancHelper.narrow(_this_object());
	}
	public TableauBlanc _this(org.omg.CORBA.ORB orb)
	{
		return TableauBlancHelper.narrow(_this_object(orb));
	}
	public TableauBlancOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(TableauBlancOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		else
		{
			return super._default_POA();
		}
	}
	public short[] get_pixel(int idpixel)
	{
		return _delegate.get_pixel(idpixel);
	}

	public boolean ajouter_pixel(short[] pixel)
	{
		return _delegate.ajouter_pixel(pixel);
	}

}
