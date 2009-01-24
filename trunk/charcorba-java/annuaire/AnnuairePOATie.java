package annuaire;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "Annuaire"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class AnnuairePOATie
	extends AnnuairePOA
{
	private AnnuaireOperations _delegate;

	private POA _poa;
	public AnnuairePOATie(AnnuaireOperations delegate)
	{
		_delegate = delegate;
	}
	public AnnuairePOATie(AnnuaireOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public Annuaire _this()
	{
		return AnnuaireHelper.narrow(_this_object());
	}
	public Annuaire _this(org.omg.CORBA.ORB orb)
	{
		return AnnuaireHelper.narrow(_this_object(orb));
	}
	public AnnuaireOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(AnnuaireOperations delegate)
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
	public boolean ajouter_tag(java.lang.String pseudo_client, java.lang.String tag)
	{
		return _delegate.ajouter_tag(pseudo_client,tag);
	}

	public boolean quitter_annuaire(java.lang.String pseudo_client)
	{
		return _delegate.quitter_annuaire(pseudo_client);
	}

	public java.lang.String[] get_amis_par_tag(java.lang.String tag)
	{
		return _delegate.get_amis_par_tag(tag);
	}

	public boolean enlever_tag(java.lang.String pseudo_client, java.lang.String tag)
	{
		return _delegate.enlever_tag(pseudo_client,tag);
	}

	public boolean joindre_annuaire(java.lang.String pseudo_client)
	{
		return _delegate.joindre_annuaire(pseudo_client);
	}

}
