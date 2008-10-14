#include <QApplication>
#include "mainwindowimpl.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include <client.h>

int main(int argc, char ** argv )
{
	Client * client_chat = new Client(argc,argv) ;
	client_chat->ajout_annuaire();
	
	QApplication app( argc, argv );
	MainWindowImpl win;
	win.show(); 
	app.connect( &app, SIGNAL( lastWindowClosed() ), &app, SLOT( quit() ) );
	return app.exec();
}
