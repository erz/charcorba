// Libs perso
#include <annuaire_impl.h>
#include <serveur.h>

// Libs systeme
#include <orb.h>
#include <string>

#include <boost/thread/thread.hpp>

using namespace std;

Serveur::Serveur()
{}

Serveur::~Serveur()
{}

Serveur::Serveur(int argc, char ** argv) 
{
	m_MICO_ORB = new ORB (argc,argv) ;
	m_MICO_ORB->ajout_service(new Annuaire_impl (),"Annuaire");
}

void Serveur::demarrer()
{
	m_MICO_ORB->demarrer();
	//boost::thread unThread(&(m_MICO_ORB->demarrer()));
}
