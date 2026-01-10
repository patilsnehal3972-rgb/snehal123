import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class displayAllStudents{

public static void main(String[] args){
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    try {
        // Step 1: Establish Connection
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company",
                "root",
                "snehalpatil21"
        );

        // Step 2: Create PreparedStatement

        pstmt = con.prepareStatement("SELECT * FROM student");

        // Step 3: Execute Query
        rs = pstmt.executeQuery();

        // Step 5: Print Headline
        System.out.println("ID\tNAME\tAGE");
        System.out.println("...................");

        // Step 4: Iterate ResultSet
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);

            System.out.println(id + "\t" + name + "\t" + age);
        }

    }
    // Step 6: Handle All Exceptions
    catch (Exception e) {
        System.out.println("Error occurred: " + e);
    }


}
}

