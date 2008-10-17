#include "serveur.h"

int main(int argc, char ** argv )
{	
	Serveur * serv_annuaire = new Serveur (argc,argv);
	serv_annuaire->demarrer();
	serv_annuaire->thread_lancement_orb->join();
	return 0;
}
