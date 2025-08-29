package Catch;

import java.awt.*;

// import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.Random;

// // import java.awt.event.KeyEvent;
// // import java.awt.event.KeyListener;
import javax.swing.*;

public class Player extends Background implements ActionListener {
    /**
     *
     */
    int x = 200, vx = 1;
    private static final long serialVersionUID = 1L;
    Timer tm = new Timer(5, this);

    public Player() {
        // tm.start();
        // addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

    }

    public void paint(final Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, 200, 100, 100);
        tm.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        x += vx;
        repaint();
    }

}