import java.util.Scanner;

/* Nigel Garcia 
 * April 1 2025
 * Array2D
 * creates 2D array of numbers
*/

public class Array2D {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many rows?:");
        int rows = scn.nextInt();
        System.out.println("How many columns?:");
        int columns = scn.nextInt();
        int[][] numbers = new int[columns][rows];

        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                System.out.println("Enter a number for column " + (i+1) + " row " + (j+1));
                numbers[i][j] = scn.nextInt();
            }
        }
        sum(numbers, columns, rows);
        scn.close();
    }
    public static void sum(int[][] numbers, int columns, int rows)
    {
        int total = 0;
        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                total += numbers[i][j];
            }
        }
        System.out.println(total);
    }
}
