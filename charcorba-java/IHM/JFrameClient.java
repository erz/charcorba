package IHM;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

@SuppressWarnings("serial")
public class JFrameClient extends JFrame 
{
	private Container fond;

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
				new JFrameChatRoom();
			}
		});
	
		setSize(200, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	 public static void main(String args[]) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, AdapterInactive, ServantAlreadyActive, WrongPolicy, InterruptedException, ServantNotActive
	 {
		 new JFrameClient();
	 }
}
