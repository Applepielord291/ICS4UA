import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * TripleX
 * counts num of x in string
 */
public class TripleX {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        String res = scn.nextLine();
        System.out.println(countX(res, 0, 0));
        scn.close();
    }
    public static int countX(String res, int test, int xCount)
    {
        if (test < res.length())
        {
            if (String.valueOf(res.toCharArray()[test]).toUpperCase().equals("X"))
            {
                return countX(res, test+1, xCount+1);
            }
            else
            {
                return countX(res, test+1, xCount);
            }
        }
        else
        {
            return xCount;
        }
    }
}
