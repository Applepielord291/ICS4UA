
//Nigel Garcia
//February 5 2025
//File that outputs a moving shape

public class StarShape {
    public static String addSpace;
    public static String row1, row2, row3, row4, row5;

    public static void main(String[] args) throws InterruptedException
    {
        loop();
    }
    public static void loop() throws InterruptedException
    {
        row1 = "**********";
        row2 = "**********";
        row3 = "**********";
        row4 = "**********";
        addSpace = "       ";

        for (int x = 0; x < 200; x++)
        {
            //move right
            String ln1 = addSpace + row1;
            row1 = ln1;
            String ln2 = addSpace + row2;
            row2 = ln2;
            String ln3 = addSpace + row3;
            row3 = ln3;
            String ln4 = addSpace + row4;
            row4 = ln4;
            System.out.println(row1 + System.lineSeparator() + row2 + System.lineSeparator() + row3 + System.lineSeparator() + row4);

            //many blank lines so it looks better also looks like its moving (i think)
            System.out.println("         " + System.lineSeparator() + "         " + System.lineSeparator() + "         " + System.lineSeparator() + "         ");
            Thread.sleep(1000);

            //move left
            ln1 = row1.replaceFirst(" ", "");
            row1 = ln1;
            ln2 = row2.replaceFirst(" ", "");
            row2 = ln2;
            ln3 = row3.replaceFirst(" ", "");
            row3 = ln3;
            ln4 = row4.replaceFirst(" ", "");
            row4 = ln4;
            System.out.println(row1 + System.lineSeparator() + row2 + System.lineSeparator() + row3 + System.lineSeparator() + row4);
        }
        Thread.sleep(1000);
        loop(); //so it moves again
    }
}
