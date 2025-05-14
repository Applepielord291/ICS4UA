/* Nigel Garcia
 * May 6 2025
 * QuickSort
 * Sorts an array of values using the quick sort method
 */

public class QuickSort {
    public static void main(String[] args) throws Exception 
    {
        int[] num = {5, 16, 7, 8, 25, 46, 67, 88, 79, 110, 121, 12};
        System.out.println("This is the element of the array <unsorted>");
        for (int i = 0; i < num.length; i++)
        {
            System.out.print(num[i] + " ");
        }
        System.out.print("\n");
        Quick(num, 0, num.length - 1);
    }
    public static void Quick(int[] num, int lowLim, int highLim)
    {
        int i = lowLim; int j = highLim; int h;
        int x = num[(lowLim + highLim) / 2];
        do
        {
            while (num[i] < x) i++;
            while (num[j] > x) j--;
            if (i <= j)
            {
                h = num[i]; 
                num[i] = num[j]; 
                num[j] = h;
                i++; j--;
            }
        } while (i <= j);

        if (lowLim < j) Quick(num, lowLim, j);
        if (i < highLim) Quick(num, i, highLim);
        System.out.print("This is the element of the array <sorted>\n");
        for (int k = 0; k < num.length; k++)
        {
            System.out.print(num[k] + " ");
        }
    }
}
