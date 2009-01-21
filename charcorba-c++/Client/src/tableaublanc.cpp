#include <tableaublanc.h>

#include <QtGui/QWidget> 
#include <QtGui/QPainter> 
#include <QtGui/QMouseEvent> 
#include <QtGui/QBrush>
#include <QVector>
#include <QPoint>
#include <ctype.h>
#include <iostream>
#include <pixel.h>

using namespace std;

Widget_tableaublanc::Widget_tableaublanc(QWidget* parent ): QWidget(parent) 
{
	setPalette(QPalette(QColor(255, 255, 255)));
	setAutoFillBackground(true);
	m_vect_qpoints = new QVector <Pixel> () ;
	m_qcolor_couleur_actuelle = QColor (Qt::black);
}

void Widget_tableaublanc::mouseMoveEvent(QMouseEvent* e) 
{
	m_vect_qpoints->push_back(Pixel(QPoint(e->x(),e->y()),
	                                m_qcolor_couleur_actuelle,
	                                true));
	repaint();
}

void Widget_tableaublanc::mousePressEvent(QMouseEvent *e)
{
	m_vect_qpoints->push_back(Pixel(QPoint(e->x(),e->y()),
	                                m_qcolor_couleur_actuelle,
	                                false));
	repaint();
}

void Widget_tableaublanc::mouseReleaseEvent(QMouseEvent *e)
{
	m_vect_qpoints->push_back(Pixel(QPoint(e->x(),e->y()),
	                                m_qcolor_couleur_actuelle,
	                                false));
}

void Widget_tableaublanc::paintEvent(QPaintEvent *evnt)
{
	QPainter painter(this) ;
	painter.setPen(QPen(Qt::black));
	int i;
	for(i=0;i<m_vect_qpoints->size();++i)
	{
		Pixel point = m_vect_qpoints->value(i);
		painter.setPen(QPen(m_qcolor_couleur_actuelle));
		if (point.m_est_continu == true )
		{
			Pixel point_prec = m_vect_qpoints->value(i-1);
			painter.drawLine(point_prec.m_qpoint,point.m_qpoint);
		}
		else
		{
			painter.drawPoint(point.m_qpoint);
		}
	}
}

void Widget_tableaublanc::set_couleur_bleu ()
{
	m_qcolor_couleur_actuelle = QColor (Qt::blue) ;
}

void Widget_tableaublanc::set_couleur_rouge ()
{
	m_qcolor_couleur_actuelle = QColor (Qt::red) ;
}

void Widget_tableaublanc::set_couleur_vert ()
{
	m_qcolor_couleur_actuelle = QColor (Qt::green) ;
}
