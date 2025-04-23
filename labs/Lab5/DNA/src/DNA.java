import java.util.Scanner;

public class DNA {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a DNA stand, the program will output some analysis");
        String res = scn.nextLine();
        char[] chars = new char[res.length()];
        for (int i = 0; i < chars.length; i++)
        {
            if (String.valueOf(chars[i]).toUpperCase().matches("[ACGT]"))
            {
                genReport(res, chars);
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
        //String comp = "";
        //String revComp = "";
        for (int i = 0; i < chars.length; i++)
        {
            revString = revString.concat(String.valueOf(chars[i]));
        }
        System.out.println("Revers eString: " + revString);
    }
}
