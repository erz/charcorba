#include <QApplication>
#include "mainwindowimpl.h"
#include <client.h>
#include <autotest_client.h>
#include <dialog_tableaublanc.h>

int main(int argc, char ** argv )
{
	
	// Initialisation du client
	Client * client_chat = new Client(argc,argv);
	client_chat->demarrer();
	
	// Initialisation de la GUI
	QApplication qapplication( argc, argv );
	MainWindowImpl fenetre;
	fenetre.initialiser();
	fenetre.ARGC=argc;
	fenetre.ARGV=argv;
	fenetre.show(); 

	Autotest_client * autotest_client = new Autotest_client (client_chat);
	autotest_client->demarrer();
	
	qapplication.connect( &qapplication, SIGNAL( lastWindowClosed() ), &qapplication, SLOT( quit() ) );
	qapplication.exec();
	//Pseudo
	fenetre.get_ui().labelPseudo->setText("");
	fenetre.get_ui().labelPseudo->setText(Client::get_instance()->m_pseudo.c_str());
	delete autotest_client;
	delete client_chat ;
	return 0 ;
}
