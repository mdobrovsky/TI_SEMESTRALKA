import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.ImageObserver;
import java.util.Stack;

public class DrawingPanel extends JPanel {
	/** aktualni stav v kterem se nachazime */
    AktualniStav aktualniStav;
	/** slouzi k zahajeni simulace */
    boolean start = true;
	/** zasobnik stavu, pres ktere jsme presli */
    Stack<AktualniStav> stack;
	/** vstupni retezec */
    String retezec = "";


    public DrawingPanel() {
        this.setPreferredSize(new Dimension(1200, 480));
        stack = new Stack<>();
    }

	/**
	 * Hlavni vykreslovaci metoda
	 * @param g1  the <code>Graphics</code> context in which to paint
	 */
    @Override
    public void paint(Graphics g1) {
        super.paint(g1);


        Graphics2D g2 = (Graphics2D) g1;
        Font font = g2.getFont();

        g2.setFont(new Font("Times New", Font.TYPE1_FONT, 15));
        g2.drawString("Stiskněte '0' nebo '1' k vložení řetězce do konečného automatu                        " +
                "Pro krok zpět stikněte '\u2B05'                        Pro reset 'r'", 20, 35);
        g2.drawString("Historie:", 1125, 20);

        g2.drawString("Vstupní řetězec:", 20, 80);
        g2.drawString(" " + retezec, 145, 80);

        g2.setFont(font);
        g2.drawString("Vypracovali: Vitalyi Bohera, Martin Dobrovský", 20, 460);
        g2.drawString("Fakulta aplikovaných věd Západočeské univerzity", 20, 477);
        g2.scale(1.5, 1.5);
        g2.translate(-40, 50);
        g2.setStroke(new BasicStroke(2));


        Ellipse2D s = new Ellipse2D.Double(100, 100, 40, 40);
        g2.draw(s);
        String nazevS = "S";
        int x = 120 - g2.getFontMetrics().stringWidth(nazevS) / 2;
        int y = 125;
        g2.drawString(nazevS, x, y);
		Stav stavS = new Stav(s, nazevS, x, y);

        Ellipse2D a = new Ellipse2D.Double(200, 100, 40, 40);
        g2.draw(a);
        String nazevA = "A";
        x = 220 - g2.getFontMetrics().stringWidth(nazevA) / 2;
        y = 125;
        g2.drawString(nazevA, x, y);
        Stav stavA = new Stav(a, nazevA, x, y);

        Path2D vstup = new Path2D.Double(new Line2D.Double(100, 120, 75, 120));
        vstup.append(new Line2D.Double(90, 116, 100, 120), false);
        vstup.append(new Line2D.Double(90, 124, 100, 120), false);
        g2.draw(vstup);
		Hrana hranaVstup = new Hrana(null, stavS, null, vstup, -1, -1);

        Path2D sa0 = new Path2D.Double(new Line2D.Double(140, 120, 200, 120));
        sa0.append(new Line2D.Double(190, 116, 200, 120), false);
        sa0.append(new Line2D.Double(190, 124, 200, 120), false);
        g2.draw(sa0);
        String nazevSa0 = "0";
        int hx = 170 - g2.getFontMetrics().stringWidth(nazevSa0) / 2;
        int hy = 115;
        g2.drawString(nazevSa0, hx, hy);
        Hrana hranaSA0 = new Hrana(stavS, stavA, nazevSa0, sa0, hx, hy);


        Path2D ss1 = new Path2D.Double(new Arc2D.Double(105, 77, 30, 30, -45, 270, Arc2D.OPEN));
        ss1.append(new Line2D.Double(109, 103, 102, 98), false);
        ss1.append(new Line2D.Double(109, 103, 109, 95), false);
        g2.draw(ss1);
        String nazevSs1 = "1";
        hx = 120 - g2.getFontMetrics().stringWidth(nazevSs1) / 2;
        hy = 72;
        g2.drawString(nazevSs1, hx, hy);
        Hrana hranaSS1 = new Hrana(stavS, stavS, nazevSs1, ss1, hx, hy);


        Ellipse2D b = new Ellipse2D.Double(300, 100, 40, 40);
        g2.draw(b);
        String nazevB = "B";
        x = 320 - g2.getFontMetrics().stringWidth(nazevB) / 2;
        y = 125;
        g2.drawString(nazevB, x, y);
        Stav stavB = new Stav(b, nazevB, x, y);

        Path2D ab1 = new Path2D.Double(new Line2D.Double(240, 120, 300, 120));
        ab1.append(new Line2D.Double(290, 116, 300, 120), false);
        ab1.append(new Line2D.Double(290, 124, 300, 120), false);
        g2.draw(ab1);
        String nazevAb1 = "1";
        hx = 270 - g2.getFontMetrics().stringWidth(nazevAb1) / 2;
        hy = 115;
        g2.drawString(nazevAb1, hx, hy);
        Hrana hranaAB1 = new Hrana(stavA, stavB, nazevAb1, ab1, hx, hy);


        Path2D aa0 = new Path2D.Double(new Arc2D.Double(205, 77, 30, 30, -45, 270, Arc2D.OPEN));
        aa0.append(new Line2D.Double(209, 103, 202, 98), false);
        aa0.append(new Line2D.Double(209, 103, 209, 95), false);
        g2.draw(aa0);
        String nazevAa0 = "0";
        hx = 220 - g2.getFontMetrics().stringWidth(nazevAa0) / 2;
        hy = 72;
        g2.drawString(nazevAa0, hx, hy);
        Hrana hranaAA0 = new Hrana(stavA, stavA, nazevAa0, aa0, hx, hy);


        Path2D bs1 = new Path2D.Double(new QuadCurve2D.Double(315, 140, 210, 200, 130, 138));
        bs1.append(new Line2D.Double(130, 138, 141, 141), false);
        bs1.append(new Line2D.Double(130, 138, 137, 148), false);
        g2.draw(bs1);
        String nazevBs1 = "1";
        hx = 220 - g2.getFontMetrics().stringWidth(nazevBs1) / 2;
        hy = 183;
        g2.drawString(nazevBs1, hx, hy);
        Hrana hranaBS1 = new Hrana(stavB, stavS, nazevBs1, bs1, hx, hy);


        Ellipse2D c = new Ellipse2D.Double(400, 100, 40, 40);
        g2.draw(c);
        String nazevC = "C";
        x = 420 - g2.getFontMetrics().stringWidth(nazevC) / 2;
        g2.drawString(nazevC, x, 125);
        Stav stavC = new Stav(c, nazevC, x, y);

        Path2D bc0 = new Path2D.Double(new Line2D.Double(340, 120, 400, 120));
        bc0.append(new Line2D.Double(390, 116, 400, 120), false);
        bc0.append(new Line2D.Double(390, 124, 400, 120), false);
        g2.draw(bc0);
        String nazevBc0 = "0";
        hx = 370 - g2.getFontMetrics().stringWidth(nazevBc0) / 2;
        hy = 115;
        g2.drawString(nazevBc0, hx, hy);
        Hrana hranaBC0 = new Hrana(stavB, stavC, nazevBc0, bc0, hx, hy);


        Ellipse2D d = new Ellipse2D.Double(500, 100, 40, 40);
        g2.draw(d);
        String nazevD = "D";
        x = 520 - g2.getFontMetrics().stringWidth(nazevD) / 2;
        g2.drawString(nazevD, x, 125);
        Stav stavD = new Stav(d, nazevD, x, y);

        Path2D cd0 = new Path2D.Double(new Line2D.Double(440, 120, 500, 120));
        cd0.append(new Line2D.Double(490, 116, 500, 120), false);
        cd0.append(new Line2D.Double(490, 124, 500, 120), false);
        g2.draw(cd0);
        String nazevCd0 = "0";
        hx = 470 - g2.getFontMetrics().stringWidth(nazevCd0) / 2;
        hy = 115;
        g2.drawString(nazevCd0, hx, hy);
        Hrana hranaCD0 = new Hrana(stavC, stavD, nazevCd0, cd0, hx, hy);

        Ellipse2D e = new Ellipse2D.Double(600, 100, 40, 40);
        g2.draw(e);
        String nazevE = "E";
        x = 620 - g2.getFontMetrics().stringWidth(nazevE) / 2;
        g2.drawString(nazevE, x, 125);
        Stav stavE = new Stav(e, nazevE, x, y);

        Path2D de1 = new Path2D.Double(new Line2D.Double(540, 120, 600, 120));
        de1.append(new Line2D.Double(590, 116, 600, 120), false);
        de1.append(new Line2D.Double(590, 124, 600, 120), false);
        g2.draw(de1);
        String nazevDe1 = "1";
        hx = 570 - g2.getFontMetrics().stringWidth(nazevDe1) / 2;
        hy = 115;
        g2.drawString(nazevDe1, hx, hy);
        Hrana hranaDE1 = new Hrana(stavD, stavE, nazevDe1, de1, hx, hy);

        Path2D cb1 = new Path2D.Double(new QuadCurve2D.Double(334, 135, 370, 150, 407, 135));
        cb1.append(new Line2D.Double(334, 135, 343, 142), false);
        cb1.append(new Line2D.Double(334, 135, 345, 135), false);
        g2.draw(cb1);
        String nazevCb1 = "1";
        hx = 370 - g2.getFontMetrics().stringWidth(nazevCb1) / 2;
        hy = 155;
        g2.drawString(nazevCb1, hx, hy);
        Hrana hranaCB1 = new Hrana(stavC, stavB, nazevCb1, cb1, hx, hy);

        Path2D da0 = new Path2D.Double(new QuadCurve2D.Double(234, 105, 370.5, 20, 507, 105));
        da0.append(new Line2D.Double(234, 105, 241, 97), false);
        da0.append(new Line2D.Double(234, 105, 245, 103), false);
        g2.draw(da0);
        String nazevDa0 = "0";
        hx = 370 - g2.getFontMetrics().stringWidth(nazevDa0) / 2;
        hy = 57;
        g2.drawString(nazevDa0, hx, hy);
        Hrana hranaDA0 = new Hrana(stavD, stavA, nazevDa0, da0, hx, hy);


        Ellipse2D f = new Ellipse2D.Double(700, 20, 40, 40);
        g2.draw(f);
        String nazevF = "F";
        x = 720 - g2.getFontMetrics().stringWidth(nazevF) / 2;
        y = 45;
        g2.drawString(nazevF, x, y);
        Stav stavF = new Stav(f, nazevF, x, y);

        Ellipse2D g = new Ellipse2D.Double(700, 180, 40, 40);
        g2.draw(g);
        String nazevG = "G";
        x = 720 - g2.getFontMetrics().stringWidth(nazevG) / 2;
        y = 205;
        g2.drawString(nazevG, x, y);
        Stav stavG = new Stav(g, nazevG, x, y);

        Path2D eg1 = new Path2D.Double(new Line2D.Double(636.6, 132.5, 704.4, 187.5));
        eg1.append(new Line2D.Double(704.4, 187.5, 698.27, 177.47), false);
        eg1.append(new Line2D.Double(704.4, 187.5, 693.25, 183.75), false);
        g2.draw(eg1);
        String nazevEg1 = "1";
        hx = 660;
        hy = 168;
        g2.drawString(nazevEg1, hx, hy);
        Hrana hranaEG1 = new Hrana(stavE, stavG, nazevEg1, eg1, hx, hy);

        Path2D gf0 = new Path2D.Double(new Line2D.Double(720, 180, 720, 60));
        gf0.append(new Line2D.Double(720, 60, 715.98, 71.05), false);
        gf0.append(new Line2D.Double(720, 60, 724.02, 71.05), false);
        g2.draw(gf0);
        String nazevGf0 = "0";
        g2.drawString(nazevGf0, 723, 120);
        Hrana hranaGF0 = new Hrana(stavG, stavF, nazevGf0, gf0, 723, 120);

        Path2D vystupf = new Path2D.Double(new Line2D.Double(740, 40, 765, 40));
        vystupf.append(new Line2D.Double(765, 40, 753.95, 35.94), false);
        vystupf.append(new Line2D.Double(765, 40, 753.95, 43.98), false);
        g2.draw(vystupf);
		Hrana hranaVystupF = new Hrana(stavF, null, null, vystupf, -1, -1);

        Path2D vystupe = new Path2D.Double(new Line2D.Double(604.38, 132.49, 584.91, 148.17));
        vystupe.append(new Line2D.Double(584.91, 148.17, 596.07, 144.41), false);
        vystupe.append(new Line2D.Double(584.91, 148.17, 591.03, 138.15), false);
        g2.draw(vystupe);
		Hrana hranaVystupE = new Hrana(stavE, null, null, vystupe, -1, -1);

        Path2D ff0 = new Path2D.Double(new Arc2D.Double(705, -3, 30, 30, -45, 270, Arc2D.OPEN));
        ff0.append(new Line2D.Double(709, 23, 702, 18), false);
        ff0.append(new Line2D.Double(709, 23, 709, 15), false);
        g2.draw(ff0);
        String nazevFf0 = "0";
        hx = 720 - g2.getFontMetrics().stringWidth(nazevFf0) / 2;
        hy = -8;
        g2.drawString(nazevFf0, hx, hy);
        Hrana hranaFF0 = new Hrana(stavF, stavF, nazevFf0, ff0, hx, hy);


        AffineTransform old = g2.getTransform();
        g2.translate(700, 200);
        g2.scale(1, -1);
        g2.translate(-700, -200);
        AffineTransform tr = g2.getTransform();
        Path2D gg1 = new Path2D.Double(new Arc2D.Double(705, 157, 30, 30, -45, 270, Arc2D.OPEN));
        gg1.append(new Line2D.Double(709, 183, 702, 178), false);
        gg1.append(new Line2D.Double(709, 183, 709, 175), false);
        g2.draw(gg1);
        g2.setTransform(old);
        String nazevGg1 = "1";
        hx = 720 - g2.getFontMetrics().stringWidth(nazevGg1) / 2;
        hy = 255;
        g2.drawString(nazevGg1, hx, hy);
        Hrana hranaGG1 = new Hrana(stavG, stavG, nazevGg1, gg1, hx, hy);
        hranaGG1.setTr(tr);


        Path2D fe1 = new Path2D.Double(new QuadCurve2D.Double(639.96, 120.78, 689.91, 104.88, 716.38, 59.67));
        fe1.append(new Line2D.Double(639.96, 120.78, 649, 114), false);
        fe1.append(new Line2D.Double(639.96, 120.78, 651, 121), false);
        g2.draw(fe1);
        String nazevFe1 = "1";
        g2.drawString(nazevFe1, 675, 95);
        Hrana hranaFE1 = new Hrana(stavF, stavE, nazevFe1, fe1, 675, 95);

        Path2D ef0 = new Path2D.Double(new QuadCurve2D.Double(623.6, 100.42, 650.09, 55.12, 699.98, 39.22));
        ef0.append(new Line2D.Double(699.98, 39.22, 690, 39.22), false);
        ef0.append(new Line2D.Double(699.98, 39.22, 691, 46.8), false);
        g2.draw(ef0);
        String nazevEf0 = "0";
        g2.drawString(nazevEf0, 650, 60);
        Hrana hranaEF0 = new Hrana(stavE, stavF, nazevEf0, ef0, 650, 60);

        stavA.setH_jedna(hranaAB1);
        stavA.setH_nula(hranaAA0);
        Hrana[] vstupniHranyA = new Hrana[]{hranaAA0, hranaSA0, hranaDA0};
        stavA.setVstupniHrany(vstupniHranyA);

        stavB.setH_jedna(hranaBS1);
        stavB.setH_nula(hranaBC0);
        Hrana[] vstupniHranyB = new Hrana[]{hranaCB1, hranaAB1};
        stavB.setVstupniHrany(vstupniHranyB);

        stavC.setH_nula(hranaCD0);
        stavC.setH_jedna(hranaCB1);
        Hrana[] vstupniHranyC = new Hrana[]{hranaBC0};
        stavC.setVstupniHrany(vstupniHranyC);

        stavS.setH_nula(hranaSA0);
        stavS.setH_jedna(hranaSS1);
        Hrana[] vstupniHranyS = new Hrana[]{hranaVstup, hranaBS1, hranaSS1};
        stavS.setVstupniHrany(vstupniHranyS);

        stavD.setH_nula(hranaDA0);
        stavD.setH_jedna(hranaDE1);
        Hrana[] vstupniHranyD = new Hrana[]{hranaCD0};
        stavD.setVstupniHrany(vstupniHranyD);

        stavE.setH_nula(hranaEF0);// vyresit vystupni vrchol
        stavE.setH_jedna(hranaEG1);
        Hrana[] vstupniHranyE = new Hrana[]{hranaDE1, hranaFE1};
        stavE.setVstupniHrany(vstupniHranyE);

        stavF.setH_nula(hranaFF0); // totez
        stavF.setH_jedna(hranaFE1);
        Hrana[] vstupniHranyF = new Hrana[]{hranaEF0, hranaFF0, hranaGF0};
        stavF.setVstupniHrany(vstupniHranyF);

        stavG.setH_nula(hranaGF0);
        stavG.setH_jedna(hranaGG1);
        Hrana[] vstupniHranyG = new Hrana[]{hranaEG1, hranaGG1};
        stavG.setVstupniHrany(vstupniHranyG);

//        stavy = new Stav[]{stavS, stavA, stavB, stavC, stavD, stavF, stavG, stavE};
//        hrany = new Hrana[]{hranaSS1, hranaSA0, hranaAA0, hranaAB1, hranaBS1, hranaBC0, hranaCB1, hranaCD0, hranaDA0, hranaDE1,
//                hranaEG1, hranaEF0, hranaFE1, hranaFF0, hranaGG1, hranaGF0, hranaVystupF, hranaVystupE, hranaVstup};


        if (start) {
            aktualniStav = new AktualniStav(stavS, hranaVstup, stack);
            aktualniStav.zvyraznit(g2);
            start = false;
        }
        AktualniStav copy = new AktualniStav(aktualniStav.aktualniStav, aktualniStav.aktualniHrana, stack);
        stack.add(copy);
        aktualniStav.zvyraznit(g2);

        if (aktualniStav.aktualniStav.nazev.equals("E")) {
            hranaVystupE.vystupniHrana(g2);
        }
        if (aktualniStav.aktualniStav.nazev.equals("F")) {
			hranaVystupF.vystupniHrana(g2);
        }
    }

	/**
	 * Resetuje simulaci
	 */
    public void reset() {
        this.start = true;
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }


}
