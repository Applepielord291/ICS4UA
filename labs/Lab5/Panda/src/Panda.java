import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * Panda
 * outputs panda ears given panda number
 */
public class Panda {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        int res = scn.nextInt();
        System.out.println(pandaEars(res, 0, 0));
        scn.close();
    }
    public static int pandaEars(int pandaNumber, int test, int ear)
    {
        if (test < pandaNumber)
        {
            return pandaEars(pandaNumber, test+1, ear+2);
        }
        else
        {
            return ear;
        }
    }
}
