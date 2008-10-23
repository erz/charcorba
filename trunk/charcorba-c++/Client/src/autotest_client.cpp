#include "autotest_client.h"
#include <string>
#include <iostream>

#include <client.h>

using namespace std;

Autotest_client::Autotest_client( ) 
{
}

Autotest_client::Autotest_client( Client * mon_client ) 
	: m_client (mon_client)
{
}

void Autotest_client::demarrer()
{
	string cmd;
	while( getline(cin,cmd,' ') )
	{
		string arguments ;
		getline(cin,arguments,'\n');
		cout << "[DEBUG]\tAppel '" << cmd << "(" << arguments << ")'" << endl; 
		if (cmd == "ajouter_tag" )			m_client->ajouter_tag(arguments);
		else if (cmd == "set_pseudo" )		m_client->set_pseudo(arguments);
		else if (cmd == "joindre_annuaire")	m_client->joindre_annuaire();
		else if(cmd == "envoyer_message") m_client->ecrire_message("sylvain",arguments);
		else if (cmd == "afficher_message") {m_client->afficher_message_distant();}
		else if (cmd == "sleep") sleep(10);
										
			

	}
}

