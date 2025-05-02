import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * xToY
 * converts all x to y in a string
 */

public class xToy {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        String res = scn.nextLine();
        System.out.println(convertX(res, 0));
        scn.close();
    }
    public static String convertX(String res, int test)
    {
        char[] x = new char[res.length()];
        x = res.toCharArray();
        String newS = "";
        if (test < res.length())
        {
            if (String.valueOf(res.charAt(test)).toUpperCase().equals("X"))
            {
                x[test] = 'Y';
                for (int i = 0; i < x.length; i++)
                {
                    newS += x[i];
                }
                return convertX(newS, test+1);
            }
            return convertX(res, test+1);
        }
        else
        {
            for (int i = 0; i < x.length; i++)
            {
                newS += x[i];
            }
            return newS.toLowerCase();
        }
    }
}
