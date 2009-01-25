#include "client.h"
#include <QString>
#include "annuaire.h"
#include "standard_impl.h"
#include "orb.h"
#include <chatroom_impl.h>
#include <tableau_blanc_impl.h>

#include <string>
#include <set>
#include <map>

#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>


using namespace std;
 
Client * Client::singleton_client = NULL ;
 
Client::Client()
	: QObject ()
{}

Client::~Client()
{
	arreter();
	delete m_standard;
	delete m_MICO_ORB;
}


Client::Client(int argc, char ** argv)  
{
	m_MICO_ORB = new ORB (argc,argv,true) ;	
	m_standard = new Standard_impl();
	Client::singleton_client = this ;
}

Client * Client::get_instance ()
{
	return Client::singleton_client ;
}

Standard_impl * Client::get_standard(){
	
	return m_standard;
}

Annuaire_var  Client::get_annuaire()
{
	return  m_service_annuaire;
}

void Client::set_pseudo (string pseudo)
{	
	cout << "[DEBUG]\tPseudo client : " << pseudo << endl;
	m_pseudo = pseudo ;
	m_MICO_ORB->ajout_service(m_standard,pseudo);	
}

void Client::joindre_annuaire()
{
	std::cout << "[DEBUG]\tConnexion au service d'annuaire" << std::endl ;
	CORBA::Object_var service = m_MICO_ORB->connecter_service("Annuaire");
	
	m_service_annuaire = Annuaire::_narrow(service.in()) ;
	m_service_annuaire->joindre_annuaire(m_pseudo.c_str());

	if (CORBA::is_nil(m_service_annuaire))
	{
		cerr << "[DEBUG]\tL'IOR n'est pas une référence sur un service." << endl;
	}
}

void Client::ajouter_tag (string tag)
{
	cout << "[DEBUG]\tAjouter tag : " << tag << endl ;
	m_service_annuaire->ajouter_tag(m_pseudo.c_str(),tag.c_str());
	liste_tags.insert(tag);
}

void Client::enlever_tag (string tag)
{
	cout << "[DEBUG]\tEnlever tag : " << tag << endl ;
	//m_service_annuaire->ajouter_tag(m_pseudo.c_str(),tag.c_str());
	liste_tags.erase(tag);
}


void Client::get_amis_par_tag (string tag)
{
	cout << "[DEBUG]\tRecherche de nouveaux amis possédants le tag : '" << tag << "'" << endl;
	::Annuaire::t_liste_string* retval = m_service_annuaire->get_amis_par_tag(tag.c_str()) ;
	CORBA::ULong i=0;
	for (i=0;i< retval->length();++i)
	{
		CORBA::String_var ami = (*retval)[i] ;
		if (string(ami) != m_pseudo) 
		{
			ajouter_ami(string(ami));
		}
	}
}

void Client::ajouter_ami (string ami)
{
	liste_amis.insert(string(ami));	
	cout << "[DEBUG]\tNouvel ami : '" << ami << "'" << endl ;
	emit ami_ajoute(QString(ami.c_str()));
}

void Client::afficher_message(string pseudo,string message)
{
	CORBA::Object_var service_distant = m_MICO_ORB->connecter_service(pseudo);
	Standard_var standard_distant = Standard::_narrow(service_distant.in()) ;
	standard_distant->afficher_message(m_pseudo.c_str(),message.c_str());
}

void Client::demarrer()
{
	cout << "[DEBUG]\tDémarrage du client" << endl;
	m_MICO_ORB->demarrer();
}

void Client::arreter()
{
	cout << "[DEBUG]\tArret du client" << endl ;
	m_MICO_ORB->arreter();
}

void Client::creer_chatroom (string nom_chatroom)
{
	cout << "[DEBUG]\tCréation de la chatroom '" << nom_chatroom << "'" << endl ;
	Chatroom_impl * chatroom = new Chatroom_impl(nom_chatroom);
	m_liste_chatrooms_locales.insert( pair<string,Chatroom_impl *>(nom_chatroom,chatroom));
	m_MICO_ORB->ajout_service(chatroom,nom_chatroom);
}

void Client::inviter_client_chatroom (string pseudo,string nom_chatroom)
{
	m_liste_chatrooms_locales[nom_chatroom]->inviter_client(pseudo) ;
}


void Client::ajouter_message(string nom_chatroom,string message)
{
	cout<<"[DEBUG]\tEnvoie message sur la chatroom"<<endl;
	m_liste_chatrooms_distantes[nom_chatroom]->ajouter_message (m_pseudo.c_str(),message.c_str());
}

void Client::ajouter_message_local(string nom_chatroom,string message)
{
	cout<<"[DEBUG]\tEnvoie message sur la chatroom"<<endl;
	m_liste_chatrooms_locales[nom_chatroom]->ajouter_message (m_pseudo.c_str(),message.c_str());
}

void Client::message_recu(QString pseudo,QString message)
{
	cout<<"[DEBUG]\t Message recu"<<endl;
	emit signal_message_recu(QString(pseudo),QString(message));
}

void Client::signal_invitation_chatroom(QString chatroom)
{
	emit invitation_chatroom(chatroom);
}

void Client::signal_chatroom(QString chatroom)
{
	emit signal_client_chatroom(chatroom);
}

Message Client::get_message (string nom_chatroom,unsigned long idmessage)
{
	cout << "[DEBUG]\tRéception du message " << idmessage << " de la chatroom " << nom_chatroom << endl ;
	::Chatroom::t_string_auteur * retval = m_liste_chatrooms_distantes[nom_chatroom]->get_message(idmessage) ;
	CORBA::String_var auteur = (*retval)[0] ;
	CORBA::String_var message = (*retval)[1] ;

	Message msg;
	msg.auteur = auteur;
	msg.message = message;
	cout << "[DEBUG]\tAuteur :\t" << msg.auteur << endl ;
	cout << "[DEBUG]\tMessage :\t" << msg.message << endl ;
	return msg ;
}

/* Fonctions liées aux tableaux */

void Client::creer_tableau_blanc (std::string nom_tableau)
{
	cout << "[DEBUG]\tCréation du tableau blanc '" << nom_tableau << "'" << endl ;
	TableauBlanc_impl * tableau = new TableauBlanc_impl (nom_tableau);
	m_liste_tableauxblancs_locaux.insert( pair<string,TableauBlanc_impl *>(nom_tableau,tableau));
	m_MICO_ORB->ajout_service(tableau,nom_tableau);
	cout << "[DEBUG]\t Envoie du signal " << endl ;
}

void Client::inviter_client_tableaublanc (string pseudo, string nom_tableau)
{
	m_liste_tableauxblancs_locaux[nom_tableau]->inviter_client(pseudo);
}

void Client::ajouter_pixel (std::string nom_tableau,Pixel pixel)
{
	cout<<"[DEBUG]\tEnvoie message sur le tableau " << nom_tableau <<endl;

	s_pixel mon_pixel ;
	
	mon_pixel.x = pixel.m_qpoint.x() ;
	mon_pixel.y = pixel.m_qpoint.y() ;
	mon_pixel.rouge = pixel.m_qcolor.red();
	mon_pixel.vert = pixel.m_qcolor.green();
	mon_pixel.bleu = pixel.m_qcolor.blue();
	mon_pixel.est_continu = pixel.m_est_continu;
	m_liste_tableauxblancs_distants[nom_tableau]->ajouter_pixel(mon_pixel)  ;
	QString qstring (nom_tableau.c_str());
}

Pixel Client::get_pixel (std::string nom_tableau,unsigned long idmessage)
{
	cout << "[DEBUG]\tRéception du pixel " << idmessage << " du tableau " << nom_tableau << endl ;
	s_pixel pixel = m_liste_tableauxblancs_distants[nom_tableau]->get_pixel(idmessage) ;
	cout << "[DEBUG]\tValeur (" << pixel.x << "," << pixel.y << ")" << endl ;
	return Pixel(QPoint(pixel.x,pixel.y),QColor(pixel.rouge,pixel.vert,pixel.bleu),pixel.est_continu) ;
}

void Client::participer_tableau_blanc (QString nom_tableau)
{
	emit signal_participation_tableau_blanc (nom_tableau);
}

void Client::sync_tableau_blanc (QString nom_tableau,unsigned long idpixel)
{
	cout << "On synchronise le tableau blanc !" << endl ;
	emit signal_sync_tableau_blanc (nom_tableau,idpixel);
}