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

