#ifndef ORB_H
#define ORB_H

#include <CORBA.h>
#include <coss/CosNaming.h>
#include <string>
#include <annuaire.h>
#include <vector>

class ORB  
{

private:

	int m_argc ;
	char ** m_argv ;

	CORBA::ORB_var m_ORB ;
	PortableServer::POA_var m_POA ;
	CosNaming::NamingContext_var m_serveur_de_noms ;

public:

	ORB();
	~ORB();
	ORB(int argc, char ** argv, bool) ;
	void demarrer();
	void arreter();
	void ajout_service(PortableServer::Servant,std::string);
	CORBA::Object_var connecter_servive  (std::string nom_service);
};

#endif
