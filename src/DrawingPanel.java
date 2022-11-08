import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.nio.file.Path;

public class DrawingPanel extends JPanel {

	public DrawingPanel() {
		this.setPreferredSize(new Dimension(800, 800));		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.scale(2.5,2.5);


		//Ellipse2D s = new Ellipse2D.Double(100,100,20,20);
		//Ellipse2D a = new Ellipse2D.Double(150,100,20,20);

		Ellipse2D s = new Ellipse2D.Double(100,100,40,40);
		Ellipse2D a = new Ellipse2D.Double(200,100,40,40);

		Path2D sa0 = new Path2D.Double(new Line2D.Double(140,120,200,120));

		Path2D sa0_horni = new Path2D.Double(new Line2D.Double(190,116,200,120));
		Path2D sa0_dolni = new Path2D.Double(new Line2D.Double(190,124,200,120));
		//sa0.append(sa0_dolni);

		Arc2D arc = new Arc2D.Double(120,85,100,45,20,140,Arc2D.OPEN);

		QuadCurve2D q = new QuadCurve2D.Double(140,120,150,110,180,120);
		g2.draw(q);
		


		g2.draw(s);
		g2.draw(a);
		g2.draw(sa0);
		g2.draw(sa0_dolni);
		g2.draw(sa0_horni);
		//g2.draw(arc);



	}
	

}
