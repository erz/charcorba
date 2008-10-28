// Libs perso
#include <annuaire_impl.h>
#include <serveur.h>

// Libs systeme
#include <orb.h>
#include <string>
#include <iostream>

#include <CORBA.h>
#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

using namespace std;

Serveur::Serveur()
{}

Serveur::~Serveur()
{}

Serveur::Serveur(int argc, char ** argv) 
{
	cout << "[DEBUG]\tInitialisation du serveur" << endl ;
	m_MICO_ORB = new ORB (argc,argv,true) ;
	m_annuaire = new Annuaire_impl () ;
	m_MICO_ORB->ajout_service(m_annuaire,"Annuaire");
	m_MICO_ORB->connecter_service("Annuaire");
}

void Serveur::demarrer()
{
	cout << "[DEBUG]\tDémarrage du serveur" << endl;
	m_MICO_ORB->demarrer();
}
