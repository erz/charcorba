
#include <chatroom_impl.h>


// Implementation for interface Chatroom

CORBA::Boolean
Chatroom_impl::ajouter_message( const char* pseudo, const char* message )
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


::Chatroom::t_string_auteur*
Chatroom_impl::get_message( CORBA::ULong idmessage )
  throw(
    ::CORBA::SystemException)

{
  ::Chatroom::t_string_auteur* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

