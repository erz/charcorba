package annuaire;

/**
 *	Generated from IDL interface "Annuaire"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class _AnnuaireStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements Annuaire
{
	private String[] ids = {"IDL:Annuaire:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = AnnuaireOperations.class;
	public boolean ajouter_tag(java.lang.String pseudo_client, java.lang.String tag)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_tag", true);
				_os.write_string(pseudo_client);
				_os.write_string(tag);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "ajouter_tag", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AnnuaireOperations _localServant = (AnnuaireOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.ajouter_tag(pseudo_client,tag);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean quitter_annuaire(java.lang.String pseudo_client)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "quitter_annuaire", true);
				_os.write_string(pseudo_client);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "quitter_annuaire", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AnnuaireOperations _localServant = (AnnuaireOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.quitter_annuaire(pseudo_client);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public java.lang.String[] get_amis_par_tag(java.lang.String tag)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_amis_par_tag", true);
				_os.write_string(tag);
				_is = _invoke(_os);
				java.lang.String[] _result = annuaire.AnnuairePackage.t_liste_stringHelper.read(_is);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "get_amis_par_tag", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AnnuaireOperations _localServant = (AnnuaireOperations)_so.servant;
			java.lang.String[] _result;			try
			{
			_result = _localServant.get_amis_par_tag(tag);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean enlever_tag(java.lang.String pseudo_client, java.lang.String tag)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "enlever_tag", true);
				_os.write_string(pseudo_client);
				_os.write_string(tag);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "enlever_tag", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AnnuaireOperations _localServant = (AnnuaireOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.enlever_tag(pseudo_client,tag);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public boolean joindre_annuaire(java.lang.String pseudo_client)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "joindre_annuaire", true);
				_os.write_string(pseudo_client);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "joindre_annuaire", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			AnnuaireOperations _localServant = (AnnuaireOperations)_so.servant;
			boolean _result;			try
			{
			_result = _localServant.joindre_annuaire(pseudo_client);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return _result;
		}

		}

	}

	public void sendc_ajouter_tag(AMI_AnnuaireHandler ami_handler, java.lang.String pseudo_client, java.lang.String tag)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "ajouter_tag", true);
				_os.write_string(pseudo_client);
				_os.write_string(tag);
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

	public void sendc_quitter_annuaire(AMI_AnnuaireHandler ami_handler, java.lang.String pseudo_client)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "quitter_annuaire", true);
				_os.write_string(pseudo_client);
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

	public void sendc_get_amis_par_tag(AMI_AnnuaireHandler ami_handler, java.lang.String tag)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "get_amis_par_tag", true);
				_os.write_string(tag);
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

	public void sendc_enlever_tag(AMI_AnnuaireHandler ami_handler, java.lang.String pseudo_client, java.lang.String tag)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "enlever_tag", true);
				_os.write_string(pseudo_client);
				_os.write_string(tag);
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

	public void sendc_joindre_annuaire(AMI_AnnuaireHandler ami_handler, java.lang.String pseudo_client)
	{
		while(true)
		{
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "joindre_annuaire", true);
				_os.write_string(pseudo_client);
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
