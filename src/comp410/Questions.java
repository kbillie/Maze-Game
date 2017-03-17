/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp410;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kailabillie
 */
public class Questions extends JPanel {
    
    JLabel question;
    
    public Questions() {
        
        //this.gamePanel= gamePanel;

        setSize(5, 100);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //creates the text thst will be inside the JLabel
        question = new JLabel("Question: ");
        
        //adds the JLabel to the panel
        add(question);
        
    }
    
}
