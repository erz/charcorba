#include <QtGui>
#include "mainwindowimpl.h"
#include "dialog_connexion.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>

using namespace std;

MainWindowImpl::MainWindowImpl( QWidget * parent, Qt::WFlags f) 
	: QMainWindow(parent, f)
{
	cout<<"[DEBUG]\tCréation fenetre"<<endl;
	ui.setupUi(this);
	
	//liaison des élements visuels avec les fonctions qui seront déclanchées par un signal
	connect(ui.qaction_connexion,SIGNAL(triggered()),this,SLOT(afficher_dialog_connexion()));
}

Dialog_connexion * MainWindowImpl::get_dialog_connexion()
{
	if ( m_dialog_connexion == NULL )
		m_dialog_connexion = new Dialog_connexion();
	return m_dialog_connexion;
}

void MainWindowImpl::afficher_dialog_connexion()
{
	cout << "[DEBUG - GUI]\t Afficher_boite" << endl ;
	get_dialog_connexion()->show();
}

