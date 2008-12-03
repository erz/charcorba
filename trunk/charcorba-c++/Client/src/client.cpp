#include "client.h"
#include <QString>
#include "annuaire.h"
#include "standard_impl.h"
#include "orb.h"
#include <chatroom_impl.h>

#include <string>
#include <set>
#include <map>

#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>


using namespace std;
 
Client * Client::singleton_client = NULL ;
 
Client::Client()
	: QObject ()
{}

Client::~Client()
{
	arreter();
	delete m_standard;
	delete m_MICO_ORB;
}


Client::Client(int argc, char ** argv)  
{
	m_MICO_ORB = new ORB (argc,argv,true) ;	
	m_standard = new Standard_impl();
	Client::singleton_client = this ;
}

Client * Client::get_instance ()
{
	return Client::singleton_client ;
}

void Client::set_pseudo (string pseudo)
{	
	cout << "[DEBUG]\tPseudo client : " << pseudo << endl;
	m_pseudo = pseudo ;
	m_MICO_ORB->ajout_service(m_standard,pseudo);	
}

void Client::joindre_annuaire()
{
	std::cout << "[DEBUG]\tConnexion au service d'annuaire" << std::endl ;
	CORBA::Object_var service = m_MICO_ORB->connecter_service("Annuaire");
	
	m_service_annuaire = Annuaire::_narrow(service.in()) ;
	m_service_annuaire->joindre_annuaire(m_pseudo.c_str());

	if (CORBA::is_nil(m_service_annuaire))
	{
		cerr << "[DEBUG]\tL'IOR n'est pas une référence sur un service." << endl;
	}
}

void Client::ajouter_tag (string tag)
{
	cout << "[DEBUG]\tAjouter tag : " << tag << endl ;
	m_service_annuaire->ajouter_tag(m_pseudo.c_str(),tag.c_str());
	liste_tags.insert(tag);
}

void Client::enlever_tag (string tag)
{
	cout << "[DEBUG]\tEnlever tag : " << tag << endl ;
	//m_service_annuaire->ajouter_tag(m_pseudo.c_str(),tag.c_str());
	liste_tags.erase(tag);
}

void Client::get_amis_par_tag (string tag)
{
	cout << "[DEBUG]\tRecherche de nouveaux amis possédants le tag : '" << tag << "'" << endl;
	::Annuaire::t_liste_string* retval = m_service_annuaire->get_amis_par_tag(tag.c_str()) ;
	CORBA::ULong i=0;
	for (i=0;i< retval->length();++i)
	{
		CORBA::String_var ami = (*retval)[i] ;
		if (string(ami) != m_pseudo) 
		{
			ajouter_ami(string(ami));
		}
	}
}

void Client::ajouter_ami (string ami)
{
	liste_amis.insert(string(ami));	
	cout << "[DEBUG]\tNouvel ami : '" << ami << "'" << endl ;
	emit ami_ajoute(QString(ami.c_str()));
}

/*string Client::ami_ajoute (string ami)
{
	return ami;
}*/

void Client::afficher_message(string pseudo,string message)
{
	CORBA::Object_var service_distant = m_MICO_ORB->connecter_service(pseudo);

	Standard_var standard_distant = Standard::_narrow(service_distant.in()) ;
	standard_distant->afficher_message(m_pseudo.c_str(),message.c_str());
}

void Client::demarrer()
{
	cout << "[DEBUG]\tDémarrage du client" << endl;
	m_MICO_ORB->demarrer();
}

void Client::arreter()
{
	cout << "[DEBUG]\tArret du client" << endl ;
	m_MICO_ORB->arreter();
}

void Client::creer_chatroom (string nom_chatroom)
{
	cout << "[DEBUG]\tCréation de la chatroom '" << nom_chatroom << "'" << endl ;
	Chatroom_impl * chatroom = new Chatroom_impl(nom_chatroom);
	
	m_liste_chatrooms_locales.insert( pair<string,Chatroom_impl *>(nom_chatroom,chatroom));
	m_MICO_ORB->ajout_service(chatroom,nom_chatroom);
}

void Client::inviter_client_chatroom (string pseudo,string nom_chatroom)
{
	m_liste_chatrooms_locales[nom_chatroom]->inviter_client(pseudo) ;
}

void Client::ajouter_message(string nom_chatroom,string message)
{
	m_liste_chatrooms_distantes[nom_chatroom]->ajouter_message (m_pseudo.c_str(),message.c_str());
}

Message Client::get_message (string nom_chatroom,unsigned long idmessage)
{
	cout << "[DEBUG]\tRéception du message " << idmessage << " de la chatroom " << nom_chatroom << endl ;
	::Chatroom::t_string_auteur * retval = m_liste_chatrooms_distantes[nom_chatroom]->get_message(idmessage) ;
	CORBA::String_var auteur = (*retval)[0] ;
	CORBA::String_var message = (*retval)[1] ;

	Message msg;
	msg.auteur = auteur;
	msg.message = message;
	cout << "[DEBUG]\tAuteur :\t" << msg.auteur << endl ;
	cout << "[DEBUG]\tMessage :\t" << msg.message << endl ;
	return msg ;
}
