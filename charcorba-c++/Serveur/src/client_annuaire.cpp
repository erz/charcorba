#include "client_annuaire.h"

#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <annuaire_impl.h>
#include <orb.h>
#include <standard.h>


using namespace std;
using boost::thread ;

void f_thread_ping_utilisateur (Client_annuaire & client_annuaire)
{
	while (1)
	{
		try 
		{
			CORBA::Object_var service_distant = ::ORB::static_ORB->connecter_service (client_annuaire.m_pseudo);
			Standard_var standard_distant = Standard::_narrow(service_distant.in()) ;
			standard_distant->ping();	
		}
		catch (...)
		{
			cout << "[DEBUG]\tLe client '" << client_annuaire.m_pseudo << "' s'est déconnecté brutalement !" << endl ;
			Annuaire_impl::m_static_annuaire->m_liste_clients.erase(client_annuaire.m_pseudo);
			return ;
		}
		boost::xtime xt;
		boost::xtime_get(&xt, boost::TIME_UTC);
		xt.sec += 5 ;
		boost::thread::sleep(xt);
	}
}

Client_annuaire::Client_annuaire() 
{}

Client_annuaire::Client_annuaire(std::string pseudo)
	: m_pseudo (pseudo)
{
	m_test_activite = new thread ( boost::bind( &f_thread_ping_utilisateur, (*this)));
}

void Client_annuaire::ajouter_tag (std::string tag)
{
	liste_tags.insert(tag);
}

void Client_annuaire::enlever_tag (std::string tag)
{
	liste_tags.erase(tag);
}

bool Client_annuaire::possede_tag (std::string tag)
{
	return liste_tags.end() != liste_tags.find(tag);
}

std::set<std::string> Client_annuaire::get_tags(void)
{	
	return liste_tags;
}
