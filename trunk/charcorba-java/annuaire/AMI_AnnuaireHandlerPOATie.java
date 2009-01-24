package annuaire;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "AMI_AnnuaireHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class AMI_AnnuaireHandlerPOATie
	extends AMI_AnnuaireHandlerPOA
{
	private AMI_AnnuaireHandlerOperations _delegate;

	private POA _poa;
	public AMI_AnnuaireHandlerPOATie(AMI_AnnuaireHandlerOperations delegate)
	{
		_delegate = delegate;
	}
	public AMI_AnnuaireHandlerPOATie(AMI_AnnuaireHandlerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AMI_AnnuaireHandler _this()
	{
		return AMI_AnnuaireHandlerHelper.narrow(_this_object());
	}
	public AMI_AnnuaireHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_AnnuaireHandlerHelper.narrow(_this_object(orb));
	}
	public AMI_AnnuaireHandlerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(AMI_AnnuaireHandlerOperations delegate)
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
	public void quitter_annuaire(boolean ami_return_val)
	{
_delegate.quitter_annuaire(ami_return_val);
	}

	public void enlever_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.enlever_tag_excep(excep_holder);
	}

	public void enlever_tag(boolean ami_return_val)
	{
_delegate.enlever_tag(ami_return_val);
	}

	public void joindre_annuaire_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.joindre_annuaire_excep(excep_holder);
	}

	public void joindre_annuaire(boolean ami_return_val)
	{
_delegate.joindre_annuaire(ami_return_val);
	}

	public void ajouter_tag(boolean ami_return_val)
	{
_delegate.ajouter_tag(ami_return_val);
	}

	public void quitter_annuaire_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.quitter_annuaire_excep(excep_holder);
	}

	public void get_amis_par_tag(java.lang.String[] ami_return_val)
	{
_delegate.get_amis_par_tag(ami_return_val);
	}

	public void get_amis_par_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.get_amis_par_tag_excep(excep_holder);
	}

	public void ajouter_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.ajouter_tag_excep(excep_holder);
	}

}
