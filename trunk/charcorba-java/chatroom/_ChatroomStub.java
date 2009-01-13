package chatroom;

/**
 *	Generated from IDL interface "Chatroom"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _ChatroomStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements Chatroom
{
	private String[] ids = {"IDL:Chatroom:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = ChatroomOperations.class;
	public java.lang.String[] get_message(int idmessage)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_message", true);
				_os.write_ulong(idmessage);
				_is = _invoke(_os);
				java.lang.String[] _result = chatroom.ChatroomPackage.t_string_auteurHelper.read(_is);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_message", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			ChatroomOperations _localServant = (ChatroomOperations)_so.servant;
			java.lang.String[] _result;			try
			{
			_result = _localServant.get_message(idmessage);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean ajouter_message(java.lang.String pseudo_client, java.lang.String message)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_message", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_message", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			ChatroomOperations _localServant = (ChatroomOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.ajouter_message(pseudo_client,message);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public void sendc_get_message(AMI_ChatroomHandler ami_handler, int idmessage)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_message", true);
				_os.write_ulong(idmessage);
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

	public void sendc_ajouter_message(AMI_ChatroomHandler ami_handler, java.lang.String pseudo_client, java.lang.String message)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_message", true);
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

}
