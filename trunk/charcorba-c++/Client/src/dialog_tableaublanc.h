#ifndef __DIALOG_TABLEAUBLANC_H__
#define __DIALOG_TABLEAUBLANC_H__

#include <QtGui/QWidget> 
#include <QtGui/QDialog>
#include <tableaublanc.h>

 
class Dialog_tableaublanc: public QDialog 
{
	Q_OBJECT 	
	Widget_tableaublanc * m_widget_tableaublanc ;
	
	public: 
		Dialog_tableaublanc(QWidget * parent = 0); 
} ; 
 
#endif // __DIALOG_TABLEAUBLANC_H__
