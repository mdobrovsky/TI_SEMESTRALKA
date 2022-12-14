import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Stav {
    /** objekt kruznice stavu */
    Ellipse2D kruznice;
    /** nazev stavu */
    String nazev;
    /** pozice nazvu */
    int stringX;
    /** pozice nazvu */
    int stringY;
    /** hrana s ohodnocenim nula ze stavu */
    Hrana h_nula;
    /** hrana s ohodnocenim jedna ze stavu */
    Hrana h_jedna;
    /** vstupni hrany stavu */
    Hrana[] vstupniHrany;

    public Stav(Ellipse2D kruznice, String nazev,int x, int y) {
        this.kruznice = kruznice;
        this.nazev = nazev;
        stringX = x;
        stringY = y;
    }

    public void setH_nula(Hrana h_nula) {
        this.h_nula = h_nula;
    }

    public void setH_jedna(Hrana h_jedna) {
        this.h_jedna = h_jedna;
    }

    public void setVstupniHrany(Hrana[] vstupniHrany) {
        this.vstupniHrany = vstupniHrany;
    }

    public void zvyraznitStav(Graphics2D g2){
        g2.setColor(Color.ORANGE);
        g2.draw(kruznice);
        g2.drawString(nazev,stringX,stringY);
        g2.setColor(Color.BLACK);
    }

    public void zacernitStav(Graphics2D g2){
        g2.setColor(Color.black);
        g2.draw(kruznice);
        g2.drawString(nazev,stringX,stringY);

    }
}
