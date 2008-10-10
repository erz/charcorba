/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <CORBA.h>
#include <mico/throw.h>

#ifndef __COMPTEUR_H__
#define __COMPTEUR_H__




class Compteur;
typedef Compteur *Compteur_ptr;
typedef Compteur_ptr CompteurRef;
typedef ObjVar< Compteur > Compteur_var;
typedef ObjOut< Compteur > Compteur_out;

/*
 * Base class and common definitions for interface Compteur
 */

class Compteur : 
  virtual public CORBA::Object
{
  public:
    virtual ~Compteur();

    #ifdef HAVE_TYPEDEF_OVERLOAD
    typedef Compteur_ptr _ptr_type;
    typedef Compteur_var _var_type;
    #endif

    static Compteur_ptr _narrow( CORBA::Object_ptr obj );
    static Compteur_ptr _narrow( CORBA::AbstractBase_ptr obj );
    static Compteur_ptr _duplicate( Compteur_ptr _obj )
    {
      CORBA::Object::_duplicate (_obj);
      return _obj;
    }

    static Compteur_ptr _nil()
    {
      return 0;
    }

    virtual void *_narrow_helper( const char *repoid );

    virtual void inc() = 0;
    virtual void dec() = 0;
    virtual CORBA::Long valeur() = 0;

  protected:
    Compteur() {};
  private:
    Compteur( const Compteur& );
    void operator=( const Compteur& );
};

// Stub for interface Compteur
class Compteur_stub:
  virtual public Compteur
{
  public:
    virtual ~Compteur_stub();
    void inc();
    void dec();
    CORBA::Long valeur();

  private:
    void operator=( const Compteur_stub& );
};

#ifndef MICO_CONF_NO_POA

class Compteur_stub_clp :
  virtual public Compteur_stub,
  virtual public PortableServer::StubBase
{
  public:
    Compteur_stub_clp (PortableServer::POA_ptr, CORBA::Object_ptr);
    virtual ~Compteur_stub_clp ();
    void inc();
    void dec();
    CORBA::Long valeur();

  protected:
    Compteur_stub_clp ();
  private:
    void operator=( const Compteur_stub_clp & );
};

#endif // MICO_CONF_NO_POA

#ifndef MICO_CONF_NO_POA

class POA_Compteur : virtual public PortableServer::StaticImplementation
{
  public:
    virtual ~POA_Compteur ();
    Compteur_ptr _this ();
    bool dispatch (CORBA::StaticServerRequest_ptr);
    virtual void invoke (CORBA::StaticServerRequest_ptr);
    virtual CORBA::Boolean _is_a (const char *);
    virtual CORBA::InterfaceDef_ptr _get_interface ();
    virtual CORBA::RepositoryId _primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr);

    virtual void * _narrow_helper (const char *);
    static POA_Compteur * _narrow (PortableServer::Servant);
    virtual CORBA::Object_ptr _make_stub (PortableServer::POA_ptr, CORBA::Object_ptr);

    virtual void inc() = 0;
    virtual void dec() = 0;
    virtual CORBA::Long valeur() = 0;

  protected:
    POA_Compteur () {};

  private:
    POA_Compteur (const POA_Compteur &);
    void operator= (const POA_Compteur &);
};

#endif // MICO_CONF_NO_POA

extern CORBA::StaticTypeInfo *_marshaller_Compteur;

#endif
