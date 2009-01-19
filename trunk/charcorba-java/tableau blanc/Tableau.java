import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Tableau extends JPanel {
	
	private class ColoredPoint extends Point
	{
		private Color color;
		public ColoredPoint(int x, int y, Color c)
		{
			super(x, y);
			color = c;
		}
		
		public void setColor(Color color) { this.color = color; }
		public Color getColor() { return color; }
	}

	private ArrayList<ColoredPoint> pixels = new ArrayList<ColoredPoint>();
	private JButton clearButton = new JButton("clear");
	private JButton redButton = new JButton("   ");
	private JButton greenButton = new JButton("   ");
	private JButton blueButton = new JButton("   ");
	private Color color;
	public Tableau()
	{
		setLayout(new FlowLayout());
		setBackground(Color.white);
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Tableau.this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Tableau.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
		});
		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent arg0) {
				Tableau.this.draw(arg0.getX(), arg0.getY());
			}
			
		});
		
		clearButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pixels.clear();
				repaint();
			}
			
		});
		add(clearButton);
		redButton.setBackground(Color.red);
		greenButton.setBackground(Color.green);
		blueButton.setBackground(Color.blue);
		
		add(redButton);
		add(greenButton);
		add(blueButton);
		
		redButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.red;
				
			}
			
		});
		greenButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.green;
				
			}
			
		});
		blueButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = Color.blue;
				
			}
			
		});
		
		
		this.setPreferredSize(new Dimension(500, 500));
	}
	
	public void draw(int x, int y) {
		System.out.println('(' + x + ", " + y + ')');
		pixels.add(new ColoredPoint(x, y, color));
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		for (int i=0; i<pixels.size(); i++)
		{
			g.setColor(pixels.get(i).getColor());
			g.fillOval(pixels.get(i).x, pixels.get(i).y, 3, 3);
		}
	}

	public static void main(String[] args)
	{
		JFrame fenetre = new JFrame();
		fenetre.setLayout(new FlowLayout());
		fenetre.add(new Tableau());
		fenetre.setSize(800, 600);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
