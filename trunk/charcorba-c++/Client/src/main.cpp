#include <QApplication>
#include "mainwindowimpl.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include <client.h>

int main(int argc, char ** argv )
{
	Client * client_chat = new Client(argc,argv,"trix") ;
	client_chat->ajout_annuaire();
	client_chat->nouveau_tag("geek");
	client_chat->nouveau_tag("chuck norris");
	client_chat->nouveau_tag("c++");
	client_chat->nouveau_tag("Front anti-java");
	client_chat->get_amis_par_tag("Front anti-java");

/*	QApplication app( argc, argv );
	MainWindowImpl win;
	win.show(); 
	app.connect( &app, SIGNAL( lastWindowClosed() ), &app, SLOT( quit() ) );
	return app.exec();*/
	return 0 ;
}
