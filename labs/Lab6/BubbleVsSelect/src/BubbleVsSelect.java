public class BubbleVsSelect {
    public static void main(String[] args) throws Exception 
    {
        int[] testSize = { 5, 10, 50, 100, 500, 1000 };
        System.out.println(bubbleSort(testSize));
        System.out.println(selectSort(testSize));
    }
    public static String bubbleSort(int[] arrSize)
    {
        int swaps = 0; int compares = 0;
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
                        swaps++;
                    }
                    else
                    {
                        compares++;
                    }
                }
            }
        }
        return "Swaps: " + swaps + " Compares: " + compares;
    }
    public static String selectSort(int[] arrSize)
    {
        int swaps = 0; int compares = 0;
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
            for (int i = 0; i < num.length - 1; i++)
            {
                double min = num[i][0];
                for (int j = i+1; j < num.length; j++)
                {
                    if (num[i][j] < min)
                    {
                        min = num[i][j];
                        j = i;
                        swaps++;
                    }
                }
                for (int k = i; k < num.length + 1; k++)
                {
                    if (num[i][k] == min)
                    {
                        num[i][k] = num[i][i];
                        num[i][i] = min;
                        swaps++;
                        break;
                    }
                }
                compares++;
            }
        }
        return "Swaps: " + swaps + " Compares: " + compares;
    }
}
