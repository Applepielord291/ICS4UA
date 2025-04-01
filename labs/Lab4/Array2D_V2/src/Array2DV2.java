import java.util.Scanner;

/* Nigel Garcia
 * April 1 2025
 * Array2D v2
 * Creates 2D array of anything
 */

public class Array2DV2 {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many rows?:");
        int rows = scn.nextInt();
        System.out.println("How many columns?:");
        int columns = scn.nextInt();
        String[][] res = new String[columns][rows];

        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                System.out.println("Enter a number for column " + (i+1) + " row " + (j+1));
                res[i][j] = scn.nextLine();
            }
        }
        display(res, columns, rows);
        scn.close();
    }
    public static void display(String[][] res, int columns, int rows)
    {
        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
