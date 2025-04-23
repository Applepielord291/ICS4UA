import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * DistinctDigit
 * takes user input value and chekcs if each value is unique
 */

public class DistinctDigit {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a value to check if its a distinct digit");
        int res = scn.nextInt();
        String res2 = String.valueOf(res);
        char[] chars = new char[res2.length()];
        chars = res2.toCharArray();
        for (int i = 0; i < res2.length(); i++)
        {
            for (int j = 0; j < res2.length(); j++)
            {
                if (String.valueOf(chars[i]).matches(String.valueOf(chars[j])))
                {
                    System.out.println("repeat");
                    break;
                }
                else if (!String.valueOf(chars[i]).matches(String.valueOf(chars[j])) && i != j)
                {
                    System.out.println("non");
                    System.out.println(i); System.out.println(j);
                    break;
                }
            }
        }
        scn.close();
    }
}
