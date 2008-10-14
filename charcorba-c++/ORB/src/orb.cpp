#include <orb.h>
#include <CORBA.h>
#include <annuaire.h>
#include <coss/CosNaming.h>
#include <iostream>
#include <string>

#include <stdio.h>
#include <stdlib.h>

using namespace std;

ORB::ORB() 
{}

ORB::~ORB()
{}
	
ORB::ORB(int argc, char ** argv) 
{	
	m_ORB = CORBA::ORB_init (argc,argv);

	cout << "Initialisation ORB ok" << endl ;
	cout << "Démarrage de l'ORB ..." << endl ;

	m_POA = PortableServer::POA::_narrow (m_ORB->resolve_initial_references("RootPOA"));
	cout << "Initialisation POA ok" << endl ;
	
	m_serveur_de_noms  = CosNaming::NamingContext::_narrow (m_ORB->resolve_initial_references("NameService"));
	cout << "Initialisation NameService ok" << endl ;
	assert(!CORBA::is_nil(m_serveur_de_noms.in()));	

	m_POA->the_POAManager()->activate();

	cout << "Initilisation terminée" << endl ;
}

void ORB::demarrer ()
{
	try
	{
		m_ORB->run();
	}
	catch(CORBA::SystemException&)
	{
		cerr << "Exception Système CORBA" << endl;
	}
	catch(CORBA::Exception&)
	{
		cerr << "Exception CORBA" << endl;
	}
	catch(...)
	{
		cerr << "Exception inconnue" << endl;
	}
	cout << "ORB démarré" << endl ;
}

void ORB::arreter ()
{
	m_POA->destroy (TRUE,TRUE);
		
	for(int i=0;i<m_vect_services.size();++i)
	{
		delete m_vect_services[i];
	}
}

CORBA::Object_var ORB::connecter_servive  (std::string nom_service)
{
	CosNaming::Name c_nom_service;
	c_nom_service.length (1);
	c_nom_service[0].id = CORBA::string_dup (nom_service.c_str());	

	CORBA::Object_var obj1 = m_serveur_de_noms->resolve(c_nom_service);
	assert(!CORBA::is_nil(obj1.in()));

	return obj1 ;
}

void ORB::ajout_service(PortableServer::Servant service, std::string nom_service)
{
	cout << "Début ajout du service " << nom_service << endl ;
	CosNaming::Name c_nom_service;
	c_nom_service.length (1);
	c_nom_service[0].id = CORBA::string_dup (nom_service.c_str());	
	
	m_POA->activate_object (service);
	CORBA::Object_var ref_service_Annuaire = service->_this();
	m_serveur_de_noms->rebind (c_nom_service, ref_service_Annuaire.in());
	m_vect_services.push_back(service);
	cout << "Fin ajout du service" << endl ;
}
