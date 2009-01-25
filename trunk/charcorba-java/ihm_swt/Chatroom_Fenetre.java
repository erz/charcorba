package ihm_swt;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.*;

import Client.Client;

import chatroom.Chatroom_impl;

public class Chatroom_Fenetre 
{
	public String nom_chatroom;
	public Shell shell;
	public List listeMessages;
	public Text message;
	
	
	public Chatroom_Fenetre(final String nom_chatroom)
	{
		   this.nom_chatroom = nom_chatroom;
		   shell = new Shell(Display.getCurrent());
		   
		   shell.setText(nom_chatroom);

		   listeMessages = new List(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		   listeMessages.setBounds(5, 5, 480, 410);

		   message = new Text(shell, SWT.BORDER);
		   message.setBounds(5, 420, 380, 30); 

		   final Button button = new Button(shell, SWT.PUSH);   
		   button.setBounds(400, 420, 80, 30); 

		   button.setText("Envoyer");
		   button.addListener(SWT.Selection, new Listener() 
		   {
		        public void handleEvent(Event e) 
		        {
		        	//System.out.println(nom_chatroom+ " " + message.getText());
		        	Client.singleton_client.ajouter_message(nom_chatroom, message.getText());
		        }
		   });
		   
		   shell.pack();
		   
		   shell.setSize(500, 500);
		   shell.open();
	}
	
	public static void main(String[] args) 
	{
		   new Chatroom_Fenetre("Hop");
	}

	public void ecrireMessage(String auteur, String mess) 
	{
		System.out.println(auteur+" "+mess);
		listeMessages.add(auteur+" : "+ mess);
	}
}
