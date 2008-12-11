#include "dialog_window.h"


using namespace std;
// place your code here
Dialog_window::Dialog_window(QString pseudo)
{
	cout<<"[DEBUG]\tDialog Window"<<endl;
	ui.setupUi(this);
	client_distant= pseudo.toStdString();
	connect(ui.pushButton,SIGNAL(clicked()),this,SLOT(envoyer_message()));
	
}

void Dialog_window::envoyer_message(){
	  
		message=ui.lineEdit->text().toStdString();
		Client::get_instance()->afficher_message(client_distant,message);
		
		string tmp = ui.textEdit->toPlainText().toStdString();
		message = tmp+"\n"+message;
		ui.textEdit->setText(message.c_str());
}

void Dialog_window::ecrire_message(){
}