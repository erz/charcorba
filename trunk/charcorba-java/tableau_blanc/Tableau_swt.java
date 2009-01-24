package tableau_blanc;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Tableau_swt {

	private Shell shell;
	
	private Canvas canvas;
	
	private boolean isMousePressed;
	private Color color;
	private ArrayList<Pixel> pixels;
	
	
	private class Pixel
	{
		int x, y;
		boolean isContinu;
		Color color;
		
		public Pixel(int x, int y, Color c, boolean isContinu)
		{
			this.x = x;
			this.y = y;
			this.color = c;
			this.isContinu = isContinu;
		}
	}
	
	public Tableau_swt(Display display)
	{
		shell = new Shell(display);
		shell.setText("Tableau blanc");
		shell.setLayout(new RowLayout(SWT.NONE));
		
		pixels = new ArrayList<Pixel>();
		color = new Color(Display.getDefault(), new RGB(255, 0, 0));
		canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(new Color(Display.getDefault(), new RGB(255, 255, 255)));
		canvas.setLayoutData(new RowData(400, 400));
		
		Button redButton = new Button(shell, SWT.NONE);
		redButton.setText("ROUGE");
		redButton.addListener(SWT.MouseDown, new Listener()
		{
			public void handleEvent(Event arg0) {
				color = new Color(Display.getDefault(), new RGB(255, 0, 0));
			}
		});
		Button greenButton = new Button(shell, SWT.NONE);
		greenButton.setText("VERT");
		greenButton.addListener(SWT.MouseDown, new Listener()
		{
			public void handleEvent(Event arg0) {
				color = new Color(Display.getDefault(), new RGB(0, 255, 0));
			}
		});
		Button blueButton = new Button(shell, SWT.NONE);
		blueButton.setText("BLEU");
		blueButton.addListener(SWT.MouseDown, new Listener()
		{
			public void handleEvent(Event arg0) {
				color = new Color(Display.getDefault(), new RGB(0, 0, 255));
			}
		});
		
		canvas.addPaintListener(new PaintListener()
		{
			public void paintControl(PaintEvent event) {
				for (int i=0; i<pixels.size()-1; i++)
				{
					event.gc.setForeground(pixels.get(i).color);
					if (! pixels.get(i).isContinu)
						event.gc.drawPoint(pixels.get(i).x, pixels.get(i).y);
					else
						event.gc.drawLine(pixels.get(i+1).x, pixels.get(i+1).y, pixels.get(i).x, pixels.get(i).y);
				}
			}
		});
		canvas.addMouseMoveListener(new MouseMoveListener()
		{
			public void mouseMove(MouseEvent event) {
				if (isMousePressed)
					addPixel(event.x, event.y, color, true);
			}
		});
		canvas.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDown(MouseEvent event) {
				isMousePressed = true;
				addPixel(event.x, event.y, color, false);
			}
			@Override
			public void mouseUp(MouseEvent event) {
				isMousePressed = false;
				addPixel(event.x, event.y, color, false);
			}
		});
		
		shell.pack();
		shell.open();
		
		while (! shell.isDisposed())
			if (! display.readAndDispatch())
				display.sleep();
		display.dispose();
	}
	
	public void addPixel(int x, int y, Color c, boolean isContinu)
	{
		pixels.add(new Pixel(x, y, color, isContinu));
		sendPixel(x, y, c.getRed(), c.getGreen(), c.getBlue(), isContinu);
		canvas.redraw();
	}
	
	public void sendPixel(int x, int y, int r, int g, int b, boolean isContinu)
	{
		
	}
	public void receivePixel(int x, int y, int r, int g, int b, boolean isContinu)
	{
		pixels.add(new Pixel(x, y, new Color(Display.getDefault(), new RGB(r, g, b)), isContinu));
		canvas.redraw();
	}
	
	public static void main(String[] args)
	{
		new Tableau_swt(new Display());
	}
}
