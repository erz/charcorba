#ifndef __TABLEAUBLANC_H__
#define __TABLEAUBLANC_H__

#include <QtGui/QWidget> 
#include <QtGui/QPainter> 
#include <QtGui/QMouseEvent> 
#include <QPoint>
#include <QVector>
 
using namespace std;
 
class Widget_tableaublanc: public QWidget 
{
	Q_OBJECT 
 	int last_x ;
 	int last_y ;
	
	QVector <QPoint> * m_vect_qpoints ; 
 
 public: 
   Widget_tableaublanc(QWidget* parent = 0); 
 
 protected: 
   void mouseMoveEvent(QMouseEvent* e);
   void mouseReleaseEvent(QMouseEvent *event);
   void paintEvent(QPaintEvent *event); 
} ; 
 
#endif // __TABLEAUBLANC_H__
