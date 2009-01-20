import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Tableau extends JPanel {	
	private Color[] colors = {Color.red, Color.green, Color.blue};

	private class ColoredPoint extends Point
	{
		private Color color;
		public ColoredPoint(int x, int y, Color c)
		{
			super(x, y);
			color = c;
		}
		public Color getColor()
		{
			return color;
		}
	}
	private ArrayList<ColoredPoint> pixels = new ArrayList<ColoredPoint>();
	private Color color = Color.black;
	public Tableau()
	{
		JButton clearButton = new JButton("clear");
		add(clearButton);
		clearButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pixels.clear();
				repaint();
			}
		});
		
		for (int i=0; i<colors.length; i++)
		{
			final JButton jb = new JButton("   ");
			add(jb);
			jb.setBackground(colors[i]);
			jb.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					color = jb.getBackground();
				}
			});
		}
		addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
		});
		addMouseMotionListener(new MouseMotionAdapter()
		{

			@Override
			public void mouseDragged(MouseEvent arg0) {
				ColoredPoint newPoint;
				pixels.add(newPoint = new ColoredPoint(arg0.getX(), arg0.getY(), color));
				repaint();
				
				sendPixel(newPoint.x, newPoint.y, newPoint.getColor().getRed(), newPoint.getColor().getGreen(), newPoint.getColor().getBlue());
			}
			
		});
	}
	
	public void sendPixel(int x, int y, int r, int g, int b)
	{
		System.out.println(x + " " + y + "  " + r + " " + g + " " + b);
	}
	public void receivePixel(int x, int y, int r, int g, int b)
	{
		pixels.add(new ColoredPoint(x, y, new Color(r, g, b)));
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		for (int i=1; i<pixels.size(); i++)
		{
			g.setColor(pixels.get(i).getColor());
			g.drawLine(pixels.get(i-1).x, pixels.get(i-1).y, pixels.get(i).x, pixels.get(i).y);
		}
	}
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.add(new Tableau());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setSize(800, 600);

	}

}
