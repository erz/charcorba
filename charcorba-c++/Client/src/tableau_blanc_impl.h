
#ifndef __TABLEAU_BLANC_IMPL_H__
#define __TABLEAU_BLANC_IMPL_H__

#include <tableau_blanc.h>
#include <standard.h>
#include <string>
#include <QVector>
#include <pixel.h>

// Implementation for interface TableauBlanc
class TableauBlanc_impl : virtual public POA_TableauBlanc
{
  private:
  
	std::string m_nom_tableau ;	
	std::map <std::string,Standard_var> m_liste_participants;
	QVector <Pixel> * m_vect_pixels ; 

  public:

	TableauBlanc_impl ();
	TableauBlanc_impl (std::string nom_tableau);

    CORBA::Boolean ajouter_pixel( const ::s_pixel& pixel )
      throw(
        ::CORBA::SystemException)
    ;

    ::s_pixel get_pixel( CORBA::ULong idpixel )
      throw(
        ::CORBA::SystemException)
    ;

    
    void inviter_client (std::string pseudo);
};


#endif
