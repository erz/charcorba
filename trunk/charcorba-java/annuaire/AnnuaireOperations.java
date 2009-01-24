package annuaire;

/**
 *	Generated from IDL interface "Annuaire"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface AnnuaireOperations
{
	/* constants */
	/* operations  */
	boolean joindre_annuaire(java.lang.String pseudo_client);
	boolean quitter_annuaire(java.lang.String pseudo_client);
	boolean ajouter_tag(java.lang.String pseudo_client, java.lang.String tag);
	boolean enlever_tag(java.lang.String pseudo_client, java.lang.String tag);
	java.lang.String[] get_amis_par_tag(java.lang.String tag);
}
