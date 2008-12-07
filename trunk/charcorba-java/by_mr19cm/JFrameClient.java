package by_mr19cm;

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
public class JFrameClient extends JFrame {
	
	private Container fond;
	private Contact[] listeContacts = {
				new Contact(0, "mika"),
				new Contact(1, "trix"),
				new Contact(2, "titi"),
				new Contact(3, "grande folle"),
				new Contact(4, "violeur d'enfants")
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
			@Override
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
	
	public static void main(String[] args)
	{
		new JFrameClient();
	}

}
