import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * xToY
 * converts all x to y in a string
 * this is unfinished
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
        if (test < res.length())
        {
            if (String.valueOf(res.toCharArray()[test]).toUpperCase().equals("X"))
            {
                return convertX(res, test++);
            }
            else
            {
                return convertX(res, test+1);
            }
        }
        else
        {
            return res;
        }
    }
}
