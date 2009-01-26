#ifndef __DIALOG_TAGS_H__
#define __DIALOG_TAGS_H__

#include <QtGui>
#include <QDialog>
#include "ui_dialog_tags.h"
#include <string>
#include <iostream>


using namespace std;

class  Dialog_tags:public QDialog, private Ui::DialogTags
{
	Q_OBJECT
	
	public:
	Dialog_tags();
	void Actualisation_tags();
	
	public slots:
	void Ajouter_tags();
	void Copier_tags_distant();
	
	private:
	Ui_DialogTags ui;
};

#endif // __DIALOG_TAGS_H__