package Client;

/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _StandardStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements Standard
{
	private String[] ids = {"IDL:Standard:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = StandardOperations.class;
	public boolean afficher_message(java.lang.String pseudo_client, java.lang.String message)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "afficher_message", true);
				_os.write_string(pseudo_client);
				_os.write_string(message);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "afficher_message", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			StandardOperations _localServant = (StandardOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.afficher_message(pseudo_client,message);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean ping()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ping", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ping", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			StandardOperations _localServant = (StandardOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.ping();
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean inviter_client(java.lang.String chatroom)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "inviter_client", true);
				_os.write_string(chatroom);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "inviter_client", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			StandardOperations _localServant = (StandardOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.inviter_client(chatroom);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean signal_chatroom(java.lang.String chatroom)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "signal_chatroom", true);
				_os.write_string(chatroom);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "signal_chatroom", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			StandardOperations _localServant = (StandardOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.signal_chatroom(chatroom);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public void sendc_afficher_message(AMI_StandardHandler ami_handler, java.lang.String pseudo_client, java.lang.String message)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "afficher_message", true);
				_os.write_string(pseudo_client);
				_os.write_string(message);
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

	public void sendc_ping(AMI_StandardHandler ami_handler)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ping", true);
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

	public void sendc_inviter_client(AMI_StandardHandler ami_handler, java.lang.String chatroom)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "inviter_client", true);
				_os.write_string(chatroom);
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

	public void sendc_signal_chatroom(AMI_StandardHandler ami_handler, java.lang.String chatroom)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "signal_chatroom", true);
				_os.write_string(chatroom);
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
