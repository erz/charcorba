#include <QtGui>
#include "mainwindowimpl.h"
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
	connect(ui.menuServeur, SIGNAL(clicked()),this, SLOT(Initialiser()));
	connect(ui.menubar, SIGNAL(hovered()),this, SLOT(Initialiser()));
	connect(ui.pushButton,SIGNAL(clicked()),this,SLOT(afficherBoite()));
}

//fonction d'initialisation du client 
void MainWindowImpl::initialiser()
{
}

//fonction de test liée au bouton
void MainWindowImpl::afficher_boite()
{
	QMessageBox::about(this, tr("Test"),tr("Hello World!"));
}

