package Client;

import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.DoubleHolder;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;
import org.omg.CORBA.ShortHolder;
import org.omg.CORBA.StringHolder;

public class Standard_impl extends StandardPOA
{
	@Override
	public boolean afficher_message(String pseudo_client, String message) 
	{
		// TODO Auto-generated method stub
		return false;
	}	
	public boolean inviter_client(String chatroom) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ping() {
		// TODO Auto-generated method stub
		System.out.println("HOP");
		return false;
	}

	@Override
	public boolean signal_chatroom(String chatroom) {
		// TODO Auto-generated method stub
		return false;
	}

}
