import java.awt.BorderLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setTitle("Semestralni Prace - Teoreticka Informatika");
        okno.setSize(640, 480);

        DrawingPanel panel = new DrawingPanel();
        okno.add(panel, BorderLayout.CENTER); //prida komponentu

        JPanel toolbar = new JPanel();

        JButton btnExit = new JButton("Exit");
        toolbar.add(btnExit,BorderLayout.WEST);


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
                    panel.aktualniStav.zmen(1);
                }
                if(e.getKeyChar()=='0') {
                    panel.aktualniStav.zmen(0);
                }
                if(e.getKeyChar()== '\uFFFF') {
                    // blbne kdyz tam je jen vstupni stav
                    panel.stack.pop();
                    panel.historie = panel.historie.substring(0,panel.historie.length()-6);
                    panel.aktualniStav.zpet();
                }

               panel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });






    }

}
