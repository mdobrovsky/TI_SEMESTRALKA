import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;

public class DrawingPanel extends JPanel {

	public DrawingPanel() {
		this.setPreferredSize(new Dimension(800, 800));		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;

		Ellipse2D e1 = new Ellipse2D.Double(100,100,20,20);
		Ellipse2D e2 = new Ellipse2D.Double(150,100,20,20);
		Path2D p = new Path2D.Double(new Line2D.Double(120,120,170,120));
		p.append(new );




	}
	

}
