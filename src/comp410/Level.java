/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp410;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kailabillie
 */
public class Level extends JFrame {

    JButton easyBtn = new JButton("Easy");
    JButton mediumBtn = new JButton("Medium");
    JButton hardBtn = new JButton("Hard");
    JLabel label = new JLabel("Choose a level:");

    public Level() {
        setTitle("Level Screen"); //sets the tile of the frame to space invaders
        //setSize(, 600); //sets the size of the window to 600 by 600
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); //sets the visibiilty of the frame to true

        Container container = this.getContentPane();

        setLayout(new GridLayout(4, 1, 1, 1));

        //add buttons to command panel
        add(label);
        add(easyBtn);
        add(mediumBtn);
        add(hardBtn);

        easyBtn.addActionListener(new CommandActionListener());
        mediumBtn.addActionListener(new CommandActionListener());
        hardBtn.addActionListener(new CommandActionListener());

        pack();
    }

    private class CommandActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();

            if (btn.getText().equals("Easy")) {
                GameFrame gf = new GameFrame();
                
            } else if (btn.getText().equals("Medium")) {
                GameFrame gf = new GameFrame();
            } else if (btn.getText().equals("Hard")) {
                GameFrame gf = new GameFrame();
            }

        }

    }

}
