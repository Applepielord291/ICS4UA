import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * check6
 * checks if an array contains a 6
 */

public class check6 {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Array length: ");
        int length = scn.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Enter num: ");
            int res = scn.nextInt();
            arr[i] = res;
        }
        System.out.println(check(arr, 0));
        scn.close();
    }
    public static boolean check(int[] arr, int test)
    {
        if (arr[test] == 6 && (test+1) < arr.length)
        {
            return true;
        }
        else if (arr[test] != 6 && (test+1) < arr.length)
        {
            return check(arr, test+1);
        }
        else
        {
            return false;
        }
    }
}
