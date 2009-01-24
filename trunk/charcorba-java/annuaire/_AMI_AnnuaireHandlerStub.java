package annuaire;

/**
 *	Generated from IDL interface "AMI_AnnuaireHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _AMI_AnnuaireHandlerStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements AMI_AnnuaireHandler
{
	private String[] ids = {"IDL:AMI_AnnuaireHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = AMI_AnnuaireHandlerOperations.class;
	public void quitter_annuaire(boolean ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "quitter_annuaire", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "quitter_annuaire", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.quitter_annuaire(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void enlever_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "enlever_tag_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "enlever_tag_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.enlever_tag_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void enlever_tag(boolean ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "enlever_tag", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "enlever_tag", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.enlever_tag(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void joindre_annuaire_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "joindre_annuaire_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "joindre_annuaire_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.joindre_annuaire_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void joindre_annuaire(boolean ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "joindre_annuaire", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "joindre_annuaire", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.joindre_annuaire(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void ajouter_tag(boolean ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_tag", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_tag", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.ajouter_tag(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void quitter_annuaire_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "quitter_annuaire_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "quitter_annuaire_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.quitter_annuaire_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void get_amis_par_tag(java.lang.String[] ami_return_val)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_amis_par_tag", true);
				annuaire.AnnuairePackage.t_liste_stringHelper.write(_os,ami_return_val);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_amis_par_tag", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.get_amis_par_tag(ami_return_val);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void get_amis_par_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_amis_par_tag_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_amis_par_tag_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.get_amis_par_tag_excep(excep_holder);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public void ajouter_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_tag_excep", true);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_tag_excep", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AMI_AnnuaireHandlerOperations _localServant = (AMI_AnnuaireHandlerOperations)_so.servant;
			try
			{
			_localServant.ajouter_tag_excep(excep_holder);
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
