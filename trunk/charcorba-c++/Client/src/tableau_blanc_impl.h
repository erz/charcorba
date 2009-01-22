
#ifndef __TABLEAU_BLANC_IMPL_H__
#define __TABLEAU_BLANC_IMPL_H__

#include <tableau_blanc.h>
#include <string>

// Implementation for interface TableauBlanc
class TableauBlanc_impl : virtual public POA_TableauBlanc
{
  private:
  
  	std::string m_nom_tableau ;

  public:

	TableauBlanc_impl ();
	TableauBlanc_impl (std::string nom_tableau);

    CORBA::Boolean ajouter_pixel( const ::TableauBlanc::t_pixel& pixel )
      throw(
        ::CORBA::SystemException)
    ;

    ::TableauBlanc::t_pixel* get_pixel( CORBA::ULong idpixel )
      throw(
        ::CORBA::SystemException)
    ;
    
    void inviter_client (std::string pseudo);
};


#endif
