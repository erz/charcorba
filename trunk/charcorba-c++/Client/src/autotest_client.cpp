#include "autotest_client.h"
#include <string>
#include <iostream>
#include <client.h>

#include <boost/thread/thread.hpp>
#include <boost/bind.hpp>
#include <coss/CosNaming.h>

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


void f_thread_lancement_autotest ()
{
	string cmd;
	while( getline(cin,cmd,' ') )
	{
		cout << "[DEBUG]\tAppel '" << cmd  << "'" << endl; 
		if      (cmd == "ajouter_tag" )		Client::get_instance()->ajouter_tag(getstring(cin,'\n'));
		else if (cmd == "set_pseudo" )		Client::get_instance()->set_pseudo(getstring(cin,'\n'));
		else if (cmd == "joindre_annuaire")	Client::get_instance()->joindre_annuaire(),getstring(cin,'\n');
		else if (cmd == "afficher_message")	
		{
			string client_distant = getstring(cin,' ');
			string message = getstring(cin,'\n');
			Client::get_instance()->afficher_message(client_distant,message);
		}
		else if (cmd == "sleep")			sleep(atoi(getstring(cin,'\n').c_str()));
		else if (cmd == "get_amis_par_tag")	Client::get_instance()->get_amis_par_tag (getstring(cin,'\n'));
		else if (cmd == "creer_chatroom" )	Client::get_instance()->creer_chatroom(getstring(cin,'\n'));
		else if (cmd == "inviter_client_chatroom")
		{
			string pseudo = getstring(cin,' ');
			string chatroom = getstring(cin,'\n');
			Client::get_instance()->inviter_client_chatroom(pseudo,chatroom);
		}
		else if (cmd == "ajouter_message")
		{
			string nom_chatroom = getstring(cin,' ');
			string message = getstring(cin,'\n');
			Client::get_instance()->ajouter_message(nom_chatroom,message);
		}
		else if (cmd == "get_message" )
		{
			string nom_chatroom = getstring (cin,' ');
			unsigned long idmessage = atoi(getstring (cin,'\n').c_str()) ;
			Message msg = Client::get_instance()->get_message(nom_chatroom,idmessage);
		}
	}	
}

void Autotest_client::demarrer()
{
	new boost::thread (&f_thread_lancement_autotest);
}

