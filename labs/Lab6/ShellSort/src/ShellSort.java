/* Nigel Garcia
 * May 12 2025
 * ShellSort
 * sorts a 2d array using the shellsort method
 */

public class ShellSort {
    public static void main(String[] args) throws Exception 
    {
        int temp = 0; 
        int[] gaps = {2, 1, 0}; 
        int[][] num = {{5, 16, 7, 8}, {25, 46, 67, 88}, {79, 110, 121, 12}};
        for (int gap : gaps) {
            for (int i = gap; i < gaps.length; i++) { //starts at x element in gap array, runs 4 - gap times
                System.out.println("runs i" + i);
                temp = num[i][0];
                for (int j = i; j >= gap && num[gap][0] > temp; j -= gap) { //if j is within the gap
                    System.out.println("runs j" + j);
                    num[i][j] = num[i][j - gap]; 
                    //num[i][j] = temp;
                }
            }
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[i][j] + " ");
            }
        }
    }
}
