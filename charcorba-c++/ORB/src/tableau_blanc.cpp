/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <tableau_blanc.h>


using namespace std;

//--------------------------------------------------------
//  Implementation of stubs
//--------------------------------------------------------
#ifdef HAVE_EXPLICIT_STRUCT_OPS
s_pixel::s_pixel()
{
}

s_pixel::s_pixel( const s_pixel& _s )
{
  x = ((s_pixel&)_s).x;
  y = ((s_pixel&)_s).y;
  rouge = ((s_pixel&)_s).rouge;
  vert = ((s_pixel&)_s).vert;
  bleu = ((s_pixel&)_s).bleu;
  est_continu = ((s_pixel&)_s).est_continu;
}

s_pixel::~s_pixel()
{
}

s_pixel&
s_pixel::operator=( const s_pixel& _s )
{
  x = ((s_pixel&)_s).x;
  y = ((s_pixel&)_s).y;
  rouge = ((s_pixel&)_s).rouge;
  vert = ((s_pixel&)_s).vert;
  bleu = ((s_pixel&)_s).bleu;
  est_continu = ((s_pixel&)_s).est_continu;
  return *this;
}
#endif

class _Marshaller_s_pixel : public ::CORBA::StaticTypeInfo {
    typedef s_pixel _MICO_T;
  public:
    ~_Marshaller_s_pixel();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_s_pixel::~_Marshaller_s_pixel()
{
}

::CORBA::StaticValueType _Marshaller_s_pixel::create() const
{
  return (StaticValueType) new _MICO_T;
}

void _Marshaller_s_pixel::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = *(_MICO_T*) s;
}

void _Marshaller_s_pixel::free( StaticValueType v ) const
{
  delete (_MICO_T*) v;
}

::CORBA::Boolean _Marshaller_s_pixel::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  return
    dc.struct_begin() &&
    CORBA::_stc_short->demarshal( dc, &((_MICO_T*)v)->x ) &&
    CORBA::_stc_short->demarshal( dc, &((_MICO_T*)v)->y ) &&
    CORBA::_stc_short->demarshal( dc, &((_MICO_T*)v)->rouge ) &&
    CORBA::_stc_short->demarshal( dc, &((_MICO_T*)v)->vert ) &&
    CORBA::_stc_short->demarshal( dc, &((_MICO_T*)v)->bleu ) &&
    CORBA::_stc_boolean->demarshal( dc, &((_MICO_T*)v)->est_continu ) &&
    dc.struct_end();
}

void _Marshaller_s_pixel::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ec.struct_begin();
  CORBA::_stc_short->marshal( ec, &((_MICO_T*)v)->x );
  CORBA::_stc_short->marshal( ec, &((_MICO_T*)v)->y );
  CORBA::_stc_short->marshal( ec, &((_MICO_T*)v)->rouge );
  CORBA::_stc_short->marshal( ec, &((_MICO_T*)v)->vert );
  CORBA::_stc_short->marshal( ec, &((_MICO_T*)v)->bleu );
  CORBA::_stc_boolean->marshal( ec, &((_MICO_T*)v)->est_continu );
  ec.struct_end();
}

::CORBA::StaticTypeInfo *_marshaller_s_pixel;



/*
 * Base interface for class TableauBlanc
 */

TableauBlanc::~TableauBlanc()
{
}

void *
TableauBlanc::_narrow_helper( const char *_repoid )
{
  if( strcmp( _repoid, "IDL:TableauBlanc:1.0" ) == 0 )
    return (void *)this;
  return NULL;
}

TableauBlanc_ptr
TableauBlanc::_narrow( CORBA::Object_ptr _obj )
{
  TableauBlanc_ptr _o;
  if( !CORBA::is_nil( _obj ) ) {
    void *_p;
    if( (_p = _obj->_narrow_helper( "IDL:TableauBlanc:1.0" )))
      return _duplicate( (TableauBlanc_ptr) _p );
    if (!strcmp (_obj->_repoid(), "IDL:TableauBlanc:1.0") || _obj->_is_a_remote ("IDL:TableauBlanc:1.0")) {
      _o = new TableauBlanc_stub;
      _o->CORBA::Object::operator=( *_obj );
      return _o;
    }
  }
  return _nil();
}

TableauBlanc_ptr
TableauBlanc::_narrow( CORBA::AbstractBase_ptr _obj )
{
  return _narrow (_obj->_to_object());
}

class _Marshaller_TableauBlanc : public ::CORBA::StaticTypeInfo {
    typedef TableauBlanc_ptr _MICO_T;
  public:
    ~_Marshaller_TableauBlanc();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    void release (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_TableauBlanc::~_Marshaller_TableauBlanc()
{
}

::CORBA::StaticValueType _Marshaller_TableauBlanc::create() const
{
  return (StaticValueType) new _MICO_T( 0 );
}

void _Marshaller_TableauBlanc::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = ::TableauBlanc::_duplicate( *(_MICO_T*) s );
}

void _Marshaller_TableauBlanc::free( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
  delete (_MICO_T*) v;
}

void _Marshaller_TableauBlanc::release( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
}

::CORBA::Boolean _Marshaller_TableauBlanc::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj;
  if (!::CORBA::_stc_Object->demarshal(dc, &obj))
    return FALSE;
  *(_MICO_T *) v = ::TableauBlanc::_narrow( obj );
  ::CORBA::Boolean ret = ::CORBA::is_nil (obj) || !::CORBA::is_nil (*(_MICO_T *)v);
  ::CORBA::release (obj);
  return ret;
}

void _Marshaller_TableauBlanc::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj = *(_MICO_T *) v;
  ::CORBA::_stc_Object->marshal( ec, &obj );
}

::CORBA::StaticTypeInfo *_marshaller_TableauBlanc;


/*
 * Stub interface for class TableauBlanc
 */

TableauBlanc_stub::~TableauBlanc_stub()
{
}

#ifndef MICO_CONF_NO_POA

void *
POA_TableauBlanc::_narrow_helper (const char * repoid)
{
  if (strcmp (repoid, "IDL:TableauBlanc:1.0") == 0) {
    return (void *) this;
  }
  return NULL;
}

POA_TableauBlanc *
POA_TableauBlanc::_narrow (PortableServer::Servant serv) 
{
  void * p;
  if ((p = serv->_narrow_helper ("IDL:TableauBlanc:1.0")) != NULL) {
    serv->_add_ref ();
    return (POA_TableauBlanc *) p;
  }
  return NULL;
}

TableauBlanc_stub_clp::TableauBlanc_stub_clp ()
{
}

TableauBlanc_stub_clp::TableauBlanc_stub_clp (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
  : CORBA::Object(*obj), PortableServer::StubBase(poa)
{
}

TableauBlanc_stub_clp::~TableauBlanc_stub_clp ()
{
}

#endif // MICO_CONF_NO_POA

CORBA::Boolean TableauBlanc_stub::ajouter_pixel( const s_pixel& _par_pixel )
{
  CORBA::StaticAny _sa_pixel( _marshaller_s_pixel, &_par_pixel );
  CORBA::Boolean _res;
  CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );

  CORBA::StaticRequest __req( this, "ajouter_pixel" );
  __req.add_in_arg( &_sa_pixel );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return _res;
}


#ifndef MICO_CONF_NO_POA

CORBA::Boolean
TableauBlanc_stub_clp::ajouter_pixel( const s_pixel& _par_pixel )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_TableauBlanc * _myserv = POA_TableauBlanc::_narrow (_serv);
    if (_myserv) {
      CORBA::Boolean __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->ajouter_pixel(_par_pixel);
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

  return TableauBlanc_stub::ajouter_pixel(_par_pixel);
}

#endif // MICO_CONF_NO_POA

s_pixel TableauBlanc_stub::get_pixel( CORBA::ULong _par_idpixel )
{
  CORBA::StaticAny _sa_idpixel( CORBA::_stc_ulong, &_par_idpixel );
  s_pixel _res;
  CORBA::StaticAny __res( _marshaller_s_pixel, &_res );

  CORBA::StaticRequest __req( this, "get_pixel" );
  __req.add_in_arg( &_sa_idpixel );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return _res;
}


#ifndef MICO_CONF_NO_POA

s_pixel
TableauBlanc_stub_clp::get_pixel( CORBA::ULong _par_idpixel )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_TableauBlanc * _myserv = POA_TableauBlanc::_narrow (_serv);
    if (_myserv) {
      s_pixel __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->get_pixel(_par_idpixel);
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

  return TableauBlanc_stub::get_pixel(_par_idpixel);
}

#endif // MICO_CONF_NO_POA

class _Marshaller__seq_6b_short : public ::CORBA::StaticTypeInfo {
    typedef BoundedSequenceTmpl< CORBA::Short,MICO_TID_DEF,6> _MICO_T;
  public:
    ~_Marshaller__seq_6b_short();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller__seq_6b_short::~_Marshaller__seq_6b_short()
{
}

::CORBA::StaticValueType _Marshaller__seq_6b_short::create() const
{
  return (StaticValueType) new _MICO_T;
}

void _Marshaller__seq_6b_short::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = *(_MICO_T*) s;
}

void _Marshaller__seq_6b_short::free( StaticValueType v ) const
{
  delete (_MICO_T*) v;
}

::CORBA::Boolean _Marshaller__seq_6b_short::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::ULong len;
  if( !dc.seq_begin( len ) )
    return FALSE;
  ((_MICO_T *) v)->length( len );
  if (len > 0) {
    if (!dc.get_shorts (&(*(_MICO_T *)v)[0], len))
      return FALSE;
  }
  return dc.seq_end();
}

void _Marshaller__seq_6b_short::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::ULong len = ((_MICO_T *) v)->length();
  ec.seq_begin( len );
  if (len > 0) {
    ec.put_shorts (&(*(_MICO_T *)v)[0], len);
  }
  ec.seq_end();
}

::CORBA::StaticTypeInfo *_marshaller__seq_6b_short;

struct __tc_init_TABLEAU_BLANC {
  __tc_init_TABLEAU_BLANC()
  {
    _marshaller_s_pixel = new _Marshaller_s_pixel;
    _marshaller_TableauBlanc = new _Marshaller_TableauBlanc;
    _marshaller__seq_6b_short = new _Marshaller__seq_6b_short;
  }

  ~__tc_init_TABLEAU_BLANC()
  {
    delete static_cast<_Marshaller_s_pixel*>(_marshaller_s_pixel);
    delete static_cast<_Marshaller_TableauBlanc*>(_marshaller_TableauBlanc);
    delete static_cast<_Marshaller__seq_6b_short*>(_marshaller__seq_6b_short);
  }
};

static __tc_init_TABLEAU_BLANC __init_TABLEAU_BLANC;

//--------------------------------------------------------
//  Implementation of skeletons
//--------------------------------------------------------

// PortableServer Skeleton Class for interface TableauBlanc
POA_TableauBlanc::~POA_TableauBlanc()
{
}

::TableauBlanc_ptr
POA_TableauBlanc::_this ()
{
  CORBA::Object_var obj = PortableServer::ServantBase::_this();
  return ::TableauBlanc::_narrow (obj);
}

CORBA::Boolean
POA_TableauBlanc::_is_a (const char * repoid)
{
  if (strcmp (repoid, "IDL:TableauBlanc:1.0") == 0) {
    return TRUE;
  }
  return FALSE;
}

CORBA::InterfaceDef_ptr
POA_TableauBlanc::_get_interface ()
{
  CORBA::InterfaceDef_ptr ifd = PortableServer::ServantBase::_get_interface ("IDL:TableauBlanc:1.0");

  if (CORBA::is_nil (ifd)) {
    mico_throw (CORBA::OBJ_ADAPTER (0, CORBA::COMPLETED_NO));
  }

  return ifd;
}

CORBA::RepositoryId
POA_TableauBlanc::_primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr)
{
  return CORBA::string_dup ("IDL:TableauBlanc:1.0");
}

CORBA::Object_ptr
POA_TableauBlanc::_make_stub (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
{
  return new ::TableauBlanc_stub_clp (poa, obj);
}

bool
POA_TableauBlanc::dispatch (CORBA::StaticServerRequest_ptr __req)
{
  #ifdef HAVE_EXCEPTIONS
  try {
  #endif
    if( strcmp( __req->op_name(), "ajouter_pixel" ) == 0 ) {
      ::s_pixel _par_pixel;
      CORBA::StaticAny _sa_pixel( _marshaller_s_pixel, &_par_pixel );

      CORBA::Boolean _res;
      CORBA::StaticAny __res( CORBA::_stc_boolean, &_res );
      __req->add_in_arg( &_sa_pixel );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = ajouter_pixel( _par_pixel );
      __req->write_results();
      return true;
    }
    if( strcmp( __req->op_name(), "get_pixel" ) == 0 ) {
      CORBA::ULong _par_idpixel;
      CORBA::StaticAny _sa_idpixel( CORBA::_stc_ulong, &_par_idpixel );

      ::s_pixel _res;
      CORBA::StaticAny __res( _marshaller_s_pixel, &_res );
      __req->add_in_arg( &_sa_idpixel );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = get_pixel( _par_idpixel );
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
POA_TableauBlanc::invoke (CORBA::StaticServerRequest_ptr __req)
{
  if (dispatch (__req)) {
      return;
  }

  CORBA::Exception * ex = 
    new CORBA::BAD_OPERATION (0, CORBA::COMPLETED_NO);
  __req->set_exception (ex);
  __req->write_results();
}

