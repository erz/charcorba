
#include <client_impl.h>


// Implementation for interface Client

CORBA::Boolean
Client_impl::ajouter_message( const char* pseudo, const char* message )
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


::Client::t_liste_string*
Client_impl::get_tag( const char* pseudo )
  throw(
    ::CORBA::SystemException)

{
  ::Client::t_liste_string* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

