#ifndef __ANNUAIRE_IMPL_H__
#define __ANNUAIRE_IMPL_H__

#include <annuaire.h>

// Implementation for interface Annuaire
class Annuaire_impl : virtual public POA_Annuaire
{
	private:
		CORBA::Long solde;

  public:

    void ajouter( CORBA::ULong id )
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
