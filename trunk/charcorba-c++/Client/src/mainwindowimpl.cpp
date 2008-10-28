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
	cout<<"[DEBUG]\tCreation fenetre"<<endl;
	ui.setupUi(this);
	
	//liaison des élements visuels avec les fonctions qui seront déclanchées par un signal
	connect(ui.menuServeur, SIGNAL(clicked()),this, SLOT(Initialiser()));
	connect(ui.menubar, SIGNAL(hovered()),this, SLOT(Initialiser()));
	connect(ui.pushButton,SIGNAL(clicked()),this,SLOT(afficherBoite()));
}

//fonction d'initialisation du client 
void MainWindowImpl::Initialiser()
{
	
	cout<<"[DEBUG]\tinitialisation Client:"<<endl;
	Client * client_chat = new Client(ARGC,ARGV);
	client_chat->demarrer();
	
	Autotest_client * autotest_client = new Autotest_client (client_chat);
	autotest_client->demarrer();
	client_chat->m_MICO_ORB->thread_lancement_orb->join();	
}

//fonction de test liée au bouton
void MainWindowImpl::afficherBoite()
{
    QMessageBox::about(this, tr("Test"),tr("Hello World!"));
    cout<<"[DEBUG]initialisation"<<endl;
    Client * client_chat = new Client(ARGC,ARGV);
	client_chat->demarrer();
	
	Autotest_client * autotest_client = new Autotest_client (client_chat);
	autotest_client->demarrer();
	client_chat->m_MICO_ORB->thread_lancement_orb->join();
}
//
