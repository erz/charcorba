#include <pixel.h>
#include <QPoint>
#include <QColor>

Pixel::Pixel()
{
	
}

Pixel::~Pixel()
{
	
}

Pixel::Pixel(QPoint qpoint, 
	         QColor qcolor,
	         bool est_continu)
{
	m_qpoint = qpoint;
	m_qcolor = qcolor;
	m_est_continu = est_continu ;
}
