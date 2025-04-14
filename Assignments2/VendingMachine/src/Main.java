import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/* Nigel Garcia
 * April 11 2025
 * Main
 * Main script for the vending machine program, you need to run this script
 * If you want to see my timeline and thoughts on the assignment, scroll down on this file (this is the most I can do to show that im not using chatgpt (also i gues it would be pretty obvious cause my code sucks))
 */

public class Main {
    //Variables that i need to acces from other scripts
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

    File file = null; //both declared outside a function because I dont want to create a new File and bufferedWriter each time
    BufferedWriter bw = null; //These are for the result.txt file, which print out the revenue of each day.
    public static void main(String[] args) throws Exception 
    {
        soda1.name = "Coca cola"; //assigning values to soda instances (until line 61) (may remove the name value cause its useless as of right now) (Edit: nvm its not)
        soda1.price = 1.00;
        soda1.initialQuantity = 20;
        soda1.currentQuantity = soda1.initialQuantity;
        soda1.userBought = 0;

        soda2.name = "Fanta";
        soda2.price = 1.50;
        soda2.initialQuantity = 20;
        soda2.currentQuantity = soda2.initialQuantity;
        soda2.userBought = 0;

        soda3.name = "Crush";
        soda3.price = 1.50;
        soda3.initialQuantity = 20;
        soda3.currentQuantity = soda3.initialQuantity;
        soda3.userBought = 0;

        soda4.name = "Water";
        soda4.price = 1.00;
        soda4.initialQuantity = 20;
        soda4.currentQuantity = soda4.initialQuantity;
        soda4.userBought = 0;

        soda5.name = "Stomach acid";
        soda5.price = 1.00;
        soda5.initialQuantity = 20;
        soda5.currentQuantity = soda5.initialQuantity;
        soda5.userBought = 0;

        frame.ShowFrame(); //calls upon the frame function so that it displays the JFrame to the user

        AnimFrame animFrame = new AnimFrame(); //Frame that plays vending machine animations
        animFrame.showFrame(); 

        frame.setPrices(soda1.price, soda2.price, soda3.price, soda4.price, soda5.price); //displays the prices to the textArea
        frame.setQuantity(soda1.initialQuantity, soda2.initialQuantity, soda3.initialQuantity, soda4.initialQuantity, soda5.initialQuantity); //displays quantity to the txtArea
    }

    //Its funny, originally this was a function that calculated revenue but since I added confirmation purchase this function completely changed
    //anyways, theres a function for each soda, when their respective buttons are clicked, this function is called (depending on button)
    //it adds +1 of x soda to the list and also checks if the user is actually able to get the desired soda or not (quantity check)
    //This is also what makes the quantity txtArea say "empty" when quantity is 0
    public int soda1Clicked()
    {
        if (soda1.currentQuantity > soda1.userBought && soda1.userBought < 20)
        {
            soda1.userBought += 1;
            return soda1.userBought;
        }
        else if (soda1.currentQuantity <= soda1.userBought || soda1.userBought >= 20)
        {
            return 0;
        }
        return 0;
    }
    public int soda2Clicked()
    {
        if (soda2.currentQuantity > soda2.userBought && soda2.userBought < 20)
        {
            soda2.userBought += 1;
            return soda2.userBought;
        }
        else if (soda2.currentQuantity <= soda2.userBought || soda2.userBought >= 20)
        {
            return 0;
        }
        return 0;
    }
    public int soda3Clicked()
    {
        if (soda3.currentQuantity > soda3.userBought && soda3.userBought < 20)
        {
            soda3.userBought += 1;
            return soda3.userBought;
        }
        else if (soda3.currentQuantity <= soda3.userBought || soda3.userBought >= 20)
        {
            return 0;
        }
        return 0;
        
    }
    public int soda4Clicked()
    {
        if (soda4.currentQuantity > soda4.userBought && soda4.userBought < 20)
        {
            soda4.userBought += 1;
            return soda4.userBought;
        }
        else if (soda4.currentQuantity <= soda4.userBought || soda4.userBought >= 20)
        {
            return 0;
        }
        return 0;
    }
    public int soda5Clicked()
    {
        if (soda5.currentQuantity > soda5.userBought && soda5.userBought < 20)
        {
            soda5.userBought += 1;
            return soda5.userBought;
        }
        else if (soda5.currentQuantity <= soda5.userBought || soda5.userBought >= 20)
        {
            return 0;
        }
        return 0;
    }

    //The opposite of the above functions, I added a button where the user could remove a soda from their list
    //checks if it can even be done (Example: cant remove one soda from purchase list if user didnt purchase anything)
    //Instantiates a Popup frame when it cant remove soda
    public void soda1Remove()
    {
        if (soda1.userBought > 0)
        {
            soda1.userBought -= 1;
            Frame.numSoda1.setText("" + soda1.userBought);
        }
        else
        {
            Frame.impossibleRemoveBtn();
        }
    }
    public void soda2Remove()
    {
        if (soda2.userBought > 0)
        {
            soda2.userBought -= 1;
            Frame.numSoda2.setText("" + soda2.userBought);
        }
        else
        {
            Frame.impossibleRemoveBtn();
        }
    }
    public void soda3Remove()
    {
        if (soda3.userBought > 0)
        {
            soda3.userBought -= 1;
            Frame.numSoda3.setText("" + soda3.userBought);
        }
        else
        {
            Frame.impossibleRemoveBtn();
        }
    }
    public void soda4Remove()
    {
        if (soda4.userBought > 0)
        {
            soda4.userBought -= 1;
            Frame.numSoda4.setText("" + soda4.userBought);
        }
        else
        {
            Frame.impossibleRemoveBtn();
        }
    }
    public void soda5Remove()
    {
        if (soda5.userBought > 0)
        {
            soda5.userBought -= 1;
            Frame.numSoda5.setText("" + soda5.userBought);
        }
        else
        {
            Frame.impossibleRemoveBtn();
        }
    }

    //Called upon when the user clicks the confirm button
    //calculates revenue based off of how many drinks user bought
    //then adds up all the revenue 
    public void addRevenue()
    {
        soda1.currentQuantity -= soda1.userBought;
        revenue += soda1.userBought * soda1.price;
        soda1.userBought = 0;
        Frame.numSoda1.setText("" + soda1.userBought);
        Frame.soda1TxtAreaQuantity.setText("" + soda1.currentQuantity);

        soda2.currentQuantity -= soda2.userBought;
        revenue += soda2.userBought * soda2.price;
        soda2.userBought = 0;
        Frame.numSoda2.setText("" + soda2.userBought);
        Frame.soda2TxtAreaQuantity.setText("" + soda2.currentQuantity);

        soda3.currentQuantity -= soda3.userBought;
        revenue += soda3.userBought * soda3.price;
        soda3.userBought = 0;
        Frame.numSoda3.setText("" + soda3.userBought);
        Frame.soda3TxtAreaQuantity.setText("" + soda3.currentQuantity);

        soda4.currentQuantity -= soda4.userBought;
        revenue += soda4.userBought * soda4.price;
        soda4.userBought = 0;
        Frame.numSoda4.setText("" + soda4.userBought);
        Frame.soda4TxtAreaQuantity.setText("" + soda4.currentQuantity);

        soda5.currentQuantity -= soda5.userBought;
        revenue += soda5.userBought * soda5.price;
        soda5.userBought = 0;
        Frame.numSoda5.setText("" + soda5.userBought);
        Frame.soda5TxtAreaQuantity.setText("" + soda5.currentQuantity);
        
        Frame.revTxt.setText("$" + revenue + "0"); //yeah.. I was gonna use the decimalFormatter class but was too lazy (all the prices i set were 1.00 or 1.50 anyway)
    }

    //once the reset button is clicked, this function is called, where it displays the revenue of x day onto a .txt file
    //.txt file is then displayed on the JFrame
    //The revenue for past days are saved on the .txt file, and are overwritten when you relaunch the program.
    public void printResults() throws IOException
    {
        if (!fileMade)
        {
            file = new File("VendingMachine/src/result.txt");
            bw = new BufferedWriter(new FileWriter(file));
            try
            {
                bw.write("Day " + day + ": $" + revenue + "0");
                day++;
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
    //user bought goes to zero, and revenue is reset.
    public void resetQuantities()
    {
        soda1.currentQuantity = soda1.initialQuantity;
        soda2.currentQuantity = soda2.initialQuantity;
        soda3.currentQuantity = soda3.initialQuantity;
        soda4.currentQuantity = soda4.initialQuantity;
        soda5.currentQuantity = soda5.initialQuantity;
        soda1.userBought = 0;
        soda2.userBought = 0;
        soda3.userBought = 0;
        soda4.userBought = 0;
        soda5.userBought = 0;
        
        totalRevenue += revenue;
        Frame.totalRevTxt.setText("$" + totalRevenue + "0"); //yeah.. I was gonna use the decimalFormatter class but was too lazy (all the prices i set were 1.00 or 1.50 anyway)
        revenue = 0.0;
        
        frame.setQuantity(soda1.currentQuantity, soda2.currentQuantity, soda3.currentQuantity, soda4.currentQuantity, soda5.currentQuantity);
        frame.resetUserList(soda1.userBought, soda2.userBought, soda3.userBought, soda4.userBought, soda5.userBought);
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
 *      - gray out picture when quantity is empty (done)
 *      - select button instead of buying drink immediately (and buying custom amount of x drink) (done)
 *      - possibly adding sounds? (NOPE) (maybe next time?)
 *      - Make a second main window with silly animations i made from blender :3 (almost done) (FINALLY DONE)
 *      - replacing a drink with another drink (planning to do) (edit: will most likely NOT do)
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
 * 
 * (Day 2 on 2025-04-12)
 *      - finished 3D model for the vending machine, now to do the animations
 * (3:53pm)
 *      - "Blender rendering the animation? best I can do is 4 hours." While it renders, ill work on some more enhancements.
 *      - Also added the "DrinkSelectFrame.java" script.
 * (5:16pm)
 *      - Animation finally finished rendering, now to do 2 more animation clips
 * 
 *  Time for a break?
 * 
 *  (Day 3)(12:19pm)
 *      - Animation 2 done, and added timer so that the second anim clip can actually play
 * 
 *  (10:35pm)
 *      - Time to clean up my code and remove any unnecesary stuff
 * 
 *  (7:55pm)
 *      - Expanded the frame, you can now finally see a list of what you are about to buy before you buy it!
 * 
 *  (8:10pm)
 *      - Finally got the option pane confirming the reset button working
 * 
 *  (Day 4 (2025-04-14))(8:46am)
 *      - Cleaning up code and adding more comments then im basically done...
 *      - also possibly changeing the layout of the frame a bit
 * 
 * And now, I think everything is done.. (unless the enhancements arent good enough)
 * ------------------------------------------------------------------------------------------------------------------------------------
 * Main Takeaways:
 *      - I absolutely love JFrames
 *      - when it comes to coding math focused programs, I suck at it ??
 *      - I will take every chance I get to throw an animation into my project and you cant stop me (only me can stop me (if future assignment gets more challenging))
 *      - JFrames REALLY ARE similar to Unity c# 
 *      - Setting deadlines for myself actually makes me motivated!? 
 *          (I originally planned to finish this on friday then changed the personal deadline to sunday cause of the animations HAHA)
 *      - I might be on YandereDev levels of bad coding (BAD BAD NO GOOD)
 *      - making timelines are motivating, and makes me feel proud of a project I made (so ill keep doing these)
 * ------------------------------------------------------------------------------------------------------------------------------------
 */