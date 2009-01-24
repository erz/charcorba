package annuaire;

/**
 *	Generated from IDL interface "Annuaire"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public abstract class AnnuairePOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, AnnuaireOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "ajouter_tag", new java.lang.Integer(0));
		m_opsHash.put ( "quitter_annuaire", new java.lang.Integer(1));
		m_opsHash.put ( "get_amis_par_tag", new java.lang.Integer(2));
		m_opsHash.put ( "enlever_tag", new java.lang.Integer(3));
		m_opsHash.put ( "joindre_annuaire", new java.lang.Integer(4));
	}
	private String[] ids = {"IDL:Annuaire:1.0"};
	public Annuaire _this()
	{
		return AnnuaireHelper.narrow(_this_object());
	}
	public Annuaire _this(org.omg.CORBA.ORB orb)
	{
		return AnnuaireHelper.narrow(_this_object(orb));
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
			case 0: // ajouter_tag
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(ajouter_tag(_arg0,_arg1));
				break;
			}
			case 1: // quitter_annuaire
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(quitter_annuaire(_arg0));
				break;
			}
			case 2: // get_amis_par_tag
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				annuaire.AnnuairePackage.t_liste_stringHelper.write(_out,get_amis_par_tag(_arg0));
				break;
			}
			case 3: // enlever_tag
			{
				java.lang.String _arg0=_input.read_string();
				java.lang.String _arg1=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(enlever_tag(_arg0,_arg1));
				break;
			}
			case 4: // joindre_annuaire
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				_out.write_boolean(joindre_annuaire(_arg0));
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
