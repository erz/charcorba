package tableau_blanc;

import org.eclipse.swt.graphics.Color;

public class Pixel {
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


