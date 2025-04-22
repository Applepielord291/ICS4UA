import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * CountVowel
 * counts the number of vowels and outputs vowel count for each vowel
 */

public class CountVowel {
    public static void main(String[] args) throws Exception 
    {
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a phrase and outputs vowel count: ");
        String res = scn.nextLine();
        char[] chars = new char[res.length()];
        chars = res.toCharArray();
        for (int i = 0; i < res.length(); i++)
        {
            if (chars[i] == 'a' || chars[i] == 'A') aCount++;
            else if (chars[i] == 'e' || chars[i] == 'E') eCount++;
            else if (chars[i] == 'i' || chars[i] == 'I') iCount++;
            else if (chars[i] == 'o' || chars[i] == 'O') oCount++;
            else if (chars[i] == 'u' || chars[i] == 'U') uCount++;
        }

        System.out.println("a count: " + aCount);
        System.out.println("e count: " + eCount);
        System.out.println("i count: " + iCount);
        System.out.println("o count: " + oCount);
        System.out.println("u count: " + uCount);
        scn.close();
    }
}
