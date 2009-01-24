package annuaire;

/**
 *	Generated from IDL interface "AMI_AnnuaireHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface AMI_AnnuaireHandlerOperations
	extends org.omg.Messaging.ReplyHandlerOperations
{
	/* constants */
	/* operations  */
	void joindre_annuaire(boolean ami_return_val);
	void joindre_annuaire_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void quitter_annuaire(boolean ami_return_val);
	void quitter_annuaire_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void ajouter_tag(boolean ami_return_val);
	void ajouter_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void enlever_tag(boolean ami_return_val);
	void enlever_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder);
	void get_amis_par_tag(java.lang.String[] ami_return_val);
	void get_amis_par_tag_excep(org.omg.Messaging.ExceptionHolder excep_holder);
}
