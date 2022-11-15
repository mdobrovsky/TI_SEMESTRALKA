import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class Main {
    private static JTextArea ta;
    private static JScrollPane scrollP;

    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setTitle("Semestrální Práce KIV/TI - Simulace rozpoznávacího konečného automatu");
        okno.setSize(640, 480);

        DrawingPanel panel = new DrawingPanel();
        okno.setResizable(false);
        okno.add(panel, BorderLayout.CENTER); //prida komponentu

        JPanel toolbar = new JPanel();

        JButton btnExit = new JButton("Exit");
        toolbar.add(btnExit,BorderLayout.WEST);

        ta = new JTextArea("S          \n");

        scrollP = new JScrollPane(ta);
        ta.setTabSize(5);
        ta.setFocusable(false);
        ta.setCaretPosition(ta.getDocument().getLength());
        scrollP.setWheelScrollingEnabled(true);
        scrollP.setPreferredSize(new Dimension(100, 60));


        okno.add(scrollP, BorderLayout.EAST);


        okno.add(toolbar, BorderLayout.SOUTH);


        okno.pack(); //udela resize okna dle komponent

        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setLocationRelativeTo(null); //vycentrovat na obrazovce
        okno.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okno.dispose();
            }
        });

        panel.setFocusable(true);
        panel.requestFocus();
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()=='1') { // na vstupu prisla 1
                    panel.retezec = panel.retezec + "1"; // pridame do aktualniho retezce 1
                    // pridame vypis prechodove funkce pro aktualni stav a vstupni symbol 1
                    ta.append("δ("+panel.aktualniStav.aktualniStav.nazev + ", 1) = " + panel.aktualniStav.aktualniStav.h_jedna.doStavu.nazev +"\n");
                    panel.aktualniStav.zmen(1); // nastavime novy aktualni stav
                    panel.repaint(); // vykresleme zmeny
                }
                if(e.getKeyChar()=='0') { //na vstupu prisla 0
                    panel.retezec = panel.retezec + "0"; // pridame do aktualniho retezce 0
                    // pridame vypis prechodove funkce pro aktualni stav a vstupni symbol 0
                    ta.append("δ("+panel.aktualniStav.aktualniStav.nazev + ", 0) = " + panel.aktualniStav.aktualniStav.h_nula.doStavu.nazev +"\n");
                    panel.aktualniStav.zmen(0); // nastavime novy aktualni stav
                    panel.repaint(); // vykresleme zmeny
                }
                if(e.getKeyChar()== '\uFFFF') { // krok zpet
                    if(panel.retezec.length() >=1) { // uprava aktualniho retezce, odrizneme posledni symbol
                        panel.retezec = panel.retezec.substring(0, panel.retezec.length() - 1);
                    }
                    AktualniStav as = panel.stack.pop(); // vybereme aktualni stav

                    ta.replaceRange("",((ta.getLineCount()-2)*12),((ta.getLineCount()-1)*12)); // uprava vypisu prechodovych funkci
                    if (!panel.stack.isEmpty()) {   // pokud po odebrani stavu ze zasobniku neni zasobnik prazdnej, tj jsou tam jeste stavy
                        panel.aktualniStav.zpet();  // tak nahradime aktualni stav za predchozi
                        panel.repaint(); // vykresleme zmeny
                    }
                    else { // pokud by po odstraneni stavu by byl zasobnik prazdnej, znamena to ze jsme na zacatku, tj jsme v pocatecnim stavu
                        panel.stack.push(as); // tak ho zase vratime (pocatecni stav)
                    }
                }
                if (e.getKeyChar() == 'r' || e.getKeyChar() =='R') { // resetovani automatu
                    panel.retezec = ""; // smazeme aktualni retezec
                    ta.replaceRange("",0,((ta.getLineCount()-1)*12)); // smazeme zaznamy prechodovych funkci
                    panel.reset(); // nastaveni aktualniho stavu na pocatecni a vymazani zasobniku
                    panel.repaint(); // vykresleni zmen
                }
                if (ta.getLineCount()-1 == 0){
                    ta.append("S          \n");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
