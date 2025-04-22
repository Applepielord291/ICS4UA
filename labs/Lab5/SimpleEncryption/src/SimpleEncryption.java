import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * SimpleEncryption
 * takes user response and increases encoding value for each char by 2
 */

public class SimpleEncryption {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a response and it will encrypt it");
        String res = scn.nextLine();
        System.out.print("\n");
        for (int i = 0; i < res.length(); i++)
        {
            char ech = (char)(res.charAt(i) + 2);
            System.out.print(ech);
        }
        scn.close();
    }
}
