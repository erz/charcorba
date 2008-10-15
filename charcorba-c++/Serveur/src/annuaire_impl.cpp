
#include <annuaire_impl.h>
#include <map>
#include <string>
#include <iostream>

using namespace std ;
// Implementation for interface Annuaire

CORBA::Boolean
Annuaire_impl::inscrire_serveur( const char* pseudo )
  throw(
    ::CORBA::SystemException)
{
  std::cout << "Entrée fonction serveur inscrire_serveur() " << std::endl ;
  CORBA::Boolean retval ;
  retval = true;
  ping_utilisateurs.insert(pair<string,int>(string(pseudo),0));
  std::cout << "Ajout de l'utilisateur " << pseudo << std::endl ;
  return retval; 
}

CORBA::Boolean
Annuaire_impl::nouveau_tag( const char* pseudo, const char* tag )
  throw(
    ::CORBA::SystemException)

{
  CORBA::Boolean retval;
  retval = true;
  annuaire_utilisateurs.insert(pair<string,string>(string(pseudo),string(tag)));
  annuaire_tags.insert(pair<string,string>(string(tag),string(pseudo)));
  std::cout << "Ajout du tag " << tag << " pour l'utilisateur " << pseudo << std::endl ;
  return retval; 
}


::Annuaire::t_liste_string*
Annuaire_impl::get_amis_par_tag( const char* tag )
  throw(
    ::CORBA::SystemException)

{
  ::Annuaire::t_liste_string* retval;
  
  multimap<string,string>::iterator i;
  cout << "Les utilisateurs appartenant au tag " << tag << " sont : " << endl;
  for (i = annuaire_tags.lower_bound(tag);
       i!= annuaire_tags.upper_bound(tag);
       i++)
   cout << (*i).second << endl;

  retval = new ::Annuaire::t_liste_string [annuaire_tags.count(tag)] ;
  return retval; 
}

