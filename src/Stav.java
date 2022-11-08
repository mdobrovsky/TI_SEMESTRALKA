import java.awt.geom.Ellipse2D;

public class Stav {
    Ellipse2D kruznice;
    String nazev;
    Hrana h_nula;
    Hrana h_jedna;
    Hrana[] vstupniHrany;

    public Stav(Ellipse2D kruznice, String nazev, Hrana h_nula, Hrana h_jedna, Hrana[] vstupniHrany) {
        this.kruznice = kruznice;
        this.nazev = nazev;
        this.h_nula = h_nula;
        this.h_jedna = h_jedna;
        this.vstupniHrany = vstupniHrany;
    }
}
