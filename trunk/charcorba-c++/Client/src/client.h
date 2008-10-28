#ifndef CLIENT_H
#define CLIENT_H

#include <string>
#include "orb.h"

#include <set>
#include <map>
#include <standard.h>
#include <standard_impl.h>

#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

using namespace std;

class Client{

private:
	Client * m_client;
	// Objet qui implémente la gestion des messages entrants
	Standard_impl * m_standard ; 
	
	// Annuaire ( service distant )
	Annuaire_var m_service_annuaire ;
	
	//Client Distant
	Standard_var m_service_client;
	
	
	std::string m_pseudo ;

	std::set <std::string> liste_amis ;
	std::set <std::string> liste_tags ;

	// Liste des conversations actives
	std::map <std::string,Standard_var> liste_client_distants ;

public:

	ORB * m_MICO_ORB ;
	
	Client();
	Client(int, char **); 
	~Client();
	
	boost::thread * thread_ecrire_message ;
	
	void demarrer();
	void set_pseudo(std::string);
	
	void joindre_annuaire();
	void ajouter_tag (std::string tag);
	void get_amis_par_tag (std::string tag);
	
	void ajouter_message(string pseudo,string message);
};
#endif
