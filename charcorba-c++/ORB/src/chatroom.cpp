/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <chatroom.h>


using namespace std;

//--------------------------------------------------------
//  Implementation of stubs
//--------------------------------------------------------


/*
 * Base interface for class Chatroom
 */

Chatroom::~Chatroom()
{
}

void *
Chatroom::_narrow_helper( const char *_repoid )
{
  if( strcmp( _repoid, "IDL:Chatroom:1.0" ) == 0 )
    return (void *)this;
  return NULL;
}

Chatroom_ptr
Chatroom::_narrow( CORBA::Object_ptr _obj )
{
  Chatroom_ptr _o;
  if( !CORBA::is_nil( _obj ) ) {
    void *_p;
    if( (_p = _obj->_narrow_helper( "IDL:Chatroom:1.0" )))
      return _duplicate( (Chatroom_ptr) _p );
    if (!strcmp (_obj->_repoid(), "IDL:Chatroom:1.0") || _obj->_is_a_remote ("IDL:Chatroom:1.0")) {
      _o = new Chatroom_stub;
      _o->CORBA::Object::operator=( *_obj );
      return _o;
    }
  }
  return _nil();
}

Chatroom_ptr
Chatroom::_narrow( CORBA::AbstractBase_ptr _obj )
{
  return _narrow (_obj->_to_object());
}

class _Marshaller_Chatroom : public ::CORBA::StaticTypeInfo {
    typedef Chatroom_ptr _MICO_T;
  public:
    ~_Marshaller_Chatroom();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    void release (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_Chatroom::~_Marshaller_Chatroom()
{
}

::CORBA::StaticValueType _Marshaller_Chatroom::create() const
{
  return (StaticValueType) new _MICO_T( 0 );
}

void _Marshaller_Chatroom::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = ::Chatroom::_duplicate( *(_MICO_T*) s );
}

void _Marshaller_Chatroom::free( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
  delete (_MICO_T*) v;
}

void _Marshaller_Chatroom::release( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
}

::CORBA::Boolean _Marshaller_Chatroom::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj;
  if (!::CORBA::_stc_Object->demarshal(dc, &obj))
    return FALSE;
  *(_MICO_T *) v = ::Chatroom::_narrow( obj );
  ::CORBA::Boolean ret = ::CORBA::is_nil (obj) || !::CORBA::is_nil (*(_MICO_T *)v);
  ::CORBA::release (obj);
  return ret;
}

void _Marshaller_Chatroom::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj = *(_MICO_T *) v;
  ::CORBA::_stc_Object->marshal( ec, &obj );
}

::CORBA::StaticTypeInfo *_marshaller_Chatroom;


/*
 * Stub interface for class Chatroom
 */

Chatroom_stub::~Chatroom_stub()
{
}

#ifndef MICO_CONF_NO_POA

void *
POA_Chatroom::_narrow_helper (const char * repoid)
{
  if (strcmp (repoid, "IDL:Chatroom:1.0") == 0) {
    return (void *) this;
  }
  return NULL;
}

POA_Chatroom *
POA_Chatroom::_narrow (PortableServer::Servant serv) 
{
  void * p;
  if ((p = serv->_narrow_helper ("IDL:Chatroom:1.0")) != NULL) {
    serv->_add_ref ();
    return (POA_Chatroom *) p;
  }
  return NULL;
}

Chatroom_stub_clp::Chatroom_stub_clp ()
{
}

Chatroom_stub_clp::Chatroom_stub_clp (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
  : CORBA::Object(*obj), PortableServer::StubBase(poa)
{
}

Chatroom_stub_clp::~Chatroom_stub_clp ()
{
}

#endif // MICO_CONF_NO_POA

CORBA::Boolean Chatroom_stub::ajouter_message( const char* _par_pseudo, const char* _par_message )
{
  CORBA::StaticAny _sa_pseudo( CORBA::_stc_string, &_par_pseudo );
  CORBA::StaticAny _sa_message( CORBA::_stc_string, &_par_message );
  CORBA::Boolean _res;
  CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );

  CORBA::StaticRequest __req( this, "ajouter_message" );
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
Chatroom_stub_clp::ajouter_message( const char* _par_pseudo, const char* _par_message )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Chatroom * _myserv = POA_Chatroom::_narrow (_serv);
    if (_myserv) {
      CORBA::Boolean __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->ajouter_message(_par_pseudo, _par_message);
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

  return Chatroom_stub::ajouter_message(_par_pseudo, _par_message);
}

#endif // MICO_CONF_NO_POA

Chatroom::t_string_auteur* Chatroom_stub::get_message( CORBA::ULong _par_idmessage )
{
  CORBA::StaticAny _sa_idmessage( CORBA::_stc_ulong, &_par_idmessage );
  CORBA::StaticAny __res( _marshaller__seq_2b_string );

  CORBA::StaticRequest __req( this, "get_message" );
  __req.add_in_arg( &_sa_idmessage );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return (Chatroom::t_string_auteur*) __res._retn();
}


#ifndef MICO_CONF_NO_POA

Chatroom::t_string_auteur*
Chatroom_stub_clp::get_message( CORBA::ULong _par_idmessage )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Chatroom * _myserv = POA_Chatroom::_narrow (_serv);
    if (_myserv) {
      Chatroom::t_string_auteur* __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->get_message(_par_idmessage);
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

  return Chatroom_stub::get_message(_par_idmessage);
}

#endif // MICO_CONF_NO_POA

class _Marshaller__seq_2b_string : public ::CORBA::StaticTypeInfo {
    typedef BoundedStringSequenceTmpl<CORBA::String_var,2> _MICO_T;
  public:
    ~_Marshaller__seq_2b_string();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller__seq_2b_string::~_Marshaller__seq_2b_string()
{
}

::CORBA::StaticValueType _Marshaller__seq_2b_string::create() const
{
  return (StaticValueType) new _MICO_T;
}

void _Marshaller__seq_2b_string::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = *(_MICO_T*) s;
}

void _Marshaller__seq_2b_string::free( StaticValueType v ) const
{
  delete (_MICO_T*) v;
}

::CORBA::Boolean _Marshaller__seq_2b_string::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::ULong len;
  if( !dc.seq_begin( len ) )
    return FALSE;
  ((_MICO_T *) v)->length( len );
  for( ::CORBA::ULong i = 0; i < len; i++ ) {
    if( !CORBA::_stc_string->demarshal( dc, &(*(_MICO_T*)v)[i]._for_demarshal() ) )
      return FALSE;
  }
  return dc.seq_end();
}

void _Marshaller__seq_2b_string::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::ULong len = ((_MICO_T *) v)->length();
  ec.seq_begin( len );
  for( ::CORBA::ULong i = 0; i < len; i++ )
    CORBA::_stc_string->marshal( ec, &(*(_MICO_T*)v)[i].inout() );
  ec.seq_end();
}

::CORBA::StaticTypeInfo *_marshaller__seq_2b_string;

struct __tc_init_CHATROOM {
  __tc_init_CHATROOM()
  {
    _marshaller_Chatroom = new _Marshaller_Chatroom;
    _marshaller__seq_2b_string = new _Marshaller__seq_2b_string;
  }

  ~__tc_init_CHATROOM()
  {
    delete static_cast<_Marshaller_Chatroom*>(_marshaller_Chatroom);
    delete static_cast<_Marshaller__seq_2b_string*>(_marshaller__seq_2b_string);
  }
};

static __tc_init_CHATROOM __init_CHATROOM;

//--------------------------------------------------------
//  Implementation of skeletons
//--------------------------------------------------------

// PortableServer Skeleton Class for interface Chatroom
POA_Chatroom::~POA_Chatroom()
{
}

::Chatroom_ptr
POA_Chatroom::_this ()
{
  CORBA::Object_var obj = PortableServer::ServantBase::_this();
  return ::Chatroom::_narrow (obj);
}

CORBA::Boolean
POA_Chatroom::_is_a (const char * repoid)
{
  if (strcmp (repoid, "IDL:Chatroom:1.0") == 0) {
    return TRUE;
  }
  return FALSE;
}

CORBA::InterfaceDef_ptr
POA_Chatroom::_get_interface ()
{
  CORBA::InterfaceDef_ptr ifd = PortableServer::ServantBase::_get_interface ("IDL:Chatroom:1.0");

  if (CORBA::is_nil (ifd)) {
    mico_throw (CORBA::OBJ_ADAPTER (0, CORBA::COMPLETED_NO));
  }

  return ifd;
}

CORBA::RepositoryId
POA_Chatroom::_primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr)
{
  return CORBA::string_dup ("IDL:Chatroom:1.0");
}

CORBA::Object_ptr
POA_Chatroom::_make_stub (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
{
  return new ::Chatroom_stub_clp (poa, obj);
}

bool
POA_Chatroom::dispatch (CORBA::StaticServerRequest_ptr __req)
{
  #ifdef HAVE_EXCEPTIONS
  try {
  #endif
    if( strcmp( __req->op_name(), "ajouter_message" ) == 0 ) {
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

      _res = ajouter_message( _par_pseudo.inout(), _par_message.inout() );
      __req->write_results();
      return true;
    }
    if( strcmp( __req->op_name(), "get_message" ) == 0 ) {
      CORBA::ULong _par_idmessage;
      CORBA::StaticAny _sa_idmessage( CORBA::_stc_ulong, &_par_idmessage );

      ::Chatroom::t_string_auteur* _res;
      CORBA::StaticAny __res( _marshaller__seq_2b_string );
      __req->add_in_arg( &_sa_idmessage );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = get_message( _par_idmessage );
      __res.value( _marshaller__seq_2b_string, _res );
      __req->write_results();
      delete _res;
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
POA_Chatroom::invoke (CORBA::StaticServerRequest_ptr __req)
{
  if (dispatch (__req)) {
      return;
  }

  CORBA::Exception * ex = 
    new CORBA::BAD_OPERATION (0, CORBA::COMPLETED_NO);
  __req->set_exception (ex);
  __req->write_results();
}

