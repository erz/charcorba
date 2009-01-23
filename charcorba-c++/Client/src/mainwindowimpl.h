#ifndef MAINWINDOWIMPL_H
#define MAINWINDOWIMPL_H

#include <QMainWindow>
#include <QString>
#include <QListWidgetItem>
#include "ui_mainwindow.h"
#include "dialog_connexion.h"
#include "dialog_window.h"
#include <dialog_tableaublanc.h>

#include <stdio.h>
#include <string>

#include <map>


class MainWindowImpl : public QMainWindow, public Ui::MainWindow
{

Q_OBJECT
public:
	int ARGC;
	char ** ARGV;
	Dialog_connexion * m_dialog_connexion ;
	Dialog_window *  m_dialog_window[5]  ;
	Dialog_window * m_dialog_chatroom_window  ;
	
	std::map <std::string,Dialog_tableaublanc *> m_liste_dialog_tableauxblancs ;
	
	MainWindowImpl( QWidget * parent = 0, Qt::WFlags f = 0 );
	void initialiser () ;
	
public slots:
	void afficher_dialog_connexion();
	void ouvrir_qpopupmenu_client (QListWidgetItem * item);
	void ouvrir_dialog_window(QListWidgetItem * item);
	void ouvrir_dialog_chatroom_window(QListWidgetItem * item);
	void ajouter_ami (QString ami);
	void afficher_message_window(QString pseudo,QString message);
	void Inviter_chatroom();
	void Ouvrir_chatroom(QString chatroom);
	void afficher_message_chatroom_window(QString chatroom);

	//Fonctions sur les tableaux blancs
	void ouvrir_dialog_tableaublanc (QString nom_tableaublanc);
	void ajouter_pixel (QString nom_tableaublancs,Pixel pixel);

private:
	Ui_MainWindow ui;
	Dialog_connexion * get_dialog_connexion();
	Dialog_window * get_dialog_window(QString pseudo,int indice);
	Dialog_window * get_dialog_chatroom_window(QString pseudo);
	bool Premiere_ouverture;
	unsigned long compteurmessage;
};
#endif
