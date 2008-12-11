
#include <standard_impl.h>
#include <string>
#include <map>
#include <iostream>
#include <chatroom.h>
#include <client.h>

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
	cout << "[DEBUG - Standard]\tAffichage du message '" << message << "' venant de '" << pseudo << "'" << endl ;
	CORBA::Boolean retval ;
	retval = true;
    Client::get_instance()->message_recu(QString(pseudo),QString(message));
	return retval; 
}

CORBA::Boolean
Standard_impl::inviter_client( const char* chatroom )
  throw(
    ::CORBA::SystemException)

{
	cout << "[DEBUG - Standard]\tRéception d'une invitation à participer au chat '" << chatroom << "'" << endl ;
	CORBA::Boolean retval = true ;
	
	
	CORBA::Object_var service = Client::get_instance()->m_MICO_ORB->connecter_service(chatroom);
	
	Chatroom_var service_chatroom ;
	service_chatroom = Chatroom::_narrow(service.in()) ;

	if (CORBA::is_nil(service_chatroom))
	{
		cerr << "[DEBUG]\tL'IOR n'est pas une référence sur un service." << endl;
	}
	
	Client::get_instance()->m_liste_chatrooms_distantes.insert( pair<string,Chatroom_var>(string(chatroom),service_chatroom));
	return retval;
}

CORBA::Boolean
Standard_impl::signal_chatroom( const char* chatroom )
  throw(
    ::CORBA::SystemException)

{
	CORBA::Boolean retval;
	return retval;
}

CORBA::Boolean
Standard_impl::ping()
  throw(
    ::CORBA::SystemException)

{
	CORBA::Boolean retval = true ;
	return retval;
}

