public class BSimulator {
    public static void main(String[] args) throws Exception 
    {
        int swap = 0;
        int compare = 0;
        int[] testSize = { 5, 10, 50, 100, 500, 1000 };
        sort(swap, compare, testSize);
    }
    public static void sort(int swap, int compare, int[] arrSize)
    {
        for (int size : arrSize)
        {
            double num[][] = new double[size + 1][size + 1];
            for (int i = 0; i < num.length - 1; i++)
            {
                for (int j = 0; j < num.length - 1; j++)
                {
                    num[i][j] = Math.round(1 + Math.random() * 10000);
                }
            }
            for (int i = 0; i < num.length -1 ; i++)
            {
                for (int j = 0; j < num.length- 1; j++)
                {
                    if (num[i][j] > num[i][j+1] && j+1 < num.length - 1)
                    {
                        double temp = num[i][j + 1]; //smaller number
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
            System.out.println("Swap: " + swap); System.out.println("Compare: " + compare);
            swap = 0; compare = 0;
        }
    }
}
