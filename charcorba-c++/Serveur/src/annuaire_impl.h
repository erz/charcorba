
#ifndef __ANNUAIRE_IMPL_H__
#define __ANNUAIRE_IMPL_H__

#include <annuaire.h>
#include <map>

// Implementation for interface Annuaire
class Annuaire_impl : virtual public POA_Annuaire
{
  public:

	// Clef = pseudo, valeur= dernier ping
	std::map <std::string,unsigned int> ping_utilisateurs ; 

	// Clef = pseudo, valeurs = tags
    // Utilisée pour l'ajout / la suppression / la recherche d'un client
    std::multimap <std::string,std::string> annuaire_utilisateurs ;
	
	// Clef = tags, valeurs = pseudo
	// Utilisée afin de connaitre les clients associés à un tag
	std::multimap <std::string,std::string> annuaire_tags ;

    CORBA::Boolean joindre_annuaire( const char* pseudo )
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Boolean ajouter_tag( const char* pseudo, const char* tag )
      throw(
        ::CORBA::SystemException)
    ;

    ::Annuaire::t_liste_string* get_amis_par_tag( const char* tag )
      throw(
        ::CORBA::SystemException)
    ;

};


#endif
