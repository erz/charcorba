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
  return retval; 
}

::TableauBlanc::t_pixel*
TableauBlanc_impl::get_pixel( CORBA::ULong idpixel )
  throw(
    ::CORBA::SystemException)

{
  ::TableauBlanc::t_pixel* retval;
  return retval; 
}

void TableauBlanc_impl::inviter_client (string pseudo)
{
	cout << "[DEBUG]\t[Tableau - '" << m_nom_tableau << "']\tOn invite le client '" << pseudo << "'" << endl ;
	CORBA::Object_var service_distant = Client::get_instance()->m_MICO_ORB->connecter_service(pseudo);

	Standard_var standard_distant = Standard::_narrow(service_distant.in()) ;
	standard_distant->inviter_client(m_nom_chatroom.c_str());
	
	m_liste_participants.insert( pair<string,Standard_var>(pseudo,standard_distant));
}

