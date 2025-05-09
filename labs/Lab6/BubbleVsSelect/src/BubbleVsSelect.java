public class BubbleVsSelect {
    public static void main(String[] args) throws Exception 
    {
        int[] testSize = { 5, 10, 50, 100, 500, 1000 };
        System.out.print("\n");
        selectSort(testSize);
    }
    public static void selectSort(int[] test)
    {
        for (int k = 0; k < test.length; k++)
        {
            int[] num = new int[test[k]];
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
                for (int t = i; t < num.length + 1; t++)
                {
                    if (num[t] == min)
                    {
                        num[t] = num[i];
                        num[i] = min;
                        break;
                    }
                }
            }
        }
        System.out.println("done");
    }
}
