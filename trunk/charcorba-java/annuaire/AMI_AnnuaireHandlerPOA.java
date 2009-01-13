package annuaire;

/**
 *	Generated from IDL interface "AMI_AnnuaireHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class AMI_AnnuaireHandlerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AMI_AnnuaireHandlerOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "quitter_annuaire", new java.lang.Integer(0));
		m_opsHash.put ( "enlever_tag_excep", new java.lang.Integer(1));
		m_opsHash.put ( "enlever_tag", new java.lang.Integer(2));
		m_opsHash.put ( "joindre_annuaire_excep", new java.lang.Integer(3));
		m_opsHash.put ( "joindre_annuaire", new java.lang.Integer(4));
		m_opsHash.put ( "ajouter_tag", new java.lang.Integer(5));
		m_opsHash.put ( "quitter_annuaire_excep", new java.lang.Integer(6));
		m_opsHash.put ( "get_amis_par_tag", new java.lang.Integer(7));
		m_opsHash.put ( "get_amis_par_tag_excep", new java.lang.Integer(8));
		m_opsHash.put ( "ajouter_tag_excep", new java.lang.Integer(9));
	}
	private String[] ids = {"IDL:AMI_AnnuaireHandler:1.0","IDL:omg.org/Messaging/ReplyHandler:1.0"};
	public AMI_AnnuaireHandler _this()
	{
		return AMI_AnnuaireHandlerHelper.narrow(_this_object());
	}
	public AMI_AnnuaireHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_AnnuaireHandlerHelper.narrow(_this_object(orb));
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // quitter_annuaire
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				quitter_annuaire(_arg0);
				break;
			}
			case 1: // enlever_tag_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				enlever_tag_excep(_arg0);
				break;
			}
			case 2: // enlever_tag
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				enlever_tag(_arg0);
				break;
			}
			case 3: // joindre_annuaire_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				joindre_annuaire_excep(_arg0);
				break;
			}
			case 4: // joindre_annuaire
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				joindre_annuaire(_arg0);
				break;
			}
			case 5: // ajouter_tag
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				ajouter_tag(_arg0);
				break;
			}
			case 6: // quitter_annuaire_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				quitter_annuaire_excep(_arg0);
				break;
			}
			case 7: // get_amis_par_tag
			{
				java.lang.String[] _arg0=annuaire.AnnuairePackage.t_liste_stringHelper.read(_input);
				_out = handler.createReply();
				get_amis_par_tag(_arg0);
				break;
			}
			case 8: // get_amis_par_tag_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				get_amis_par_tag_excep(_arg0);
				break;
			}
			case 9: // ajouter_tag_excep
			{
				org.omg.Messaging.ExceptionHolder _arg0=(org.omg.Messaging.ExceptionHolder)((org.omg.CORBA_2_3.portable.InputStream)_input).read_value ("IDL:omg.org/Messaging/ExceptionHolder:1.0");
				_out = handler.createReply();
				ajouter_tag_excep(_arg0);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
