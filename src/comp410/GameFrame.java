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
import java.awt.Graphics;
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
    JButton nextQuesBtn = new JButton("Next Question");
    JButton nextLvlBtn = new JButton("Next Level");
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
        gamePanel.setQues(questionPanel);

        setLayout(new BorderLayout());

        //add buttons to command panel
        commandPanel.add(btnExit);
        commandPanel.add(nextQuesBtn);
        commandPanel.add(nextLvlBtn);
        btnExit.addActionListener(new CommandActionListener());
        nextQuesBtn.addActionListener(new CommandActionListener());
        nextLvlBtn.addActionListener(new CommandActionListener());

        //adds all the panels to the GameFrame
        //the commandPanel holds the start, restart and exit buttons
        //the gamePanel holds the main part of the screen with the spaceship, aliens and lasercanon
        //the status panel holds the score
        top = new JPanel();
        //top.setLayout(new GridLayout(2, 1, 1, 1));
        top.setLayout(new BorderLayout());
        top.add(statusPanel, BorderLayout.NORTH);
        top.add(questionPanel, BorderLayout.SOUTH);
//
//        center = new JPanel() {
//
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.setColor(Color.WHITE);
//                g.fillRect(0, 0, getWidth(), getHeight());
//
//            }
//        };
//        center.setBorder(new javax.swing.border.LineBorder(Color.BLACK));
//
//        center.add(gamePanel);
//        center.setPreferredSize(new Dimension(500, 500));
//        center.setSize(new Dimension(500, 500));
        
        
        
        

        container.add(commandPanel, BorderLayout.SOUTH);
        container.add(gamePanel, BorderLayout.CENTER);
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
            if (btn.getText().equals("Next Question")) {
                questionPanel.NextQuestion();
                if (questionPanel.getQuestionNumber() != 16) {
                    gamePanel.randomMaze();
                }
                pack();

            }
            if (btn.getText().equals("Next Level")) {
                questionPanel.NextLevel();
                if (!(questionPanel.getQuestionNumber() > 10 && questionPanel.getQuestionNumber() < 17)) {
                    gamePanel.randomMaze();

                }
                pack();
            }

        }
        

    }
}
