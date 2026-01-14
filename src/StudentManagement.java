import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class StudentManagement {
public static Connection con=null;
public static Connection establishConnection()
    {
        String url = "jdbc:mysql://localhost:3306/company";
        String dbUser = "root";
        String dbPass = "snehalpatil21";
        try{
            //Register Deriver
            Class.forName(url);
            // create connection
            con=DriverManager


    }
}
