import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class DeleteOperation {
    public static void main(String[] args) {
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter id: ");
        int id=Scan.nextInt();
        try {
            // 1. Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","snehalpatil21");
            // 3. Create Statement
            PreparedStatement stmt = con.prepareStatement("Delete from student WHERE id = ?");
            stmt.setInt(1,id);
            // 4. Execute Statement
            int count = stmt.executeUpdate();
            if (count > 0) {
                System.out.println("Deletion Successful");
            }
            else{
                System.out.println("Deletion Unsuccessful");
            }
            // 5. close connection
            con.close();
            System.out.println(count + " : Record DELETED into table...");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
