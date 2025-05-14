/* Nigel Garcia
 * May 12 2025
 * MergeSort
 * Sorts an array using the merge sort method
 * This program is unfinished
 */

public class MergeSort {
    public static void main(String[] args) throws Exception {
        int[] num = {5, 16, 7, 8, 25, 46, 67, 88, 79, 110, 121, 12};
        int gap = num.length/2;
        int temp = 0;
        for (int i = gap; i < num.length-1; i++) {
            if (num[i] > num[i+1] && (i+1) < num.length) {
                temp = num[i+1];
                num[i+1] = num[i];
                num[i] = temp;
            }
        }
        for(int i = 0; i < gap; i++) {
            if (num[i] > num[i+1] && (i+1) < gap) {
                temp = num[i+1];
                num[i+1] = num[i];
                num[i] = temp;
            }
        }
        //Array printing result
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
