import java.util.Scanner;

/* NIgel Garcia
 * April 22 2025
 * PigLatin
 * checks if itss pig latin
 */

public class Piglatin {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a phrase, it will be converted to pig latin.");
        String res = scn.nextLine();
        char[] chars = new char[res.length()];
        chars = res.toCharArray();
        if (String.valueOf(chars[0]).toUpperCase().matches("[AEIOU]"))
        {
            res = res.concat("way");
        }
        else if (!String.valueOf(chars[0]).toUpperCase().matches("[AEIOU]"))
        {
            String t = res.substring(0, 1);
            res = res.substring(1, res.length());
            res = res.concat(t + "ay");
        }
        System.out.println(res);
        scn.close();
    }
}
