package Client;

public class Standard_impl extends StandardPOA
{
	public boolean afficher_message(String pseudo_client, String message) 
	{
		return false;
	}
	public boolean inviter_client(String chatroom) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ping() {
		// TODO Auto-generated method stub
		System.out.println("HOP");
		return false;
	}

	public boolean signal_chatroom(String chatroom) {
		// TODO Auto-generated method stub
		return false;
	}

}
