#ifndef CLIENT_H
#define CLIENT_H

#include <string>
#include <QObject>
#include <QString>
#include "orb.h"

#include <set>
#include <map>
#include <standard.h>
#include <standard_impl.h>
#include <chatroom_impl.h>

#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

using namespace std;

class Client : public QObject
{
	Q_OBJECT
private:

	// Singleton Client
	static Client * singleton_client ;
		
	// Objet qui implémente la gestion des messages entrants
	Standard_impl * m_standard ; 
	
	// Annuaire ( service distant )
	Annuaire_var m_service_annuaire ;

public:
	
	std::string m_pseudo ;

	std::set <std::string> liste_amis ;
	std::set <std::string> liste_tags ;

	// Liste des chatrooms locales 
	std::map <std::string,Chatroom_impl *> m_liste_chatrooms_locales ;

	// Liste des chatrooms distantes 
	std::map <std::string,Chatroom_var> m_liste_chatrooms_distantes ;

	ORB * m_MICO_ORB ;
	
	Client();
	Client(int, char **); 
	~Client();
	
	static Client * get_instance ();
	
	boost::thread * thread_ecrire_message ;
	
	void demarrer();
	void arreter();
	
	void set_pseudo(std::string);
	
	public :
	
	// Fonctions liées à l'annuaire
	void joindre_annuaire();
	void ajouter_tag (std::string tag);
	void enlever_tag (std::string tag);
	void get_amis_par_tag (std::string tag);
	void ajouter_ami (std::string);
	Standard_impl * get_standard();
	
	// Fonctions liées aux standards	
	void afficher_message(string pseudo,string message);
	void inviter_client_chatroom (std::string pseudo,std::string nom_chatroom);
	void message_recu(QString pseudo, QString message);

	// Fonctions liées aux chatrooms
	void creer_chatroom (std::string nom_chatroom);
	void ajouter_message(std::string nom_chatroom,std::string message);
	void ajouter_message_local(std::string nom_chatroom,std::string message);
	void signal_invitation_chatroom(QString);
	void signal_chatroom(QString);
	Message get_message (std::string nom_chatroom,unsigned long idmessage);

	signals :
	
	void ami_ajoute (QString);
	void signal_message_recu(QString,QString);
	void signal_client_chatroom(QString);
	void invitation_chatroom(QString); 
};
#endif
