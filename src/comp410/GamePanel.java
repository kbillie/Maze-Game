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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.Random;
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

    private ImageIcon icon;

    //constructor that sets the size and adds all the objects from the arraylist to the panel
    public GamePanel() {

        String pathBegin = "/Users/kailabillie/NetBeansProjects/Comp410/src/comp410/Mazes/Maze";

        randomNumber = rand.nextInt(10) + 1;

        String pathEnd = ".png";

        String chooseMaze = pathBegin + randomNumber + pathEnd;

        icon = new ImageIcon(chooseMaze);

        setSize(600, 600);

        player = new Player(this.getWidth(), this.getHeight(), 10);
        addGameObject(player);

        //adds to the key listener to the panel
        addKeyListener(this);

        //sets the panel tp focusable so that the key listener can work
        setFocusable(true);

        rand = new Random();

        this.setBorder(new javax.swing.border.LineBorder(Color.BLACK));

        setOpaque(false);
        
        
    }

    //mwthods that allows to add the objects to the arraylist
    public void addGameObject(GameObject go) {

        gameObjects.add(go);

    }

    @Override

    //paints all the objects that are visible in the arraylist 
    protected void paintComponent(Graphics g) {

        BufferedImage scaledImage = getScaledImage();

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
            repaint();

            //if the left arrow key is pressed move the canon to the left
        } else if (code == KeyEvent.VK_LEFT) {
            player.moveLeft();
            repaint();
        } else if (code == KeyEvent.VK_UP) {
            player.moveUp();
            repaint();
        } else if (code == KeyEvent.VK_DOWN) {
            player.moveDown();
            repaint();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //starts the game
    public void start() {
        if (!playing) {
            player = new Player(this.getWidth(), this.getHeight(), 10);
            gameObjects.add(player);

            playing = true;
            points = 0;
            requestFocus();
            statusPanel.setPoints(points);

        }
    }

    //sets the game back to the intial state that it originally was when the
    //game began
    public void restart() {
        while (!gameObjects.isEmpty()) {
            gameObjects.remove(0);
        }
        playing = false;
        start();
    }

    private BufferedImage getScaledImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) image.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);

        return image;
    }

}
