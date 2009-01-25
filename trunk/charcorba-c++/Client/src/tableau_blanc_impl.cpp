#include <string>
#include <tableau_blanc_impl.h>
#include <tableaublanc.h>
#include <client.h>
#include <QVector>
#include <pixel.h>

using namespace std;

TableauBlanc_impl::TableauBlanc_impl ()
{}

TableauBlanc_impl::TableauBlanc_impl (string nom_tableau)
{
	m_nom_tableau = nom_tableau ;
	m_vect_pixels = new QVector <Pixel> ();
}

// Implementation for interface TableauBlanc

CORBA::Boolean
TableauBlanc_impl::ajouter_pixel( const ::s_pixel& pixel )
  throw(
    ::CORBA::SystemException)
{
  CORBA::Boolean retval;
  //cout << "[DEBUG]\t[Tableau - '" << m_nom_tableau << "']\tAjout d'un pixel à la position ('" << pixel[0] << "," << pixel[1] << "'" << endl ; 
  
  m_vect_pixels->push_back(Pixel(QPoint(pixel.x,pixel.y),QColor(pixel.rouge,pixel.vert,pixel.bleu),pixel.est_continu));
  
  map<string,Standard_var>::iterator pos;
  for (pos = m_liste_participants.begin(); pos != m_liste_participants.end(); ++pos)
  {
      //cout << "[DEBUG]\t[Tableau - '" << m_nom_tableau << "']\tOn averti le client '" << pos->first << " de l'insertion du message d'id " << m_vect_pixels->size() <<  endl;
      pos->second->signal_tableaublanc (m_nom_tableau.c_str(),m_vect_pixels->size());
  }
  return retval; 
}

::s_pixel
TableauBlanc_impl::get_pixel( CORBA::ULong idpixel )
  throw(
    ::CORBA::SystemException)
{

  s_pixel pixel ;
  Pixel mon_pixel = m_vect_pixels->value(idpixel) ; 
  pixel.x = mon_pixel.m_qpoint.x();
  pixel.y = mon_pixel.m_qpoint.y();
  pixel.rouge = mon_pixel.m_qcolor.red();
  pixel.vert = mon_pixel.m_qcolor.green();
  pixel.bleu = mon_pixel.m_qcolor.blue();
  pixel.est_continu = mon_pixel.m_est_continu ;

  return pixel; 
}

void TableauBlanc_impl::inviter_client (string pseudo)
{
	//cout << "[DEBUG]\t[Tableau - '" << m_nom_tableau << "']\tOn invite le client '" << pseudo << "'" << endl ;
	CORBA::Object_var service_distant = Client::get_instance()->m_MICO_ORB->connecter_service(pseudo);

	Standard_var standard_distant = Standard::_narrow(service_distant.in()) ;
	standard_distant->inviter_client_tableaublanc(m_nom_tableau.c_str());
	m_liste_participants.insert( pair<string,Standard_var>(pseudo,standard_distant));
}

