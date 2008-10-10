#ifndef ORB_H
#define ORB_H

#include <CORBA.h>
#include <coss/CosNaming.h>
#include <vector>
#include <string>

class ORB  
{

private:

	int m_argc ;
	char ** m_argv ;

	CORBA::ORB_var m_ORB ;
	PortableServer::POA_var m_POA ;
	CosNaming::NamingContext_var m_serveur_de_noms ;
	std::vector <PortableServer::Servant> m_vect_services ;

public:

	ORB();
	~ORB();
	ORB(int ,char **);
	void demarrer();
	void arreter();
	void ajout_service(PortableServer::Servant,std::string);
};

#endif
