/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <Compteur.h>


using namespace std;

//--------------------------------------------------------
//  Implementation of stubs
//--------------------------------------------------------

/*
 * Base interface for class Compteur
 */

Compteur::~Compteur()
{
}

void *
Compteur::_narrow_helper( const char *_repoid )
{
  if( strcmp( _repoid, "IDL:Compteur:1.0" ) == 0 )
    return (void *)this;
  return NULL;
}

Compteur_ptr
Compteur::_narrow( CORBA::Object_ptr _obj )
{
  Compteur_ptr _o;
  if( !CORBA::is_nil( _obj ) ) {
    void *_p;
    if( (_p = _obj->_narrow_helper( "IDL:Compteur:1.0" )))
      return _duplicate( (Compteur_ptr) _p );
    if (!strcmp (_obj->_repoid(), "IDL:Compteur:1.0") || _obj->_is_a_remote ("IDL:Compteur:1.0")) {
      _o = new Compteur_stub;
      _o->CORBA::Object::operator=( *_obj );
      return _o;
    }
  }
  return _nil();
}

Compteur_ptr
Compteur::_narrow( CORBA::AbstractBase_ptr _obj )
{
  return _narrow (_obj->_to_object());
}

class _Marshaller_Compteur : public ::CORBA::StaticTypeInfo {
    typedef Compteur_ptr _MICO_T;
  public:
    ~_Marshaller_Compteur();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    void release (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_Compteur::~_Marshaller_Compteur()
{
}

::CORBA::StaticValueType _Marshaller_Compteur::create() const
{
  return (StaticValueType) new _MICO_T( 0 );
}

void _Marshaller_Compteur::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = ::Compteur::_duplicate( *(_MICO_T*) s );
}

void _Marshaller_Compteur::free( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
  delete (_MICO_T*) v;
}

void _Marshaller_Compteur::release( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
}

::CORBA::Boolean _Marshaller_Compteur::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj;
  if (!::CORBA::_stc_Object->demarshal(dc, &obj))
    return FALSE;
  *(_MICO_T *) v = ::Compteur::_narrow( obj );
  ::CORBA::Boolean ret = ::CORBA::is_nil (obj) || !::CORBA::is_nil (*(_MICO_T *)v);
  ::CORBA::release (obj);
  return ret;
}

void _Marshaller_Compteur::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj = *(_MICO_T *) v;
  ::CORBA::_stc_Object->marshal( ec, &obj );
}

::CORBA::StaticTypeInfo *_marshaller_Compteur;


/*
 * Stub interface for class Compteur
 */

Compteur_stub::~Compteur_stub()
{
}

#ifndef MICO_CONF_NO_POA

void *
POA_Compteur::_narrow_helper (const char * repoid)
{
  if (strcmp (repoid, "IDL:Compteur:1.0") == 0) {
    return (void *) this;
  }
  return NULL;
}

POA_Compteur *
POA_Compteur::_narrow (PortableServer::Servant serv) 
{
  void * p;
  if ((p = serv->_narrow_helper ("IDL:Compteur:1.0")) != NULL) {
    serv->_add_ref ();
    return (POA_Compteur *) p;
  }
  return NULL;
}

Compteur_stub_clp::Compteur_stub_clp ()
{
}

Compteur_stub_clp::Compteur_stub_clp (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
  : CORBA::Object(*obj), PortableServer::StubBase(poa)
{
}

Compteur_stub_clp::~Compteur_stub_clp ()
{
}

#endif // MICO_CONF_NO_POA

void Compteur_stub::inc()
{
  CORBA::StaticRequest __req( this, "inc" );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
}


#ifndef MICO_CONF_NO_POA

void
Compteur_stub_clp::inc()
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Compteur * _myserv = POA_Compteur::_narrow (_serv);
    if (_myserv) {
      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        _myserv->inc();
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
      return;
    }
    _postinvoke ();
  }

  Compteur_stub::inc();
}

#endif // MICO_CONF_NO_POA

void Compteur_stub::dec()
{
  CORBA::StaticRequest __req( this, "dec" );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
}


#ifndef MICO_CONF_NO_POA

void
Compteur_stub_clp::dec()
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Compteur * _myserv = POA_Compteur::_narrow (_serv);
    if (_myserv) {
      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        _myserv->dec();
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
      return;
    }
    _postinvoke ();
  }

  Compteur_stub::dec();
}

#endif // MICO_CONF_NO_POA

CORBA::Long Compteur_stub::valeur()
{
  CORBA::Long _res;
  CORBA::StaticAny __res( CORBA::_stc_long, &_res );

  CORBA::StaticRequest __req( this, "valeur" );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return _res;
}


#ifndef MICO_CONF_NO_POA

CORBA::Long
Compteur_stub_clp::valeur()
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Compteur * _myserv = POA_Compteur::_narrow (_serv);
    if (_myserv) {
      CORBA::Long __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->valeur();
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

  return Compteur_stub::valeur();
}

#endif // MICO_CONF_NO_POA

struct __tc_init_COMPTEUR {
  __tc_init_COMPTEUR()
  {
    _marshaller_Compteur = new _Marshaller_Compteur;
  }

  ~__tc_init_COMPTEUR()
  {
    delete static_cast<_Marshaller_Compteur*>(_marshaller_Compteur);
  }
};

static __tc_init_COMPTEUR __init_COMPTEUR;

//--------------------------------------------------------
//  Implementation of skeletons
//--------------------------------------------------------

// PortableServer Skeleton Class for interface Compteur
POA_Compteur::~POA_Compteur()
{
}

::Compteur_ptr
POA_Compteur::_this ()
{
  CORBA::Object_var obj = PortableServer::ServantBase::_this();
  return ::Compteur::_narrow (obj);
}

CORBA::Boolean
POA_Compteur::_is_a (const char * repoid)
{
  if (strcmp (repoid, "IDL:Compteur:1.0") == 0) {
    return TRUE;
  }
  return FALSE;
}

CORBA::InterfaceDef_ptr
POA_Compteur::_get_interface ()
{
  CORBA::InterfaceDef_ptr ifd = PortableServer::ServantBase::_get_interface ("IDL:Compteur:1.0");

  if (CORBA::is_nil (ifd)) {
    mico_throw (CORBA::OBJ_ADAPTER (0, CORBA::COMPLETED_NO));
  }

  return ifd;
}

CORBA::RepositoryId
POA_Compteur::_primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr)
{
  return CORBA::string_dup ("IDL:Compteur:1.0");
}

CORBA::Object_ptr
POA_Compteur::_make_stub (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
{
  return new ::Compteur_stub_clp (poa, obj);
}

bool
POA_Compteur::dispatch (CORBA::StaticServerRequest_ptr __req)
{
  #ifdef HAVE_EXCEPTIONS
  try {
  #endif
    if( strcmp( __req->op_name(), "inc" ) == 0 ) {

      if( !__req->read_args() )
        return true;

      inc();
      __req->write_results();
      return true;
    }
    if( strcmp( __req->op_name(), "dec" ) == 0 ) {

      if( !__req->read_args() )
        return true;

      dec();
      __req->write_results();
      return true;
    }
    if( strcmp( __req->op_name(), "valeur" ) == 0 ) {
      CORBA::Long _res;
      CORBA::StaticAny __res( CORBA::_stc_long, &_res );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = valeur();
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
POA_Compteur::invoke (CORBA::StaticServerRequest_ptr __req)
{
  if (dispatch (__req)) {
      return;
  }

  CORBA::Exception * ex = 
    new CORBA::BAD_OPERATION (0, CORBA::COMPLETED_NO);
  __req->set_exception (ex);
  __req->write_results();
}

