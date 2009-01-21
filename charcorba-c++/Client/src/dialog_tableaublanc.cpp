#include "dialog_tableaublanc.h"
#include "tableaublanc.h"

#include <QtGui/QDialog> 
#include <QtGui/QWidget>
#include <QtGui/QVBoxLayout>
#include <QtGui/QHBoxLayout>
#include <QtGui/QPushButton>

Dialog_tableaublanc::Dialog_tableaublanc(QWidget * parent): 
	QDialog(parent) 
{
	m_widget_tableaublanc = new Widget_tableaublanc ();

	QVBoxLayout * layout_palette = new QVBoxLayout ;

	m_pushbutton_bleu = new QPushButton("&Bleu",this) ;
	m_pushbutton_rouge = new QPushButton("&Rouge",this) ;
	m_pushbutton_vert = new QPushButton("&Vert",this) ;

	connect(m_pushbutton_bleu,SIGNAL(clicked()),m_widget_tableaublanc,SLOT(set_couleur_bleu()));
	connect(m_pushbutton_rouge,SIGNAL(clicked()),m_widget_tableaublanc,SLOT(set_couleur_rouge()));
	connect(m_pushbutton_vert,SIGNAL(clicked()),m_widget_tableaublanc,SLOT(set_couleur_vert()));
	
	layout_palette->addWidget(m_pushbutton_bleu);
	layout_palette->addWidget(m_pushbutton_rouge);
	layout_palette->addWidget(m_pushbutton_vert);
	
	QVBoxLayout * layout_tableau = new QVBoxLayout ;
	layout_tableau->addWidget(m_widget_tableaublanc);
	m_widget_tableaublanc->setMinimumSize(400,300);

	QHBoxLayout * layout_horizontal = new QHBoxLayout ;
	layout_horizontal->addLayout(layout_tableau);
	layout_horizontal->addLayout(layout_palette);
	setLayout (layout_horizontal);	
}
