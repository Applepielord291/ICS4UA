public class Main {
    private String real;
    private int number;
    private char no;
    public Main(char c)
    {
        no = c;
        System.out.println(no);
    }
    public String GetSetMain(String r)
    {
        real = r;
        return real;
    }
    public int GetSet(int num)
    {
        number = num;
        return number;
    }
}
