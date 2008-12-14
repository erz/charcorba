#include <QtGui>
#include <QString>
#include <QListView>
#include <QMenu>
#include <QPoint>
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
	m_dialog_window=NULL;
	ui.setupUi(this);
}

void MainWindowImpl::initialiser ()
{
	connect(ui.qaction_connexion,SIGNAL(triggered()),this,SLOT(afficher_dialog_connexion()));
	connect(Client::get_instance(),SIGNAL(ami_ajoute(QString)),this,SLOT(ajouter_ami(QString)));	
	connect(ui.qlistwidget_amis,SIGNAL(itemDoubleClicked(QListWidgetItem *)),this,SLOT(ouvrir_dialog_window(QListWidgetItem *)));
	connect(Client::get_instance(),SIGNAL(signal_message_recu(QString,QString)),this,SLOT(afficher_message_window(QString,QString)));
	//connect(ui.qlistwidget_amis,SIGNAL(itemClicked (QListWidgetItem *)),this,SLOT(ouvrir_qpopupmenu_client(QListWidgetItem *)));
	
}

void MainWindowImpl::afficher_message_window(QString pseudo,QString message){
	cout<< "[DEBUG - GUI]\tOuverture nouvelle fenetre apres reception message"<<endl;
	get_dialog_window(pseudo)->show();
	m_dialog_window->exec();
	if(Premiere_ouverture==true)
		{
			Premiere_ouverture=false;		
		}
	m_dialog_window->ecrire_message(pseudo.toStdString(),message.toStdString());
}

void MainWindowImpl::ouvrir_qpopupmenu_client (QListWidgetItem * item)
{
	cout << "[DEBUG - GUI]\tOuverture du menu" << endl ;
	QMenu * fileMenu = new QMenu (this);
	fileMenu->addAction("Inviter chatroom");
	fileMenu->addAction("Envoyer message");
	fileMenu->show();
	fileMenu->exec(QCursor::pos());
	
}

void MainWindowImpl::ouvrir_dialog_window (QListWidgetItem * item)
{
	cout << "[DEBUG - GUI]\tOuverture fenetre de conversation" << endl ;
	get_dialog_window(item->text());
	m_dialog_window->show();
	m_dialog_window->exec();
}

void MainWindowImpl::ajouter_ami (QString ami)
{
	cout << "[DEBUG - GUI]\tAjout de l'ami : '" << ami.toStdString() << "'" << endl;
	QListWidgetItem * qitem_ami = new QListWidgetItem (ami);
	ui.qlistwidget_amis->addItem(qitem_ami);
}

Dialog_connexion * MainWindowImpl::get_dialog_connexion()
{
	if ( m_dialog_connexion == NULL )
		m_dialog_connexion = new Dialog_connexion();
	return m_dialog_connexion;
}

Dialog_window * MainWindowImpl::get_dialog_window(QString pseudo)
{
	if ( m_dialog_window == NULL )
	{
		m_dialog_window = new Dialog_window(pseudo);
		Premiere_ouverture=true;
	}
		
	
	return m_dialog_window;
}

void MainWindowImpl::afficher_dialog_connexion()
{
	cout << "[DEBUG - GUI]\t Afficher_boite" << endl ;
	//get_dialog_connexion()->show();
}

