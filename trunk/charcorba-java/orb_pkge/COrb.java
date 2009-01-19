package orb_pkge;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class COrb 
{
	
	public static COrb static_orb;
	
	//Portable server
	org.omg.PortableServer.POA m_POA ;
	
	//Objet Corba
	org.omg.CORBA.Object objetCorba; 
	
	//Serveur de nom
	NamingContext namingContext;
	
	public COrb(String args[]) throws InvalidName
	{
	 	// Create an object request broker
	    ORB orb = ORB.init(args, null);

	    // Obtain object reference for name service ...
       objetCorba = orb.resolve_initial_references("NameService");
            
        // ... and narrow it to a NameContext
        namingContext = NamingContextHelper.narrow(objetCorba);

        static_orb = this;

	}
	
	public org.omg.CORBA.Object connecter_service (String nom_service) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName
	{
        //Create a name component array
        NameComponent nc_array[] = { new NameComponent(nom_service,"") };

        // Get an address book object reference ...
        org.omg.CORBA.Object objectReference = namingContext.resolve(nc_array);
        return objectReference;
	}
	
	public void ajout_service(org.omg.PortableServer.Servant service, String nom_service)
	{
		NameComponent c_nom_service = new NameComponent(nom_service, "");
		
		m_POA.activate_object (service);
		org.omg.CORBA.Object ref_service_Annuaire = service._this_object();
		namingContext.rebind (c_nom_service, ref_service_Annuaire.in());
	}
}
