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
    boolean fileMade = false; //bool value that checks if file is made

    static Soda soda1 = new Soda(); //refer to "Soda.java"
    static Soda soda2 = new Soda(); //also im making multiple instances of soda clas so just so that its easier to create new sodas :)
    static Soda soda3 = new Soda();
    static Soda soda4 = new Soda();
    static Soda soda5 = new Soda();

    static Frame frame = new Frame(); //refer to "Frame.java"

    File file = null;
    BufferedWriter bw = null;
    public static void main(String[] args) throws Exception 
    {
        frame.ShowFrame(); //calls upon the frame function so that it displays the JFrame to the user

        AnimFrame animFrame = new AnimFrame();
        animFrame.showFrame(); //WIP might not even use but its a new window that plays vending machine

        soda1.name = "Coca cola"; //assigning values to soda instances (until line 58) (may remove the name value cause its useless as of right now)
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
    //Additionaly, it checks if the quantity is greater than 0 or not. if its not, the quantity textArea says "EMPTY"
    public double[] soda1Clicked()
    {
        if (soda1.currentQuantity > 0)
        {
            double[] revenues = new double[2];
            revenue += soda1.price;
            totalRevenue += soda1.price;
            revenues[0] = revenue;
            revenues[1] = totalRevenue;
            soda1.currentQuantity -= 1;
            frame.soda1TxtAreaQuantity.setText("" + soda1.currentQuantity);
            return revenues;
        }
        else 
        {
            frame.soda1TxtAreaQuantity.setText("EMPTY");
            return null;
        }
        
    }
    public double[] soda2Clicked()
    {
        if (soda2.currentQuantity > 0)
        {
            double[] revenues = new double[2];
            revenue += soda2.price;
            totalRevenue += soda2.price;
            revenues[0] = revenue;
            revenues[1] = totalRevenue;
            soda2.currentQuantity -= 1;
            frame.soda2TxtAreaQuantity.setText("" + soda2.currentQuantity);
            return revenues;
        }
        else 
        {
            frame.soda2TxtAreaQuantity.setText("EMPTY");
            return null;
        }
        
    }
    public double[] soda3Clicked()
    {
        if (soda3.currentQuantity > 0)
        {
            double[] revenues = new double[2];
            revenue += soda3.price;
            totalRevenue += soda3.price;
            revenues[0] = revenue;
            revenues[1] = totalRevenue;
            soda3.currentQuantity -= 1;
            frame.soda3TxtAreaQuantity.setText("" + soda3.currentQuantity);
            return revenues;
        }
        else 
        {
            frame.soda3TxtAreaQuantity.setText("EMPTY");
            return null;
        }
        
    }
    public double[] soda4Clicked()
    {
        if (soda4.currentQuantity > 0)
        {
            double[] revenues = new double[2];
            revenue += soda4.price;
            totalRevenue += soda4.price;
            revenues[0] = revenue;
            revenues[1] = totalRevenue;
            soda4.currentQuantity -= 1;
            frame.soda4TxtAreaQuantity.setText("" + soda4.currentQuantity);
            return revenues;
        }
        else 
        {
            frame.soda4TxtAreaQuantity.setText("EMPTY");
            return null;
        }
        
    }
    public double[] soda5Clicked()
    {
        if (soda5.currentQuantity > 0)
        {
            double[] revenues = new double[2];
            revenue += soda5.price;
            totalRevenue += soda5.price;
            revenues[0] = revenue;
            revenues[1] = totalRevenue;
            soda5.currentQuantity -= 1;
            frame.soda5TxtAreaQuantity.setText("" + soda5.currentQuantity);
            return revenues;
        }
        else 
        {
            frame.soda5TxtAreaQuantity.setText("EMPTY");
            return null;
        }
    }

    //once the reset button is clicked, this function is called, where it displays the revenue of x day onto a .txt file
    //revenue is reset, then the .txt file is displayed onto the textArea
    //The revenue for past days are saved on the .txt file, and are overwritten when you relaunch the program.
    public void printResults() throws IOException
    {
        if (!fileMade)
        {
            file = new File("Assignments2/Assignments2/src/result.txt");
            bw = new BufferedWriter(new FileWriter(file));
            try
            {
                bw.write("Day " + day + ": $" + revenue + "0");
                day++;
                revenue = 0;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                bw.close();
                fileMade = true;
            }
        }
        else
        {
            FileWriter fw = new FileWriter(file, true);
            try
            {
                fw.write("\n");
                fw.write("Day " + day + ": $" + revenue + "0");
                day++;
                revenue = 0;
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                fw.close();
            }
        }
    }
    //when the user presses the reset button, this function is called, where it restocks all of the drinks (back up to its initial value, which is 20)
    public void resetQuantities()
    {
        soda1.currentQuantity = soda1.initialQuantity;
        soda2.currentQuantity = soda2.initialQuantity;
        soda3.currentQuantity = soda3.initialQuantity;
        soda4.currentQuantity = soda4.initialQuantity;
        soda5.currentQuantity = soda5.initialQuantity;
        frame.setQuantity(soda1.currentQuantity, soda2.currentQuantity, soda3.currentQuantity, soda4.currentQuantity, soda5.currentQuantity);
    }
}

/* ASSIGNMENT 2 TIMELINE
 * Day 1 (2025-04-11): Created all the necessary files (soda container class, JFrame class and main class) 
    *  I already have experience with JFrames cause I was practicing a bunch by implementing JFrames into my lab4 stuff
    *  but DEAR GOD its actually so beautiful how tedious this specific JFrame project is its so bad that it loops back into being so fun (I guess im a masochist?)
    *  I found it quite interesting that the JFrame system is actually VERY similar to Unity's GameObject hierarchy/UI system, so I was able to pick it up quickly.
    *  Anyway by the end of the period (at 12:00pm) I had the visual layout of the frame with info and the soda instance class finished but it has no functionality yet
    *  Im planning on working on it at home ill update it as I go but my plan next is to get the actual basic back-end processes working
 *  Its 2:06pm right now (yes, im doing this in religion class)
 *      just finished the revenue system, pretty straightforward but quite inefficient.. (nah ill fix optimization later)
 *  (2:29pm): added reset button functionality so it actually keeps track of revenue per day now, as well as a buffered writer to write the revenue produced each day
 *      because of fileio integration, I added another text area on the left side to display the output.txt file
 *      however, the fileIO isnt working well right now its overwriting the old text with new each time so gotta fix that
 *  (4:26pm) Finally fixed the problem, haha I love coding and being stuck on simple problems.. anyways, 
 *      All the past revenues for each day are now saved onto a .txt file, the txt file being displayed on a textArea on the right side of the window.
 *      also made the textAreas non-editable, so now you cant change the text directly >:)
 *  (5:32pm) Fixed item quantity issue, now you cant get items if theyre out of stock (a pop up window will appear)
 *      also added two new UI elements that displays current revenue for x day, and the total revenue across all days
 *  (5:40pm) Quantity now resets when the user hits the restart button
 *      also, the exit button actually works now!
 * 
 * --------------------------------------------------------------------------------------------------------
 *  (5:45pm 2025-04-11) FINISHED ASSIGNMENT (BASE INSTRUCTIONS), BUT OH BOY ITS NOT OVER IM ADDING ENHANCEMENTS 
 * 
 *  Enhancement ideas
 *      - gray out picture when quantity is empty
 *      - select button instead of buying drink immediately (and buying custom amount of x drink)
 *      - possibly adding sounds?
 *      - Make a second main window with silly animations i made from blender :3
 * 
 *  Ill take a break for a bit today...
 * --------------------------------------------------------------------------------------------------------
 * 
 * ENCHANCEMENT TIMELINE
 * (Late at night, the prime time for writing miserable code...)
 * (10:36pm on 2025-04-11) 
 *      - picture is now grayed out when the user depletes the quantity of a can
 *      - picture is reveerted back to normal once the user resets
 *      - if you were wondering, I found an online photoshop website called PhotoPea and took the image file for each and made them black and white
 * 
 * (11:28pm on 2025-04-11)
 *      - been doing some research on adding mp4's to JFrames, and now I just HAVE TO add a video into this project
 *      - so.... I made a new JFrame!! refer to the "AnimFrame.java" script!
 */