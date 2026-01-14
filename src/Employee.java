import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Employee {
    static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter id=");
        int id=scan.nextInt();
        System.out.println("Enter name=");
        String name=scan.next();
        System.out.println("Enter city=");
        String city=scan.next();


        try {
            // 1. Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","snehalpatil21");
            // 3. Create Statement
            PreparedStatement stmt = con.prepareStatement("INSERT INTO employees values(?, ?,?)");
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setString(3,city);
            // 4. Execute Statement
            int count = stmt.executeUpdate();
            // 5. close connection
            con.close();
            System.out.println(count + " : Record inserted into table...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


