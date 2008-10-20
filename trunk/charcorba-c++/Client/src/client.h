#ifndef CLIENT_H
#define CLIENT_H

#include <string>
#include "orb.h"

#include <set>
#include <map>
#include <standard.h>
#include <standard_impl.h>

class Client{

private:

	// Objet qui implémente la gestion des messages entrants
	Standard_impl * m_client ; 
	
	ORB * m_MICO_ORB ;

	// Annuaire ( service distant )
	Annuaire_var m_service_annuaire ;
	
	std::string m_pseudo ;

	std::set <std::string> liste_amis ;
	std::set <std::string> liste_tags ;

	// Liste des conversations actives
	std::map <std::string,Standard_var> liste_client_distants ;

public:
	Client();
	Client(int, char **,std::string); 
	~Client();

	void joindre_annuaire();
	void ajouter_tag (std::string tag);
	void get_amis_par_tag (std::string tag);
};
#endif
