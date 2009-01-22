package orb_pkge;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import chatroom.Chatroom;
import chatroom.ChatroomHelper;

import Client.Standard;
import Client.StandardHelper;

public class COrb implements Runnable 
{
	
	public static COrb static_orb;
	
	public ORB orb;
	
	private Thread orb_thread;
	
	//Portable server
	org.omg.PortableServer.POA m_POA ;
	
	//Objet Corba
	org.omg.CORBA.Object objetCorba; 
	
	//Serveur de nom
	NamingContextExt namingContext;
	
	public COrb(String args[]) throws InvalidName, AdapterInactive
	{
	 	// Create an object request broker
	    orb = ORB.init(args, null);
	    
	    m_POA = org.omg.PortableServer.POAHelper.narrow (orb.resolve_initial_references("RootPOA"));
		m_POA.the_POAManager().activate();

	    // Obtain object reference for name service ...
       objetCorba = orb.resolve_initial_references("NameService");
            
        // ... and narrow it to a NameContext
        namingContext = NamingContextExtHelper.narrow(objetCorba);

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
	
	public void ajout_service(org.omg.PortableServer.Servant service, String nom_service) throws org.omg.CosNaming.NamingContextPackage.InvalidName, ServantAlreadyActive, WrongPolicy, CannotProceed, NotFound, ServantNotActive
	{

	      NameComponent c_nom_service[] = namingContext.to_name( nom_service );

		m_POA.activate_object (service);
		//org.omg.CORBA.Object ref_service_Annuaire = service._this_object();
		
	      // get object reference from the servant
	      System.out.println(service.toString());
	      org.omg.CORBA.Object ref_service_Annuaire = m_POA.servant_to_reference(service);

	      if (service.getClass().getCanonicalName().compareTo("Client.Standard_impl") == 0)
	      {
	    	  
	    	  Standard href_service_Annuaire = StandardHelper.narrow(ref_service_Annuaire);
	    	  namingContext.rebind (c_nom_service, href_service_Annuaire);
	      }
	      if (service.getClass().getCanonicalName().compareTo("chatroom.Chatroom_impl") == 0)
	      {
	    	  
	    	  Chatroom href_service_Annuaire = ChatroomHelper.narrow(ref_service_Annuaire);
	    	  namingContext.rebind (c_nom_service, href_service_Annuaire);
	      }

	}
	
	public void demarrer ()
	{
		  new Thread (this).start();
	}
	
	public void arreter ()
	{
		orb.destroy();
		m_POA.destroy(true, true);
	}
	
	public void run() 
	{
		orb.run();
	}
	
}
