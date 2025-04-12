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
    static JFrame frame = new JFrame();
    JTextArea soda1TxtAreaPrice = new JTextArea();
    JTextArea soda1TxtAreaQuantity = new JTextArea();
    static JButton soda1PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/CocaCola.jpg"));

    JTextArea soda2TxtAreaPrice = new JTextArea();
    JTextArea soda2TxtAreaQuantity = new JTextArea();
    static JButton soda2PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/Fanta.jpg"));

    JTextArea soda3TxtAreaPrice = new JTextArea();
    JTextArea soda3TxtAreaQuantity = new JTextArea();
    static JButton soda3PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/Crush.jpg"));

    JTextArea soda4TxtAreaPrice = new JTextArea();
    JTextArea soda4TxtAreaQuantity = new JTextArea();
    static JButton soda4PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/Water.jpg"));

    JTextArea soda5TxtAreaPrice = new JTextArea();
    JTextArea soda5TxtAreaQuantity = new JTextArea();
    static JButton soda5PictureBtn = new JButton(new ImageIcon("Assignments2/Assignments2/src/Images/StomachAcid.jpg"));

    static JTextArea totalTxt = new JTextArea();
    static JTextArea resultTxt = new JTextArea();
    static JTextArea actualTotalTxt = new JTextArea();

    static Main main = new Main();
    public void ShowFrame()
    {
        //defining all the components
        JPanel panel = new JPanel();
        JButton exitBtn = new JButton("Exit");
        JButton resetBtn = new JButton("Reset");
        JLabel drinkLabel = new JLabel("Drinks Left:");
        JLabel drinkLabel2 = new JLabel("Drinks Left:");
        JLabel drinkLabel3 = new JLabel("Drinks Left: ");
        JLabel drinkLabel4 = new JLabel("Drinks Left:");
        JLabel drinkLabel5 = new JLabel("Drinks Left: ");
        JLabel totalLabel = new JLabel("Revenue (1 day):");
        JLabel realTotalLabel = new JLabel("Total Revenue:");
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

        //makes all the textAreas non-editable by users
        soda1TxtAreaPrice.setEditable(false);
        soda1TxtAreaQuantity.setEditable(false);
        soda2TxtAreaPrice.setEditable(false);
        soda2TxtAreaQuantity.setEditable(false);
        soda3TxtAreaPrice.setEditable(false);
        soda3TxtAreaQuantity.setEditable(false);
        soda4TxtAreaPrice.setEditable(false);
        soda4TxtAreaQuantity.setEditable(false);
        soda5TxtAreaPrice.setEditable(false);
        soda5TxtAreaQuantity.setEditable(false);
        totalTxt.setEditable(false);
        resultTxt.setEditable(false);

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
        totalLabel.setBounds(225, 225, 100, 25);
        totalTxt.setBounds(225, 250, 50, 20);
        soda1PictureBtn.setBounds(0, 0, 75, 75);
        soda2PictureBtn.setBounds(0, 100, 75, 75);
        soda3PictureBtn.setBounds(0, 200, 75, 75);
        soda4PictureBtn.setBounds(220, 0, 75, 75);
        soda5PictureBtn.setBounds(220, 100, 75, 75);
        scrollPane.setBounds(420, 25, 150, 250);
        realTotalLabel.setBounds(330, 225, 150, 25);
        actualTotalTxt.setBounds(330, 250, 50, 20);

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
        panel.add(realTotalLabel);
        panel.add(actualTotalTxt);

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
        double[] rev = main.soda1Clicked();
        if (rev != null)
        {
            totalTxt.setText("$" + rev[0] + "0");
            actualTotalTxt.setText("$" + rev[1] + "0");
        }
        else 
        {
            soda1PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/CocaColaEmpty.png"));
            JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
        }
        
    }
    public static void soda2Clicked()
    {
        double[] rev = main.soda2Clicked();
        if (rev != null)
        {
            totalTxt.setText("$" + rev[0] + "0");
            actualTotalTxt.setText("$" + rev[1] + "0");
        }
        else 
        {
            soda2PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/FantaEmpty.png"));
            JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
        }
        
    }
    public static void soda3Clicked()
    {
        double[] rev = main.soda3Clicked();
        if (rev != null)
        {
            totalTxt.setText("$" + rev[0] + "0");
            actualTotalTxt.setText("$" + rev[1] + "0");
        }
        else 
        {
            soda3PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/CrushEmpty.png"));
            JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
        }
        
    }
    public static void soda4Clicked()
    {
        double[] rev = main.soda4Clicked();
        if (rev != null)
        {
            totalTxt.setText("$" + rev[0] + "0");
            actualTotalTxt.setText("$" + rev[1] + "0");
        }
        else 
        {
            soda4PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/WaterEmpty.png"));
            JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
        }
        
    }
    public static void soda5Clicked()
    {
        double[] rev = main.soda5Clicked();
        if (rev != null)
        {
            totalTxt.setText("$" + rev[0] + "0");
            actualTotalTxt.setText("$" + rev[1] + "0");
        }
        else 
        {
            soda5PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/StomachAcidEmpty.png"));
            JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
        }
        
    }
    public static void exitBtnClicked()
    {
        frame.dispose();
    }
    public static void resetBtnClicked() throws IOException
    {
        main.printResults();
        main.resetQuantities();

        soda1PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/CocaCola.jpg"));
        soda2PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/Fanta.jpg"));
        soda3PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/Crush.jpg"));
        soda4PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/Water.jpg"));
        soda5PictureBtn.setIcon(new ImageIcon("Assignments2/Assignments2/src/Images/StomachAcid.jpg"));

        totalTxt.setText("$0.00");
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
