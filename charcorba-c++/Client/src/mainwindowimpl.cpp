#include <QtGui>
#include <QString>
#include <QListView>
#include "mainwindowimpl.h"
#include "dialog_connexion.h"
#include <CORBA.h>
#include <annuaire.h>
#include <iostream>
#include "client.h"

using namespace std;

MainWindowImpl::MainWindowImpl( QWidget * parent, Qt::WFlags f) 
	: QMainWindow(parent, f)
{
	cout<<"[DEBUG]\tCréation fenetre"<<endl;
	ui.setupUi(this);
}

void MainWindowImpl::initialiser ()
{
	connect(ui.qaction_connexion,SIGNAL(triggered()),this,SLOT(afficher_dialog_connexion()));
	connect(Client::get_instance(),SIGNAL(ami_ajoute(QString)),this,SLOT(ajouter_ami(QString)));	
}

void MainWindowImpl::ajouter_ami (QString ami)
{
	cout << "[DEBUG - GUI]\tAjout de l'ami : '" << ami.toStdString() << "'" << endl;
	ui.qlistwidget_amis->addItem(ami);
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
	//get_dialog_connexion()->show();
}

