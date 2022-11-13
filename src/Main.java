import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class Main {
    private static JTextArea ta;
    private static JScrollPane scrollP;

    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setTitle("Semestralni Prace - Teoreticka Informatika");
        okno.setSize(640, 480);

        DrawingPanel panel = new DrawingPanel();
        okno.add(panel, BorderLayout.CENTER); //prida komponentu

        JPanel toolbar = new JPanel();

        JButton btnExit = new JButton("Exit");
        toolbar.add(btnExit,BorderLayout.WEST);

        ta = new JTextArea("S          \n");

        scrollP = new JScrollPane(ta);
        ta.setTabSize(5);
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
                if(e.getKeyChar()=='1') {
                    panel.retezec = panel.retezec + "1";
                    ta.append("δ("+panel.aktualniStav.aktualniStav.nazev + ", 1) = " + panel.aktualniStav.aktualniStav.h_jedna.doStavu.nazev +"\n");
                    panel.aktualniStav.zmen(1);
                    panel.repaint();
                }
                if(e.getKeyChar()=='0') {
                    panel.retezec = panel.retezec + "0";
                    ta.append("δ("+panel.aktualniStav.aktualniStav.nazev + ", 0) = " + panel.aktualniStav.aktualniStav.h_nula.doStavu.nazev +"\n");
                    panel.aktualniStav.zmen(0);
                    panel.repaint();
                }
                if(e.getKeyChar()== '\uFFFF') {
                    if(panel.retezec.length() >=1) {
                        panel.retezec = panel.retezec.substring(0, panel.retezec.length() - 1);
                    }
                    // blbne kdyz tam je jen vstupni stav
                    AktualniStav as = panel.stack.pop();

                    System.out.println((ta.getLineCount()-2)*12);
                    ta.replaceRange("",((ta.getLineCount()-2)*12),((ta.getLineCount()-1)*12));
                    if (!panel.stack.isEmpty()) {
                        panel.aktualniStav.zpet();
                        panel.repaint();
                    }
                    else {
                        panel.stack.push(as);
                    }
                }
                if (e.getKeyChar() == 'r' || e.getKeyChar() =='R') {
                    panel.retezec = "";
                    System.out.println((ta.getLineCount()-1)*12);
                    ta.replaceRange("",0,((ta.getLineCount()-1)*12));
                    panel.reset();
                    panel.repaint();
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
