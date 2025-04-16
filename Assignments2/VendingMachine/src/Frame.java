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
    //also I made these public since im applying the values from the instantiated soda classes into the textareas. (and to access them from other scripts)
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    JTextArea soda1TxtAreaPrice = new JTextArea();
    static JTextArea soda1TxtAreaQuantity = new JTextArea();
    static JButton soda1PictureBtn = new JButton(new ImageIcon("VendingMachine/src/Images/CocaCola.jpg"));

    JTextArea soda2TxtAreaPrice = new JTextArea();
    static JTextArea soda2TxtAreaQuantity = new JTextArea();
    static JButton soda2PictureBtn = new JButton(new ImageIcon("VendingMachine/src/Images/Fanta.jpg"));

    JTextArea soda3TxtAreaPrice = new JTextArea();
    static JTextArea soda3TxtAreaQuantity = new JTextArea();
    static JButton soda3PictureBtn = new JButton(new ImageIcon("VendingMachine/src/Images/Crush.jpg"));

    JTextArea soda4TxtAreaPrice = new JTextArea();
    static JTextArea soda4TxtAreaQuantity = new JTextArea();
    static JButton soda4PictureBtn = new JButton(new ImageIcon("VendingMachine/src/Images/Water.jpg"));

    JTextArea soda5TxtAreaPrice = new JTextArea();
    static JTextArea soda5TxtAreaQuantity = new JTextArea();
    static JButton soda5PictureBtn = new JButton(new ImageIcon("VendingMachine/src/Images/StomachAcid.jpg"));

    static JTextArea revTxt = new JTextArea();
    static JTextArea resultTxt = new JTextArea();
    static JTextArea totalRevTxt = new JTextArea();

    static JScrollPane scrollPaneResult = new JScrollPane(resultTxt);

    static JTextArea numSoda1 = new JTextArea();
    static JTextArea numSoda2 = new JTextArea();
    static JTextArea numSoda3 = new JTextArea();
    static JTextArea numSoda4 = new JTextArea();
    static JTextArea numSoda5 = new JTextArea();

    static JLabel revLabel = new JLabel("Revenue (1 day):");
    static JLabel revTotalLabel = new JLabel("Total Revenue:");

    static Main main = new Main();
    static AnimFrame anim = new AnimFrame();
    static boolean loggedIn = false;
    public void ShowFrame()
    {
        //defining all the components
        
        JButton exitBtn = new JButton("Exit");
        JButton resetBtn = new JButton("Reset");
        JLabel drinkLabel = new JLabel("Drinks Left:");
        JLabel drinkLabel2 = new JLabel("Drinks Left:");
        JLabel drinkLabel3 = new JLabel("Drinks Left: ");
        JLabel drinkLabel4 = new JLabel("Drinks Left:");
        JLabel drinkLabel5 = new JLabel("Drinks Left: ");
        
        
        JLabel buyTitleLbl = new JLabel("You are about to buy:");
        JLabel soda1Label = new JLabel(Main.soda1.name);
        JLabel soda2Label = new JLabel(Main.soda2.name);
        JLabel soda3Label = new JLabel(Main.soda3.name);
        JLabel soda4Label = new JLabel(Main.soda4.name);
        JLabel soda5Label = new JLabel(Main.soda5.name);
        JButton soda1RemoveBtn = new JButton("-1");
        JButton soda2RemoveBtn = new JButton("-1");
        JButton soda3RemoveBtn = new JButton("-1");
        JButton soda4RemoveBtn = new JButton("-1");
        JButton soda5RemoveBtn = new JButton("-1");
        JButton confirmBuyBtn = new JButton("Confirm");
        JMenuBar barMenu = new JMenuBar();
        JButton loginBtn = new JButton("login");
        
        //frame manager (this basically manages the size and visuals and layouts of the frame)
        frame.setResizable(false);
        frame.setSize(800, 425);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(800, 425);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Silly Vending Machine!?");
        frame.setIconImage(new ImageIcon("VendingMachine/src/Images/ProgramIcon.png").getImage());

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
        revTxt.setEditable(false);
        resultTxt.setEditable(false);
        numSoda1.setEditable(false);
        numSoda2.setEditable(false);
        numSoda3.setEditable(false);
        numSoda4.setEditable(false);
        numSoda5.setEditable(false);

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
        revLabel.setBounds(225, 225, 100, 25);
        revTxt.setBounds(225, 250, 50, 20);
        soda1PictureBtn.setBounds(15, 0, 75, 75);
        soda2PictureBtn.setBounds(15, 100, 75, 75);
        soda3PictureBtn.setBounds(15, 200, 75, 75);
        soda4PictureBtn.setBounds(220, 0, 75, 75);
        soda5PictureBtn.setBounds(220, 100, 75, 75);
        scrollPaneResult.setBounds(420, 25, 150, 250);
        revTotalLabel.setBounds(330, 225, 150, 25);
        totalRevTxt.setBounds(330, 250, 50, 20);
        buyTitleLbl.setBounds(620, 25, 175, 25);
        soda1Label.setBounds(620, 50, 175, 25);
        numSoda1.setBounds (620, 75, 50, 25);
        soda2Label.setBounds(620, 100, 175, 25);
        numSoda2.setBounds(620, 125, 50, 25);
        soda3Label.setBounds(620, 150, 175, 25);
        numSoda3.setBounds(620, 175, 50, 25);
        soda4Label.setBounds(620, 200, 175, 25);
        numSoda4.setBounds(620, 225, 50, 25);
        soda5Label.setBounds(620, 250, 175, 25);
        numSoda5.setBounds(620, 275, 50, 25);
        confirmBuyBtn.setBounds(620, 325, 150, 25);
        soda1RemoveBtn.setBounds(700, 75, 50, 25);
        soda2RemoveBtn.setBounds(700, 125, 50, 25);
        soda3RemoveBtn.setBounds(700, 175, 50, 25);
        soda4RemoveBtn.setBounds(700, 225, 50, 25);
        soda5RemoveBtn.setBounds(700, 275, 50, 25);


        //button listeners so that the buttons actually have funcctonality
        exitBtn.addActionListener(e -> exitBtnClicked());
        resetBtn.addActionListener(e -> {
            try {
                resetBtnClicked();
            } catch (IOException e1) {
                errorOccured(e1);
            }
        });
        soda1PictureBtn.addActionListener(e -> soda1Clicked());
        soda2PictureBtn.addActionListener(e -> soda2Clicked());
        soda3PictureBtn.addActionListener(e -> soda3Clicked());
        soda4PictureBtn.addActionListener(e -> soda4Clicked());
        soda5PictureBtn.addActionListener(e -> soda5Clicked());

        soda1RemoveBtn.addActionListener(e -> main.soda1Remove());
        soda2RemoveBtn.addActionListener(e -> main.soda2Remove());
        soda3RemoveBtn.addActionListener(e -> main.soda3Remove());
        soda4RemoveBtn.addActionListener(e -> main.soda4Remove());
        soda5RemoveBtn.addActionListener(e -> main.soda5Remove());
        confirmBuyBtn.addActionListener(e -> confirmedPurchase());
        loginBtn.addActionListener(e -> {
            try {
                clickedLogin();
            } catch (IOException e1) {
                errorOccured(e1);
            }
        });

        //this area is pretty much adding all the components onto the frame soda that the user can actually see them
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
        panel.add(soda1PictureBtn);
        panel.add(soda2PictureBtn);
        panel.add(soda3PictureBtn);
        panel.add(soda4PictureBtn);
        panel.add(soda5PictureBtn);
        panel.add(buyTitleLbl);
        panel.add(soda1Label);
        panel.add(soda2Label);
        panel.add(soda3Label);
        panel.add(soda4Label);
        panel.add(soda5Label);
        panel.add(numSoda1);
        panel.add(numSoda2);
        panel.add(numSoda3);
        panel.add(numSoda4);
        panel.add(numSoda5);
        panel.add(confirmBuyBtn);
        panel.add(soda1RemoveBtn);
        panel.add(soda2RemoveBtn);
        panel.add(soda3RemoveBtn);
        panel.add(soda4RemoveBtn);
        panel.add(soda5RemoveBtn);
        frame.setJMenuBar(barMenu);
        barMenu.add(loginBtn);

        frame.setVisible(true); //sets the frame visible so that the user can actually see the window.

        //sets textArea values so that the textAreas arent blank on program startup
        Frame.numSoda1.setText("0");
        Frame.numSoda2.setText("0");
        Frame.numSoda3.setText("0");
        Frame.numSoda4.setText("0");
        Frame.numSoda5.setText("0");
        revTxt.setText("$0.00");
        totalRevTxt.setText("$0.00");
    }
    //This function is called upon on program startup, it displays hte prices of each soda to the user (so that the user actually knows the cost)
    public void setPrices(double soda1, double soda2, double soda3, double soda4, double soda5)
    {
        soda1TxtAreaPrice.setText("$" + soda1 + "0");
        soda2TxtAreaPrice.setText("$" + soda2 + "0");
        soda3TxtAreaPrice.setText("$" + soda3 + "0");
        soda4TxtAreaPrice.setText("$" + soda4 + "0");
        soda5TxtAreaPrice.setText("$" + soda5 + "0");
    }
    //same idea as the setPrices function, its called on startup and lets the user know the initial quantity.
    public void setQuantity(int soda1, int soda2, int soda3, int soda4, int soda5)
    {
        soda1TxtAreaQuantity.setText("" + soda1);
        soda2TxtAreaQuantity.setText("" + soda2);
        soda3TxtAreaQuantity.setText("" + soda3);
        soda4TxtAreaQuantity.setText("" + soda4);
        soda5TxtAreaQuantity.setText("" + soda5);
    }
    //When the user clicks the confirm button, it resets the userBought values then calls this function
    //the userBought values are the parameters and it changes the txtAreas back to 0
    public void resetUserList(int soda1, int soda2, int soda3, int soda4, int soda5)
    {
        numSoda1.setText("" + soda1);
        numSoda2.setText("" + soda2);
        numSoda3.setText("" + soda3);
        numSoda4.setText("" + soda4);
        numSoda5.setText("" + soda5);
    }

    //The next many functions deal with drink purchasing (clicking on the drink image)
    //essentially, when a button is clicked, it is added +1 for the selected soda.
    //bought value to check if the user can actually get a soda or not (quantity)
    //with the system I made it so that bought returns 0 if the quantity is empty.
    //if 0, a popup window saying that the selected product is empty appears and the image goes gray. (if the quantity is 0)
    //if user tries to get more soda then quantity amount, popup will say the user is buying too much, and will stop the user.
    public static void soda1Clicked() 
    {
        int bought = main.soda1Clicked();
        if (bought != 0)
        {
            numSoda1.setText("" + bought);
        }
        else 
        {
            if (Main.soda1.userBought >= Main.soda1.currentQuantity && Main.soda1.userBought != 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("Woah, Way too much, read the Quantity!"));
            }
            else if (Main.soda1.currentQuantity <= 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
            }
        }
    }
    public static void soda2Clicked() 
    {
        int bought = main.soda2Clicked();
        if (bought != 0)
        {
            numSoda2.setText("" + bought);
        }
        else 
        {
            if (Main.soda2.userBought >= Main.soda2.currentQuantity && Main.soda2.userBought != 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("Woah, Way too much, read the Quantity!"));
            }
            else if (Main.soda2.currentQuantity <= 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));   
            }
        }
    }
    public static void soda3Clicked() 
    {
        int bought = main.soda3Clicked();
        if (bought != 0)
        {
            numSoda3.setText("" + bought);
        }
        else 
        {
            if (Main.soda3.userBought >= Main.soda3.currentQuantity && Main.soda3.userBought != 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("Woah, Way too much, read the Quantity!"));
            }
            else if (Main.soda3.currentQuantity <= 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
            }
            
        }
    }
    public static void soda4Clicked() 
    {
        int bought = main.soda4Clicked();
        if (bought != 0)
        {
            numSoda4.setText("" + bought);
        }
        else 
        {
            if (Main.soda4.userBought >= Main.soda4.currentQuantity && Main.soda4.userBought != 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("Woah, Way too much, read the Quantity!"));
            }
            else if (Main.soda4.currentQuantity <= 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
            }
        }
    }
    public static void soda5Clicked() 
    {
        int bought = main.soda5Clicked();
        if (bought != 0)
        {
            numSoda5.setText("" + bought);
        }
        else 
        {
            if (Main.soda5.userBought >= Main.soda5.currentQuantity && Main.soda5.userBought != 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("Woah, Way too much, read the Quantity!"));
            }
            else if (Main.soda5.userBought >= Main.soda5.currentQuantity && Main.soda5.userBought != 0)
            {
                JOptionPane.showMessageDialog(null, new JLabel("The item you want does not exist!"));
            }
        }
    }

    //This function is called when the user tries to remove a soda from their list but they have no soda. Cant have negative soda
    public static void impossibleRemoveBtn()
    {
        JOptionPane.showMessageDialog(null, new JLabel("You havent even though of buying it yet!??"));
    }

    //When the user clicks confirm, it called upon the anim frame to play the "Bought" clip
    //additionaly, it adds totalRevenue += revenue (inside main function)
    //additionaly, changes the drink current quantity value (soda#.currentQuantity - soda#.userBought)
    //checks if its less then 0, if it is, sets quantity text to empty and makes image grey.
    public static void confirmedPurchase()
    {
        if ((Main.soda1.userBought + Main.soda2.userBought + Main.soda3.userBought + Main.soda4.userBought + Main.soda5.userBought) != 0)
        {   
            AnimFrame.playClip();
            main.addRevenue();
            if (Main.soda1.currentQuantity <= 0)
            {
                soda1PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/CocaColaEmpty.png"));
                soda1TxtAreaQuantity.setText("EMPTY");
            }
            if (Main.soda2.currentQuantity <= 0)
            {
                soda2PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/FantaEmpty.png"));
                soda2TxtAreaQuantity.setText("EMPTY");
            }
            if (Main.soda3.currentQuantity <= 0)
            {
                soda3PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/CrushEmpty.png"));
                soda3TxtAreaQuantity.setText("EMPTY");
            }
            if (Main.soda4.currentQuantity <= 0)
            {
                soda4PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/WaterEmpty.png"));
                soda4TxtAreaQuantity.setText("EMPTY");
            }
            if (Main.soda5.currentQuantity <= 0)
            {
                soda5PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/StomachAcidEmpty.png"));
                soda5TxtAreaQuantity.setText("EMPTY");
            }
        }
        
    }

    //Simple, closes the program when the exit button is closed.
    public static void exitBtnClicked()
    {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "WARNING", JOptionPane.YES_NO_OPTION);
        {
            if (result == JOptionPane.YES_OPTION)
            {
                AnimFrame.frame.dispose();
                frame.dispose();
            }
        }
        
    }

    //when user clicked login, popup window appears asking for password
    //password located in .txt file
    //takes user input and checks if its equal to the string in the .txt file
    //if true, adds the revenue information
    //else, tells the user password is wrong and gives an option to try again
    //if user is already logged in, program lets user know that they are already logged in
    public static void clickedLogin() throws IOException
    {
        if (!loggedIn)
        {
            var result = JOptionPane.showInputDialog(null, "Please enter a password.");
            try (BufferedReader br = new BufferedReader(new FileReader("VendingMachine\\src\\password")))
            {
                if (result.equals(br.readLine()))
                {
                    panel.add(scrollPaneResult);
                    panel.add(revTotalLabel);
                    panel.add(totalRevTxt);
                    panel.add(revLabel);
                    panel.add(revTxt);
                    frame.setVisible(false);
                    frame.setVisible(true);
                    loggedIn = true;
                }
                else
                {
                    int ans = JOptionPane.showConfirmDialog(null, "Wrong password, want to try again?", "WARNING", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) clickedLogin();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, new JLabel("You are already logged in!"));
        }
    }

    //function called when the user clicks the reset btn
    //pop-up window displaying if the user wnats to reset and move on to the next day
    //if the user clicks yes, the reset button resets the almost all the values (except for totalRevenue, result.txt, the fileIO vars, soda prices....)
    //textArea then reads result.txt (with the newly written value and day) and displays it onto the frame
    public static void resetBtnClicked() throws IOException
    {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to rest and move on to the next day? dont forget to confirm your purchase!", "WARNING", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION)
        {
            main.printResults();
            main.resetQuantities();

            soda1PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/CocaCola.jpg"));
            soda2PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/Fanta.jpg"));
            soda3PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/Crush.jpg"));
            soda4PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/Water.jpg"));
            soda5PictureBtn.setIcon(new ImageIcon("VendingMachine/src/Images/StomachAcid.jpg"));

            revTxt.setText("$0.00");
            try 
            {
                resultTxt.read(new BufferedReader(new FileReader("VendingMachine/src/result.txt")), null);
            }
            catch (IOException e)
            {
                errorOccured(e);
            }
        }
    }

    //error frame when error happens
    public static void errorOccured(Exception e)
    {
        JOptionPane.showMessageDialog(null, new JLabel("An error has occured: " + e));
    }
}