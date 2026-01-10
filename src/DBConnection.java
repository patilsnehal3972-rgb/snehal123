//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter
import java.sql.*;
public class DBConnection {
    public static void main(String ar[])
    {
        try
        {
            //Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snehaldb", "root", "snehalpatil21");
            System.out.println("CONNECTION SUCCESSFUL.....");


            con.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}