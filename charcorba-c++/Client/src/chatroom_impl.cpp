#include <string>
#include <chatroom_impl.h>
#include <client.h>

using namespace std;

Chatroom_impl::Chatroom_impl ()
{}

Chatroom_impl::Chatroom_impl (string nom_chatroom)
	: m_nom_chatroom (nom_chatroom)
{}
	
// Implementation for interface Chatroom

CORBA::Boolean
Chatroom_impl::ajouter_message( const char* pseudo, const char* message )
  throw(
    ::CORBA::SystemException)

{
	cout << "[DEBUG]\t Ajout d'un message venant de '" << pseudo << "' sur le chat '" << m_nom_chatroom << endl;
	CORBA::Boolean retval;
	Message msg;
	msg.auteur = string(pseudo) ;
	msg.message = string(message) ;
	m_liste_messages.push_back(msg);
	return retval; 
}


::Chatroom::t_string_auteur*
Chatroom_impl::get_message( CORBA::ULong idmessage )
  throw(
    ::CORBA::SystemException)

{
  cout << "[DEBUG]\t[Chatroom - '" << m_nom_chatroom << "']\tDemande de réception du message " << idmessage << endl ;
  ::Chatroom::t_string_auteur* retval = new ::Chatroom::t_string_auteur ();
  retval->length(2);
  
  const char * c_auteur = m_liste_messages[idmessage].auteur.c_str() ;
  CORBA::String_var s_auteur (c_auteur);

  const char * c_message = m_liste_messages[idmessage].message.c_str() ;
  CORBA::String_var s_message (c_message);  
  
  (*retval)[0] = c_auteur ;
  (*retval)[1] = c_message ;
  return retval; 
}

void Chatroom_impl::inviter_client (string pseudo)
{
	cout << "[DEBUG]\t[Chatroom - '" << m_nom_chatroom << "']\tOn invite le client '" << pseudo << "'" << endl ;
/*	CORBA::Object_var service_distant = Client::m_client->m_MICO_ORB->connecter_service(pseudo);

	Standard_var standard_distant = Standard::_narrow(service_distant.in()) ;
	standard_distant->inviter_client(pseudo.c_str());*/
}
