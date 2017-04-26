/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp410;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author kailabillie
 */
public class Clues {
    
     File fil = new File("clues.txt");

    Scanner scan;
    
    ArrayList<String> listOfClues; 
    
    public Clues () {
        
         try {
            scan = new Scanner(fil);
            //this.gamePanel= gamePanel;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
       listOfClues = new ArrayList<String>(); 
       
       int question = 0;
       
       while (scan.hasNext()) {
           question = Integer.parseInt(scan.nextLine().trim());
           listOfClues.add(scan.nextLine());
       }
       
//       for (int i = 0; i<listOfClues.size(); i++) {
//           System.out.println(listOfClues.get(i));
//       }
        
    }
    
}
