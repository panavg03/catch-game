package Catch;

// import javax.swing.ImageIcon;

import javax.swing.JFrame;
// import javax.swing.JLabel;

// import java.awt.*;  

import java.awt.Color;
// import java.awt.Component;
// import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
// import java.awt.*;  
// import javax.swing.JFrame;  

// import java.awt.event.ActionEvent;

// import java.awt.event.ActionListener;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
// import java.util.Random;
// import javax.swing.Timer;

import javax.swing.JPanel;

public class Background extends JPanel {
    /**
     *
     */
    static String s = "Pressed: ";
    static int width = 1365, height = 705;
    private static final long serialVersionUID = 1L;
    Rectangle bg1;

    public void paint(final Graphics g) {
        bg1 = new Rectangle(0, height - 60, width, 60);
        super.paint(g);
        // background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, width, height);
        // border
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width, height);
        // bg1
        g.setColor(Color.GREEN);

        g.fill3DRect((int) bg1.getX(), (int) bg1.getY(), (int) bg1.getWidth(), (int) bg1.getHeight(), true);

    }

    public static void main(final String[] args) {
        Background b = new Background();
        Ball d = new Ball();
        // Player p = new Player();
        JFrame f = new JFrame();
        f.setTitle("Catch");

        f.setSize(width, height);

        // System.out.println(s);

        // f.setBackground(Color.cyan);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(b);

        // f.add(p);

        f.add(d);

        f.setVisible(true);

    }

}
