#include <tableaublanc.h>

#include <QtGui/QWidget> 
#include <QtGui/QPainter> 
#include <QtGui/QMouseEvent> 
#include <QtGui/QBrush>
#include <QVector>
#include <QPoint>
#include <ctype.h>
#include <iostream>

using namespace std;

Widget_tableaublanc::Widget_tableaublanc(QWidget* parent ): QWidget(parent) 
{
	setPalette(QPalette(QColor(255, 255, 255)));
	setAutoFillBackground(true);
	m_vect_qpoints = new QVector <QPoint> () ;
}
 
void Widget_tableaublanc::mouseMoveEvent(QMouseEvent* e) 
{
	qDebug("(%d,%d)",e->x(), e->y()) ;
	m_vect_qpoints->push_back(QPoint(e->x(),e->y()));
	repaint();
}

void Widget_tableaublanc::mouseReleaseEvent(QMouseEvent *event)
{
	m_vect_qpoints->push_back(QPoint(0,0));
}

void Widget_tableaublanc::paintEvent(QPaintEvent *evnt)
{
	QPainter painter(this) ;
	int i;	
	for(i=1;i<m_vect_qpoints->size();++i)
	{
		QPoint point = m_vect_qpoints->value(i);
		if (point.x() == 0 && point.y() == 0 )
			i=i+1;
		else
			painter.drawLine(m_vect_qpoints->value(i-1),m_vect_qpoints->value(i));
	}
}