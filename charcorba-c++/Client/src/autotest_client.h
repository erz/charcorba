#ifndef AUTOTEST_CLIENT_H
#define AUTOTEST_CLIENT_H
#include <client.h>


class Autotest_client  
{

private:
	Client * m_client ;

public:
	Autotest_client();
	Autotest_client(Client *);
	void demarrer();
	
};
#endif
