
#ifndef __COMPTEUR_IMPL_H__
#define __COMPTEUR_IMPL_H__

#include <Compteur.h>


// Implementation for interface Compteur
class Compteur_impl : virtual public POA_Compteur
{
  private:
  	CORBA::Long solde;

  public:

    void inc()
      throw(
        ::CORBA::SystemException)
    ;

    void dec()
      throw(
        ::CORBA::SystemException)
    ;

    CORBA::Long valeur()
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
