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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JButton btnStart = new JButton("Start");
    
    JButton btnExit = new JButton("Exit");
    private GamePanel gamePanel = new GamePanel();
    StatusPanel statusPanel = new StatusPanel();

    public GameFrame() {

        Container container = this.getContentPane();

        //sets the background to black
        gamePanel.setBackground(Color.BLACK);

        setLayout(new BorderLayout());

        //add buttons to command panel
        commandPanel.add(btnStart);
        
        commandPanel.add(btnExit);
        btnExit.addActionListener(new CommandActionListener());
        btnStart.addActionListener(new CommandActionListener());
        gamePanel.setPreferredSize(new Dimension(500, 500));

        //adds all the panels to the GameFrame
        //the commandPanel holds the start, restart and exit buttons
        //the gamePanel holds the main part of the screen with the spaceship, aliens and lasercanon
        //the status panel holds the score
        container.add(commandPanel, BorderLayout.SOUTH);
        container.add(gamePanel, BorderLayout.CENTER);
        container.add(statusPanel, BorderLayout.NORTH);

        gamePanel.setStatusPanel(statusPanel);

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
            } else if (btn.getText().equals("Start")) {

                getGamePanel().start();

            }

        }

    }

}
