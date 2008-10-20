
#ifndef __ANNUAIRE_IMPL_H__
#define __ANNUAIRE_IMPL_H__

#include <boost/progress.hpp>
#include <annuaire.h>
#include <map>

#include <client_annuaire.h>

using boost::timer;

// Implementation for interface Annuaire
class Annuaire_impl : virtual public POA_Annuaire
{
  public:

	static Annuaire_impl * m_static_annuaire  ;

	// Clef = pseudo, valeur= dernier ping
	std::map <std::string,Client_annuaire> m_liste_clients ; 

	Annuaire_impl();

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
