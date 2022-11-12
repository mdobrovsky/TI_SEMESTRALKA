import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Hrana {
    Stav odStavu;
    Stav doStavu;
    String ohodnoceni;
    int stringX;
    int stringY;
    Path2D sipka;
    AffineTransform tr;

    public Hrana(Stav odStavu, Stav doStavu, String ohodnoceni, Path2D sipka,int x, int y) {
        this.odStavu = odStavu;
        this.doStavu = doStavu;
        this.ohodnoceni = ohodnoceni;
        this.sipka = sipka;
        stringX = x;
        stringY = y;
    }

    public void setTr(AffineTransform tr) {
        this.tr = tr;
    }

    public void zvyraznit(Graphics2D g2){
        AffineTransform old = g2.getTransform();
        g2.setColor(Color.RED);
        if (tr != null) g2.setTransform(tr);
        g2.draw(sipka);
        if (tr != null) g2.setTransform(old);


        if (ohodnoceni != null) {
            g2.drawString(ohodnoceni,stringX,stringY);
            g2.setColor(Color.BLACK);
        }
    }

    public void zacernit(Graphics2D g2){
        g2.setColor(Color.black);
        AffineTransform old = g2.getTransform();
        if (tr != null) g2.setTransform(tr);
        g2.draw(sipka);
        if (tr != null) g2.setTransform(old);
        if (ohodnoceni != null) {
            g2.drawString(ohodnoceni,stringX,stringY);
        }
    }

    public void vystupniHrana(Graphics2D g2){
        g2.setColor(new Color(50, 205, 50));
        AffineTransform old = g2.getTransform();
        if (tr != null) g2.setTransform(tr);
        g2.draw(sipka);
        if (tr != null) g2.setTransform(old);
        g2.setColor(Color.BLACK);
    }
}
