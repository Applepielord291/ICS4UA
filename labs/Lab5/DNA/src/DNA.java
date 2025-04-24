import java.util.Scanner;

/* Nigel Garcia
 * April 23 2025
 * DNA
 * User inputs DNA string and outputs information
 */

public class DNA {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a DNA stand, the program will output some analysis");
        String res = scn.nextLine();
        
        char[] chars = new char[res.length()];
        chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (String.valueOf(chars[i]).toUpperCase().matches("[ACGT]"))
            {
                genReport(res, chars);
                break;
            }
            else if (!String.valueOf(chars[i]).toUpperCase().matches("[ACGT]"))
            {
                System.out.println("DNA string is not valid.");
                break;
            }
        }
        scn.close();
    }
    public static void genReport(String res, char[] chars) //almost works
    {
        System.out.println("DNA String: " + res.toUpperCase());
        System.out.println("String Length: " + res.length());
        String revString = "";
        String comp = "";
        String revComp = "";
        for (int i = chars.length; i > 0; i--)
        {
            revString = revString.concat(String.valueOf(chars[i - 1]));
        }
        comp = res.toUpperCase();
        comp.replaceAll("G", "C");
        comp.replaceAll("C", "G");
        comp.replaceAll("A", "T");
        comp.replaceAll("T", "A");
        System.out.println("comp: " + comp);
        char[] chars2 = new char[comp.length()];
        chars2 = comp.toCharArray();
        for (int i = chars2.length; i > 0; i--)
        {
            revComp = revComp.concat(String.valueOf(chars2[i - 1]));
        }
        System.out.println("Reverse String: " + revString.toUpperCase());
        System.out.println("String complement: " + comp.toUpperCase());
        System.out.println("Reverse complement: " + revComp.toUpperCase());
    }
}
