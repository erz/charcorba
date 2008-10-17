#ifndef CLIENT_H
#define CLIENT_H

#include <string>
#include "orb.h"

#include <set>

class Client  
{

private:
	ORB * m_MICO_ORB ;

	Annuaire_var m_service_annuaire ;
	std::string m_pseudo ;

	std::set <std::string> liste_amis ;
	std::set <std::string> liste_tags ;

public:
	Client();
	Client(int, char **,std::string); 
	~Client();

	void joindre_annuaire();
	void ajouter_tag (std::string tag);
	void get_amis_par_tag (std::string tag);
};
#endif
