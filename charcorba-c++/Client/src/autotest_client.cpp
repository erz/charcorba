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

string getstring (istream & flux,char delim)
{
	string tmp;
	getline(flux,tmp,delim);
	return tmp ;
}

void Autotest_client::demarrer()
{
	string cmd;
	while( getline(cin,cmd,' ') )
	{
		cout << "[DEBUG]\tAppel '" << cmd  << "'" << endl; 
		if      (cmd == "ajouter_tag" )		m_client->ajouter_tag(getstring(cin,'\n'));
		else if (cmd == "set_pseudo" )		m_client->set_pseudo(getstring(cin,'\n'));
		else if (cmd == "joindre_annuaire")	m_client->joindre_annuaire(),getstring(cin,'\n');
		else if (cmd == "ajouter_message")	
		{
			string client_distant = getstring(cin,' ') ;
			string message = getstring(cin,'\n') ;
			m_client->ajouter_message(client_distant,message);	
		}
		else if (cmd == "sleep")			sleep(atoi(getstring(cin,'\n').c_str()));
	}
}

