package ihm_swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class Chatroom_Accueil {
	
	public Chatroom_Accueil(){
		Display display = new Display();
	    final Shell shell = new Shell(display);
	    
	    Menu menuBar = new Menu(shell, SWT.BAR);
	    MenuItem menu = new MenuItem(menuBar, SWT.CASCADE);
	    menu.setText("Menu");
	
	    Menu sousMenu = new Menu(shell, SWT.DROP_DOWN);
	    menu.setMenu(sousMenu);
	
	    MenuItem quitter = new MenuItem(sousMenu, SWT.PUSH);
	    quitter.setText("Quitter");
	   
	    Button button = new Button(shell, SWT.CENTER);
	    button.setBounds(75, 50, 150, 30);
	    button.setText("&Connexion");
	    
	    shell.setMenuBar(menuBar);
	    shell.pack();
	    shell.setSize(300, 400);
	    shell.open();
	        
	    quitter.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) {
	        	shell.close();
	        }
	      });
	    
	    while (!shell.isDisposed())
	        if (!display.readAndDispatch())
	          display.sleep();
	        
	    display.dispose();
  }
}
