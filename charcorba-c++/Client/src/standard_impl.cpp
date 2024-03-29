#include <standard_impl.h>
#include <string>
#include <map>
#include <iostream>
#include <chatroom.h>
#include <client.h>
#include <tableau_blanc.h>

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
Standard_impl::inviter_client_chatroom ( const char* chatroom )
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
	
	QString tmp = QString::fromStdString(chatroom);
	Client::get_instance()->signal_invitation_chatroom(tmp);
	return retval;
}

CORBA::Boolean
Standard_impl::inviter_client_tableaublanc ( const char* tableau )
  throw(
    ::CORBA::SystemException)
{
	cout << "[DEBUG - Standard]\tRéception d'une invitation à participer au tableau blanc '" << tableau << "'" << endl ;
	
	CORBA::Boolean retval = true ;
	
	CORBA::Object_var service = Client::get_instance()->m_MICO_ORB->connecter_service(tableau);
	
	TableauBlanc_var service_tableaublanc ;
	service_tableaublanc = TableauBlanc::_narrow(service.in()) ;

	if (CORBA::is_nil(service_tableaublanc))
	{
		cerr << "[DEBUG]\tL'IOR n'est pas une référence sur un service." << endl;
	}
	
	Client::get_instance()->m_liste_tableauxblancs_distants.insert( pair<string,TableauBlanc_var>(string(tableau),service_tableaublanc));
	
	QString tmp = QString::fromStdString(tableau);
	Client::get_instance()->participer_tableau_blanc(tmp);
	
	return retval;
}

CORBA::Boolean
Standard_impl::signal_chatroom( const char* chatroom, CORBA::ULong idpixel )
  throw(
    ::CORBA::SystemException)
{
	CORBA::Boolean retval;
	Client::get_instance()->signal_chatroom(chatroom);
	return retval;
}

CORBA::Boolean
Standard_impl::signal_tableaublanc( const char* tableau, CORBA::ULong idpixel )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;
  Client::get_instance()->sync_tableau_blanc (QString (tableau),idpixel);
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

