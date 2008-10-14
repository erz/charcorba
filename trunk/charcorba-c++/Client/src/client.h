#ifndef CLIENT_H
#define CLIENT_H

#include "orb.h"

class Client  
{

private:
	ORB * m_MICO_ORB ;
public:
	Client();
	Client(int, char **); 
	~Client();

	void ajout_annuaire();

};
#endif
