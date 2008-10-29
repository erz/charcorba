#include "client.h"
#include "annuaire.h"
#include "standard_impl.h"
#include "orb.h"

#include <string>
#include <set>
#include <map>

#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

using namespace std;
 
Client::Client()
{}

Client::Client(int argc, char ** argv)  
{
	m_MICO_ORB = new ORB (argc,argv,true) ;	
	m_standard = new Standard_impl() ;
}

Client::~Client()
{}

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
			liste_amis.insert(string(ami));	
			cout << "[DEBUG]\tNouvel ami : '" << ami << "'" << endl ;
		}
	}
}

void Client::afficher_message(string pseudo,string message)
{
	CORBA::Object_var service_distant = m_MICO_ORB->connecter_service(pseudo);

	m_service_client = Standard::_narrow(service_distant.in()) ;
	m_service_client->afficher_message(m_pseudo.c_str(),message.c_str());
}

void Client::demarrer()
{
	cout << "[DEBUG]\tDémarrage du client" << endl;
	m_MICO_ORB->demarrer();
}
