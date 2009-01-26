#include "dialog_tags.h"
#include "client.h"


Dialog_tags::Dialog_tags()
{
	cout<<"[DEBUG GUI]\tOuverture Dialog tags"<<endl;
	ui.setupUi(this);
	Actualisation_tags();
	connect(ui.ButtonAjoutTag,SIGNAL(clicked()),this,SLOT(Ajouter_tags()));
	connect(ui.Buttoncopiertag,SIGNAL(clicked()),this,SLOT(Copier_tags_distant()));
	connect(ui.Buttonsupprimertag,SIGNAL(clicked()),this,SLOT(Supprimer_tag_local()));
}

void Dialog_tags::Ajouter_tags()
{
	cout<<"[DEBUG GUI]\tAjout tag"<<endl;
	Client::get_instance()->ajouter_tag(ui.lineEditTags->text().toStdString());
	Actualisation_tags();
}

void Dialog_tags::Actualisation_tags()
{
	
	//Init
	ui.listTagsServeur->clear();
	ui.listTagsLocal->clear();
	Annuaire_var tmp=Client::get_instance()->get_annuaire();
	
	::Annuaire::t_liste_string* retval = tmp->get_tags() ;
	CORBA::ULong i=0;
	for (i=0;i< retval->length();++i)
	{
		CORBA::String_var tag = (*retval)[i] ;
		QListWidgetItem * qitem_tag = new QListWidgetItem (string(tag).c_str());
		ui.listTagsServeur->addItem(qitem_tag);		
	}
	
	set <std::string> liste_locale=Client::get_instance()->liste_tags;
	
	for (set<string>::iterator it=liste_locale.begin(); it!=liste_locale.end(); it++)
	{	
		QListWidgetItem * qitem_tag = new QListWidgetItem (string(*it).c_str());
		ui.listTagsLocal->addItem(qitem_tag);		
	}
}

void Dialog_tags::Copier_tags_distant()
{
	
	Client::get_instance()->ajouter_tag(ui.listTagsServeur->currentItem()->text().toStdString());
	Actualisation_tags();
	
}

void Dialog_tags::Supprimer_tag_local()
{
	Client::get_instance()->enlever_tag(ui.listTagsLocal->currentItem()->text().toStdString());
	Actualisation_tags();
}