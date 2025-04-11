import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

/* Nigel Garcia
 * April 11 2025
 * Frame
 * This is the frame for the vending machine program, deals with all the visuals and button functionality n stuff.
 */

public class Frame {
    //I apologize for the naming scheme...
    //also I made these public since im applying the values from the instantiated soda classes into the textareas.
    JTextArea soda1TxtAreaPrice = new JTextArea();
    JTextArea soda1TxtAreaQuantity = new JTextArea();
    JButton soda1PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/CocaCola.jpg"));

    JTextArea soda2TxtAreaPrice = new JTextArea();
    JTextArea soda2TxtAreaQuantity = new JTextArea();
    JButton soda2PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/Fanta.jpg"));

    JTextArea soda3TxtAreaPrice = new JTextArea();
    JTextArea soda3TxtAreaQuantity = new JTextArea();
    JButton soda3PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/Crush.jpg"));

    JTextArea soda4TxtAreaPrice = new JTextArea();
    JTextArea soda4TxtAreaQuantity = new JTextArea();
    JButton soda4PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/Water.jpg"));

    JTextArea soda5TxtAreaPrice = new JTextArea();
    JTextArea soda5TxtAreaQuantity = new JTextArea();
    JButton soda5PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/StomachAcid.jpg"));

    static JTextArea totalTxt = new JTextArea();
    static JTextArea resultTxt = new JTextArea();

    static Main main = new Main();
    public void ShowFrame()
    {
        //defining all the components
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton exitBtn = new JButton("Exit");
        JButton resetBtn = new JButton("Reset");
        JLabel drinkLabel = new JLabel("Drinks Left:");
        JLabel drinkLabel2 = new JLabel("Drinks Left:");
        JLabel drinkLabel3 = new JLabel("Drinks Left: ");
        JLabel drinkLabel4 = new JLabel("Drinks Left:");
        JLabel drinkLabel5 = new JLabel("Drinks Left: ");
        JLabel totalLabel = new JLabel("Total sales:");
        JScrollPane scrollPane = new JScrollPane(resultTxt);
        
        //frame manager (this basically manages the size and visuals of the frame (no components))
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Vending machine HWATTT");

        //sets the positions of all of the components
        exitBtn.setBounds(300, 325, 150, 25);
        resetBtn.setBounds(100, 325, 150, 25);
        soda1TxtAreaPrice.setBounds(100, 25, 100, 25);
        soda1TxtAreaQuantity.setBounds(100, 75, 100, 25);
        drinkLabel.setBounds(25, 75, 100, 25);
        soda2TxtAreaPrice.setBounds(100, 125, 100, 25);
        soda2TxtAreaQuantity.setBounds(100, 175, 100,25);
        drinkLabel2.setBounds(25, 175, 100, 25);
        soda3TxtAreaPrice.setBounds(100, 225, 100, 25);
        soda3TxtAreaQuantity.setBounds(100, 275, 100, 25);
        drinkLabel3.setBounds(25, 275, 100, 25);
        soda4TxtAreaPrice.setBounds(300, 25, 100, 25);
        soda4TxtAreaQuantity.setBounds(300, 75, 100, 25);
        drinkLabel4.setBounds(225, 75, 100, 25);
        soda5TxtAreaPrice.setBounds(300, 125, 100, 25);
        soda5TxtAreaQuantity.setBounds(300, 175, 100, 25);
        drinkLabel5.setBounds(225, 175, 100, 25);
        totalLabel.setBounds(300, 250, 100, 25);
        totalTxt.setBounds(300, 275, 100, 25);
        soda1PictureBtn.setBounds(0, 0, 75, 75);
        soda2PictureBtn.setBounds(0, 100, 75, 75);
        soda3PictureBtn.setBounds(0, 200, 75, 75);
        soda4PictureBtn.setBounds(220, 0, 75, 75);
        soda5PictureBtn.setBounds(220, 100, 75, 75);
        scrollPane.setBounds(420, 25, 150, 250);

        //button listeners so that the buttons actually have funcctonality
        exitBtn.addActionListener(e -> exitBtnClicked());
        resetBtn.addActionListener(e -> {
            try {
                resetBtnClicked();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        soda1PictureBtn.addActionListener(e -> soda1Clicked());
        soda2PictureBtn.addActionListener(e -> soda2Clicked());
        soda3PictureBtn.addActionListener(e -> soda3Clicked());
        soda4PictureBtn.addActionListener(e -> soda4Clicked());
        soda5PictureBtn.addActionListener(e -> soda5Clicked());

        //this area is pretty much adding all the components onto the frame soa that the user can actually sewe them
        frame.add(panel);
        panel.add(exitBtn);
        panel.add(resetBtn);
        panel.add(soda1TxtAreaPrice);
        panel.add(soda1TxtAreaQuantity);
        panel.add(soda2TxtAreaPrice);
        panel.add(soda2TxtAreaQuantity);
        panel.add(soda3TxtAreaPrice);
        panel.add(soda3TxtAreaQuantity);
        panel.add(soda4TxtAreaPrice);
        panel.add(soda4TxtAreaQuantity);
        panel.add(soda5TxtAreaPrice);
        panel.add(soda5TxtAreaQuantity);
        panel.add(drinkLabel);
        panel.add(drinkLabel2);
        panel.add(drinkLabel3);
        panel.add(drinkLabel4);
        panel.add(drinkLabel5);
        panel.add(totalLabel);
        panel.add(totalTxt);
        panel.add(soda1PictureBtn);
        panel.add(soda2PictureBtn);
        panel.add(soda3PictureBtn);
        panel.add(soda4PictureBtn);
        panel.add(soda5PictureBtn);
        panel.add(scrollPane);

        frame.setVisible(true);
    }
    public void setPrices(double soda1, double soda2, double soda3, double soda4, double soda5)
    {
        soda1TxtAreaPrice.setText("$" + soda1 + "0");
        soda2TxtAreaPrice.setText("$" + soda2 + "0");
        soda3TxtAreaPrice.setText("$" + soda3 + "0");
        soda4TxtAreaPrice.setText("$" + soda4 + "0");
        soda5TxtAreaPrice.setText("$" + soda5 + "0");
    }
    public void setQuantity(int soda1, int soda2, int soda3, int soda4, int soda5)
    {
        soda1TxtAreaQuantity.setText("" + soda1);
        soda2TxtAreaQuantity.setText("" + soda2);
        soda3TxtAreaQuantity.setText("" + soda3);
        soda4TxtAreaQuantity.setText("" + soda4);
        soda5TxtAreaQuantity.setText("" + soda5);
    }


    public static void soda1Clicked()
    {
        double rev = main.soda1Clicked();
        totalTxt.setText("$" + rev + "0");
    }
    public static void soda2Clicked()
    {
        double rev = main.soda2Clicked();
        totalTxt.setText("$" + rev + "0");
    }
    public static void soda3Clicked()
    {
        double rev = main.soda3Clicked();
        totalTxt.setText("$" + rev + "0");
    }
    public static void soda4Clicked()
    {
        double rev = main.soda4Clicked();
        totalTxt.setText("$" + rev + "0");
    }
    public static void soda5Clicked()
    {
        double rev = main.soda5Clicked();
        totalTxt.setText("$" + rev + "0");
    }
    public static void exitBtnClicked()
    {

    }
    public static void resetBtnClicked() throws IOException
    {
        main.printResults();
        try 
        {
            resultTxt.read(new BufferedReader(new FileReader("Assignments2/Assignments2/src/result.txt")), null);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
