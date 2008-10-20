
#include <standard_impl.h>


// Implementation for interface Standard

CORBA::Boolean
Standard_impl::ajouter_message( const char* pseudo, const char* message )
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


::Standard::t_liste_string*
Standard_impl::get_tag( const char* pseudo )
  throw(
    ::CORBA::SystemException)

{
  ::Standard::t_liste_string* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

