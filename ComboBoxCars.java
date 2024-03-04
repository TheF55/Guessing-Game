/*
 * Program          Module 11 
 * Programmer       Theodore Feldmman
 * Date             12/12/2023
 * Description      Car Brand guessing game 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxCars {
    
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel1, statusLabel2, bottomLabel, carLabel;
    private JPanel userInputPanel, buttonPanel;
    private JButton guessButton, newButton;
    
    private JComboBox brandComboBox;
    private int number;

    String[] carString = {
        "F-150",
        "Chiron",
        "X1 SUV",
        "RDX",
        "Charger",
        "296 GTS",
        "Sierra",
        "Accord",
    };

    String[] brandString = {
        "Ford",
        "Bugatti",
        "BMW",
        "Acura",
        "Dodge",
        "Ferrari",
        "GMC",
        "Honda",
    };

     public ComboBoxCars(){
        number = (int)(Math.random() * 8);

        System.out.println("Number = " + number);

        prepareGUI();
    }

    public static void main(String[] args) {
        ComboBoxCars c = new ComboBoxCars();
        c.start();
    }

    private void prepareGUI(){
        headerLabel = new JLabel("Guess the Car Brand" , JLabel.CENTER);

        //set up user input pannel
        userInputPanel = new JPanel();
        userInputPanel.setLayout(new FlowLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        //set up components of the userInput panel
        carLabel = new JLabel(carString[number]);
        brandComboBox = new JComboBox(brandString);


        guessButton = new JButton("Guess");
        newButton = new JButton("New Game");

        //Add the components to the panel
        userInputPanel.add(carLabel);
        userInputPanel.add(brandComboBox);
        userInputPanel.add(guessButton);
        userInputPanel.add(newButton);

        //set up the status for the feedback labels
        statusLabel1 = new JLabel("", JLabel.CENTER);
        statusLabel2 = new JLabel("", JLabel.CENTER);

        //sets up the blank label for the bottom of the form
        bottomLabel = new JLabel("", JLabel.CENTER);

        //sets up the main frame
        mainFrame = new JFrame("Guessing Car Brand Game");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(6, 1));
        mainFrame.setResizable(false);
        mainFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //Adds labels and control panel to the mainFrame
        mainFrame.add(headerLabel);
        mainFrame.add(userInputPanel);
        mainFrame.add(buttonPanel);
        mainFrame.add(statusLabel1);
        mainFrame.add(statusLabel2);
        mainFrame.add(bottomLabel);
        mainFrame.setVisible(true);
    }

    private void start (){
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strBrand = (String) brandComboBox.getSelectedItem();

                if(strBrand.contentEquals(brandString[number])){
                    statusLabel1.setText("Very Good!");

                }
                else{
                    statusLabel1.setText("Sorry, the answer is " + brandString[number]);
                }
            }
        });

        //Plays again
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e){
                number = (int)(Math.random() * 8);
                

                carLabel.setText((carString[number]));


            }
        });
    }

}

