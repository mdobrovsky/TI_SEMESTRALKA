import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.nio.file.Path;

public class DrawingPanel extends JPanel {

	public DrawingPanel() {
		this.setPreferredSize(new Dimension(1200, 480));
	}
	
	@Override
	public void paint(Graphics g1) {
		super.paint(g1);
		
		Graphics2D g2 = (Graphics2D)g1;
		g2.scale(1.5,1.5);
		g2.translate(-40, 50);
		g2.setStroke(new BasicStroke(2));

		Ellipse2D s = new Ellipse2D.Double(100,100,40,40);
		g2.draw(s);
		String nazevS = "S";
		g2.drawString(nazevS, 120 - g2.getFontMetrics().stringWidth(nazevS)/2 ,125 );

		Ellipse2D a = new Ellipse2D.Double(200,100,40,40);
		g2.draw(a);
		String nazevA = "A";
		g2.drawString(nazevA, 220 - g2.getFontMetrics().stringWidth(nazevA)/2 ,125 );

		Path2D vstup = new Path2D.Double(new Line2D.Double(100,120,75,120));
		vstup.append(new Line2D.Double(90,116,100,120), false);
		vstup.append(new Line2D.Double(90,124,100,120), false);
		g2.draw(vstup);

		Path2D sa0 = new Path2D.Double(new Line2D.Double(140,120,200,120));
		sa0.append(new Line2D.Double(190,116,200,120), false);
		sa0.append(new Line2D.Double(190,124,200,120), false);
		g2.draw(sa0);
		String nazevSa0 = "0";
		g2.drawString(nazevSa0, 170 - g2.getFontMetrics().stringWidth(nazevSa0)/2 ,115 );

		Path2D ss1 = new Path2D.Double(new Arc2D.Double(105,77,30,30,-45, 270, Arc2D.OPEN));
		ss1.append(new Line2D.Double(109,103,102,98), false);
		ss1.append(new Line2D.Double(109,103,109,95), false);
		g2.draw(ss1);
		String nazevSs1 = "1";
		g2.drawString(nazevSs1, 120 - g2.getFontMetrics().stringWidth(nazevSs1)/2 ,72 );

		Ellipse2D b = new Ellipse2D.Double(300,100,40,40);
		g2.draw(b);
		String nazevB = "B";
		g2.drawString(nazevB, 320 - g2.getFontMetrics().stringWidth(nazevB)/2 ,125 );

		Path2D ab1 = new Path2D.Double(new Line2D.Double(240,120,300,120));
		ab1.append(new Line2D.Double(290,116,300,120), false);
		ab1.append(new Line2D.Double(290,124,300,120), false);
		g2.draw(ab1);
		String nazevAb1 = "1";
		g2.drawString(nazevAb1, 270 - g2.getFontMetrics().stringWidth(nazevAb1)/2 ,115 );

		Path2D aa0 = new Path2D.Double(new Arc2D.Double(205,77,30,30,-45, 270, Arc2D.OPEN));
		aa0.append(new Line2D.Double(209,103,202,98), false);
		aa0.append(new Line2D.Double(209,103,209,95), false);
		g2.draw(aa0);
		String nazevAa0 = "0";
		g2.drawString(nazevAa0, 220 - g2.getFontMetrics().stringWidth(nazevAa0)/2 ,72 );

		Path2D bs1 = new Path2D.Double(new QuadCurve2D.Double(315,140,210,200,130,138));
		bs1.append(new Line2D.Double(130,138,141,141), false);
		bs1.append(new Line2D.Double(130,138,137,148), false);
		g2.draw(bs1);
		String nazevBs1 = "1";
		g2.drawString(nazevBs1, 220 - g2.getFontMetrics().stringWidth(nazevBs1)/2 ,183 );

		Ellipse2D c = new Ellipse2D.Double(400,100,40,40);
		g2.draw(c);
		String nazevC = "C";
		g2.drawString(nazevC, 420 - g2.getFontMetrics().stringWidth(nazevC)/2 ,125 );

		Path2D bc0 = new Path2D.Double(new Line2D.Double(340,120,400,120));
		bc0.append(new Line2D.Double(390,116,400,120), false);
		bc0.append(new Line2D.Double(390,124,400,120), false);
		g2.draw(bc0);
		String nazevBc0 = "0";
		g2.drawString(nazevBc0, 370 - g2.getFontMetrics().stringWidth(nazevBc0)/2 ,115 );

		Ellipse2D d = new Ellipse2D.Double(500,100,40,40);
		g2.draw(d);
		String nazevD = "D";
		g2.drawString(nazevD, 520 - g2.getFontMetrics().stringWidth(nazevD)/2 ,125 );

		Path2D cd0 = new Path2D.Double(new Line2D.Double(440,120,500,120));
		cd0.append(new Line2D.Double(490,116,500,120), false);
		cd0.append(new Line2D.Double(490,124,500,120), false);
		g2.draw(cd0);
		String nazevCd0 = "0";
		g2.drawString(nazevCd0, 470 - g2.getFontMetrics().stringWidth(nazevCd0)/2 ,115 );

		Ellipse2D e = new Ellipse2D.Double(600,100,40,40);
		g2.draw(e);
		String nazevE = "E";
		g2.drawString(nazevE, 620 - g2.getFontMetrics().stringWidth(nazevE)/2 ,125 );

		Path2D de1 = new Path2D.Double(new Line2D.Double(540,120,600,120));
		de1.append(new Line2D.Double(590,116,600,120), false);
		de1.append(new Line2D.Double(590,124,600,120), false);
		g2.draw(de1);
		String nazevDe1 = "1";
		g2.drawString(nazevDe1, 570 - g2.getFontMetrics().stringWidth(nazevDe1)/2 ,115 );

		Path2D cb1 = new Path2D.Double(new QuadCurve2D.Double(334,135,370,150,407,135));
		cb1.append(new Line2D.Double(334,135,343,142), false);
		cb1.append(new Line2D.Double(334,135,345,135), false);
		g2.draw(cb1);
		String nazevCb1 = "1";
		g2.drawString(nazevCb1, 370 - g2.getFontMetrics().stringWidth(nazevCb1)/2 ,155 );

		Path2D da0 = new Path2D.Double(new QuadCurve2D.Double(234,105,370.5,20,507,105));
		da0.append(new Line2D.Double(234,105,241,97), false);
		da0.append(new Line2D.Double(234,105,245,103), false);
		g2.draw(da0);
		String nazevDa0 = "0";
		g2.drawString(nazevDa0, 370 - g2.getFontMetrics().stringWidth(nazevDa0)/2 ,57 );

		Ellipse2D f = new Ellipse2D.Double(700,20,40,40);
		g2.draw(f);
		String nazevF = "F";
		g2.drawString(nazevF, 720 - g2.getFontMetrics().stringWidth(nazevF)/2 ,45 );

		Ellipse2D g = new Ellipse2D.Double(700,180,40,40);
		g2.draw(g);
		String nazevG = "G";
		g2.drawString(nazevG, 720 - g2.getFontMetrics().stringWidth(nazevG)/2 ,205 );

		Path2D eg1 = new Path2D.Double(new Line2D.Double(636.6,132.5,704.4, 187.5));
		eg1.append(new Line2D.Double(704.4,187.5,698.27,177.47), false);
		eg1.append(new Line2D.Double(704.4,187.5,693.25,183.75), false);
		g2.draw(eg1);
		String nazevEg1 = "1";
		g2.drawString(nazevEg1, 660 , 168 );

		Path2D gf0 = new Path2D.Double(new Line2D.Double(720,180,720, 60));
		gf0.append(new Line2D.Double(720,60,715.98,71.05), false);
		gf0.append(new Line2D.Double(720,60,724.02,71.05), false);
		g2.draw(gf0);
		String nazevGf0 = "0";
		g2.drawString(nazevGf0, 723 , 120 );

		Path2D vystupf = new Path2D.Double(new Line2D.Double(740,40,765, 40));
		vystupf.append(new Line2D.Double(765,40,753.95,35.94), false);
		vystupf.append(new Line2D.Double(765,40,753.95,43.98), false);
		g2.draw(vystupf);

		Path2D vystupe = new Path2D.Double(new Line2D.Double(604.38,132.49,584.91, 148.17));
		vystupe.append(new Line2D.Double(584.91,148.17,596.07,144.41), false);
		vystupe.append(new Line2D.Double(584.91,148.17,591.03,138.15), false);
		g2.draw(vystupe);

		Path2D ff0 = new Path2D.Double(new Arc2D.Double(705,-3,30,30,-45, 270, Arc2D.OPEN));
		ff0.append(new Line2D.Double(709,23,702,18), false);
		ff0.append(new Line2D.Double(709,23,709,15), false);
		g2.draw(ff0);
		String nazevFf0 = "0";
		g2.drawString(nazevFf0, 720 - g2.getFontMetrics().stringWidth(nazevFf0)/2 ,-8 );

		AffineTransform old = g2.getTransform();
		g2.translate(700,200);
		g2.scale(1,-1);
		g2.translate(-700,-200);
		Path2D gg1 = new Path2D.Double(new Arc2D.Double(705,157,30,30,-45, 270, Arc2D.OPEN));
		gg1.append(new Line2D.Double(709,183,702,178), false);
		gg1.append(new Line2D.Double(709,183,709,175), false);
		g2.draw(gg1);
		g2.setTransform(old);
		String nazevGg1 = "1";
		g2.drawString(nazevGg1, 720 - g2.getFontMetrics().stringWidth(nazevGg1)/2 ,255 );

		Path2D fe1 = new Path2D.Double(new QuadCurve2D.Double(639.96,120.78,689.91, 104.88,716.38,59.67));
		fe1.append(new Line2D.Double(639.96,120.78,649,114), false);
		fe1.append(new Line2D.Double(639.96,120.78,651,121), false);
		g2.draw(fe1);
		String nazevFe1 = "1";
		g2.drawString(nazevFe1, 675 , 95 );

		Path2D ef0 = new Path2D.Double(new QuadCurve2D.Double(623.6,100.42,650.09, 55.12,699.98,39.22));
		ef0.append(new Line2D.Double(699.98,39.22,690,39.22), false);
		ef0.append(new Line2D.Double(699.98,39.22,691,46.8), false);
		g2.draw(ef0);
		String nazevEf0 = "0";
		g2.drawString(nazevEf0, 650 , 60 );

	}
	

}
