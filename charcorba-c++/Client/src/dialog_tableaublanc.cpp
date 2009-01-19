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
	layout_palette->addWidget(new QPushButton("&Bleu",this));
	layout_palette->addWidget(new QPushButton("&Rouge",this));
	layout_palette->addWidget(new QPushButton("&Jaune",this));
	
	QVBoxLayout * layout_tableau = new QVBoxLayout ;
	layout_tableau->addWidget(m_widget_tableaublanc);	
	m_widget_tableaublanc->setMinimumSize(400,300);
	//m_widget_tableaublanc->setBackground(new QBrush("white"));

	QHBoxLayout * layout_horizontal = new QHBoxLayout ;
	layout_horizontal->addLayout(layout_tableau);
	layout_horizontal->addLayout(layout_palette);
	setLayout (layout_horizontal);	
}
