package IHM;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFrameClient extends JFrame 
{
	private Container fond;
	
	//Temporaire : pour tester en local
	ArrayList<String> tagsMika = new ArrayList<String>() {{ add("Lucille je t'aime"); add("Tiens bien l'alcool");  }};;
	ArrayList<String> tagsTrix= new ArrayList<String>() {{ add("CORBA!!!"); add("Suicide");  }};;
	ArrayList<String> tagsTony= new ArrayList<String>() {{ add("Jamais la où on l'attend"); add("Recherche couple"); }};;
	ArrayList<String> tagsFlo= new ArrayList<String>() {{ add("Blond"); add("Nudiste");  }};;
	ArrayList<String> tagsAurel= new ArrayList<String>() {{ add("Jamais la où on l'attend"); add("Tiens bien l'alcool");  }};;
	
	private Contact[] listeContacts = {
				new Contact(0, "mika", tagsMika),
				new Contact(1, "trix", tagsTrix),
				new Contact(2, "titi", tagsTony),
				new Contact(3, "grande folle", tagsFlo),
				new Contact(4, "violeur d'enfants", tagsAurel)
				};
	private ArrayList<JCheckBox> listeContactsChekBox;
	private JButton creerChatRoom;
	
	public JFrameClient()
	{
		super("Client JAVA");
		
		setJMenuBar(new JMenuBarreMenu(this));
		
		fond = this.getContentPane();
		fond.setLayout(new FlowLayout());
		
		fond.add(creerChatRoom = new JButton("creer une chatroom"));
		creerChatRoom.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0) {
				new JFrameChatRoom(getContactsSelected());
			}
		});
		
		listeContactsChekBox = new ArrayList<JCheckBox>();

		setSize(200, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void getContacts()
	{
		for (int i=0; i<listeContacts.length; i++)
		{
			JCheckBox nouveauContact = new JCheckBox(listeContacts[i].getPseudo());
			nouveauContact.setPreferredSize(new Dimension(150, 30));
			listeContactsChekBox.add(nouveauContact);
			fond.add(nouveauContact);
			nouveauContact.revalidate();
		}
	}
	
	public ArrayList<Contact> getContactsSelected()
	{
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		for (int i=0; i<listeContactsChekBox.size(); i++)
			if (listeContactsChekBox.get(i).isSelected())
				contacts.add(listeContacts[i]);
		return contacts;
	}
	
	public Contact[] getListeContacts()
	{
		return listeContacts;
	}
	/*
	public static void main(String[] args)
	{
		new JFrameClient();
	}*/

}
