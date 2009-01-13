package IHM;

import java.util.ArrayList;

public class Contact {

	private int id;
	private String pseudo;
	private ArrayList<String> tags;
	
	public Contact(int id, String pseudo, ArrayList<String> tags)
	{
		this.id = id;
		this.pseudo = pseudo;
		this.tags = tags;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getPseudo()
	{
		return pseudo;
	}
	
	public ArrayList<String> getTags()
	{
		return tags;
	}
}
