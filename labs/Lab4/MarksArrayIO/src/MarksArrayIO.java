import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* Nigel Garcia
 * March 24 2025
 * outputs marks, total, average, and letter grade given the mark values and number of marks
 */

public class MarksArrayIO {
    public static void main(String[] args) throws Exception //file creation and variable declaration
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./labs/Lab4/MarksArrayIO/src/output.txt")))
        {
            Scanner scn = new Scanner(System.in);
            System.out.println("How many marks would you like to enter?");
            int res = Integer.parseInt(scn.nextLine());
            int[] markList = marks(res);
            double avg = add(markList);
            String lvl = showLevel(avg);
            dispOutput(avg, lvl, markList, bw);
            System.out.println("please check the results located in labs/Lab4/MarksArrayIO/src/output.txt");
            bw.close();
            scn.close();
        }
        catch (Exception e)
        {
            System.out.println("Cant access file, " + e);
        }
    }
    public static int[] marks(int res) //adds marks to a list
    {
        Scanner scn = new Scanner(System.in);
        int[] markList = new int[res];
        for (int i = 0; i < res; i++)
        {
            System.out.println("Enter mark " + (i + 1));
            int mark = Integer.parseInt(scn.nextLine());
            markList[i] = mark;
        }
        scn.close();
        return markList;
    }
    public static double add(int[] marks) //calculates total and average from mark list
    {
        double total = 0;
        for (int i = 0; i < marks.length; i++)
        {
            total += marks[i];
        }
        return total / marks.length;
    }
    public static String showLevel(double avg) //calculates level grade in the worst way possible
    {
        String result = "";
        if (avg >= 95) result = "You are a level 4+ student";
        else if (87 <= avg && avg <= 94) result = "You are a level 4 student";
        else if (80 <= avg && avg <= 86) result = "You are a level 4- student";
        else if (77 <= avg && avg <= 79) result = "You are a level 3+ student";
        else if (73 <= avg && avg <= 76) result = "You are a level 3 student";
        else if (70 <= avg && avg <= 72) result = "You are a level 3- student";
        else if (67 <= avg && avg <= 69) result = "You are a level 2+ student";
        else if (63 <= avg && avg <= 66) result = "You are a level 2 student";
        else if (60 <= avg && avg <= 62) result = "You are a level 2- student";
        else if (57 <= avg && avg <= 59) result = "You are a level 1+ student";
        else if (53 <= avg && avg <= 56) result = "You are a level 1 student";
        else if (50 <= avg && avg <= 52) result = "You are a level 1- student";
        else if (avg <= 49) result = "You are a failure, R";
        return result;
    }
    public static void dispOutput(double avg, String res, int[] marks, BufferedWriter bw) throws Exception //prints results into the output file
    {
        double total = 0;
        bw.write("These are your marks: ");
        bw.write("\n\n");
        for (int i = 0; i < marks.length; i++)
        {
            bw.write("Your mark " + (i + 1) + " is : " + marks[i]);
            bw.write("\n");
        }
        bw.write("\n");
        for (int i = 0; i < marks.length; i++)
        {
            total += marks[i];
        }
        bw.write("Your total is : " + total);
        bw.write("\n"); bw.write("Your average is : " + avg);
        bw.write("\n"); bw.write(res);
    }
}
