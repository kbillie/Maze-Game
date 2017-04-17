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

public class Player extends GameObject{

    private int pnlWidth;
    private int pnlHeight;
    private int moveInc;

    //sets the intial properties for the lasercanon
    public Player(int pnlWidth, int pnlHeight, int moveInc) {

        super();
        this.pnlWidth = pnlWidth;
        this.pnlHeight = pnlHeight;
        this.moveInc = moveInc;
        setWidth(15);
        setHeight(15);

    }

    /**
     * @return the pnlWidth
     */
    public int getPnlWidth() {
        return pnlWidth;
    }

    /**
     * @param pnlWidth the pnlWidth to set
     */
    public void setPnlWidth(int pnlWidth) {
        this.pnlWidth = pnlWidth;
    }

    /**
     * @return the pnlHeight
     */
    public int getPnlHeight() {
        return pnlHeight;
    }

    /**
     * @param pnlHeight the pnlHeight to set
     */
    public void setPnlHeight(int pnlHeight) {
        this.pnlHeight = pnlHeight;
    }

    /**
     * @return the moveInc
     */
    public int getMoveInc() {
        return moveInc;
    }

    /**
     * @param moveInc the moveInc to set
     */
    public void setMoveInc(int moveInc) {
        this.moveInc = moveInc;
    }

    //draws the laser canon as a red rectangle at the location, width and height specified in the constructor
    public void draw(Graphics g) {

        g.setColor(Color.MAGENTA);

        g.fillRect(getLocation().x, getLocation().y, getWidth(), getHeight());

    }

    public String toString() {

        String finalString;

        finalString = super.toString() + getPnlWidth() + ", " + getPnlHeight() + ", " + getMoveInc() + ", ";

        return finalString;
    }

    //moves the laser canon to the right across the screen by adding to it's x value if it is at the bounds stops it
    public void moveRight() {

        getLocation().x += moveInc;

        if (getLocation().x + getWidth() >= pnlWidth) {
            getLocation().x = pnlWidth - getWidth();
        }

    }

    //moves the laser canon to the left across the screen by adding to it's x value if it is at the bounds stops it
    public void moveLeft() {

        getLocation().x -= moveInc;

        if (getLocation().x <= 0) {
            getLocation().x = 0;
        }

    }

    public void moveUp() {

        getLocation().y -= moveInc;

        if (getLocation().y <= 0) {
            getLocation().y = 0;
        }
    }

    public void moveDown() {

        getLocation().y += moveInc;

        if (getLocation().y + getHeight() >= pnlHeight) {
            getLocation().y = pnlHeight - getHeight();
        }

    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.MAGENTA);

        g.fillRect(getLocation().x + x, getLocation().y + y, getWidth(), getHeight());

    }
}

