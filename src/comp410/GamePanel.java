/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp410;

/**
 *
 * @author kailabillie
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {

    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private Player player;
    Random rand = new Random();

    private StatusPanel statusPanel = new StatusPanel();
    private int randomNumber;
    private int count;
    int points = 0;
    boolean playing = false;

    private BufferedImage icon;
    BufferedImage scaledImage;
    private Questions ques = null;
    JPanel maze;

    //constructor that sets the size and adds all the objects from the arraylist to the panel
    public GamePanel() {

        setSize(500, 500);
        setPreferredSize(new Dimension(500, 500));
        maze = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(scaledImage, 0, 0, null);
                for (GameObject go : gameObjects) {
                    go.draw(g);
                }
            }
        };
        maze.setSize(400, 400);
        maze.setPreferredSize(new Dimension(400, 400));
        setBorder(new javax.swing.border.LineBorder(Color.BLACK));

        add(maze);

        player = new Player(this.getWidth(), this.getHeight(), 10);
        addGameObject(player);

        //adds to the key listener to the panel
        addKeyListener(this);

        setOpaque(false);
        randomMaze();

    }

    //methods that allows to add the objects to the arraylist
    public void addGameObject(GameObject go) {

        gameObjects.add(go);

    }

    @Override

    //paints all the objects that are visible in the arraylist 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (GameObject go : gameObjects) {
            go.draw(g, maze.getX(), maze.getY());
        }

        //System.out.println(getQues().getQuestionNumber());
        g.setColor(Color.BLUE);
        if (ques.getQuestionType() == 0) {

            g.drawOval(50, 450, 30, 30);
            g.fillOval(50, 450, 30, 30);
            g.drawString("a", 50, 450);

            g.drawOval(150, 450, 30, 30);
            g.fillOval(150, 450, 30, 30);
            g.drawString("b", 150, 450);

            g.drawOval(300, 450, 30, 30);
            g.fillOval(300, 450, 30, 30);
            g.drawString("c", 300, 450);

            g.drawOval(400, 450, 30, 30);
            g.fillOval(400, 450, 30, 30);
            g.drawString("d", 400, 450);

        } else if (ques.getQuestionType() == 1) {

            g.drawOval(50, 450, 30, 30);
            g.fillOval(50, 450, 30, 30);
            g.drawString("true", 50, 450);

            g.drawOval(150, 450, 30, 30);
            g.fillOval(150, 450, 30, 30);
            g.drawString("false", 150, 450);
        } else if (ques.getQuestionType() == 2) {
            g.fillOval(250, 400, 30, 30);
        }

    }

    /**
     * @return the randomNumber
     */
    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * @param randomNumber the randomNumber to set
     */
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the statusPanel
     */
    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    /**
     * @param statusPanel the statusPanel to set
     */
    public void setStatusPanel(StatusPanel statusPanel) {
        this.statusPanel = statusPanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //if the right key is pressed move the canon to the right
        if (code == KeyEvent.VK_RIGHT) {
            getPlayer().moveRight();
            for (int x = 0; x < getPlayer().getWidth(); x++) {
                for (int y = 0; y < getPlayer().getHeight(); y++) {
                    if ((getRed(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getGreen(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getBlue(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0)) {
                        getPlayer().setLocation(getPlayer().getLocation());
                        getPlayer().moveLeft();
                        break;
                    }
                }
            }
            repaint();

        } //if the left arrow key is pressed move the canon to the left
        else if (code == KeyEvent.VK_LEFT) {

            getPlayer().moveLeft();
            for (int x = 0; x < getPlayer().getWidth(); x++) {
                for (int y = 0; y < getPlayer().getHeight(); y++) {
                    if ((getRed(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getGreen(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getBlue(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0)) {
                        getPlayer().setLocation(getPlayer().getLocation());
                        getPlayer().moveRight();
                        break;
                    }
                }
            }
            repaint();
        } else if (code == KeyEvent.VK_UP) {

            getPlayer().moveUp();
            for (int x = 0; x < getPlayer().getWidth(); x++) {
                for (int y = 0; y < getPlayer().getHeight(); y++) {
                    if ((getRed(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getGreen(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getBlue(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0)) {
                        getPlayer().setLocation(getPlayer().getLocation());
                        getPlayer().moveDown();
                        break;
                    }
                }
            }
            repaint();
        } else if (code == KeyEvent.VK_DOWN) {

            getPlayer().moveDown();
            for (int x = 0; x < getPlayer().getWidth(); x++) {
                for (int y = 0; y < getPlayer().getHeight(); y++) {
                    if ((getRed(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getGreen(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0) && (getBlue(x + getPlayer().getLocation().x, y + getPlayer().getLocation().y) == 0)) {
                        getPlayer().setLocation(getPlayer().getLocation());
                        getPlayer().moveUp();
                        break;
                    }
                }
            }
            repaint();
        } else {
            return;
        }

        int px = player.getLocation().x + maze.getX();
        int py = player.getLocation().y + maze.getY();
        int ex = 275;
        int ey = 415;
        int x = (px - ex);
        int y = (py - ey);
        if (Math.sqrt(x * x + y * y) < 30) {
            JOptionPane.showMessageDialog(this, "Found exit");

            if (ques.getQuestionType() == 0) {
                
            } else if (ques.getQuestionType() == 1) {
                
            } else if (ques.getQuestionType() == 2) {
                
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private BufferedImage getScaledImage() {
        BufferedImage image = new BufferedImage(maze.getWidth(), maze.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) image.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(icon, 0, 0, maze.getWidth(), maze.getHeight(), null);
        System.out.println(getWidth() + " " + getHeight());

        return image;
    }

    public int getRed(int x, int y) {
        if (x >= scaledImage.getWidth() || y >= scaledImage.getHeight() || x < 0 || y < 0) {
            return 1;
        }
        return (scaledImage.getRGB(x, y) >> 16) & 0xff;
    }

    public int getGreen(int x, int y) {
        if (x >= scaledImage.getWidth() || y >= scaledImage.getHeight() || x < 0 || y < 0) {
            return 1;
        }
        return (scaledImage.getRGB(x, y) >> 8) & 0xff;
    }

    public int getBlue(int x, int y) {
        if (x >= scaledImage.getWidth() || y >= scaledImage.getHeight() || x < 0 || y < 0) {
            return 1;
        }
        return scaledImage.getRGB(x, y) & 0xff;
    }

    public void randomMaze() {

        String pathBegin = "Maze";

        randomNumber = rand.nextInt(10) + 1;

        String pathEnd = ".png";

        String chooseMaze = "Mazes/" + pathBegin + randomNumber + pathEnd;

        try {
            icon = javax.imageio.ImageIO.read(getClass().getResourceAsStream(chooseMaze));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        scaledImage = getScaledImage();
        //sets the panel tp focusable so that the key listener can work
        player.setLocation(new Point(maze.getWidth() / 2 - 24, 0));
        setFocusable(true);
        requestFocus();

        repaint();

    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the ques
     */
    public Questions getQues() {
        return ques;
    }

    /**
     * @param ques the ques to set
     */
    public void setQues(Questions ques) {
        this.ques = ques;
    }
}
