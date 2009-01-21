#ifndef __PIXEL_H__
#define __PIXEL_H__

#include <QPoint>
#include <QColor>

class Pixel 
{
	
public:

	QPoint m_qpoint ;
	QColor m_qcolor ;
	bool m_est_continu;

public:

	Pixel();
	Pixel(QPoint qpoint, 
	      QColor qcolor,
	      bool est_continu);

	~Pixel();

};

#endif // __PIXEL_H__
