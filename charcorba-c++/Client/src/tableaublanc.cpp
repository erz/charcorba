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
#include <client.h>

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
	Client::get_instance()->ajouter_pixel (string("tableau_test"),
                                          Pixel(QPoint(e->x(),e->y()),
	                                      m_qcolor_couleur_actuelle,
	                                      true));
}

void Widget_tableaublanc::mousePressEvent(QMouseEvent *e)
{
	Client::get_instance()->ajouter_pixel (string("tableau_test"),
                                          Pixel(QPoint(e->x(),e->y()),
	                                      m_qcolor_couleur_actuelle,
	                                      false));
}

void Widget_tableaublanc::mouseReleaseEvent(QMouseEvent *e)
{
	Client::get_instance()->ajouter_pixel (string("tableau_test"),
                                          Pixel(QPoint(e->x(),e->y()),
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
		//cout << point.m_qpoint.x() << ":" <<  point.m_qpoint.y() << endl ;
		painter.setPen(QPen(point.m_qcolor));
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

void Widget_tableaublanc::ajouter_pixel (Pixel pixel)
{
	//cout << "On dessine le pixel " << pixel.m_qpoint.x() << "," << pixel.m_qpoint.y() << endl ;
	m_vect_qpoints->push_back(pixel);
	repaint();
}

