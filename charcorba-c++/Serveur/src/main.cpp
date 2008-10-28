#include "serveur.h"

int main(int argc, char ** argv )
{	
	Serveur * serv_annuaire = new Serveur (argc,argv);
	serv_annuaire->demarrer();
	serv_annuaire->m_MICO_ORB->thread_lancement_orb->join();
	return 0;
}
