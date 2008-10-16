
#ifndef __ANNUAIRE_IMPL_H__
#define __ANNUAIRE_IMPL_H__

#include <annuaire.h>
#include <map>

// Implementation for interface Annuaire
class Annuaire_impl : virtual public POA_Annuaire
{
  public:

	// Clef = pseudo, valeur= dernier ping
	std::multimap <std::string,unsigned int> ping_utilisateurs ; 

	// Clef = pseudo, valeurs = tags
    std::multimap <std::string,std::string> annuaire_utilisateurs ;
	
	// Clef = tags, valeurs = pseudo
	std::multimap <std::string,std::string> annuaire_tags ;

    CORBA::Boolean joindre_serveur( const char* pseudo )
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
