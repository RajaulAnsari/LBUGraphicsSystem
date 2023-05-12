package razaul;

import java.awt.Color;
import java.awt.Graphics;

public class Extra {
	public static void main(String args[]) {
		
	}
	public void paint(Graphics g) {
		Color col=new Color(0,255,0);
		g.setColor(col);
//		g.fillRect(100, 100, 50, 50);
		g.drawPolygon(new int [] {100,0,100}, new int [] {200,250,40}, 3);
//								  xpoints , ypoints , sides
		
	}
	
}
