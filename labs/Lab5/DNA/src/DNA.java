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
    public static void genReport(String res, char[] chars)
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
        char[] chars2 = new char[comp.length()];
        chars2 = comp.toCharArray();
        String comp2 = "";
        for (int i = 0; i < comp.length(); i++)
        {
            if (String.valueOf(chars2[i]).toUpperCase().equals("G")) comp2 += 'C';
            else if (String.valueOf(chars2[i]).toUpperCase().equals("C")) comp2 += 'G';
            else if (String.valueOf(chars2[i]).toUpperCase().equals("A")) comp2 += 'T';
            else if (String.valueOf(chars2[i]).toUpperCase().equals("T")) comp2 += 'A';
        }
        comp = comp.replaceAll("G", "C");
        comp = comp.replaceAll("C", "G");
        comp = comp.replaceAll("A", "T");
        comp = comp.replaceAll("T", "A");
        
        char[] chars3 = new char[comp2.length()];
        chars3 = comp2.toCharArray();
        for (int i = chars3.length; i > 0; i--)
        {
            revComp = revComp.concat(String.valueOf(chars3[i - 1]));
        }
        System.out.println("Reverse String: " + revString.toUpperCase());
        System.out.println("String complement: " + comp2.toUpperCase());
        System.out.println("Reverse complement: " + revComp.toUpperCase());
    }
}
