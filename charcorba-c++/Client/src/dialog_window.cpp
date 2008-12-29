#include "dialog_window.h"


using namespace std;
// place your code here

Dialog_window::Dialog_window()
{
	cout<<"[DEBUG]\tDialog Chatroom Window"<<endl;
	ui.setupUi(this);
	connect(ui.pushButton,SIGNAL(clicked()),this,SLOT(chatroom_envoyer_message()));
}


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
		
		//On affiche le message dans la fenetre
		string tmp = ui.textEdit->toPlainText().toStdString();
		message="[Moi]\n"+message;
		if(!tmp.empty())
			message = tmp+"\n"+message;
		ui.textEdit->setText(message.c_str());
		
		//on vide la ligne
		ui.lineEdit->clear();
		ui.lineEdit->setFocus();
		
		
}

void Dialog_window::chatroom_envoyer_message()
{
	cout<<"[DEBUG]\tEnvoie du message sur la chatroom"<<endl;
	message=ui.lineEdit->text().toStdString();
	Client::get_instance()->ajouter_message("tmp",message);
	
}

void Dialog_window::ecrire_message(string pseudo,string message){
	//On affiche le message dans la fenetre
		string tmp = ui.textEdit->toPlainText().toStdString();
		message="["+pseudo+"]"+"\n"+message;
		if(!tmp.empty())
			message = tmp+"\n"+message;
		ui.textEdit->setText(message.c_str());
}
