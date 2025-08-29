package Catch;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Ball extends Background implements ActionListener, KeyListener {
    /**
     *
     */

    static boolean paused = false;
    static boolean start = false;
    int speedx, xx = 700, score = 0, lives = 5;
    Timer tm = new Timer(5, this);
    private static final long serialVersionUID = 1L;
    int x = width / 2, y = 0, velx, vely = 2;
    Rectangle ball, player;

    public Ball() {
        // tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

    }

    // BufferedImage image = null;
    // try {
    // image = ImageIO.read(Image.class.getResourceAsStream("C:/Panav/Misc/dwn
    // arrow.png"));
    // } catch (IOException e) {
    // //TODO: handle exception
    // e.printStackTrace();
    // }
    // int w = image.getWidth();
    // int h = image.getHeight();
    // int[] p = image.getRGB(0, 0,w,h,null,0,w);
    // image.flush();

    public void paint(Graphics g) {
        super.paint(g);
        // Ball
        g.setColor(Color.RED);
        ball = new Rectangle(x, y, 20, 20);
        g.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());

        // Player
        player = new Rectangle(xx, height - 130, 100, 20);
        g.setColor(Color.BLACK);
        // hole
        g.fillOval((int) player.getX(), (int) player.getY(), (int) player.getWidth(), (int) player.getHeight());
        // g.fillOval((int) player.getX(), (int) player.getY(),(int)
        // player.getWidth(),(int) player.getHeight());
        // left line
        g.drawLine((int) player.getX(), (int) player.getY() + 10, (int) player.getX(), height - 65);
        // right line
        g.drawLine((int) player.getX() + (int) player.getWidth(), (int) player.getY() + 10,
                (int) player.getX() + (int) player.getWidth(), height - 65);

        // g.drawArc(400,200 , 200, 100, 20, 40);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + lives, 110, 20);
        // tm.start();
        // Random person
        Random posx = new Random();
        if (ball.intersects(bg1)) {
            x = posx.nextInt(width - 10);
            y = 0;
            lives -= 1;
            Toolkit.getDefaultToolkit().beep();

        }
        if (ball.intersects(player)) {
            x = posx.nextInt(width - 10);
            y = 0;
            score += 1;
            System.out.println("Score!");

        }
        if (lives < 1) {
            vely = 0;
            y = 0;
            lives = 0;
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, width, height);
            g.setColor(Color.WHITE);
            g.drawString("Game over", width / 2, height / 2);
            g.drawString("Score: " + score, width / 2, height / 2 + 100);
            g.drawString("Lives: " + lives, width / 2, height / 2 + 200);

        }
        if (paused == true) {
            g.setColor(Color.WHITE);
            g.drawString("Paused", width / 2, height / 2);
            System.out.println("Paused");
        }
        if (start == false) {
            g.setColor(Color.WHITE);
            g.drawString("Press Space to start", width / 2 - 100, 300);
            g.drawString("Press p to pause", width / 2 - 100, 300 + 50);
            g.drawString("Dont let the ball reach the ground", width / 2 - 100, 300 + 100);
            g.drawString("Use the arrow keys to move the basket", width / 2 - 100, 300 + 150);
            System.out.println("Game Started");

        }

    }

    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            speedx = -12;
        }
        if (c == KeyEvent.VK_RIGHT) {
            speedx = 12;
        }
        if (c == KeyEvent.VK_SPACE) {
            tm.start();
            paused = false;
            start = true;
        }
        if (c == KeyEvent.VK_P) {
            tm.stop();
            paused = true;
        }
        if (c == KeyEvent.VK_F) {
            score += 10;
        }
        // String d = KeyEvent.getKeyText(c);
        // s += d;
        String d = KeyEvent.getKeyText(e.getKeyCode());
        s = "Typed: ";
        s += d;
        System.out.println(s);
    }

    public void keyTyped(KeyEvent e) {

        // System.out.println(a);
        // String d = KeyEvent.getKeyText(e.getKeyCode());
        // String ds = "Typed:";
        // ds += d;
        // System.out.println(ds);
        // ds = "Typed: ";

    }

    public void keyReleased(KeyEvent e) {

        speedx = 0;

    }

    public void actionPerformed(final ActionEvent e) {
        if (xx > width - 107) {
            speedx = 0;
            xx = width - 108;
        }
        if (xx < 5) {
            speedx = 0;
            xx = 6;
        }
        if (score > 20) {
            vely = score / 10;
        }

        y += vely;
        xx += speedx;
        // System.out.println(s);
        repaint();

    }

}