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
		g2.scale(1.5,1.5);
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

		Path2D aa0 = new Path2D.Double(new Arc2D.Double(205,77,30,30,-45, 270, Arc2D.OPEN));
		aa0.append(new Line2D.Double(209,103,202,98), false);
		aa0.append(new Line2D.Double(209,103,209,95), false);
		g2.draw(aa0);

		Path2D bs1 = new Path2D.Double(new QuadCurve2D.Double(315,140,210,200,130,138));
		bs1.append(new Line2D.Double(130,138,139,139), false);
		bs1.append(new Line2D.Double(130,138,131,145), false);
		g2.draw(bs1);

		Ellipse2D c = new Ellipse2D.Double(400,100,40,40);
		g2.draw(c);

		Path2D bc0 = new Path2D.Double(new Line2D.Double(340,120,400,120));
		bc0.append(new Line2D.Double(390,116,400,120), false);
		bc0.append(new Line2D.Double(390,124,400,120), false);
		g2.draw(bc0);

		Ellipse2D d = new Ellipse2D.Double(500,100,40,40);
		g2.draw(d);

		Path2D cd0 = new Path2D.Double(new Line2D.Double(440,120,500,120));
		cd0.append(new Line2D.Double(490,116,500,120), false);
		cd0.append(new Line2D.Double(490,124,500,120), false);
		g2.draw(cd0);

		Ellipse2D e = new Ellipse2D.Double(600,100,40,40);
		g2.draw(e);

		Path2D de1 = new Path2D.Double(new Line2D.Double(540,120,600,120));
		de1.append(new Line2D.Double(590,116,600,120), false);
		de1.append(new Line2D.Double(590,124,600,120), false);
		g2.draw(de1);

		Path2D cb1 = new Path2D.Double(new QuadCurve2D.Double(334,135,370,150,407,135));
		cb1.append(new Line2D.Double(334,135,340,142), false);
		cb1.append(new Line2D.Double(334,135,343,133), false);
		g2.draw(cb1);

		Path2D da0 = new Path2D.Double(new QuadCurve2D.Double(234,105,370.5,20,507,105));
		da0.append(new Line2D.Double(234,105,239,98), false);
		da0.append(new Line2D.Double(234,105,243,105), false);
		g2.draw(da0);






		/*QuadCurve2D sa1 = new QuadCurve2D.Double(134,105,170,90,207,105);
		Line2D sa1_horni = new Line2D.Double(134,105,140,98);
		Line2D sa1_dolni = new Line2D.Double(134,105,143,107);*/
	}
	

}
