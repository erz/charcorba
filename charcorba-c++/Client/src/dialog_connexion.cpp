#include <QtGui>
#include "dialog_connexion.h"
#include "client.h"
#include "autotest_client.h"
#include <iostream>
#include <stdlib.h>


using namespace std;

Dialog_connexion::Dialog_connexion(QWidget * parent, Qt::WFlags f) 
	: QDialog (parent, f)
{
	cout << "[DEBUG - GUI]\tCréation dialog connexion" << endl;
	ui.setupUi(this);

	connect(ui.qpushbutton_OK,SIGNAL(clicked()),this,SLOT(initialiser_client()));
}


void Dialog_connexion::initialiser_client ()
{
		cout << "[DEBUG - GUI]\tIP =\t" << ui.qlinedit_ip->text().toStdString() << endl ;
		cout << "[DEBUG - GUI]\tPort=\t" << ui.qlinedit_port->text().toStdString() << endl ;

		char *argv[] = { "ABC", "-ORBInitRef",
						"NameService=corbaloc::localhost:10809/NameService" };
		int argc = 3;
}
