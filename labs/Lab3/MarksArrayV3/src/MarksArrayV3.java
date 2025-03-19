import java.util.Scanner;

/* Nigel Garcia
 * March 18 2025
 * MarksArrayV3
 * outputs all the marks inputted by the user, calculates the average and outputs a lettter grade depending on the average
 */

public class MarksArrayV3 {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many marks would you like to enter?");
        int numOfMarks = Integer.parseInt(scn.nextLine());
        int[] marks = new int[numOfMarks];
        Update(marks);
        scn.close();
    }
    public static void Update(int[] marks) //add marks to array
    {
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++)
        {
            System.out.println("please enter a mark: ");
            marks[i] = Integer.parseInt(scn.nextLine());
        }
        output(marks);
        scn.close();
    }
    public static void output(int[] marks) //outputs marks from array
    {
        System.out.println("These are your marks: ");
        for (int i = 0; i < marks.length; i++)
        {
            System.out.print(marks[i] + "% ");
        }
        average(marks);
    }
    public static void average(int[] marks) //calculates average from marks in array
    {
        int total = 0;
        for (int i = 0; i < marks.length; i++)
        {
            total += marks[i];
        }
        int avg = total / marks.length;
        System.out.println("\nYour average is: " + avg + "% ");
        letterGrade(avg);
    }
    public static void letterGrade(int avg) //holy if else statements (letter grades)
    {
        if (avg >= 90) System.out.println("A+");
        else if (85 <= avg && avg <= 89) System.out.println("A");
        else if (80 <= avg && avg <= 84) System.out.println("A-");
        else if (77 <= avg && avg <= 79) System.out.println("B+");
        else if (73 <= avg && avg <= 76) System.out.println("B");
        else if (70 <= avg && avg <= 72) System.out.println("B-");
        else if (67 <= avg && avg <= 69) System.out.println("C+");
        else if (63 <= avg && avg <= 66) System.out.println("C");
        else if (60 <= avg && avg <= 62) System.out.println("C-");
        else if (55 <= avg && avg <= 59) System.out.println("D+");
        else if (50 <= avg && avg <= 54) System.out.println("D");
        else if (avg <= 49) System.out.println("F");
    }
}
