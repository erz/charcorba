#include <QtGui>
#include "mainwindowimpl.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include <client.h>
#include <autotest_client.h>

//
MainWindowImpl::MainWindowImpl( QWidget * parent, Qt::WFlags f) 
	: QMainWindow(parent, f)
{
	ui.setupUi(this);
	connect(ui.menuServeur, SIGNAL(clicked(int)),this,  SLOT(Initialiser()));
}

void MainWindowImpl::Initialiser()
{
	Client * client_chat = new Client(ARGC,ARGV);
	client_chat->demarrer();
	
	Autotest_client * autotest_client = new Autotest_client (client_chat);
	autotest_client->demarrer();
	client_chat->m_MICO_ORB->thread_lancement_orb->join();	
}
//
