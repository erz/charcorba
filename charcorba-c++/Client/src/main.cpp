#include <QApplication>
#include "mainwindowimpl.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include <client.h>

int main(int argc, char ** argv )
{
	//std::cout << argc << std::endl  ;
	Client * client_chat = new Client(argc,argv,"trix");
	client_chat->joindre_annuaire();
	client_chat->ajouter_tag("geek");
	client_chat->ajouter_tag("chuck norris");
	client_chat->ajouter_tag("c++");
	client_chat->ajouter_tag("Front anti-java");
	client_chat->get_amis_par_tag("Front anti-java");

/*	QApplication app( argc, argv );
	MainWindowImpl win;
	win.show(); 
	app.connect( &app, SIGNAL( lastWindowClosed() ), &app, SLOT( quit() ) );
	return app.exec();*/
	return 0 ;
}

