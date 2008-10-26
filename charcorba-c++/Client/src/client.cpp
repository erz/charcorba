#include "client.h"
#include "annuaire.h"
#include "standard_impl.h"
#include "orb.h"

#include <string>
#include <set>
#include <map>

#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>

using namespace std;
 
Client::Client()
{}

Client::Client(int argc, char ** argv)  
{
	m_MICO_ORB = new ORB (argc,argv,true) ;	
	m_standard = new Standard_impl() ;
}

Client::~Client()
{}

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
	cout << "[DEBUG]\tNouveau tag : " << tag << endl ;
	m_service_annuaire->ajouter_tag(m_pseudo.c_str(),tag.c_str());
	liste_tags.insert(tag);
}

void Client::get_amis_par_tag (string tag)
{
	cout << "[DEBUG]\tRecherche de nouveaux amis possédants le tag : '" << tag << "'" << endl;
	::Annuaire::t_liste_string* retval = m_service_annuaire->get_amis_par_tag(tag.c_str()) ;
	CORBA::ULong i=0;
	for (i=0;i< retval->length();++i)
	{
		CORBA::String_var ami = (*retval)[i] ;
		liste_amis.insert(string(ami));
		cout << "[DEBUG]\tNouvel ami : " << ami << endl ;
	}
}

void f_thread_ecrire_message(Standard_var m_service_client,const char* pseudo,string message)
{
	cout << "[DEBUG]\tThread Ecriture Message" << endl ;
	if (CORBA::is_nil(m_service_client))
	{
		cerr << "[DEBUG]\tL'IOR n'est pas une référence sur un service." << endl;
	}
	cout<<"[DEBUG]\tEnvoie du message : "<< message<<"\t vers  "<<pseudo<<endl;
	m_service_client->ajouter_message(pseudo,message.c_str());
}

void Client::ecrire_message(const char* pseudo,string message)
{
	
	
	CORBA::Object_var servicedist = m_MICO_ORB->connecter_service(pseudo);
	cout<<"[DEBUG]\tConnection au service"<<servicedist<<endl;
	
	m_service_client = Standard::_narrow(servicedist.in()) ;
	thread_ecrire_message = new boost::thread (boost::bind( &f_thread_ecrire_message, m_service_client,pseudo,message) );	
	
}

void Client::afficher_message()
{
	cout<<"[DEBUG]\tOn va afficher les messages\n"<<endl;
	multimap<string,string> tmp = m_standard->Liste_Messages;
	multimap<string,string>::iterator pos;	
	for (pos = tmp.begin(); pos != tmp.end(); ++pos)
		 {
        	cout << "message :\t" << pos->first.c_str()<< pos->second << endl;
    	}
}

void Client::afficher_message_distant()
{
	
}
