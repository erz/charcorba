#include <QtGui>
#include <QString>
#include <QListView>
#include <QMenu>
#include <QPoint>
#include "mainwindowimpl.h"
#include "dialog_connexion.h"
#include <dialog_tableaublanc.h>
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
	m_dialog_tags=NULL;
	
	InvitationChatroom=false;
	compteurmessage=0;
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
	connect(Client::get_instance(),SIGNAL(signal_client_chatroom(QString)),this,SLOT(afficher_message_chatroom_window(QString)));
	connect(ui.actionTags,SIGNAL(triggered()),this,SLOT(ouvrir_dialog_tags()));
	connect(ui.ButtonRefresh,SIGNAL(clicked()),this,SLOT(actualisation_amis()));
	
	// Callback liés aux tableaux blancs
	connect(Client::get_instance(),SIGNAL(signal_participation_tableau_blanc(QString)),this,SLOT(ouvrir_dialog_tableaublanc(QString)));
	connect(Client::get_instance(),SIGNAL(signal_sync_tableau_blanc(QString,unsigned long)),this,SLOT(sync_tableau_blanc(QString,unsigned long)));

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
			sleep(1);		
		}
	
	m_dialog_window[indice]->ecrire_message(pseudo.toStdString(),message.toStdString());
}

void MainWindowImpl::afficher_message_chatroom_window(QString chatroom)
{
	
	cout<<"[DEBUG - Chatroom]\tMessage recu!"<<endl;
	if(Premiere_ouverture==true)
		{
			Premiere_ouverture=false;		
		}
	Message tmp =Client::get_instance()->get_message(chatroom.toStdString(),compteurmessage);
	compteurmessage++;
	m_dialog_chatroom_window->ecrire_message(tmp.auteur,tmp.message);

}

void MainWindowImpl::ouvrir_dialog_tags()
{
	cout<<"[DEBUG - GUI]Appel ouverture fenetre pour gerer les tags"<<endl;
	get_dialog_tags();
	m_dialog_tags->show();
	m_dialog_tags->exec();
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
	//m_dialog_window[indice]->setName("");
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
		//m_dialog_window[indice]->setWindowTitle(pseudo.toStdString());
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

Dialog_tags * MainWindowImpl::get_dialog_tags()
{
	if(m_dialog_tags == NULL)
	{
		m_dialog_tags = new Dialog_tags();
	}
	return m_dialog_tags;
}

void MainWindowImpl::afficher_dialog_connexion()
{
	cout << "[DEBUG - GUI]\t Afficher_boite" << endl ;
}

void MainWindowImpl::Inviter_chatroom()
{
	QListWidgetItem * temp =ui.qlistwidget_amis->currentItem();
	cout<<"[DEBUG - GUI]\tNom item:"<<temp->data(0).toString().toStdString()<<endl;
	Client::get_instance()->creer_chatroom("tmp");
	Client::get_instance()->inviter_client_chatroom(temp->data(0).toString().toStdString(),"tmp");
	Client::get_instance()->inviter_client_chatroom(Client::get_instance()->m_pseudo,"tmp");
	 
	
}

void MainWindowImpl::Ouvrir_chatroom(QString chatroom)
{
	cout<<"[DEBUG - GUI]\tSignal recu!"<<endl;
	get_dialog_chatroom_window(chatroom)->show();
	m_dialog_chatroom_window->exec();
}

void MainWindowImpl::ouvrir_dialog_tableaublanc (QString nom_tableaublanc)
{
	cout<<"[DEBUG - GUI]\tOuverture de la fenêtre " << nom_tableaublanc.toStdString() << endl;
	Dialog_tableaublanc * tableaublanc  = new Dialog_tableaublanc(NULL);
	tableaublanc->show();
	
	// Tester si le dialog existe déja ou pas !
	m_liste_dialog_tableauxblancs.insert( pair<string,Dialog_tableaublanc * >(nom_tableaublanc.toStdString(),tableaublanc));
}

void MainWindowImpl::sync_tableau_blanc (QString nom_tableau,unsigned long idpixel)
{
	unsigned long taille_tableau_blanc_widget,i ;
	taille_tableau_blanc_widget = m_liste_dialog_tableauxblancs[nom_tableau.toStdString()]->m_widget_tableaublanc->m_vect_qpoints->size();

	cout << "Taille tableau blanc = " << taille_tableau_blanc_widget <<  ", pixel maj = " << idpixel << endl ;
	for(i=taille_tableau_blanc_widget;i<idpixel;++i)
	{
		Pixel pixel = Client::get_instance()->get_pixel(nom_tableau.toStdString(),i);
		m_liste_dialog_tableauxblancs[nom_tableau.toStdString()]->m_widget_tableaublanc->ajouter_pixel(pixel);
	}
}

void MainWindowImpl::actualisation_amis()
{
	
	for (set<string>::iterator it=Client::get_instance()->liste_tags.begin(); it!=Client::get_instance()->liste_tags.end(); it++)
	{	
		Client::get_instance()->get_amis_par_tag(*it);
	}
	
	ui.qlistwidget_amis->clear();
	for (set<string>::iterator it=Client::get_instance()->liste_amis.begin(); it!=Client::get_instance()->liste_amis.end(); it++)
	{
		ajouter_ami(string(*it).c_str());
	}
	
}

Ui_MainWindow MainWindowImpl::get_ui()
{
	return ui;
}