
#include <annuaire_impl.h>
#include <iostream>

using namespace std;

// Implementation for interface Annuaire

void
Annuaire_impl::ajouter( CORBA::ULong id )
  throw(
    ::CORBA::SystemException)
{
	cout << "Ajout !!!!!!!!" << endl ;
    mico_throw(::CORBA::NO_IMPLEMENT());
}
