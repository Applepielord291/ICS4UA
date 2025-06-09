import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

/* Nigel Garcia
 * June 3 2025
 * test
 * This is a database test. the database used can be found in the path.
 */

 /* Some important things to do:
  * - look into how to write and understand sql commands
  */
public class test {
    private final static String dbUrl = "jdbc:ucanaccess://C:\\Users\\pixel\\OneDrive\\Documents\\ICS4UA\\Unit4\\Students.accdb"; 
    public static void AddRow() {
        try (Connection connection = DriverManager.getConnection(dbUrl)) 
        {
            //A connection references databases.
            //it provides database information that allows this script to execute results within the context of the db.
            //A driver manager manages allows the software to interact with the database using jdbc (Java database connectivity)
            //jdbc is a java api that helps applications to communicate with databases
            //ucanaccess is a type of driver that helps with connecting to microsoft access databases

            //statements are needed to actually be able to access the information of the database
            //The statement must be created to execute a SQL query on the opened database.
            Statement s = connection.createStatement();

            //Creates a new row where for each column value adds the value into a row
            String addRow = "INSERT INTO tblStudents (FirstName, LastName, UserName, Password) VALUES ('g', 'wha', 'user2', '4')";
            s.execute(addRow);

            //s.execute are used for those SELECT.. UPDATE.. DELETE.. all thsoe commands. Put it into a Statement.execute().
            String selTable = "SELECT * FROM tblStudents";
            s.execute(selTable);

            //ResultSet contains the result of the information gathered from the command in "s.execute()"
            //Statement.getResultSet() returns the information as a ResultSet object type.
            ResultSet rs = s.getResultSet();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/input.txt")))
            {
                while((rs!=null) && (rs.next()))
                {
                    for (int i = 1; i < 7; i++)
                    {
                        bw.write(rs.getString(i) + " | ");
                    }
                    bw.write("\n");
                }
                bw.close();
                frame.finished();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            //These 2 require closing
            s.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void DeleteRow()
    {
        try (Connection connection = DriverManager.getConnection(dbUrl)) 
        {
            Statement s = connection.createStatement();
            String deleteRow = "DELETE * FROM tblStudents"; //not working properly look into how to write these commands
            s.execute(deleteRow);
            String selTable = "SELECT * FROM tblStudents";
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/input.txt")))
            {
                while((rs!=null) && (rs.next()))
                {
                    for (int i = 1; i < 7; i++)
                    {
                        bw.write(rs.getString(i) + " | ");
                    }
                    bw.write("\n");
                }
                bw.close();
                frame.finished();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            s.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

//notes for self
//install ucanaccess
//go to control panel
//place jar files in lib folder
//under java projects - referenced libraries, add all the jar files
//then, it works~
