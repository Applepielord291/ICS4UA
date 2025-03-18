import java.util.Scanner;

/* Nigel Garcia
 * March 18 2025
 * MarksArray
 * outputs all the marks that the user inputs
 */

public class MarksArray {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many marks would you like to enter?");
        int numOfMarks = Integer.parseInt(scn.nextLine());
        int[] marks = new int[numOfMarks];
        Update(marks);
        scn.close();
    }
    public static void Update(int[] marks)
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
    public static void output(int[] marks)
    {
        System.out.println("These are your marks: ");
        for (int i = 0; i < marks.length; i++)
        {
            System.out.print(marks[i] + "% ");
        }
    }
}
