
#include <annuaire_impl.h>
#include <map>
#include <iostream>
#include <string>
using namespace std ;


// Implementation for interface Annuaire

CORBA::Boolean
Annuaire_impl::joindre_annuaire( const char* pseudo )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}




CORBA::Boolean
Annuaire_impl::ajouter_tag( const char* pseudo, const char* tag )
  throw(
    ::CORBA::SystemException)

{
  cout << "[DEBUG]\tInscription du client '" << pseudo << "' dans l'annuaire " << endl ;	
  CORBA::Boolean retval;
  retval = true;
  ping_utilisateurs.insert(pair<string,int>(string(pseudo),0));
  

  return retval; 
}





::Annuaire::t_liste_string*
Annuaire_impl::get_amis_par_tag( const char* tag )
  throw(
    ::CORBA::SystemException)

{
  cout << "[DEBUG]\tRecherche des clients possédants le tag : '" << tag << "'" << endl ;
  ::Annuaire::t_liste_string* retval;
  retval = new ::Annuaire::t_liste_string (annuaire_tags.count(tag)) ;

  retval->length(annuaire_tags.count(tag));
multimap<string,string>::iterator i;
CORBA::ULong n=0;

for (i = annuaire_tags.lower_bound(tag);i!= annuaire_tags.upper_bound(tag);i++)
	{
		const char * c_tag = (*i).second.c_str() ;
		CORBA::String_var s_tag (c_tag);
		(*retval)[n] = s_tag;
		n++;	
	}



  return retval; 
}

