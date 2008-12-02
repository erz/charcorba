#ifndef MAINWINDOWIMPL_H
#define MAINWINDOWIMPL_H
//
#include <QMainWindow>
#include "ui_mainwindow.h"
#include "dialog_connexion.h"
#include <stdio.h>
//

class MainWindowImpl : public QMainWindow, public Ui::MainWindow
{

Q_OBJECT
public:
	int ARGC;
	char ** ARGV;
	Dialog_connexion * m_dialog_connexion ;
	
	MainWindowImpl( QWidget * parent = 0, Qt::WFlags f = 0 );
	
public slots:
	void afficher_dialog_connexion();

private:
	Ui_MainWindow ui;
	Dialog_connexion * get_dialog_connexion();
};
#endif
