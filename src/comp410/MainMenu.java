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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kailabillie
 */
public class MainMenu extends JFrame {

    //creates the panels and buttons that will be in the GameFrame
    JButton highScoreBtn = new JButton("View High Score");

    JButton instructionsBtn = new JButton("View Instructions");
    JButton loadBtn = new JButton("Load Game");
    JButton exitBtn = new JButton("Exit Game");

    public MainMenu() {

        setTitle("Main Menu"); //sets the tile of the frame to space invaders
        //setSize(, 600); //sets the size of the window to 600 by 600
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); //sets the visibiilty of the frame to true

        Container container = this.getContentPane();

        setLayout(new GridLayout(4, 1, 1, 1));

        //add buttons to command panel
        add(instructionsBtn);
        add(loadBtn);
        add(highScoreBtn);
        add(exitBtn);

        instructionsBtn.addActionListener(new CommandActionListener());
        loadBtn.addActionListener(new CommandActionListener());
        highScoreBtn.addActionListener(new CommandActionListener());
        exitBtn.addActionListener(new CommandActionListener());

        pack();

    }

    private class CommandActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();

            if (btn.getText().equals("View Instructions")) {
                try {
                    outputToFile("instructions.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                readIn("instructions.txt");

            }
            if (btn.getText().equals("Load Game")) {
                Level lvl = new Level();
            }
            if (btn.getText().equals("View High Score")) {
                readIn("highscores.txt");
            }
            if (btn.getText().equals("Exit Game")) {
                System.exit(0);
            }

        }

    }

    public static void readIn(String fil) {
        try {
            String input = "";
            File file = new File(fil);

            Scanner scan = new Scanner(file);

            String x;

            while (scan.hasNext()) {
                x = scan.nextLine();
                input += x + "\n";
            }

            JOptionPane.showMessageDialog(null, input);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found.\n");
        }

    }
    
    
    public static void outputToFile(String outputFileName) throws FileNotFoundException {
        
        FileOutputStream fos = new FileOutputStream (outputFileName, false);
        PrintWriter pw = new PrintWriter(fos);
        
        
        pw.println();
        pw.println();
        pw.println("Kaila Billie");
        
        pw.close();
        
    }

}
