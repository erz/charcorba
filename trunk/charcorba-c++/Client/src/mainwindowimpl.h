#ifndef MAINWINDOWIMPL_H
#define MAINWINDOWIMPL_H
//
#include <QMainWindow>
#include "ui_mainwindow.h"
#include <stdio.h>
//

class MainWindowImpl : public QMainWindow, public Ui::MainWindow
{
Q_OBJECT
public:
	int ARGC;
	char ** ARGV;
	MainWindowImpl( QWidget * parent = 0, Qt::WFlags f = 0 );
	
public slots:
	//void Connection();
	void Initialiser();
private slots:

private:
Ui_MainWindow ui;
};
#endif




