/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <annuaire.h>


using namespace std;

//--------------------------------------------------------
//  Implementation of stubs
//--------------------------------------------------------

/*
 * Base interface for class Annuaire
 */

Annuaire::~Annuaire()
{
}

void *
Annuaire::_narrow_helper( const char *_repoid )
{
  if( strcmp( _repoid, "IDL:Annuaire:1.0" ) == 0 )
    return (void *)this;
  return NULL;
}

Annuaire_ptr
Annuaire::_narrow( CORBA::Object_ptr _obj )
{
  Annuaire_ptr _o;
  if( !CORBA::is_nil( _obj ) ) {
    void *_p;
    if( (_p = _obj->_narrow_helper( "IDL:Annuaire:1.0" )))
      return _duplicate( (Annuaire_ptr) _p );
    if (!strcmp (_obj->_repoid(), "IDL:Annuaire:1.0") || _obj->_is_a_remote ("IDL:Annuaire:1.0")) {
      _o = new Annuaire_stub;
      _o->CORBA::Object::operator=( *_obj );
      return _o;
    }
  }
  return _nil();
}

Annuaire_ptr
Annuaire::_narrow( CORBA::AbstractBase_ptr _obj )
{
  return _narrow (_obj->_to_object());
}

class _Marshaller_Annuaire : public ::CORBA::StaticTypeInfo {
    typedef Annuaire_ptr _MICO_T;
  public:
    ~_Marshaller_Annuaire();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    void release (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_Annuaire::~_Marshaller_Annuaire()
{
}

::CORBA::StaticValueType _Marshaller_Annuaire::create() const
{
  return (StaticValueType) new _MICO_T( 0 );
}

void _Marshaller_Annuaire::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = ::Annuaire::_duplicate( *(_MICO_T*) s );
}

void _Marshaller_Annuaire::free( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
  delete (_MICO_T*) v;
}

void _Marshaller_Annuaire::release( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
}

::CORBA::Boolean _Marshaller_Annuaire::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj;
  if (!::CORBA::_stc_Object->demarshal(dc, &obj))
    return FALSE;
  *(_MICO_T *) v = ::Annuaire::_narrow( obj );
  ::CORBA::Boolean ret = ::CORBA::is_nil (obj) || !::CORBA::is_nil (*(_MICO_T *)v);
  ::CORBA::release (obj);
  return ret;
}

void _Marshaller_Annuaire::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj = *(_MICO_T *) v;
  ::CORBA::_stc_Object->marshal( ec, &obj );
}

::CORBA::StaticTypeInfo *_marshaller_Annuaire;


/*
 * Stub interface for class Annuaire
 */

Annuaire_stub::~Annuaire_stub()
{
}

#ifndef MICO_CONF_NO_POA

void *
POA_Annuaire::_narrow_helper (const char * repoid)
{
  if (strcmp (repoid, "IDL:Annuaire:1.0") == 0) {
    return (void *) this;
  }
  return NULL;
}

POA_Annuaire *
POA_Annuaire::_narrow (PortableServer::Servant serv) 
{
  void * p;
  if ((p = serv->_narrow_helper ("IDL:Annuaire:1.0")) != NULL) {
    serv->_add_ref ();
    return (POA_Annuaire *) p;
  }
  return NULL;
}

Annuaire_stub_clp::Annuaire_stub_clp ()
{
}

Annuaire_stub_clp::Annuaire_stub_clp (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
  : CORBA::Object(*obj), PortableServer::StubBase(poa)
{
}

Annuaire_stub_clp::~Annuaire_stub_clp ()
{
}

#endif // MICO_CONF_NO_POA

void Annuaire_stub::ajouter( CORBA::ULong _par_id )
{
  CORBA::StaticAny _sa_id( CORBA::_stc_ulong, &_par_id );
  CORBA::StaticRequest __req( this, "ajouter" );
  __req.add_in_arg( &_sa_id );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
}


#ifndef MICO_CONF_NO_POA

void
Annuaire_stub_clp::ajouter( CORBA::ULong _par_id )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_Annuaire * _myserv = POA_Annuaire::_narrow (_serv);
    if (_myserv) {
      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        _myserv->ajouter(_par_id);
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

  Annuaire_stub::ajouter(_par_id);
}

#endif // MICO_CONF_NO_POA

struct __tc_init_ANNUAIRE {
  __tc_init_ANNUAIRE()
  {
    _marshaller_Annuaire = new _Marshaller_Annuaire;
  }

  ~__tc_init_ANNUAIRE()
  {
    delete static_cast<_Marshaller_Annuaire*>(_marshaller_Annuaire);
  }
};

static __tc_init_ANNUAIRE __init_ANNUAIRE;

//--------------------------------------------------------
//  Implementation of skeletons
//--------------------------------------------------------

// PortableServer Skeleton Class for interface Annuaire
POA_Annuaire::~POA_Annuaire()
{
}

::Annuaire_ptr
POA_Annuaire::_this ()
{
  CORBA::Object_var obj = PortableServer::ServantBase::_this();
  return ::Annuaire::_narrow (obj);
}

CORBA::Boolean
POA_Annuaire::_is_a (const char * repoid)
{
  if (strcmp (repoid, "IDL:Annuaire:1.0") == 0) {
    return TRUE;
  }
  return FALSE;
}

CORBA::InterfaceDef_ptr
POA_Annuaire::_get_interface ()
{
  CORBA::InterfaceDef_ptr ifd = PortableServer::ServantBase::_get_interface ("IDL:Annuaire:1.0");

  if (CORBA::is_nil (ifd)) {
    mico_throw (CORBA::OBJ_ADAPTER (0, CORBA::COMPLETED_NO));
  }

  return ifd;
}

CORBA::RepositoryId
POA_Annuaire::_primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr)
{
  return CORBA::string_dup ("IDL:Annuaire:1.0");
}

CORBA::Object_ptr
POA_Annuaire::_make_stub (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
{
  return new ::Annuaire_stub_clp (poa, obj);
}

bool
POA_Annuaire::dispatch (CORBA::StaticServerRequest_ptr __req)
{
  #ifdef HAVE_EXCEPTIONS
  try {
  #endif
    if( strcmp( __req->op_name(), "ajouter" ) == 0 ) {
      CORBA::ULong _par_id;
      CORBA::StaticAny _sa_id( CORBA::_stc_ulong, &_par_id );

      __req->add_in_arg( &_sa_id );

      if( !__req->read_args() )
        return true;

      ajouter( _par_id );
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
POA_Annuaire::invoke (CORBA::StaticServerRequest_ptr __req)
{
  if (dispatch (__req)) {
      return;
  }

  CORBA::Exception * ex = 
    new CORBA::BAD_OPERATION (0, CORBA::COMPLETED_NO);
  __req->set_exception (ex);
  __req->write_results();
}

