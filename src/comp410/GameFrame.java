/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp410;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kailabillie
 */
public class GameFrame extends JFrame {

    //creates the panels and buttons that will be in the GameFrame
    JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    JButton btnExit = new JButton("Exit");
    private GamePanel gamePanel = new GamePanel();
    StatusPanel statusPanel = new StatusPanel();
    Questions questionPanel = new Questions();

    JPanel top;
    JPanel center;

    public GameFrame() {

        setTitle("Maze Game"); //sets the tile of the frame to space invaders
        //setSize(600, 600); //sets the size of the window to 600 by 600
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); //sets the visibiilty of the frame to true

        Container container = this.getContentPane();

        //sets the background to black
        gamePanel.setBackground(Color.BLACK);

        setLayout(new BorderLayout());

        //add buttons to command panel

        commandPanel.add(btnExit);
        btnExit.addActionListener(new CommandActionListener());

        //adds all the panels to the GameFrame
        //the commandPanel holds the start, restart and exit buttons
        //the gamePanel holds the main part of the screen with the spaceship, aliens and lasercanon
        //the status panel holds the score
        top = new JPanel();
        top.setLayout(new GridLayout(2, 1, 1, 1));
        top.add(statusPanel);
        top.add(questionPanel);
        
        center= new JPanel();
        center.add(gamePanel);
        center.setPreferredSize(new Dimension(550, 550));
        center.setSize(new Dimension(550, 550));
        

        container.add(commandPanel, BorderLayout.SOUTH);
        container.add(center, BorderLayout.CENTER);
        container.add(top, BorderLayout.NORTH);

        gamePanel.setStatusPanel(statusPanel);
        pack();

    }

    /**
     * @return the gamePanel
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * @param gamePanel the gamePanel to set
     */
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    //provides the functionality for the buttons
    private class CommandActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();

            if (btn.getText().equals("Exit")) {
                System.exit(0);
            } 

        }

    }
}
