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

    //constructor that sets the size and adds all the objects from the arraylist to the panel
    public GamePanel() {

        String pathBegin = "Maze";

        randomNumber = rand.nextInt(10) + 1;

        String pathEnd = ".png";

        String chooseMaze = "Mazes/" + pathBegin + randomNumber + pathEnd;

        try {
            icon = javax.imageio.ImageIO.read(new File(chooseMaze));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        setSize(500, 500);
        setPreferredSize(new Dimension(500, 500));

        player = new Player(this.getWidth(), this.getHeight(), 10);
        addGameObject(player);
        scaledImage = getScaledImage();

        //adds to the key listener to the panel
        addKeyListener(this);

        //sets the panel tp focusable so that the key listener can work
        setFocusable(true);

        rand = new Random();

        this.setBorder(new javax.swing.border.LineBorder(Color.BLACK));

        setOpaque(false);

    }

    //methods that allows to add the objects to the arraylist
    public void addGameObject(GameObject go) {

        gameObjects.add(go);

    }

    @Override

    //paints all the objects that are visible in the arraylist 
    protected void paintComponent(Graphics g) {


        g.drawImage(scaledImage, 0, 0, null);

        for (GameObject obj : gameObjects) {

            if (obj.isVisible()) {
                obj.draw(g);

            }

        }

        super.paintComponent(g);

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
            player.moveRight();
            for (int x = 0; x < player.getWidth(); x++) {
                for (int y = 0; y < player.getHeight(); y++) {
                    if ((getRed(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getGreen(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getBlue(x + player.getLocation().x, y + player.getLocation().y) == 0)) {
                        player.setLocation(player.getLocation());
                        player.moveLeft();
                        break;
                    }
                }
            }
            repaint();

        } //if the left arrow key is pressed move the canon to the left
        else if (code == KeyEvent.VK_LEFT) {

            player.moveLeft();
            for (int x = 0; x < player.getWidth(); x++) {
                for (int y = 0; y < player.getHeight(); y++) {
                    if ((getRed(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getGreen(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getBlue(x + player.getLocation().x, y + player.getLocation().y) == 0)) {
                        player.setLocation(player.getLocation());
                        player.moveRight();
                        break;
                    }
                }
            }
            repaint();
        } else if (code == KeyEvent.VK_UP) {

            player.moveUp();
            for (int x = 0; x < player.getWidth(); x++) {
                for (int y = 0; y < player.getHeight(); y++) {
                    if ((getRed(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getGreen(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getBlue(x + player.getLocation().x, y + player.getLocation().y) == 0)) {
                        player.setLocation(player.getLocation());
                        player.moveDown();
                        break;
                    }
                }
            }
            repaint();
        } else if (code == KeyEvent.VK_DOWN) {

            player.moveDown();
            for (int x = 0; x < player.getWidth(); x++) {
                for (int y = 0; y < player.getHeight(); y++) {
                    if ((getRed(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getGreen(x + player.getLocation().x, y + player.getLocation().y) == 0) && (getBlue(x + player.getLocation().x, y + player.getLocation().y) == 0)) {
                        player.setLocation(player.getLocation());
                        player.moveUp();
                        break;
                    }
                }
            }
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private BufferedImage getScaledImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) image.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(icon, 0, 0, getWidth(), getHeight(), null);

        return image;
    }

    public int getRed(int x, int y) {
        return (scaledImage.getRGB(x, y) >> 16) & 0xff;
    }

    public int getGreen(int x, int y) {
        return (scaledImage.getRGB(x, y) >> 8) & 0xff;
    }

    public int getBlue(int x, int y) {
        return scaledImage.getRGB(x, y) & 0xff;
    }

}
