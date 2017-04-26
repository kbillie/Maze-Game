/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp410;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kailabillie
 */
public class Questions extends JPanel {

    JLabel questionLabel = new JLabel();

    //Scanner scan = new Scanner(new File("questions.txt"));
    File fil = new File("questions.txt");

    Scanner scan;

    Answers ans = new Answers();
    private int questionNumber;
    private String question;
    private int questionType;
    private String answer;

    public Questions() {

        try {
            scan = new Scanner(fil);
            //this.gamePanel= gamePanel;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }

        setLayout(new FlowLayout(FlowLayout.LEFT));

        //adds the JLabel to the panel
        add(questionLabel);

    }

    public void Level1() {
        scan.nextLine();
        setQuestionNumber(Integer.parseInt(scan.next()));
        scan.nextLine();
        setQuestion(scan.nextLine());
        setAnswer(scan.nextLine().trim());
        setQuestionType(Integer.parseInt(scan.nextLine()));
        ans.levelOneAnswers.clear();
        ans.levelOneAnswers.add(getAnswer());
        questionLabel.setText("<html>True/False<br><br>" + getQuestionNumber() + ". " + getQuestion() + "</html>");
    }

    public void Level2() {
        while (scan.hasNext()) {
            String number = scan.next();
            if (number.contentEquals("5")) {
                setQuestionNumber(Integer.parseInt(number));
                scan.nextLine();
                setQuestion(scan.nextLine());
                ans.levelTwoAnswers.clear();
                String optionA = scan.nextLine();
                String optionB = scan.nextLine();
                String optionC = scan.nextLine();
                String optionD = scan.nextLine();
                ans.levelTwoAnswers.add(scan.nextLine().trim());
                setQuestionType(Integer.parseInt(scan.nextLine()));
                questionLabel.setText("<html>Multiple Choice<br><br>" + getQuestionNumber() + ". " + getQuestion()
                        + "<br>" + optionA + "<br>" + optionB + "<br>" + optionC + "<br>" + optionD + "</html>");
                break;
            }
        }
    }

    public void Level3() {
        while (scan.hasNext()) {
            String number = scan.next();
            if (number.contains("11")) {
                setQuestionNumber(Integer.parseInt(number));
                scan.nextLine();
                setQuestion(scan.nextLine());
                setAnswer(scan.nextLine().trim());
                setQuestionType(Integer.parseInt(scan.nextLine()));
                ans.levelThreeAnswers.clear();
                ans.levelThreeAnswers.add(getAnswer());
                questionLabel.setText("<html>Fill in the Blank<br><br>" + getQuestionNumber() + ". " + getQuestion() + "</html>");
                break;
            }
        }

    }

    public void NextQuestion() {

        int currentQuestion = getQuestionNumber();
        if (currentQuestion == 16) {
            return;
        }
        currentQuestion++;
        while (scan.hasNext()) {
            String number = scan.next();
            if (number.contains(currentQuestion + "")) {
                setQuestionNumber(Integer.parseInt(number));
                scan.nextLine();
                setQuestion(scan.nextLine());
                if (questionNumber > 0 && questionNumber < 5) {
                    setAnswer(scan.nextLine().trim());
                    ans.levelOneAnswers.clear();
                    ans.levelOneAnswers.add(getAnswer());
                    questionLabel.setText("<html>True/False<br><br>" + getQuestionNumber() + ". " + getQuestion() + "</html>");

                } else if (questionNumber > 4 && questionNumber < 11) {
                    ans.levelTwoAnswers.clear();
                    String optionA = scan.nextLine();
                    String optionB = scan.nextLine();
                    String optionC = scan.nextLine();
                    String optionD = scan.nextLine();
                    ans.levelTwoAnswers.add(scan.nextLine().trim());
                    setQuestionType(Integer.parseInt(scan.nextLine()));
                    questionLabel.setText("<html>Multiple Choice<br><br>" + getQuestionNumber() + ". " + getQuestion()
                            + "<br>" + optionA + "<br>" + optionB + "<br>" + optionC + "<br>" + optionD + "</html>");
                } else if (questionNumber > 10 && questionNumber < 17) {
                    setAnswer(scan.nextLine().trim());
                    setQuestionType(Integer.parseInt(scan.nextLine()));
                    ans.levelThreeAnswers.clear();
                    ans.levelThreeAnswers.add(getAnswer());
                    questionLabel.setText("<html>Fill in the Blank<br><br>" + getQuestionNumber() + ". " + getQuestion() + "</html>");

                }

                break;
            }

        }
    }

    public void NextLevel() {

        int currentQuestion = getQuestionNumber();
        if (currentQuestion > 10 && currentQuestion < 17) {
            return;
        }
        if (currentQuestion > 0 && currentQuestion < 5) {
            String number;
            while (scan.hasNext()) {
                number = scan.next();
                if (number.contentEquals("5")) {
                    setQuestionNumber(Integer.parseInt(number));
                    scan.nextLine();
                    setQuestion(scan.nextLine());
                    ans.levelTwoAnswers.clear();
                    String optionA = scan.nextLine();
                    String optionB = scan.nextLine();
                    String optionC = scan.nextLine();
                    String optionD = scan.nextLine();
                     ans.levelTwoAnswers.add(scan.nextLine().trim());
                    setQuestionType(Integer.parseInt(scan.nextLine()));
                    questionLabel.setText("<html>Multiple Choice<br><br>" + getQuestionNumber() + ". " + getQuestion()
                            + "<br>" + optionA + "<br>" + optionB + "<br>" + optionC + "<br>" + optionD + "</html>");
                    break;
                }

            }

        } else if (currentQuestion > 4 && currentQuestion < 11) {
            String number;
            while (scan.hasNext()) {
                number = scan.next();
                if (number.contentEquals("11")) {
                    setQuestionNumber(Integer.parseInt(number));
                    scan.nextLine();
                    setQuestion(scan.nextLine());
                    setAnswer(scan.nextLine().trim());
                    ans.levelThreeAnswers.add(getAnswer());
                    setQuestionType(Integer.parseInt(scan.nextLine()));
                    questionLabel.setText("<html>Fill in the Blank<br><br>" + getQuestionNumber() + ". " + getQuestion() + "</html>");
                    break;
                }

            }

        }

    }

    /**
     * @return the questionNumber
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    /**
     * @param questionNumber the questionNumber to set
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the questionType
     */
    public int getQuestionType() {
        return questionType;
    }

    /**
     * @param questionType the questionType to set
     */
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

}
