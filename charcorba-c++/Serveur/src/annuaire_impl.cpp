
#include <client_annuaire.h>
#include <annuaire_impl.h>
#include <map>
#include <string>
#include <iostream>

using namespace std ;
// Implementation for interface Annuaire

Annuaire_impl * Annuaire_impl::m_static_annuaire = 0 ;

Annuaire_impl::Annuaire_impl()
{
	Annuaire_impl::m_static_annuaire = this ;
}

CORBA::Boolean
Annuaire_impl::joindre_annuaire( const char* pseudo )
  throw(
    ::CORBA::SystemException)
{
  cout << "[DEBUG]\tInscription du client '" << pseudo << "' dans l'annuaire " << endl ;
  CORBA::Boolean retval ;
  retval = true;
  m_liste_clients.insert(pair<string,Client_annuaire>(string(pseudo),Client_annuaire(string(pseudo))));
  return retval; 
}

CORBA::Boolean
Annuaire_impl::quitter_annuaire( const char* pseudo )
  throw(
    ::CORBA::SystemException)
{
  cout << "[DEBUG]\nRetrait du client '" << pseudo << "' de l'annuaire " << endl ;
  CORBA::Boolean retval ;
  retval = true;
  m_liste_clients.erase(string(pseudo));
  return retval; 
}

CORBA::Boolean
Annuaire_impl::ajouter_tag( const char* pseudo, const char* tag )
  throw(
    ::CORBA::SystemException)

{
  cout << "[DEBUG]\tAjout du tag '" << tag << "' pour l'utilisateur '" << pseudo << "'" << endl ;
  CORBA::Boolean retval;
  retval = true;
  m_liste_clients[pseudo].ajouter_tag(string(tag));
  return retval; 
}

CORBA::Boolean
Annuaire_impl::enlever_tag( const char* pseudo, const char* tag )
  throw(
    ::CORBA::SystemException)

{
  cout << "[DEBUG]\tRetrait du tag '" << tag << "' pour l'utilisateur '" << pseudo << "'" << endl ;
  CORBA::Boolean retval;
  retval = true;
  m_liste_clients[pseudo].enlever_tag(string(tag));
  return retval; 
}


::Annuaire::t_liste_string*
Annuaire_impl::get_amis_par_tag( const char* tag )
  throw(
    ::CORBA::SystemException)

{
	cout << "[DEBUG]\tRecherche des clients possédants le tag : '" << tag << "'" << endl ;
	::Annuaire::t_liste_string * retval = new ::Annuaire::t_liste_string ();

	int n=0;
	for( map<string,Client_annuaire>::iterator i=m_liste_clients.begin(); i!=m_liste_clients.end(); ++i)
	{
		if ( (*i).second.possede_tag(tag) )
		{
			retval->length(n+1);
			const char * c_tag = (*i).second.m_pseudo.c_str() ;
			CORBA::String_var s_tag (c_tag);
			(*retval)[n] = s_tag;
			++n;
		}
	}
	return retval; 
}


::Annuaire::t_liste_tags*
Annuaire_impl::get_tags()
  throw(
    ::CORBA::SystemException)

{
	cout << "[DEBUG]\tEnvoie des tags : '"  << endl ;
  ::Annuaire::t_liste_tags* retval=new ::Annuaire::t_liste_tags () ;
	int n=0;
	/*
	for( map<string,Client_annuaire>::iterator i=m_liste_clients.begin(); i!=m_liste_clients.end(); ++i)
	{
		if ( (*i).second.possede_tag(tag) )
		{
			retval->length(n+1);
			const char * c_tag = (*i).second.m_pseudo.c_str() ;
			CORBA::String_var s_tag (c_tag);
			(*retval)[n] = s_tag;
			++n;
		}
	}
 */
    mico_throw(::CORBA::NO_IMPLEMENT());


  return retval; 
 }
 