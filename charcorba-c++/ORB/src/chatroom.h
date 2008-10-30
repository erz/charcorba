/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <CORBA.h>
#include <mico/throw.h>

#ifndef __CHATROOM_H__
#define __CHATROOM_H__




class Chatroom;
typedef Chatroom *Chatroom_ptr;
typedef Chatroom_ptr ChatroomRef;
typedef ObjVar< Chatroom > Chatroom_var;
typedef ObjOut< Chatroom > Chatroom_out;




/*
 * Base class and common definitions for interface Chatroom
 */

class Chatroom : 
  virtual public CORBA::Object
{
  public:
    virtual ~Chatroom();

    #ifdef HAVE_TYPEDEF_OVERLOAD
    typedef Chatroom_ptr _ptr_type;
    typedef Chatroom_var _var_type;
    #endif

    static Chatroom_ptr _narrow( CORBA::Object_ptr obj );
    static Chatroom_ptr _narrow( CORBA::AbstractBase_ptr obj );
    static Chatroom_ptr _duplicate( Chatroom_ptr _obj )
    {
      CORBA::Object::_duplicate (_obj);
      return _obj;
    }

    static Chatroom_ptr _nil()
    {
      return 0;
    }

    virtual void *_narrow_helper( const char *repoid );

    typedef BoundedStringSequenceTmpl<CORBA::String_var,2> t_string_auteur;
    typedef TSeqVar< BoundedStringSequenceTmpl<CORBA::String_var,2> > t_string_auteur_var;
    typedef TSeqOut< BoundedStringSequenceTmpl<CORBA::String_var,2> > t_string_auteur_out;

    virtual CORBA::Boolean ajouter_message( const char* pseudo, const char* message ) = 0;
    virtual ::Chatroom::t_string_auteur* get_message( CORBA::ULong idmessage ) = 0;

  protected:
    Chatroom() {};
  private:
    Chatroom( const Chatroom& );
    void operator=( const Chatroom& );
};

// Stub for interface Chatroom
class Chatroom_stub:
  virtual public Chatroom
{
  public:
    virtual ~Chatroom_stub();
    CORBA::Boolean ajouter_message( const char* pseudo, const char* message );
    ::Chatroom::t_string_auteur* get_message( CORBA::ULong idmessage );

  private:
    void operator=( const Chatroom_stub& );
};

#ifndef MICO_CONF_NO_POA

class Chatroom_stub_clp :
  virtual public Chatroom_stub,
  virtual public PortableServer::StubBase
{
  public:
    Chatroom_stub_clp (PortableServer::POA_ptr, CORBA::Object_ptr);
    virtual ~Chatroom_stub_clp ();
    CORBA::Boolean ajouter_message( const char* pseudo, const char* message );
    ::Chatroom::t_string_auteur* get_message( CORBA::ULong idmessage );

  protected:
    Chatroom_stub_clp ();
  private:
    void operator=( const Chatroom_stub_clp & );
};

#endif // MICO_CONF_NO_POA

#ifndef MICO_CONF_NO_POA

class POA_Chatroom : virtual public PortableServer::StaticImplementation
{
  public:
    virtual ~POA_Chatroom ();
    Chatroom_ptr _this ();
    bool dispatch (CORBA::StaticServerRequest_ptr);
    virtual void invoke (CORBA::StaticServerRequest_ptr);
    virtual CORBA::Boolean _is_a (const char *);
    virtual CORBA::InterfaceDef_ptr _get_interface ();
    virtual CORBA::RepositoryId _primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr);

    virtual void * _narrow_helper (const char *);
    static POA_Chatroom * _narrow (PortableServer::Servant);
    virtual CORBA::Object_ptr _make_stub (PortableServer::POA_ptr, CORBA::Object_ptr);

    virtual CORBA::Boolean ajouter_message( const char* pseudo, const char* message ) = 0;
    virtual ::Chatroom::t_string_auteur* get_message( CORBA::ULong idmessage ) = 0;

  protected:
    POA_Chatroom () {};

  private:
    POA_Chatroom (const POA_Chatroom &);
    void operator= (const POA_Chatroom &);
};

#endif // MICO_CONF_NO_POA

extern CORBA::StaticTypeInfo *_marshaller_Chatroom;

extern CORBA::StaticTypeInfo *_marshaller__seq_2b_string;

#endif
