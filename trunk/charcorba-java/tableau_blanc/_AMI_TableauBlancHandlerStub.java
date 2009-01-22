package tableau_blanc;

/**
 *	Generated from IDL interface "AMI_TableauBlancHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _AMI_TableauBlancHandlerStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements AMI_TableauBlancHandler
{
	private String[] ids = {"IDL:AMI_TableauBlancHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = AMI_TableauBlancHandlerOperations.class;
	public void get_pixel(short[] ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_pixel", true);
				tableau_blanc.TableauBlancPackage.t_pixelHelper.write(_os,ami_return_val);
				_is = _invoke(_os);
				return;
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
			AMI_TableauBlancHandlerOperations _localServant = (AMI_TableauBlancHandlerOperations)_so.servant;
			try
			{
			_localServant.get_pixel(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void ajouter_pixel(boolean ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_pixel", true);
				_os.write_boolean(ami_return_val);
				_is = _invoke(_os);
				return;
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
			AMI_TableauBlancHandlerOperations _localServant = (AMI_TableauBlancHandlerOperations)_so.servant;
			try
			{
			_localServant.ajouter_pixel(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void ajouter_pixel_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_pixel_excep", true);
				((org.omg.CORBA_2_3.portable.OutputStream)_os).write_value (excep_holder );
				_is = _invoke(_os);
				return;
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_pixel_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_TableauBlancHandlerOperations _localServant = (AMI_TableauBlancHandlerOperations)_so.servant;
			try
			{
			_localServant.ajouter_pixel_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void get_pixel_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_pixel_excep", true);
				((org.omg.CORBA_2_3.portable.OutputStream)_os).write_value (excep_holder );
				_is = _invoke(_os);
				return;
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_pixel_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_TableauBlancHandlerOperations _localServant = (AMI_TableauBlancHandlerOperations)_so.servant;
			try
			{
			_localServant.get_pixel_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

}
