
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
Standard_impl::afficher_message(const char* pseudo,const char* message)
  throw(
    ::CORBA::SystemException)
{
  cout << "[DEBUG]\tAffichage du message '" << message << "' venant de '" << pseudo << "'" << endl ;
  CORBA::Boolean retval ;
  retval = true;
  return retval; 
}

CORBA::Boolean
Standard_impl::inviter_client( const char* chatroom )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval = true ;
  
  return retval;
}


