#include "client.h"
#include "annuaire.h"
#include "orb.h"

#include <string>
using namespace std;
 
Client::Client()
{}

Client::Client(int argc, char ** argv, string pseudo)  
	: m_pseudo (pseudo)
{
	cout << "[DEBUG]\tPseudo client : " << pseudo << endl;
	m_MICO_ORB = new ORB (argc,argv,false) ;		
}

Client::~Client()
{}

void Client::ajout_annuaire()
{
	std::cout << "[DEBUG]\tConnexion au service d'annuaire" << std::endl ;
	CORBA::Object_var service = m_MICO_ORB->connecter_servive("Annuaire");
	
	m_service_annuaire = Annuaire::_narrow(service.in()) ;
    m_service_annuaire->inscrire_serveur(m_pseudo.c_str());
    
	if (CORBA::is_nil(m_service_annuaire))
	{
		cerr << "[DEBUG]\tL'IOR n'est pas une référence sur un service." << endl;
	}
}

void Client::nouveau_tag (string tag)
{
	cout << "[DEBUG]\tNouveau tag : " << tag << endl ;
	m_service_annuaire->nouveau_tag(m_pseudo.c_str(),tag.c_str());
}

void Client::get_amis_par_tag (string tag)
{
	cout << "[DEBUG]\tRecherche de nouveaux amis possédants le tag : '" << tag << "'" << endl;
	::Annuaire::t_liste_string* retval = m_service_annuaire->get_amis_par_tag(tag.c_str()) ;
	CORBA::ULong i=0;
	for (i=0;i< retval->length();++i)
	{
		CORBA::String_var ami = (*retval)[i] ;
		cout << "[DEBUG]\tNouvel ami : " << ami << endl ;
	}
}
