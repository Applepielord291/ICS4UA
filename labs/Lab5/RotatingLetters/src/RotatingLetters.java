import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * RotatingLetters
 * takes user response and checks if the response can be rotated a complete 180
 */

public class RotatingLetters {
    public static void main(String[] args) throws Exception 
    {
        boolean canBeRotated = true;
        Scanner scn = new Scanner(System.in);
        System.out.println("enter a phrase, checks if it can rotate (no more than 30 char): ");
        String res = scn.nextLine();
        char[] chars = new char[res.length()];
        chars = res.toCharArray();
        for (int i = 0; i < res.length(); i++)
        {
            String test = String.valueOf(chars[i]);
            if (test.toUpperCase().matches("[IOSHZXN]")) 
            {
                //nothing right now
            }
            else
            {
                System.out.println("can not be rotated.");
                canBeRotated = false;
                break;
            }
        }
        if (canBeRotated) System.out.println("can be rotated");
        scn.close();
    }
    public static void isRotatable(String res)
    {
        
    }
}
