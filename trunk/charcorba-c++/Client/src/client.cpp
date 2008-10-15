#include "client.h"
#include "annuaire.h"
#include "orb.h"

Client::Client()
{}

Client::Client(int argc, char ** argv)  
{
	m_MICO_ORB = new ORB (argc,argv,false) ;		
}

Client::~Client()
{}

void Client::ajout_annuaire()
{
	std::cout << "Connection au service ..." << std::endl ;
	CORBA::Object_var service = m_MICO_ORB->connecter_servive("Annuaire");
	std::cout << "OK ..." << std::endl ;
	
	std::cout << "Conversion en service Annuaire ..." << std::endl ;
	Annuaire_var service_annuaire = Annuaire::_narrow(service.in()) ;
	std::cout << "Fin conversion" << std::endl ;

	if (CORBA::is_nil(service_annuaire))
	{
		std::cerr << "L'IOR n'est pas une référence sur un service." << std::endl;
	}
	
    service_annuaire->inscrire_serveur("trix");
	service_annuaire->nouveau_tag("trix","geek");
	std::cout << "Ajout coté client effectué ..." << std::endl ;
}

