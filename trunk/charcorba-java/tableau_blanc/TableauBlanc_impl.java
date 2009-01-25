package tableau_blanc;

import java.util.HashMap;
import java.util.Vector;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Client.Standard;

public class TableauBlanc_impl extends TableauBlancPOA{

	public String m_nom_tableau;
	public HashMap<String,Standard> m_liste_participants;
	public Vector <Pixel> m_vect_pixels;
	
	public TableauBlanc_impl(String nom_tableau) 
	{
		m_nom_tableau = nom_tableau;
		m_liste_participants = new HashMap<String,Standard> ();
		m_vect_pixels = new Vector <Pixel> ();
	}

	public boolean ajouter_pixel(short[] pixel) 
	{/*
		  boolean retval;
		  
		  m_vect_pixels.add(Pixel(QPoint(pixel.x,pixel.y),QColor(pixel.rouge,pixel.vert,pixel.bleu),pixel.est_continu));
		  
		  map<string,Standard_var>::iterator pos;
		  for (pos = m_liste_participants.begin(); pos != m_liste_participants.end(); ++pos)
		  {
		      //cout << "[DEBUG]\t[Tableau - '" << m_nom_tableau << "']\tOn averti le client '" << pos->first << " de l'insertion du message d'id " << m_vect_pixels->size() <<  endl;
		      pos->second->signal_tableaublanc (m_nom_tableau.c_str(),m_vect_pixels->size());
		  }
		  return retval; }

	public short[] get_pixel(int idpixel) {
		// TODO Auto-generated method stub*/
		return true;
	}

	public void inviter_client(String pseudo) throws NotFound, CannotProceed, InvalidName {
		org.omg.CORBA.Object service_distant = orb_pkge.COrb.static_orb.connecter_service(pseudo);;
		Client.Standard standard_distant = Client.StandardHelper.narrow(service_distant) ;
		standard_distant.inviter_client(m_nom_tableau);
		m_liste_participants.put(pseudo,standard_distant);
	}

	public short[] get_pixel(int idpixel) {
		// TODO Raccord de méthode auto-généré
		return null;
	}

}
