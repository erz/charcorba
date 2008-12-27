
#ifndef __STANDARD_IMPL_H__
#define __STANDARD_IMPL_H__
#include <QObject>
#include <QDialog>
#include <standard.h>
#include <map>

using namespace std;
// Implementation for interface Standard
class Standard_impl : virtual public POA_Standard
{
  public:
  
  	static Standard_impl * m_static_standard  ;
  	
  	Standard_impl();
	
    CORBA::Boolean afficher_message( const char* pseudo, const char* message )
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Boolean inviter_client( const char* chatroom )
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Boolean signal_chatroom( const char* chatroom )
      throw(
        ::CORBA::SystemException)
    ;
    
    CORBA::Boolean ping()
      throw(
        ::CORBA::SystemException)
    ;
    signals:
    void ajout_message(QString);
    void invitation_chatroom(QString);

};


#endif
