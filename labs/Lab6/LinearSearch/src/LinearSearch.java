import java.util.Scanner;

/* Nigel Garcia
 * May 15 2025
 * Linear search
 * searches for a number using the linear search method 
 */

public class LinearSearch {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] num = {{5, 16, 7, 8}, {25, 46, 67, 88}, {79, 110, 121, 12}};
        int pos = 1;
        System.out.println("Enter the number you want to search for");
        int res = scn.nextInt();
        for (int i = 0; i < num.length; i++) 
        {
            for (int j = 0; j < num.length + 1; j++) 
            {
                pos++;
                if (num[i][j] == res) 
                {
                    System.out.println("Number found " + res + " at location " + (pos-1));
                    break;
                }
            }
        }
        scn.close();
    }
}
