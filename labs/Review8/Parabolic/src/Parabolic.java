import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

//Nigel Garcia
//Februaary 18 2025
//moves rocks n stuff (its weird, I found this review way easier than review 6)

public class Parabolic {
    public static void main(String[] args) throws Exception 
    {
        //first: down; second: right
        //Initializing stuff
        char[][] grid = new char[10][10];
        BufferedReader br = new BufferedReader(new FileReader("./labs/Review8/Parabolic/src/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int moveSpaces = 1;
        int totalLoad = 0;

        //prints out initial rock grid
        for (int x = 0; x < grid.length; x++)
        {
            grid[x] = br.readLine().toCharArray();
        }

        //gets the coordinate positions of all rocks and free spaces, and moves the circular rocks up
        for (int x = 0; x < grid.length; x++)
        {
            for (int y = 0; y < grid.length; y++)
            {
                if (grid[x][y] == 'O')
                {
                    //move rocks upward
                    if (x != 0 && grid[x-moveSpaces][y] == '.')
                    {
                        moveRocks(moveSpaces, x, y, grid);
                    }
                }
            }
        }
        //outputs rocks with new positions
        for (int x = 0; x < grid.length; x++)
        {
            System.out.println(grid[x]);
        }
        for (int x = 0; x < grid.length; x++)
        {
            for (int y = 0; y < grid.length; y++)
            {
                if (grid[x][y] == 'O')
                {
                    //oh GOd I apologize for this part of the code (determines rock load)
                    switch (x)
                    {
                        case 0:
                            totalLoad += 10;
                            break;
                        case 1:
                            totalLoad += 9;
                            break;
                        case 2:
                            totalLoad += 8;
                            break;
                        case 3:
                            totalLoad += 7;
                            break;
                        case 4:
                            totalLoad += 6;
                            break;
                        case 5:
                            totalLoad += 5;
                            break;
                        case 6:
                            totalLoad += 4;
                            break;
                        case 7:
                            totalLoad += 3;
                            break;
                        case 8:
                            totalLoad += 2;
                            break;
                        case 9:
                            totalLoad += 1;
                            break;
                        case 10:
                            totalLoad += 0;
                            break;
                    }
                }
            }
        }
        System.out.println("total load is: " + totalLoad);

        br.close();
        scanner.close();
    }

    //Function recursion for moving rocks as far as possible
    public static int moveRocks(int spaces, int xCord, int yCord, char[][] grid) throws Exception
    {
        if (xCord - spaces >= 0 && grid[xCord-spaces][yCord] == '.')
        {
            grid[xCord][yCord] = '.';
            grid[xCord - spaces][yCord] = 'O';
            //System.out.println("xCord: "+ xCord + ", " + "yCord: " + yCord);
            return moveRocks(spaces, xCord-1, yCord, grid);
        }
        return 0;
    }
}
