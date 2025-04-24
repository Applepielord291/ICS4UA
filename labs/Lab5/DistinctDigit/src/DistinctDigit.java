import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * DistinctDigit
 * takes user input value and chekcs if each value is unique
 */

public class DistinctDigit {
    public static void main(String[] args) throws Exception 
    {
        boolean distinct = true;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a value to check if its a distinct digit <No more than 10,000> ");
        int res = scn.nextInt();
        if (res <= 10000)
        {
            String res2 = String.valueOf(res);
            char[] chars = new char[res2.length()];
            chars = res2.toCharArray();
            for (int i = 0; i < res2.length(); i++)
            {
                for (int j = 0; j < res2.length(); j++)
                {
                    if (String.valueOf(chars[i]).matches(String.valueOf(chars[j])) && i != j)
                    {
                        distinct = false;
                    }
                }
            }
            if (distinct) System.out.println("Phrase is distinct");
            else if (!distinct) System.out.println("Phrase is not distinct");
        }
        else
        {
            System.out.println("Value must be less than 10000");;
        }
        scn.close();
    }
}
