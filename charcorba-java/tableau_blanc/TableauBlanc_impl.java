package tableau_blanc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Client.Standard;

public class TableauBlanc_impl extends TableauBlancPOA
{

	public String m_nom_tableau;
	public HashMap<String,Standard> m_liste_participants;
	public Vector <s_pixel> m_vect_pixels;
	
	public TableauBlanc_impl(String nom_tableau) 
	{
		m_nom_tableau = nom_tableau;
		m_liste_participants = new HashMap<String,Standard> ();
		m_vect_pixels = new Vector <s_pixel> ();
	}


	public void inviter_client(String pseudo) throws NotFound, CannotProceed, InvalidName 
	{
		org.omg.CORBA.Object service_distant = orb_pkge.COrb.static_orb.connecter_service(pseudo);;
		Client.Standard standard_distant = Client.StandardHelper.narrow(service_distant) ;
		standard_distant.inviter_client_tableaublanc(m_nom_tableau);
		m_liste_participants.put(pseudo,standard_distant);
	}


	public boolean ajouter_pixel(s_pixel pixel) 
	{
		
		  boolean retval = true;
		  System.out.println("Impl : ajout pixel "+pixel.x+" "+pixel.y);
		  m_vect_pixels.add(pixel);

          Collection<Standard> participants = m_liste_participants.values();
		  Iterator <Standard> it = participants.iterator();
		  while (it.hasNext())
		  {
					it.next().signal_tableaublanc(m_nom_tableau,m_vect_pixels.size());
		  }
		  //Client.Client.singleton_client.sync_tableau_blanc(m_nom_tableau,m_vect_pixels.size());
			
		  return retval;
	}

	public s_pixel get_pixel(int idpixel) 
	{
		return m_vect_pixels.get(idpixel);
	}

}
