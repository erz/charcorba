#include <orb.h>
#include <CORBA.h>
#include <annuaire.h>
#include <coss/CosNaming.h>
#include <iostream>
#include <string>

#include <stdio.h>
#include <stdlib.h>

ORB * ORB::static_ORB = NULL ;

using namespace std;

ORB::ORB() 
{
}

ORB::~ORB()
{}
	
ORB::ORB(int argc, char ** argv, bool activer_POA) 
{	
	cout << "[DEBUG]\tInitialisation ORB" << endl ;
	m_ORB = CORBA::ORB_init (argc,argv);
	ORB::static_ORB = this ;
	if ( activer_POA ) 
	{
		cout << "[DEBUG]\tActivation POA" << endl ;		
		m_POA = PortableServer::POA::_narrow (m_ORB->resolve_initial_references("RootPOA"));
		m_POA->the_POAManager()->activate();
	}

	cout << "[DEBUG]\tConnexion au NameService" << endl ;			
	m_serveur_de_noms  = CosNaming::NamingContext::_narrow (m_ORB->resolve_initial_references("NameService"));
	assert(!CORBA::is_nil(m_serveur_de_noms.in()));	
}

void f_thread_lancement_orb (ORB * MICO_ORB )
{
	cout << "[DEBUG]\tThread lancement ORB" << endl ;
	try
	{
		cout << "[DEBUG]\tDémarrage de l'ORB" << endl;
		MICO_ORB->m_ORB->run();
	}
	catch(CORBA::SystemException&)
	{
		cerr << "[DEBUG]\tException Système CORBA" << endl;
	}
	catch(CORBA::Exception&)
	{
		cerr << "[DEBUG]\tException CORBA" << endl;
	}
	catch(...)
	{
		cerr << "[DEBUG]\tException inconnue" << endl;
	}
}

CORBA::Object_var ORB::connecter_service  (std::string nom_service)
{
	CosNaming::Name c_nom_service;
	c_nom_service.length (1);
	c_nom_service[0].id = CORBA::string_dup (nom_service.c_str());	
	
	CORBA::Object_var obj1 ;
	try
	{
		obj1 = m_serveur_de_noms->resolve(c_nom_service);
	}
	catch(CosNaming::NamingContext::NotFound &exc)
	{
		cout << "[DEBUG]\tService '" << nom_service << "' non trouvé ..." << endl;	
	}
	return obj1 ;
}

void ORB::demarrer ()
{
	thread_lancement_orb = new boost::thread ( boost::bind( &f_thread_lancement_orb, this) );	
}

void ORB::arreter ()
{
	m_POA->destroy (TRUE,TRUE);
}

void ORB::ajout_service(PortableServer::Servant service, std::string nom_service)
{
	cout << "[DEBUG]\tAjout du service : '" << nom_service << "'" << endl ;
	CosNaming::Name c_nom_service;
	c_nom_service.length (1);
	c_nom_service[0].id = CORBA::string_dup (nom_service.c_str());	
	
	m_POA->activate_object (service);
	CORBA::Object_var ref_service_Annuaire = service->_this();
	m_serveur_de_noms->rebind (c_nom_service, ref_service_Annuaire.in());
}
