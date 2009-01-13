package chatroom;

/**
 *	Generated from IDL interface "AMI_ChatroomHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _AMI_ChatroomHandlerStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements AMI_ChatroomHandler
{
	private String[] ids = {"IDL:AMI_ChatroomHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = AMI_ChatroomHandlerOperations.class;
	public void get_message_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_message_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_message_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_ChatroomHandlerOperations _localServant = (AMI_ChatroomHandlerOperations)_so.servant;
			try
			{
			_localServant.get_message_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void get_message(java.lang.String[] ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_message", true);
				chatroom.ChatroomPackage.t_string_auteurHelper.write(_os,ami_return_val);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_message", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_ChatroomHandlerOperations _localServant = (AMI_ChatroomHandlerOperations)_so.servant;
			try
			{
			_localServant.get_message(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void ajouter_message_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_message_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_message_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_ChatroomHandlerOperations _localServant = (AMI_ChatroomHandlerOperations)_so.servant;
			try
			{
			_localServant.ajouter_message_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void ajouter_message(boolean ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_message", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_message", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_ChatroomHandlerOperations _localServant = (AMI_ChatroomHandlerOperations)_so.servant;
			try
			{
			_localServant.ajouter_message(ami_return_val);
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
