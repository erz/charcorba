#include <QApplication>
#include "mainwindowimpl.h"


int main(int argc, char ** argv )
{
/*	Client * client_chat = new Client(argc,argv);
	client_chat->demarrer();
	
	Autotest_client * autotest_client = new Autotest_client (client_chat);
	autotest_client->demarrer();
	client_chat->m_MICO_ORB->thread_lancement_orb->join();
*/
	QApplication app( argc, argv );
	MainWindowImpl win;
	win.ARGC=argc;
	win.ARGV=argv;

	win.show(); 
	app.connect( &app, SIGNAL( lastWindowClosed() ), &app, SLOT( quit() ) );
	return app.exec();
	return 0 ;
}

