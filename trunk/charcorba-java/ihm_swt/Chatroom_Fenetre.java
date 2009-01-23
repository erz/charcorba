package ihm_swt;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.*;

import chatroom.Chatroom_impl;

public class Chatroom_Fenetre 
{
	public Chatroom_impl chatroom;
	public Shell shell;
	public List listeMessages;
	public Text message;
	
	
	public Chatroom_Fenetre(Chatroom_impl chatroom)
	{
		   this.chatroom = chatroom;
		   Display display = new Display();
		   shell = new Shell(display);
		   
		   shell.setText(chatroom.m_nom_chatroom);
		   shell.setLayout(new GridLayout());
		   
		   listeMessages = new List(shell, SWT.V_SCROLL);
		   listeMessages.setSize(500, 500);
		   listeMessages.add("mon texte");
		   listeMessages.add("mon texte");
		   listeMessages.add("mon texte");
		   listeMessages.add("mon texte");
		   listeMessages.add("mon texte");
		  // listeMessages.setBounds(20, 20, 400,200);

		   Group group = new Group(shell, SWT.NONE);
		   group.setLayout (new FillLayout ());
		   
		   message = new Text(group, SWT.BORDER);
		   final Button button = new Button(group, SWT.PUSH);
		   button.setText("Envoyer");
		   shell.pack();
		   
		   shell.setSize(500, 500);
		   shell.open();
		   
		   while (!shell.isDisposed()) 
		   {
			          if (!display.readAndDispatch())
			            display.sleep();
		   }
		   display.dispose();
	}
	
	public static void main(String[] args) 
	{
		   new Chatroom_Fenetre(new Chatroom_impl("Hop"));
	}
}
