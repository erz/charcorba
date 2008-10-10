#ifndef SERVEUR_H
#define SERVEUR_H

#include "orb.h"

class Serveur
{
	private:
		ORB * m_MICO_ORB ;
	public:
		Serveur();
		~Serveur();
		Serveur(int, char **);
		void demarrer();
};

#endif
