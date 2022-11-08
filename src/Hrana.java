import java.awt.*;
import java.awt.geom.Path2D;

public class Hrana {
    Stav odStavu;
    Stav doStavu;
    String ohodnoceni;
    Path2D sipka;

    public Hrana(Stav odStavu, Stav doStavu, String ohodnoceni, Path2D sipka) {
        this.odStavu = odStavu;
        this.doStavu = doStavu;
        this.ohodnoceni = ohodnoceni;
        this.sipka = sipka;
    }
}
