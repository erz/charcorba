#include <string>
#include <tableau_blanc_impl.h>

using namespace std;

TableauBlanc_impl::TableauBlanc_impl ()
{}

TableauBlanc_impl::TableauBlanc_impl (string nom_tableau)
{
	m_nom_tableau = nom_tableau ;	
}

// Implementation for interface TableauBlanc

CORBA::Boolean
TableauBlanc_impl::ajouter_pixel( const ::TableauBlanc::t_pixel& pixel )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}


::TableauBlanc::t_pixel*
TableauBlanc_impl::get_pixel( CORBA::ULong idpixel )
  throw(
    ::CORBA::SystemException)

{
  ::TableauBlanc::t_pixel* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

