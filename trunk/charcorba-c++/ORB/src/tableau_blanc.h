/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <CORBA.h>
#include <mico/throw.h>

#ifndef __TABLEAU_BLANC_H__
#define __TABLEAU_BLANC_H__




class TableauBlanc;
typedef TableauBlanc *TableauBlanc_ptr;
typedef TableauBlanc_ptr TableauBlancRef;
typedef ObjVar< TableauBlanc > TableauBlanc_var;
typedef ObjOut< TableauBlanc > TableauBlanc_out;



struct s_pixel;
typedef TFixVar< s_pixel > s_pixel_var;
typedef s_pixel& s_pixel_out;


struct s_pixel {
  #ifdef HAVE_TYPEDEF_OVERLOAD
  typedef s_pixel_var _var_type;
  #endif
  #ifdef HAVE_EXPLICIT_STRUCT_OPS
  s_pixel();
  ~s_pixel();
  s_pixel( const s_pixel& s );
  s_pixel& operator=( const s_pixel& s );
  #endif //HAVE_EXPLICIT_STRUCT_OPS

  CORBA::Short x;
  CORBA::Short y;
  CORBA::Short rouge;
  CORBA::Short vert;
  CORBA::Short bleu;
  CORBA::Boolean est_continu;
};


/*
 * Base class and common definitions for interface TableauBlanc
 */

class TableauBlanc : 
  virtual public CORBA::Object
{
  public:
    virtual ~TableauBlanc();

    #ifdef HAVE_TYPEDEF_OVERLOAD
    typedef TableauBlanc_ptr _ptr_type;
    typedef TableauBlanc_var _var_type;
    #endif

    static TableauBlanc_ptr _narrow( CORBA::Object_ptr obj );
    static TableauBlanc_ptr _narrow( CORBA::AbstractBase_ptr obj );
    static TableauBlanc_ptr _duplicate( TableauBlanc_ptr _obj )
    {
      CORBA::Object::_duplicate (_obj);
      return _obj;
    }

    static TableauBlanc_ptr _nil()
    {
      return 0;
    }

    virtual void *_narrow_helper( const char *repoid );

    typedef BoundedSequenceTmpl< CORBA::Short,MICO_TID_DEF,6> t_pixel;
    typedef TSeqVar< BoundedSequenceTmpl< CORBA::Short,MICO_TID_DEF,6> > t_pixel_var;
    typedef TSeqOut< BoundedSequenceTmpl< CORBA::Short,MICO_TID_DEF,6> > t_pixel_out;

    virtual CORBA::Boolean ajouter_pixel( const ::s_pixel& pixel ) = 0;
    virtual ::s_pixel get_pixel( CORBA::ULong idpixel ) = 0;

  protected:
    TableauBlanc() {};
  private:
    TableauBlanc( const TableauBlanc& );
    void operator=( const TableauBlanc& );
};

// Stub for interface TableauBlanc
class TableauBlanc_stub:
  virtual public TableauBlanc
{
  public:
    virtual ~TableauBlanc_stub();
    CORBA::Boolean ajouter_pixel( const ::s_pixel& pixel );
    ::s_pixel get_pixel( CORBA::ULong idpixel );

  private:
    void operator=( const TableauBlanc_stub& );
};

#ifndef MICO_CONF_NO_POA

class TableauBlanc_stub_clp :
  virtual public TableauBlanc_stub,
  virtual public PortableServer::StubBase
{
  public:
    TableauBlanc_stub_clp (PortableServer::POA_ptr, CORBA::Object_ptr);
    virtual ~TableauBlanc_stub_clp ();
    CORBA::Boolean ajouter_pixel( const ::s_pixel& pixel );
    ::s_pixel get_pixel( CORBA::ULong idpixel );

  protected:
    TableauBlanc_stub_clp ();
  private:
    void operator=( const TableauBlanc_stub_clp & );
};

#endif // MICO_CONF_NO_POA

#ifndef MICO_CONF_NO_POA

class POA_TableauBlanc : virtual public PortableServer::StaticImplementation
{
  public:
    virtual ~POA_TableauBlanc ();
    TableauBlanc_ptr _this ();
    bool dispatch (CORBA::StaticServerRequest_ptr);
    virtual void invoke (CORBA::StaticServerRequest_ptr);
    virtual CORBA::Boolean _is_a (const char *);
    virtual CORBA::InterfaceDef_ptr _get_interface ();
    virtual CORBA::RepositoryId _primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr);

    virtual void * _narrow_helper (const char *);
    static POA_TableauBlanc * _narrow (PortableServer::Servant);
    virtual CORBA::Object_ptr _make_stub (PortableServer::POA_ptr, CORBA::Object_ptr);

    virtual CORBA::Boolean ajouter_pixel( const ::s_pixel& pixel ) = 0;
    virtual ::s_pixel get_pixel( CORBA::ULong idpixel ) = 0;

  protected:
    POA_TableauBlanc () {};

  private:
    POA_TableauBlanc (const POA_TableauBlanc &);
    void operator= (const POA_TableauBlanc &);
};

#endif // MICO_CONF_NO_POA

extern CORBA::StaticTypeInfo *_marshaller_s_pixel;

extern CORBA::StaticTypeInfo *_marshaller_TableauBlanc;

extern CORBA::StaticTypeInfo *_marshaller__seq_6b_short;

#endif
