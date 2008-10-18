
#ifndef __ANNUAIRE_IMPL_H__
#define __ANNUAIRE_IMPL_H__

#include <annuaire.h>


// Implementation for interface Annuaire
class Annuaire_impl : virtual public POA_Annuaire
{
  public:

    CORBA::Boolean joindre_annuaire( const char* pseudo )
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Boolean quitter_annuaire( const char* pseudo )
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Boolean ajouter_tag( const char* pseudo, const char* tag )
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Boolean enlever_tag( const char* pseudo, const char* tag )
      throw(
        ::CORBA::SystemException)
    ;

    ::Annuaire::t_liste_string* get_amis_par_tag( const char* tag )
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
