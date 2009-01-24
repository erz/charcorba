package ihm_swt;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import tableau_blanc.Tableau_swt;

public class Chatroom_profil {
	public Chatroom_profil (Display display){
		
	    final Shell chatroom_profil = new Shell(display);
	    
	    //zone de saisie du pseudo
	    Label label_pseudo = new Label(chatroom_profil, SWT.CENTER);
	    label_pseudo.setText("Entrez votre pseudo:");
	    label_pseudo.setLocation(0, 100);
	    Text  saisie_pseudo= new Text(chatroom_profil, SWT.NONE); 
	    saisie_pseudo.setText("Pseudo?");
	    saisie_pseudo.setBounds(140, 100, 100, 25);
		
	  //zone de saisie des tags
	    Label tag1 = new Label(chatroom_profil, SWT.CENTER);
	    tag1.setText("Tag n°1:");
	    tag1.setLocation(30, 150);
	    Text  saisie_tag1= new Text(chatroom_profil, SWT.NONE); 
	    saisie_tag1.setText("Tag?");
	    saisie_tag1.setBounds(120, 140, 100, 25);
	    
	    Label tag2 = new Label(chatroom_profil, SWT.CENTER);
	    tag2.setText("Tag n°2:");
	    tag2.setLocation(30, 180);
	    Text  saisie_tag2= new Text(chatroom_profil, SWT.NONE); 
	    saisie_tag2.setText("Tag?");
	    saisie_tag2.setBounds(120, 170, 100, 25);
	    
	    Label tag3 = new Label(chatroom_profil, SWT.CENTER);
	    tag3.setText("Tag n°3:");
	    tag3.setLocation(30, 210);
	    Text  saisie_tag3= new Text(chatroom_profil, SWT.NONE); 
	    saisie_tag3.setText("Tag?");
	    saisie_tag3.setBounds(120, 200, 100, 25);
	    
	    Button valider = new Button(chatroom_profil, SWT.CENTER);
	    valider.setBounds(100, 250, 150, 30);
	    valider.setText("Se connecter");
	    valider.addListener(SWT.MouseDown, new Listener() 
	    {
	    	public void handleEvent(Event e){
	    		
	    	}
	    });
	    
		label_pseudo.pack();
		tag1.pack();
		tag2.pack();
		tag3.pack();
	    chatroom_profil.setSize(300, 400);
	    chatroom_profil.open();
	
	while (!chatroom_profil.isDisposed())
        if (!display.readAndDispatch())
          display.sleep();
        
    display.dispose();
	}
  
}
