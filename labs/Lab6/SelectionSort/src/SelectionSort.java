/* Nigel Garcia
 * May 6 2025
 * Selection sort
 * sorts an array of values using the selection sort method
 */

public class SelectionSort {
    public static void main(String[] args) throws Exception 
    {
        int[] num = {5, 16, 7, 8, 25, 46, 67, 88, 79, 110, 121, 12};
        System.out.println("This is the element of the array <unsorted>");
        for (int i = 0; i < num.length; i++)
        {
            System.out.print(num[i] + " ");
        }
        System.out.print("\n");
        selectSort(num);
    }
    public static void selectSort(int[] num)
    {
        for (int i = 0; i < num.length - 1; i++)
        {
            int min = num[i];
            for (int j = i+1; j < num.length; j++)
            {
                if (num[j] < min)
                {
                    min = num[j];
                    j = i;
                }
            }
            for (int k = i; k < num.length + 1; k++)
            {
                if (num[k] == min)
                {
                    num[k] = num[i];
                    num[i] = min;
                    break;
                }
            }
        }
        System.out.print("This is the element of the array <sorted>\n");
        for (int i = 0; i < num.length; i++)
        {
            System.out.print(num[i] + " ");
        }
    }
}
