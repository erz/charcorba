#ifndef __TABLEAUBLANC_H__
#define __TABLEAUBLANC_H__

#include <QtGui/QWidget> 
#include <QtGui/QPainter> 
#include <QtGui/QMouseEvent> 
#include <QPoint>
#include <QVector>
#include <pixel.h> 
 
using namespace std;
 
class Widget_tableaublanc : 
	public QWidget 
{
	Q_OBJECT 
	int last_x ;
	int last_y ;
	QColor m_qcolor_couleur_actuelle ;

	public: 
	QVector <Pixel> * m_vect_qpoints ; 

		Widget_tableaublanc(QWidget* parent = 0); 
		void ajouter_pixel (Pixel pixel);
	
	protected: 
		void mouseMoveEvent(QMouseEvent* e);
		void mouseReleaseEvent(QMouseEvent *event);
		void mousePressEvent(QMouseEvent *event);
		void paintEvent(QPaintEvent *event); 

	public slots :
		void set_couleur_bleu ();
		void set_couleur_rouge ();
		void set_couleur_vert ();
} ; 
 
#endif // __TABLEAUBLANC_H__
