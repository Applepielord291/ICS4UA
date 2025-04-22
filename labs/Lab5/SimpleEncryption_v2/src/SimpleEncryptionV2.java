import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * SimpleEncryption_v2
 * takes user response and increases encoding value for each char by user requested value
 */

public class SimpleEncryptionV2 {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a response and it will encrypt it");
        String res = scn.nextLine();
        System.out.println("Enter encoding value");
        int eValue = scn.nextInt();
        System.out.print("\n");
        for (int i = 0; i < res.length(); i++)
        {
            char ech = (char)(res.charAt(i) + eValue);
            System.out.print(ech);
        }
        scn.close();
    }
}
