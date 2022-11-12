import java.awt.*;
import java.util.Stack;

public class AktualniStav {
    Stav aktualniStav;
    Hrana aktualniHrana;

    Stack<AktualniStav> stack;

    public AktualniStav(Stav aktualniStav, Hrana aktualniHrana, Stack<AktualniStav> stack) {
        this.aktualniStav = aktualniStav;
        this.aktualniHrana = aktualniHrana;
        this.stack = stack;
    }

    public void zpet(){
        AktualniStav zpet = stack.pop();
        this.aktualniStav = zpet.aktualniStav;
        this.aktualniHrana = zpet.aktualniHrana;
    }

    public void zvyraznit(Graphics2D g2){
        aktualniStav.zvyraznitStav(g2);
        aktualniHrana.zvyraznit(g2);
    }

    public void zacernit(Graphics2D g2){
        aktualniStav.zacernitStav(g2);
        aktualniHrana.zacernit(g2);
    }

    public void zmen(int vstup){
        if(vstup == 0){
            //zacernit(g2);
            this.aktualniHrana = aktualniStav.h_nula;
            this.aktualniStav = aktualniStav.h_nula.doStavu;
            //zvyraznit(g2);
        } else {
            //zacernit(g2);
            this.aktualniHrana = aktualniStav.h_jedna;
            this.aktualniStav = aktualniStav.h_jedna.doStavu;
            //zvyraznit(g2);
        }
    }
}
