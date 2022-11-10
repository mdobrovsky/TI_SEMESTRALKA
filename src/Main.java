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

        JButton btnDefPos = new JButton("M236");
        toolbar.add(btnDefPos,BorderLayout.CENTER);

        JButton btnSmaller = new JButton("-");
        toolbar.add(btnSmaller,BorderLayout.EAST);

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
                    System.out.println("1");
                    panel.aktualniStav.zmen(1);
                    panel.repaint();
                }
                if(e.getKeyChar()=='0') {
                    System.out.println("0");
                    panel.aktualniStav.zmen(0);
                    panel.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });






    }

}
