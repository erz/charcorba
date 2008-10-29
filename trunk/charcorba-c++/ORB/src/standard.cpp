/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <standard.h>


using namespace std;

//--------------------------------------------------------
//  Implementation of stubs
//--------------------------------------------------------

/*
 * Base interface for class Standard
 */

Standard::~Standard()
{
}

void *
Standard::_narrow_helper( const char *_repoid )
{
  if( strcmp( _repoid, "IDL:Standard:1.0" ) == 0 )
    return (void *)this;
  return NULL;
}

Standard_ptr
Standard::_narrow( CORBA::Object_ptr _obj )
{
  Standard_ptr _o;
  if( !CORBA::is_nil( _obj ) ) {
    void *_p;
    if( (_p = _obj->_narrow_helper( "IDL:Standard:1.0" )))
      return _duplicate( (Standard_ptr) _p );
    if (!strcmp (_obj->_repoid(), "IDL:Standard:1.0") || _obj->_is_a_remote ("IDL:Standard:1.0")) {
      _o = new Standard_stub;
      _o->CORBA::Object::operator=( *_obj );
      return _o;
    }
  }
  return _nil();
}

Standard_ptr
Standard::_narrow( CORBA::AbstractBase_ptr _obj )
{
  return _narrow (_obj->_to_object());
}

class _Marshaller_Standard : public ::CORBA::StaticTypeInfo {
    typedef Standard_ptr _MICO_T;
  public:
    ~_Marshaller_Standard();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    void release (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_Standard::~_Marshaller_Standard()
{
}

::CORBA::StaticValueType _Marshaller_Standard::create() const
{
  return (StaticValueType) new _MICO_T( 0 );
}

void _Marshaller_Standard::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = ::Standard::_duplicate( *(_MICO_T*) s );
}

void _Marshaller_Standard::free( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
  delete (_MICO_T*) v;
}

void _Marshaller_Standard::release( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
}

::CORBA::Boolean _Marshaller_Standard::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj;
  if (!::CORBA::_stc_Object->demarshal(dc, &obj))
    return FALSE;
  *(_MICO_T *) v = ::Standard::_narrow( obj );
  ::CORBA::Boolean ret = ::CORBA::is_nil (obj) || !::CORBA::is_nil (*(_MICO_T *)v);
  ::CORBA::release (obj);
  return ret;
}

void _Marshaller_Standard::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj = *(_MICO_T *) v;
  ::CORBA::_stc_Object->marshal( ec, &obj );
}

::CORBA::StaticTypeInfo *_marshaller_Standard;


/*
 * Stub interface for class Standard
 */

Standard_stub::~Standard_stub()
{
}

#ifndef MICO_CONF_NO_POA

void *
POA_Standard::_narrow_helper (const char * repoid)
{
  if (strcmp (repoid, "IDL:Standard:1.0") == 0) {
    return (void *) this;
  }
  return NULL;
}

POA_Standard *
POA_Standard::_narrow (PortableServer::Servant serv) 
{
  void * p;
  if ((p = serv->_narrow_helper ("IDL:Standard:1.0")) != NULL) {
    serv->_add_ref ();
    return (POA_Standard *) p;
  }
  return NULL;
}

Standard_stub_clp::Standard_stub_clp ()
{
}

Standard_stub_clp::Standard_stub_clp (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
  : CORBA::Object(*obj), PortableServer::StubBase(poa)
{
}

Standard_stub_clp::~Standard_stub_clp ()
{
}

#endif // MICO_CONF_NO_POA

CORBA::Boolean Standard_stub::afficher_message( const char* _par_pseudo, const char* _par_message )
{
  CORBA::StaticAny _sa_pseudo( CORBA::_stc_string, &_par_pseudo );
  CORBA::StaticAny _sa_message( CORBA::_stc_string, &_par_message );
  CORBA::Boolean _res;
  CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );

  CORBA::StaticRequest __req( this, "afficher_message" );
  __req.add_in_arg( &_sa_pseudo );
  __req.add_in_arg( &_sa_message );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return _res;
}


#ifndef MICO_CONF_NO_POA

CORBA::Boolean
Standard_stub_clp::afficher_message( const char* _par_pseudo, const char* _par_message )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Standard * _myserv = POA_Standard::_narrow (_serv);
    if (_myserv) {
      CORBA::Boolean __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->afficher_message(_par_pseudo, _par_message);
      #ifdef HAVE_EXCEPTIONS
      }
      catch (...) {
        _myserv->_remove_ref();
        _postinvoke();
        throw;
      }
      #endif

      _myserv->_remove_ref();
      _postinvoke ();
      return __res;
    }
    _postinvoke ();
  }

  return Standard_stub::afficher_message(_par_pseudo, _par_message);
}

#endif // MICO_CONF_NO_POA

CORBA::Boolean Standard_stub::inviter_client( const char* _par_chatroom )
{
  CORBA::StaticAny _sa_chatroom( CORBA::_stc_string, &_par_chatroom );
  CORBA::Boolean _res;
  CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );

  CORBA::StaticRequest __req( this, "inviter_client" );
  __req.add_in_arg( &_sa_chatroom );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return _res;
}


#ifndef MICO_CONF_NO_POA

CORBA::Boolean
Standard_stub_clp::inviter_client( const char* _par_chatroom )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Standard * _myserv = POA_Standard::_narrow (_serv);
    if (_myserv) {
      CORBA::Boolean __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->inviter_client(_par_chatroom);
      #ifdef HAVE_EXCEPTIONS
      }
      catch (...) {
        _myserv->_remove_ref();
        _postinvoke();
        throw;
      }
      #endif

      _myserv->_remove_ref();
      _postinvoke ();
      return __res;
    }
    _postinvoke ();
  }

  return Standard_stub::inviter_client(_par_chatroom);
}

#endif // MICO_CONF_NO_POA

struct __tc_init_STANDARD {
  __tc_init_STANDARD()
  {
    _marshaller_Standard = new _Marshaller_Standard;
  }

  ~__tc_init_STANDARD()
  {
    delete static_cast<_Marshaller_Standard*>(_marshaller_Standard);
  }
};

static __tc_init_STANDARD __init_STANDARD;

//--------------------------------------------------------
//  Implementation of skeletons
//--------------------------------------------------------

// PortableServer Skeleton Class for interface Standard
POA_Standard::~POA_Standard()
{
}

::Standard_ptr
POA_Standard::_this ()
{
  CORBA::Object_var obj = PortableServer::ServantBase::_this();
  return ::Standard::_narrow (obj);
}

CORBA::Boolean
POA_Standard::_is_a (const char * repoid)
{
  if (strcmp (repoid, "IDL:Standard:1.0") == 0) {
    return TRUE;
  }
  return FALSE;
}

CORBA::InterfaceDef_ptr
POA_Standard::_get_interface ()
{
  CORBA::InterfaceDef_ptr ifd = PortableServer::ServantBase::_get_interface ("IDL:Standard:1.0");

  if (CORBA::is_nil (ifd)) {
    mico_throw (CORBA::OBJ_ADAPTER (0, CORBA::COMPLETED_NO));
  }

  return ifd;
}

CORBA::RepositoryId
POA_Standard::_primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr)
{
  return CORBA::string_dup ("IDL:Standard:1.0");
}

CORBA::Object_ptr
POA_Standard::_make_stub (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
{
  return new ::Standard_stub_clp (poa, obj);
}

bool
POA_Standard::dispatch (CORBA::StaticServerRequest_ptr __req)
{
  #ifdef HAVE_EXCEPTIONS
  try {
  #endif
    if( strcmp( __req->op_name(), "afficher_message" ) == 0 ) {
      CORBA::String_var _par_pseudo;
      CORBA::StaticAny _sa_pseudo( CORBA::_stc_string, &_par_pseudo._for_demarshal() );
      CORBA::String_var _par_message;
      CORBA::StaticAny _sa_message( CORBA::_stc_string, &_par_message._for_demarshal() );

      CORBA::Boolean _res;
      CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );
      __req->add_in_arg( &_sa_pseudo );
      __req->add_in_arg( &_sa_message );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = afficher_message( _par_pseudo.inout(), _par_message.inout() );
      __req->write_results();
      return true;
    }
    if( strcmp( __req->op_name(), "inviter_client" ) == 0 ) {
      CORBA::String_var _par_chatroom;
      CORBA::StaticAny _sa_chatroom( CORBA::_stc_string, &_par_chatroom._for_demarshal() );

      CORBA::Boolean _res;
      CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );
      __req->add_in_arg( &_sa_chatroom );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = inviter_client( _par_chatroom.inout() );
      __req->write_results();
      return true;
    }
  #ifdef HAVE_EXCEPTIONS
  } catch( CORBA::SystemException_catch &_ex ) {
    __req->set_exception( _ex->_clone() );
    __req->write_results();
    return true;
  } catch( ... ) {
    CORBA::UNKNOWN _ex (CORBA::OMGVMCID | 1, CORBA::COMPLETED_MAYBE);
    __req->set_exception (_ex->_clone());
    __req->write_results ();
    return true;
  }
  #endif

  return false;
}

void
POA_Standard::invoke (CORBA::StaticServerRequest_ptr __req)
{
  if (dispatch (__req)) {
      return;
  }

  CORBA::Exception * ex = 
    new CORBA::BAD_OPERATION (0, CORBA::COMPLETED_NO);
  __req->set_exception (ex);
  __req->write_results();
}

