#include <iostream>
#include <string>
#include <map>
#include <client_impl.h>

using namespace std ;
// Implementation for interface Client_Distant

CORBA::Boolean
Client_Distant_impl::ajouter_message( const char* pseudo, const char* message )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  client_message.insert(pair<string,string>(string(pseudo),string(message)));

  return retval; 
}


::Client_Distant::t_liste_string*
Client_Distant_impl::get_tag( const char* pseudo )
  throw(
    ::CORBA::SystemException)

{
  ::Client_Distant::t_liste_string* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

