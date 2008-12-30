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
	for(int j=0;j<5;j++) m_dialog_window[j]=NULL;
	m_dialog_chatroom_window=NULL;
	ui.setupUi(this);
}

void MainWindowImpl::initialiser ()
{
	connect(ui.qaction_connexion,SIGNAL(triggered()),this,SLOT(afficher_dialog_connexion()));
	connect(Client::get_instance(),SIGNAL(ami_ajoute(QString)),this,SLOT(ajouter_ami(QString)));	
	connect(ui.qlistwidget_amis,SIGNAL(itemDoubleClicked(QListWidgetItem *)),this,SLOT(ouvrir_dialog_window(QListWidgetItem *)));
	connect(Client::get_instance(),SIGNAL(signal_message_recu(QString,QString)),this,SLOT(afficher_message_window(QString,QString)));
	connect(ui.actionInviter_Chatroom,SIGNAL(triggered()),this,SLOT(Inviter_chatroom()));
	connect(Client::get_instance(),SIGNAL(invitation_chatroom(QString)),this,SLOT(Ouvrir_chatroom(QString)));
	
	
}

void MainWindowImpl::afficher_message_window(QString pseudo,QString message){
	cout<< "[DEBUG - GUI]\tOuverture nouvelle fenetre apres reception message"<<endl;
	int indice =0;
	for(int i=0;i<ui.qlistwidget_amis->count();i++)
	{
		QListWidgetItem * tmp=ui.qlistwidget_amis->item(i);
		if(pseudo==tmp->text()) indice=i;
	}
	get_dialog_window(pseudo,indice)->show();
	m_dialog_window[indice]->exec();
	if(Premiere_ouverture==true)
		{
			Premiere_ouverture=false;		
		}
	m_dialog_window[indice]->ecrire_message(pseudo.toStdString(),message.toStdString());
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
	int indice =ui.qlistwidget_amis->row(item);
	
	get_dialog_window(item->text(),indice);
	m_dialog_window[indice]->show();
	m_dialog_window[indice]->exec();
}

void MainWindowImpl::ouvrir_dialog_chatroom_window (QListWidgetItem * item)
{
	cout << "[DEBUG - GUI]\tOuverture fenetre de conversation" << endl ;
	get_dialog_chatroom_window(item->text());
	m_dialog_chatroom_window->show();
	m_dialog_chatroom_window->exec();
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

Dialog_window * MainWindowImpl::get_dialog_window(QString pseudo,int indice)
{
	if ( m_dialog_window[indice] == NULL )
	{
		m_dialog_window[indice] = new Dialog_window(pseudo);
		Premiere_ouverture=true;
	}
		
	
	return m_dialog_window[indice];
}

Dialog_window * MainWindowImpl::get_dialog_chatroom_window(QString pseudo)
{
	if ( m_dialog_chatroom_window == NULL )
	{
		m_dialog_chatroom_window = new Dialog_window();
		Premiere_ouverture=true;
	}
		
	
	return m_dialog_chatroom_window;
}

void MainWindowImpl::afficher_dialog_connexion()
{
	cout << "[DEBUG - GUI]\t Afficher_boite" << endl ;
	//get_dialog_connexion()->show();
}

void MainWindowImpl::Inviter_chatroom()
{
	QListWidgetItem * temp =ui.qlistwidget_amis->currentItem();
	cout<<"[DEBUG - GUI]\tNom item:"<<temp->data(0).toString().toStdString()<<endl;
	Client::get_instance()->creer_chatroom("tmp");
	Client::get_instance()->inviter_client_chatroom(temp->data(0).toString().toStdString(),"tmp");
	ouvrir_dialog_chatroom_window(temp);
}

void MainWindowImpl::Ouvrir_chatroom(QString chatroom)
{
	cout<<"[DEBUG - GUI]\tSignal recu!"<<endl;
	get_dialog_chatroom_window(chatroom)->show();
	m_dialog_chatroom_window->exec();
}

