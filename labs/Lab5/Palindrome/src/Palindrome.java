import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * Palindrome
 * chekcs if its palindrome
 */

public class Palindrome {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter a value, checks if its palindrome.");
        String res = scn.nextLine();
        res = res.replaceAll("[1234567890 ,.!]", "");
        char[] chars1 = new char[res.length()];
        chars1 = res.toCharArray();
        String rev = "";
        for (int i = chars1.length; i > 0; i--)
        {
            rev += chars1[i - 1];
        }
        if (rev.toUpperCase().equals(res.toUpperCase()))
        {
            System.out.println("phrase is a palindrome!");
        }
        else
        {
            System.out.println("phrase is not palindrome");
        }
        scn.close();
    }
}
