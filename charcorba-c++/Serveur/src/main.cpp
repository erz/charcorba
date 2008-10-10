#include "serveur.h"

int main(int argc, char ** argv )
{	
	Serveur * serv_annuaire = new Serveur (argc,argv);
	serv_annuaire->demarrer();
	return 0;	
}
