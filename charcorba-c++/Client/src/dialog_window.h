#ifndef __DIALOG_WINDOW__H__
#define __DIALOG_WINDOW__H__

#include <QtGui>
#include <QDialog>
#include "ui_dialog_window.h"
#include <client.h>
#include <string>
#include <iostream>

class Dialog_window : public QDialog, private Ui::DialogWindow
{
	Q_OBJECT
public:
	Dialog_window();
	Dialog_window(QString pseudo);
	
public slots :
	void envoyer_message();
	void chatroom_envoyer_message();
	void ecrire_message(string pseudo,string message);
	void setWindowTitle(string titre);

private:

	Ui_DialogWindow ui;
	string client_distant ;
	string message ;
	string nom_chatroom;
};

#endif
