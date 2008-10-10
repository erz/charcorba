#include <Compteur_impl.h>


// Implementation for interface Compteur

void
Compteur_impl::inc()
  throw(
    ::CORBA::SystemException)

{
  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 
	solde++;
}


void
Compteur_impl::dec()
  throw(
    ::CORBA::SystemException)

{
  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 
	solde--;
}


CORBA::Long
Compteur_impl::valeur()
  throw(
    ::CORBA::SystemException)

{
  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return solde; 
}

