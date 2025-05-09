/* Nigel Garcia
 * May 6 2025
 * InsertionSort
 * sorts an array of values using the insertion method
 */

public class InsertionSort {
    public static void main(String[] args) throws Exception 
    {
        int[] num = {5, 16, 7, 8, 25, 46, 67, 88, 79, 110, 121, 12};
        System.out.println("This is the element of the array <unsorted>");
        for (int i = 0; i < num.length; i++)
        {
            System.out.print(num[i] + " ");
        }
        System.out.print("\n");
        InsertSort(num);
    }
    public static void InsertSort(int[] num)
    {
        for (int j = 1; j < num.length; j++)
        {
            int i = j - 1; //possibly the problem
            int temp = num[j];
            while (i >= 0)
            {
                if (temp < num[i]);
                {
                    int tempo = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = tempo;
                    i--;
                }
            }
            num[i + 1] = temp;
        }
        System.out.print("\n");
        for (int i = 0; i < num.length; i++)
        {
            System.out.print(num[i] + " ");
        }
    }
}
