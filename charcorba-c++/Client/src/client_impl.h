
#ifndef __CLIENT_IMPL_H__
#define __CLIENT_IMPL_H__

#include <client.h>


// Implementation for interface Client_Distant
class Client_Distant_impl : virtual public POA_Client_Distant
{
  public:

    CORBA::Boolean ajouter_message( const char* pseudo, const char* message )
      throw(
        ::CORBA::SystemException)
    ;

    ::Client_Distant::t_liste_string* get_tag( const char* pseudo )
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
