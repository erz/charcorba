#include "client_annuaire.h"

#include <boost/thread/xtime.hpp>
#include <boost/thread/thread.hpp>
#include <annuaire_impl.h>
#include <orb.h>

using namespace std;
using boost::thread ;

void f_thread_ping_utilisateur (Client_annuaire & client_annuaire)
{
	while (1)
	{
		CORBA::Object_var obj1 = ::ORB::static_ORB->connecter_service (client_annuaire.m_pseudo);
		if (CORBA::is_nil(obj1.in()))
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

bool Client_annuaire::possede_tag (std::string tag)
{
	return liste_tags.end() != liste_tags.find(tag);
}
