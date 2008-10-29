
#ifndef __CHATROOM_IMPL_H__
#define __CHATROOM_IMPL_H__

#include <chatroom.h>


// Implementation for interface Chatroom
class Chatroom_impl : virtual public POA_Chatroom
{
  public:

    CORBA::Boolean ajouter_message( const char* pseudo, const char* message )
      throw(
        ::CORBA::SystemException)
    ;

    ::Chatroom::t_string_auteur* get_message( CORBA::ULong idmessage )
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
