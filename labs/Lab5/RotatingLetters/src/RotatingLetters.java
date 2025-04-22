import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * RotatingLetters
 * takes user response and checks if the response can be rotated a complete 180
 */

public class RotatingLetters {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter a phrase, checks if it can rotate (no more than 30 char): ");
        String res = scn.nextLine();
        if (res.length() <= 30)
        {
            isRotatable(res);
        }
        else
        {
            System.out.println("Invalid");
        }
        scn.close();
    }
    public static void isRotatable(String res)
    {
        if (res.toUpperCase().contains("IOSHZXN"))
        {
            System.out.println("yar");
        }
    }
}
