
#include <standard_impl.h>
#include <string>
#include <map>
#include <iostream>

using namespace std ;
// Implementation for interface Standard
Standard_impl * Standard_impl::m_static_standard = 0 ;

Standard_impl::Standard_impl()
{
	Standard_impl::m_static_standard = this ;
}


CORBA::Boolean
Standard_impl::ajouter_message( const char* pseudo, const char* message )
  throw(
    ::CORBA::SystemException)

{
  cout << "[DEBUG]\tEnvoie Message '\n" << message << endl ;
  CORBA::Boolean retval ;
  retval = true;
  Liste_Messages.insert(pair<string,string>(string(pseudo),string(message)));
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
