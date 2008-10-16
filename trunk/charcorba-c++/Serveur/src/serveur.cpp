// Libs perso
#include <annuaire_impl.h>
#include <serveur.h>

// Libs systeme
#include <orb.h>
#include <string>
#include <iostream>

#include <boost/thread/thread.hpp>

using namespace std;

Serveur::Serveur()
{}

Serveur::~Serveur()
{}

Serveur::Serveur(int argc, char ** argv) 
{
	cout << "[DEBUG]\tInitialisation du serveur" << endl ;
	m_MICO_ORB = new ORB (argc,argv,true) ;
	m_MICO_ORB->ajout_service(new Annuaire_impl (),"Annuaire");
}

void Serveur::demarrer()
{
	cout << "[DEBUG]\tDémarrage du serveur" << endl;
	m_MICO_ORB->demarrer();
	//boost::thread unThread(&(m_MICO_ORB->demarrer()));
}
