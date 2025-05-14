/* Nigel Garcia
 * May 12 2025
 * ShellSort
 * sorts a 2d array using the shellsort method
 */

public class ShellSort {
    public static void main(String[] args) throws Exception 
    {
        int[] num = {5, 16, 7, 8, 25, 46, 67, 88, 79, 110, 121, 12};
        System.out.println("This is the element of the array <unsorted>");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        for (int gap = num.length/2; gap > 0; gap /= 2) { //constantly divides the array into groups until it cant anymore
            for (int i = gap; i < num.length; i++) { //starts at the beginning of the group second and ends at the array end
                int temp = num[i];
                int j;
                for (j = i; j >= gap && num[j - gap] > temp; j -= gap) { 
                    //if the number at the start of the first group is larger than the number at the start of the second group, the 2 swap places
                    num[j] = num[j - gap];
                }
                num[j] = temp; //the values go back to their proper ordered position
            }
        }
        //Array printing result
        System.out.println("\nThis is the element of the array <sorted>");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
