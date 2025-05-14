/* Nigel Garcia
 * May 6 2025
 * BubbleSort
 * Sorts an array of values using the bubble sort method
 */

 /* Bubble sort compares the first two elements and swaps when needed.
  * this continues until it reaches the end of the array.
  */

public class BubbleSort {
    public static void main(String[] args) throws Exception 
    {
        int[][] num = {{5, 16, 7, 8}, {25, 46, 67, 88}, {79, 110, 121, 12}};
        System.out.println("This is the element of the array <unsorted>");
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num.length; j++)
            {
                System.out.print(num[i][j] + " ");
            }
        }
        int[][] real = sort(num);
        System.out.println("\nThis is the element of the array <sorted>");
        for (int i = 0; i < real.length; i++)
        {
            for (int j = 0; j < real.length; j++)
            {
                System.out.print(real[i][j] + " ");
            }
        }
    }
    public static int[][] sort(int[][] num)
    {
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num.length; j++)
            {
                if (num[i][j] > num[i][j+1] && j+1 < num.length)
                {
                    int temp = num[i][j + 1]; 
                    num[i][j + 1] = num[i][j];
                    num[i][j] = temp;
                }
            }
        }
        return num;
    }
}
