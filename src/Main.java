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
        okno.setTitle("Martin Dobrovsky, A21B0110P, Program reaguje na klávesy x a o");
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
        btnSmaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });






    }

}
