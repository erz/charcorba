
#ifndef __STANDARD_IMPL_H__
#define __STANDARD_IMPL_H__

#include <standard.h>
#include <map>

using namespace std;
// Implementation for interface Standard
class Standard_impl : virtual public POA_Standard
{
  public:
  
  	static Standard_impl * m_static_standard  ;
  	
  	Standard_impl();
    // Clef = pseudo, message= dernier message
    //je laisse une map au cas ou on voudrait implementer une communication de groupe pour l'ordonancement des messages
	multimap <string,string> Liste_Messages ;
	
    CORBA::Boolean ajouter_message( const char* pseudo, const char* message )
      throw(
        ::CORBA::SystemException)
    ;

    ::Standard::t_liste_string* get_tag( const char* pseudo )
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
