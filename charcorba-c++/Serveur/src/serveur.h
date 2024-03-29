#ifndef SERVEUR_H
#define SERVEUR_H

#include <orb.h>
#include <annuaire_impl.h>

#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

class Serveur
{
	
	public:
		Annuaire_impl * m_annuaire ; 
		ORB * m_MICO_ORB ;
		boost::thread * thread_ping_utilisateurs ;
		
		Serveur();
		~Serveur();
		Serveur(int, char **);
		void demarrer();
		void ping_utilisateurs ();
};

#endif
