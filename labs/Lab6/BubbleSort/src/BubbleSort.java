/* Nigel Garcia
 * May 6 2025
 * BubbleSort
 * Sorts an array of values using the bubble sort method
 */

public class BubbleSort {
    public static void main(String[] args) throws Exception 
    {
        int swap = 0;
        int compare = 0;
        int[][] num = {{5, 16, 7, 8}, {25, 46, 67, 88}, {79, 110, 121, 12}};
        System.out.println("This is the element of the array <unsorted>");
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num.length; j++)
            {
                System.out.print(num[i][j] + " ");
            }
        }
        int[][] real = sort(num, swap, compare);
        System.out.println("\nThis is the element of the array <sorted>");
        for (int i = 0; i < real.length; i++)
        {
            for (int j = 0; j < real.length; j++)
            {
                System.out.print(real[i][j] + " ");
            }
        }
    }
    public static int[][] sort(int[][] num, int swap, int compare)
    {
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num.length; j++)
            {
                if (num[i][j] > num[i][j+1] && j+1 < num.length)
                {
                    int temp = num[i][j + 1]; //smaller number
                    num[i][j + 1] = num[i][j];
                    num[i][j] = temp;
                    swap++;
                }
                else
                {
                    compare++;
                }
            }
        }
        System.out.println("\n\nNumber of swaps: " + swap);
        System.out.println("Number of compares: " + compare);
        return num;
    }
}
