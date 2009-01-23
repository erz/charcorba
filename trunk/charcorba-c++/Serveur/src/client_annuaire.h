#ifndef CLIENT_ANNUAIRE_H
#define CLIENT_ANNUAIRE_H

#include <boost/progress.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

#include <map>
#include <set>
#include <client_annuaire.h>
#include <string>
#include <vector>

using boost::timer;
using boost::thread;

class Client_annuaire  
{

public:
	

	std::string m_pseudo ;
	
	thread * m_test_activite ;
	
	std::set <std::string> liste_tags ;

	Client_annuaire();
	Client_annuaire(std::string pseudo);
	
	void ajouter_tag (std::string tag);
	void enlever_tag (std::string tag);
	
	bool possede_tag (std::string tag);
	
	std::set <std::string> get_tags(void); 
};
#endif
