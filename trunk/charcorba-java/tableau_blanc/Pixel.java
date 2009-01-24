package tableau_blanc;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;

public class Pixel {
		
		public Point m_point;
		public Color m_color;
		public  short m_est_continu;
		
		public Pixel(Point point, Color color, short est_continu)
		{
			m_point = point;
			m_color = color;
			m_est_continu = est_continu;
		}
}


