
#ifndef __CHATROOM_IMPL_H__
#define __CHATROOM_IMPL_H__

#include <chatroom.h>
#include <vector>
#include <set>
#include <standard.h>

struct Message
{
	std::string message ;
	std::string auteur ;
};

// Implementation for interface Chatroom
class Chatroom_impl : virtual public POA_Chatroom
{
	
  private:
  
	std::string m_nom_chatroom ;
	std::vector <Message> m_liste_messages ;
	std::map <std::string,Standard_var> m_liste_participants;

  public:

	Chatroom_impl ();
	Chatroom_impl (std::string nom_chatroom);

    CORBA::Boolean ajouter_message( const char* pseudo, const char* message )
      throw(
        ::CORBA::SystemException)
    ;

    ::Chatroom::t_string_auteur* get_message( CORBA::ULong idmessage )
      throw(
        ::CORBA::SystemException)
    ;
    
    void inviter_client (std::string pseudo);
};


#endif
