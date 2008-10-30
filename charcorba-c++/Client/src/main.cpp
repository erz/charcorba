#include <QApplication>
#include "mainwindowimpl.h"
#include <client.h>
#include <autotest_client.h>

int main(int argc, char ** argv )
{
	// Initialisation du client
	Client * client_chat = new Client(argc,argv);
	client_chat->demarrer();
	
	Autotest_client * autotest_client = new Autotest_client (client_chat);
	autotest_client->demarrer();
	
	// Initialisation de la GUI
	QApplication qapplication( argc, argv );
	MainWindowImpl fenetre;
	fenetre.ARGC=argc;
	fenetre.ARGV=argv;
	fenetre.show(); 

	qapplication.connect( &qapplication, SIGNAL( lastWindowClosed() ), &qapplication, SLOT( quit() ) );
	qapplication.exec();
	
	delete autotest_client;
	delete client_chat ;
	return 0 ;
}
