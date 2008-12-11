#ifndef MAINWINDOWIMPL_H
#define MAINWINDOWIMPL_H

#include <QMainWindow>
#include <QString>
#include <QListWidgetItem>
#include "ui_mainwindow.h"
#include "dialog_connexion.h"
#include "dialog_window.h"

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
	Dialog_window * m_dialog_window ;
	
	MainWindowImpl( QWidget * parent = 0, Qt::WFlags f = 0 );
	void initialiser () ;
	
public slots:
	void afficher_dialog_connexion();
	void ouvrir_qpopupmenu_client (QListWidgetItem * item);
	void ouvrir_dialog_window(QListWidgetItem * item);
	void ajouter_ami (QString ami);
	void afficher_message_window(QString pseudo,QString message);

private:
	Ui_MainWindow ui;
	Dialog_connexion * get_dialog_connexion();
	Dialog_window * get_dialog_window(QString pseudo);
};
#endif
