package tableau_blanc;

import java.util.HashMap;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Client.Standard;

public class TableauBlanc_impl extends TableauBlancPOA{

	public String m_nom_tableau;
	HashMap<String,Standard> m_liste_participants;
	
	public TableauBlanc_impl(String nom_tableau) {
		// TODO Auto-generated constructor stub
	}

	public boolean ajouter_pixel(short[] pixel) {
		// TODO Auto-generated method stub
		return false;
	}

	public short[] get_pixel(int idpixel) {
		// TODO Auto-generated method stub
		return null;
	}

	public void inviter_client(String pseudo) throws NotFound, CannotProceed, InvalidName {
		org.omg.CORBA.Object service_distant = orb_pkge.COrb.static_orb.connecter_service(pseudo);;
		Client.Standard standard_distant = Client.StandardHelper.narrow(service_distant) ;
		standard_distant.inviter_client_tableaublanc(m_nom_tableau);
		m_liste_participants.put(pseudo,standard_distant);
	}

}
