import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.nio.file.Path;

public class DrawingPanel extends JPanel {

	public DrawingPanel() {
		this.setPreferredSize(new Dimension(1600, 480));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.scale(2.5,2.5);
		g2.translate(-70, 0);

		Ellipse2D s = new Ellipse2D.Double(100,100,40,40);
		g2.draw(s);

		Ellipse2D a = new Ellipse2D.Double(200,100,40,40);
		g2.draw(a);

		Path2D vstup = new Path2D.Double(new Line2D.Double(100,120,75,120));
		vstup.append(new Line2D.Double(90,116,100,120), false);
		vstup.append(new Line2D.Double(90,124,100,120), false);
		g2.draw(vstup);

		Path2D sa0 = new Path2D.Double(new Line2D.Double(140,120,200,120));
		sa0.append(new Line2D.Double(190,116,200,120), false);
		sa0.append(new Line2D.Double(190,124,200,120), false);
		g2.draw(sa0);

		Path2D ss1 = new Path2D.Double(new Arc2D.Double(105,77,30,30,-45, 270, Arc2D.OPEN));
		ss1.append(new Line2D.Double(109,103,102,98), false);
		ss1.append(new Line2D.Double(109,103,109,95), false);
		g2.draw(ss1);

		Ellipse2D b = new Ellipse2D.Double(300,100,40,40);
		g2.draw(b);

		Path2D ab1 = new Path2D.Double(new Line2D.Double(240,120,300,120));
		ab1.append(new Line2D.Double(290,116,300,120), false);
		ab1.append(new Line2D.Double(290,124,300,120), false);
		g2.draw(ab1);
	}
	

}
