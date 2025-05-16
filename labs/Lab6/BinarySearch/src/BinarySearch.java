import java.util.Scanner;

/* Nigel Garcia
 * May 15 2025
 * Binary Search
 * searches for a number using binary search (The array is sorted using the quick sort method)
 * was not aware, the array must be sorted first to work
 */

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number you want to search for: "); //init
        int res = scn.nextInt();
        int index = 0;
        int[][] num = new int[5000][5000];
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num[i].length; j++)
            {
                num[i][j] = (int)Math.round(1 + Math.random() * 10000);
            }
        }

        int[] realNums = new int[num.length * num[0].length]; //conversion
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num[i].length; j++)
            {
                realNums[index] = num[i][j];
                index++;
            }
        }
        scn.close();

        realNums = Quick(realNums, 0, realNums.length - 1); //results
        int found = binarySearch(realNums, 0, 0, realNums.length - 1, res);
        if (found != 0) System.out.println("Number " + found + " found.");
        else System.out.println("Number " + res + " not found.");
    }
    public static int[] Quick(int[] num, int lowLim, int highLim) //quicksort
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
        return num;
    }
    public static int binarySearch(int[] num, int first, int mid, int last, int res) //binary search
    {
        /*for (int i = 0; i < num.length; i++) //rows 
        {
            int last = num[i].length - 1;       !!KEEPING THE 2D ARRAY BINARY SEARCH VERSION JUST IN CASE!!
            while (first <= last) //cols
            {
                System.out.println(mid);
                if (num[i][mid] == res) //found
                {
                    return num[i][mid];
                }
                else if (num[i][mid] > res) last = mid-1; //eliminate right half
                else if (num[i][mid] < res) first = mid+1; //eliminate left half
                mid = first + (last - first)/2;
            }
            first = 0; mid = 0;
        }*/
        while (first <= last) //cols
        {
            if (num[mid] == res) //found
            {
                return num[mid];
            }
            else if (num[mid] > res) last = mid-1; //eliminate right half
            else if (num[mid] < res) first = mid+1; //eliminate left half
            mid = first + (last - first)/2;
        }
        return 0;
    }
}
