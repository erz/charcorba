package Client;


/**
* StandardHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from standard.idl
* jeudi 30 octobre 2008 09 h 25 CET
*/


// -*- c++ -*-
public final class StandardHolder implements org.omg.CORBA.portable.Streamable
{
  public Standard value = null;

  public StandardHolder ()
  {
  }

  public StandardHolder (Standard initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = StandardHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    StandardHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return StandardHelper.type ();
  }

}
