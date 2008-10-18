
#include <annuaire_impl.h>


// Implementation for interface Annuaire

CORBA::Boolean
Annuaire_impl::joindre_annuaire( const char* pseudo )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}


CORBA::Boolean
Annuaire_impl::quitter_annuaire( const char* pseudo )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}


CORBA::Boolean
Annuaire_impl::ajouter_tag( const char* pseudo, const char* tag )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}


CORBA::Boolean
Annuaire_impl::enlever_tag( const char* pseudo, const char* tag )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}


::Annuaire::t_liste_string*
Annuaire_impl::get_amis_par_tag( const char* tag )
  throw(
    ::CORBA::SystemException)

{
  ::Annuaire::t_liste_string* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

