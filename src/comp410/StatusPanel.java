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
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
    
    //creates the JLabel that will display the score
    
    JLabel score;
    GamePanel gamePanel;
    
    public StatusPanel() {
        
        this.gamePanel= gamePanel;

        //setSize(5, 100);
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //creates the text thst will be inside the JLabel
        score= new JLabel("Score: " + "0");
        
        //adds the JLabel to the panel
        add(score);
        

        
    }
    
    public void setPoints (int points) {
        score.setText("Score: " + points);
    } 
    
}

