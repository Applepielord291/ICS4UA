import java.io.BufferedWriter;
import java.io.File;
//import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileReader;

/* Nigel Garcia
 * April 11 2025
 * Main
 * Main script for the vending machine program, you need to run this script
 * If you want to see my timeline and thoughts on the assignment, scroll down on this file (this is the most I can do to show that im not using chatgpt (also i gues it would be pretty obvious cause my code sucks))
 */

public class Main {
    int day = 1; //variable to keep track of number of days passed (days increases when the user hits the reset button)
    static double revenue = 0; //keeps track of the revenue per day
    static double totalRevenue = 0; //keeps track of the total revenue across all possible days

    static Soda soda1 = new Soda(); //refer to "Soda.java"
    static Soda soda2 = new Soda(); //also im making multiple instances of soda clas so just so that its easier to create new sodas :)
    static Soda soda3 = new Soda();
    static Soda soda4 = new Soda();
    static Soda soda5 = new Soda();

    static Frame frame = new Frame(); //refer to "Frame.java"
    public static void main(String[] args) throws Exception 
    {
        frame.ShowFrame(); //calls upon the frame function so that it displays the JFrame to the user

        soda1.name = "Coca cola"; //assigning values to soda instances (until line 42) (may remove the name value cause its useless as of right now)
        soda1.price = 1.00;
        soda1.initialQuantity = 20;
        soda1.currentQuantity = soda1.initialQuantity;

        soda2.name = "Fanta";
        soda2.price = 1.50;
        soda2.initialQuantity = 20;
        soda2.currentQuantity = soda2.initialQuantity;

        soda3.name = "Crush";
        soda3.price = 1.50;
        soda3.initialQuantity = 20;
        soda3.currentQuantity = soda3.initialQuantity;

        soda4.name = "Water";
        soda4.price = 1.00;
        soda4.initialQuantity = 20;
        soda4.currentQuantity = soda4.initialQuantity;

        soda5.name = "Stomach acid";
        soda5.price = 1.00;
        soda5.initialQuantity = 20;
        soda5.currentQuantity = soda5.initialQuantity;

        frame.setPrices(soda1.price, soda2.price, soda3.price, soda4.price, soda5.price); //displays the prices to the textArea
        frame.setQuantity(soda1.initialQuantity, soda2.initialQuantity, soda3.initialQuantity, soda4.initialQuantity, soda5.initialQuantity); //displays quantity to the txtArea
    }

    //these functions keep track of revenue, called by the soda buttons (called function depends on button pressed, obviously)
    //each functions add revenue += price, then displays total revenue in the totalTxt area while decreasing quantity count and displaying that too.
    public double soda1Clicked()
    {
        revenue += soda1.price;
        soda1.currentQuantity -= 1;
        frame.soda1TxtAreaQuantity.setText("" + soda1.currentQuantity);
        return revenue;
    }
    public double soda2Clicked()
    {
        revenue += soda2.price;
        soda2.currentQuantity -= 1;
        frame.soda2TxtAreaQuantity.setText("" + soda2.currentQuantity);
        return revenue;
    }
    public double soda3Clicked()
    {
        revenue += soda3.price;
        soda3.currentQuantity -= 1;
        frame.soda3TxtAreaQuantity.setText("" + soda3.currentQuantity);
        return revenue;
    }
    public double soda4Clicked()
    {
        revenue += soda4.price;
        soda4.currentQuantity -= 1;
        frame.soda4TxtAreaQuantity.setText("" + soda4.currentQuantity);
        return revenue;
    }
    public double soda5Clicked()
    {
        revenue += soda5.price;
        soda5.currentQuantity -= 1;
        frame.soda5TxtAreaQuantity.setText("" + soda5.currentQuantity);
        return revenue;
    }

    //once the reset button is clicked, this function is called, where it displays the revenue of x day onto a .txt file
    //revenue is reset, then the .txt file is displayed onto the textArea
    public void printResults() throws IOException
    {
        File file = new File("Assignments2/Assignments2/src/result.txt");
        if (!file.exists())
        {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Assignments2/Assignments2/src/result.txt")))
            {
                bw.write("Day " + day + ": $" + revenue + "0");
                day++;
                revenue = 0;
                bw.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
            {
                bw.write("Day " + day + ": $" + revenue + "0");
                day++;
                bw.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
    }
}

/* ASSIGNMENT 2 TIMELINE
 * Day 1 (2025-04-11): Created all the necessary files (soda container class, JFrame class and main class) 
 *  I already have experience with JFrames cause I was practicing a bunch by implementing JFrames into my lab4 stuff
 *  but DEAR GOD its actually so beautiful how tedious this specific JFrame project is its so bad that it loops back into being so fun (I guess im a masochist?)
 *  I found it quite interesting that the JFrame system is actually VERY similar to Unity's GameObject hierarchy/UI system, so I was able to pick it up quickly.
 *  Anyway by the end of the period (at 12:00pm) I had the visual layout of the frame with info and the soda instance class finished but it has no functionality yet
 *  Im planning on working on it at home ill update it as I go but my plan next is to get the actual basic back-end processes working
 *  Its 2:06pm right now (yes, im doing this in religion class) and I just finished the revenue system, although I should make it more efficient.
 *  (2:29pm): added reset button functionality so it actually keeps track of revenue per day now, as well as a buffered writer to write the revenue produced each day
 *      because of fileio integration, I added another text area on the left side to display the output.txt file
 *      however, the fileIO isnt working well right now its creating a new file each time so gotta fix that
 */