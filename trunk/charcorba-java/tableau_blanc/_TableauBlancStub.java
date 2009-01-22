package tableau_blanc;

/**
 *	Generated from IDL interface "TableauBlanc"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _TableauBlancStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements TableauBlanc
{
	private String[] ids = {"IDL:TableauBlanc:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = TableauBlancOperations.class;
	public short[] get_pixel(int idpixel)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_pixel", true);
				_os.write_ulong(idpixel);
				_is = _invoke(_os);
				short[] _result = tableau_blanc.TableauBlancPackage.t_pixelHelper.read(_is);
				return _result;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_pixel", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			TableauBlancOperations _localServant = (TableauBlancOperations)_so.servant;
			short[] _result;			try
			{
			_result = _localServant.get_pixel(idpixel);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean ajouter_pixel(short[] pixel)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_pixel", true);
				tableau_blanc.TableauBlancPackage.t_pixelHelper.write(_os,pixel);
				_is = _invoke(_os);
				boolean _result = _is.read_boolean();
				return _result;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_pixel", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			TableauBlancOperations _localServant = (TableauBlancOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.ajouter_pixel(pixel);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public void sendc_get_pixel(AMI_TableauBlancHandler ami_handler, int idpixel)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_pixel", true);
				_os.write_ulong(idpixel);
				((org.jacorb.orb.Delegate)_get_delegate()).invoke(this, _os, ami_handler);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
			}
		}

	}

	public void sendc_ajouter_pixel(AMI_TableauBlancHandler ami_handler, short[] pixel)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_pixel", true);
				tableau_blanc.TableauBlancPackage.t_pixelHelper.write(_os,pixel);
				((org.jacorb.orb.Delegate)_get_delegate()).invoke(this, _os, ami_handler);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
			}
		}

	}

}
