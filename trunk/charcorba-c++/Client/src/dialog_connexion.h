#ifndef DIALOG_CONNEXION_H
#define DIALOG_CONNEXION_H

#include <QDialog>
#include "ui_dialog_connexion.h"

class Dialog_connexion : public QDialog, private Ui::Dialog
{
	Q_OBJECT
public:
	Dialog_connexion(QWidget * parent = 0, Qt::WFlags f = 0 );

public slots :
	void initialiser_client ();

private:
Ui_Dialog ui;

};

#endif
