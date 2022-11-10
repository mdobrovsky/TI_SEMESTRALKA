import java.awt.*;

public class AktualniStav {
    Stav aktualniStav;
    Hrana aktualniHrana;
    Graphics2D g2;

    public AktualniStav(Stav aktualniStav, Hrana aktualniHrana,Graphics2D g2) {
        this.aktualniStav = aktualniStav;
        this.aktualniHrana = aktualniHrana;
        this.g2 = g2;

    }

    public void zvyraznit(){
        aktualniStav.zvyraznitStav(g2);
        aktualniHrana.zvyraznit(g2);
    }

    public void zacernit(){
        aktualniStav.zacernitStav(g2);
        aktualniHrana.zacernit(g2);
    }

    public void zmen(int vstup){
        if(vstup == 0){
            zacernit();
            this.aktualniHrana = aktualniStav.h_nula;
            this.aktualniStav = aktualniStav.h_nula.doStavu;
            zvyraznit();
        } else {
            zacernit();
            this.aktualniHrana = aktualniStav.h_jedna;
            this.aktualniStav = aktualniStav.h_jedna.doStavu;
            zvyraznit();
        }
    }
}
