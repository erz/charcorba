/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <CORBA.h>
#include <mico/throw.h>

#ifndef __STANDARD_H__
#define __STANDARD_H__




class Standard;
typedef Standard *Standard_ptr;
typedef Standard_ptr StandardRef;
typedef ObjVar< Standard > Standard_var;
typedef ObjOut< Standard > Standard_out;




/*
 * Base class and common definitions for interface Standard
 */

class Standard : 
  virtual public CORBA::Object
{
  public:
    virtual ~Standard();

    #ifdef HAVE_TYPEDEF_OVERLOAD
    typedef Standard_ptr _ptr_type;
    typedef Standard_var _var_type;
    #endif

    static Standard_ptr _narrow( CORBA::Object_ptr obj );
    static Standard_ptr _narrow( CORBA::AbstractBase_ptr obj );
    static Standard_ptr _duplicate( Standard_ptr _obj )
    {
      CORBA::Object::_duplicate (_obj);
      return _obj;
    }

    static Standard_ptr _nil()
    {
      return 0;
    }

    virtual void *_narrow_helper( const char *repoid );

    virtual CORBA::Boolean afficher_message( const char* pseudo, const char* message ) = 0;
    virtual CORBA::Boolean signal_chatroom( const char* chatroom, CORBA::ULong idpixel ) = 0;
    virtual CORBA::Boolean signal_tableaublanc( const char* tableau, CORBA::ULong idpixel ) = 0;
    virtual CORBA::Boolean inviter_client( const char* chatroom ) = 0;
    virtual CORBA::Boolean ping() = 0;

  protected:
    Standard() {};
  private:
    Standard( const Standard& );
    void operator=( const Standard& );
};

// Stub for interface Standard
class Standard_stub:
  virtual public Standard
{
  public:
    virtual ~Standard_stub();
    CORBA::Boolean afficher_message( const char* pseudo, const char* message );
    CORBA::Boolean signal_chatroom( const char* chatroom, CORBA::ULong idpixel );
    CORBA::Boolean signal_tableaublanc( const char* tableau, CORBA::ULong idpixel );
    CORBA::Boolean inviter_client( const char* chatroom );
    CORBA::Boolean ping();

  private:
    void operator=( const Standard_stub& );
};

#ifndef MICO_CONF_NO_POA

class Standard_stub_clp :
  virtual public Standard_stub,
  virtual public PortableServer::StubBase
{
  public:
    Standard_stub_clp (PortableServer::POA_ptr, CORBA::Object_ptr);
    virtual ~Standard_stub_clp ();
    CORBA::Boolean afficher_message( const char* pseudo, const char* message );
    CORBA::Boolean signal_chatroom( const char* chatroom, CORBA::ULong idpixel );
    CORBA::Boolean signal_tableaublanc( const char* tableau, CORBA::ULong idpixel );
    CORBA::Boolean inviter_client( const char* chatroom );
    CORBA::Boolean ping();

  protected:
    Standard_stub_clp ();
  private:
    void operator=( const Standard_stub_clp & );
};

#endif // MICO_CONF_NO_POA

#ifndef MICO_CONF_NO_POA

class POA_Standard : virtual public PortableServer::StaticImplementation
{
  public:
    virtual ~POA_Standard ();
    Standard_ptr _this ();
    bool dispatch (CORBA::StaticServerRequest_ptr);
    virtual void invoke (CORBA::StaticServerRequest_ptr);
    virtual CORBA::Boolean _is_a (const char *);
    virtual CORBA::InterfaceDef_ptr _get_interface ();
    virtual CORBA::RepositoryId _primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr);

    virtual void * _narrow_helper (const char *);
    static POA_Standard * _narrow (PortableServer::Servant);
    virtual CORBA::Object_ptr _make_stub (PortableServer::POA_ptr, CORBA::Object_ptr);

    virtual CORBA::Boolean afficher_message( const char* pseudo, const char* message ) = 0;
    virtual CORBA::Boolean signal_chatroom( const char* chatroom, CORBA::ULong idpixel ) = 0;
    virtual CORBA::Boolean signal_tableaublanc( const char* tableau, CORBA::ULong idpixel ) = 0;
    virtual CORBA::Boolean inviter_client( const char* chatroom ) = 0;
    virtual CORBA::Boolean ping() = 0;

  protected:
    POA_Standard () {};

  private:
    POA_Standard (const POA_Standard &);
    void operator= (const POA_Standard &);
};

#endif // MICO_CONF_NO_POA

extern CORBA::StaticTypeInfo *_marshaller_Standard;

#endif
