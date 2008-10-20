
#ifndef __STANDARD_IMPL_H__
#define __STANDARD_IMPL_H__

#include <standard.h>


// Implementation for interface Standard
class Standard_impl : virtual public POA_Standard
{
  public:

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
