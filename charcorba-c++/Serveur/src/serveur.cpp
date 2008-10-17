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
}

void f_thread_ping_utilisateurs(Annuaire_impl * annuaire, ORB * MICO_ORB )
{
	cout << "[DEBUG]\tPing des utilisateurs" << endl ;
	
	while (1)
	{
		/*	Penser à tout gérer avec des timers
			Un timer par client
			std::map <std::string,TIMER ??> ping_utilisateurs ;
		
		Pour chaque client dans ping_utilisateur

			CORBA::Object_var obj1 = MICO_ORB->connecter_service (CLIENT);
			if (!CORBA::is_nil(obj1.in()))
				annuaire->ping_utilisateurs[CLIENT].RESET();
			else if ( annuaire->ping_utilisateurs[CLIENT] > 5 secondes )
			{
				cout << "[DEBUG]\t Le client " << CLIENT << " s'est déconnecté brutalement !" << endl ;
				//Suppression du client des maps :
				annuaire->quitter_annuaire();	
			}
		
		Fin pour chaque client
		*/
		boost::xtime xt;
		boost::xtime_get(&xt, boost::TIME_UTC);
		xt.sec += 1;
		boost::thread::sleep(xt);
	}
}

void f_thread_lancement_orb (ORB * MICO_ORB )
{
	cout << "[DEBUG]\tThread lancement ORB" << endl ;
	MICO_ORB->demarrer();
}

void Serveur::demarrer()
{
	cout << "[DEBUG]\tDémarrage du serveur" << endl;
	thread_lancement_orb = new boost::thread ( boost::bind( &f_thread_lancement_orb, m_MICO_ORB) );	
	//thread_ping_utilisateurs = new boost::thread ( boost::bind( &f_thread_ping_utilisateurs, m_annuaire, m_MICO_ORB ) );
}
