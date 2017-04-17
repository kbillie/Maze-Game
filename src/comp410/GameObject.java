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
import java.awt.Point;

public abstract class GameObject {

    private boolean visible;
    private Point location;
    private Color color;
    private int height;
    private int width;

    //sets the intial values for all the game objects
    public GameObject() {

        visible = true; //sets all objects intial visiblity to true
        location = new Point(0, 0);
        color = Color.BLACK;
        height = 0;
        width = 0;

    }

    //sets the intial values for all the game objects if parameters are provided
    public GameObject(boolean visible, Point location, Color color) {

        this.visible = visible;
        this.location = location;
        this.color = color;
        height = 0;
        width = 0;

    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    //the draw method for the 
    public abstract void draw(Graphics g);

    public String toString() {

        String finalString;
        finalString = isVisible() + ", " + getLocation() + ", " + getColor() + ", ";
        return finalString;

    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    public abstract void draw(Graphics g, int x, int y);

}