#ifndef CLIENT_H
#define CLIENT_H

#include <string>
#include "orb.h"

#include <set>
#include <map>
#include <standard.h>
#include <standard_impl.h>
#include <chatroom_impl.h>

#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

using namespace std;

class Client
{

private:
	// Singleton
	Client * m_client;
	
	// Objet qui implémente la gestion des messages entrants
	Standard_impl * m_standard ; 
	
	// Annuaire ( service distant )
	Annuaire_var m_service_annuaire ;
	
	std::string m_pseudo ;

	std::set <std::string> liste_amis ;
	std::set <std::string> liste_tags ;

	// Liste des chatrooms locales 
	std::map <std::string,Chatroom_impl *> m_liste_chatrooms_locales ;

	// Liste des chatrooms distantes 
	std::map <std::string,Chatroom_var> liste_chatrooms_distantes ;

public
:

	ORB * m_MICO_ORB ;
	
	Client();
	Client(int, char **); 
	~Client();
	
	boost::thread * thread_ecrire_message ;
	
	void demarrer();
	void set_pseudo(std::string);
	
	// Fonctions liées à l'annuaire
	void joindre_annuaire();
	void ajouter_tag (std::string tag);
	void enlever_tag (std::string tag);
	void get_amis_par_tag (std::string tag);

	// Fonctions liées aux standards	
	void afficher_message(string pseudo,string message);
	
	// Fonctions liées aux chatrooms
	void creer_chatroom (std::string nom_chatroom);
};
#endif
