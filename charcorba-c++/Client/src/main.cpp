#include <QApplication>
#include "mainwindowimpl.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include <client.h>

int main(int argc, char ** argv )
{
	Client * client_chat = new Client(argc,argv,argv[3]);
	client_chat->joindre_annuaire();
	
	for (int i=2;i<argc-2;++i)
	{
		client_chat->ajouter_tag(argv[i]);
	}
	
/*	QApplication app( argc, argv );
	MainWindowImpl win;
	win.show(); 
	app.connect( &app, SIGNAL( lastWindowClosed() ), &app, SLOT( quit() ) );
	return app.exec();*/
	return 0 ;
}

