/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <CORBA.h>
#include <mico/throw.h>

#ifndef __ANNUAIRE_H__
#define __ANNUAIRE_H__




class Annuaire;
typedef Annuaire *Annuaire_ptr;
typedef Annuaire_ptr AnnuaireRef;
typedef ObjVar< Annuaire > Annuaire_var;
typedef ObjOut< Annuaire > Annuaire_out;




/*
 * Base class and common definitions for interface Annuaire
 */

class Annuaire : 
  virtual public CORBA::Object
{
  public:
    virtual ~Annuaire();

    #ifdef HAVE_TYPEDEF_OVERLOAD
    typedef Annuaire_ptr _ptr_type;
    typedef Annuaire_var _var_type;
    #endif

    static Annuaire_ptr _narrow( CORBA::Object_ptr obj );
    static Annuaire_ptr _narrow( CORBA::AbstractBase_ptr obj );
    static Annuaire_ptr _duplicate( Annuaire_ptr _obj )
    {
      CORBA::Object::_duplicate (_obj);
      return _obj;
    }

    static Annuaire_ptr _nil()
    {
      return 0;
    }

    virtual void *_narrow_helper( const char *repoid );

    typedef StringSequenceTmpl<CORBA::String_var> t_liste_string;
    typedef TSeqVar< StringSequenceTmpl<CORBA::String_var> > t_liste_string_var;
    typedef TSeqOut< StringSequenceTmpl<CORBA::String_var> > t_liste_string_out;

    virtual CORBA::Boolean inscrire_serveur( const char* pseudo ) = 0;
    virtual CORBA::Boolean nouveau_tag( const char* pseudo, const char* tag ) = 0;
    virtual ::Annuaire::t_liste_string* get_amis_par_tag( const char* tag ) = 0;

  protected:
    Annuaire() {};
  private:
    Annuaire( const Annuaire& );
    void operator=( const Annuaire& );
};

// Stub for interface Annuaire
class Annuaire_stub:
  virtual public Annuaire
{
  public:
    virtual ~Annuaire_stub();
    CORBA::Boolean inscrire_serveur( const char* pseudo );
    CORBA::Boolean nouveau_tag( const char* pseudo, const char* tag );
    ::Annuaire::t_liste_string* get_amis_par_tag( const char* tag );

  private:
    void operator=( const Annuaire_stub& );
};

#ifndef MICO_CONF_NO_POA

class Annuaire_stub_clp :
  virtual public Annuaire_stub,
  virtual public PortableServer::StubBase
{
  public:
    Annuaire_stub_clp (PortableServer::POA_ptr, CORBA::Object_ptr);
    virtual ~Annuaire_stub_clp ();
    CORBA::Boolean inscrire_serveur( const char* pseudo );
    CORBA::Boolean nouveau_tag( const char* pseudo, const char* tag );
    ::Annuaire::t_liste_string* get_amis_par_tag( const char* tag );

  protected:
    Annuaire_stub_clp ();
  private:
    void operator=( const Annuaire_stub_clp & );
};

#endif // MICO_CONF_NO_POA

#ifndef MICO_CONF_NO_POA

class POA_Annuaire : virtual public PortableServer::StaticImplementation
{
  public:
    virtual ~POA_Annuaire ();
    Annuaire_ptr _this ();
    bool dispatch (CORBA::StaticServerRequest_ptr);
    virtual void invoke (CORBA::StaticServerRequest_ptr);
    virtual CORBA::Boolean _is_a (const char *);
    virtual CORBA::InterfaceDef_ptr _get_interface ();
    virtual CORBA::RepositoryId _primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr);

    virtual void * _narrow_helper (const char *);
    static POA_Annuaire * _narrow (PortableServer::Servant);
    virtual CORBA::Object_ptr _make_stub (PortableServer::POA_ptr, CORBA::Object_ptr);

    virtual CORBA::Boolean inscrire_serveur( const char* pseudo ) = 0;
    virtual CORBA::Boolean nouveau_tag( const char* pseudo, const char* tag ) = 0;
    virtual ::Annuaire::t_liste_string* get_amis_par_tag( const char* tag ) = 0;

  protected:
    POA_Annuaire () {};

  private:
    POA_Annuaire (const POA_Annuaire &);
    void operator= (const POA_Annuaire &);
};

#endif // MICO_CONF_NO_POA

extern CORBA::StaticTypeInfo *_marshaller_Annuaire;

#endif
