#include <QApplication>
#include "mainwindowimpl.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include <client.h>
#include <autotest_client.h>

int main(int argc, char ** argv )
{
	Client * client_chat = new Client(argc,argv);
	Autotest_client * autotest_client = new Autotest_client (client_chat);
	
	autotest_client->demarrer();
	
/*	QApplication app( argc, argv );
	MainWindowImpl win;
	win.show(); 
	app.connect( &app, SIGNAL( lastWindowClosed() ), &app, SLOT( quit() ) );
	return app.exec();*/
	return 0 ;
}

