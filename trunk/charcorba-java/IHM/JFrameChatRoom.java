package IHM;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class JFrameChatRoom extends JFrame 
{

	private Container contenu;
	
	private JTextArea out;
	private JTextArea in;
	private JButton send;
	
	
	public JFrameChatRoom() 
	{
		setSize(440, 370);
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contenu = getContentPane();
		
		contenu.setLayout(new FlowLayout(0, 5, 5));
		
		add(new JLabel("Participants : "));
		
		out = new JTextArea();
		out.setPreferredSize(new Dimension(400, 200));
		in = new JTextArea();
		in.setPreferredSize(new Dimension(325, 100));
		send = new JButton("Send");
		send.setPreferredSize(new Dimension(70, 100));
		
		add(out);
		add(in);
		add(send);
	}
}
