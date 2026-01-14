import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class loginSystem {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String dbUser = "root";
        String dbPass = "snehalpatil21";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username: ");
            String username = sc.next();
            System.out.println("Enter password: ");
            String password = sc.next();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
            }
            else {
                System.out.println("Invalid Credential");
            }
            rs.close();
            stmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}