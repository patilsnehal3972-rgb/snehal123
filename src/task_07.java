import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class task_07 {
    public static void main(String[] args){
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter username:");
        String username=Scan.next();
        System.out.println("Enter Password:");
        String password=Scan.next();
        try{
            // 1. Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","snehalpatil21");
            //3.Create Statement
            PreparedStatement stmt=con.prepareStatement("Select *from student where username=? password=?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                System.out.println("Login Successfull");
            }
            else{
                System.out.println("Invalid user");
            }
            rs.close();
            stmt.close();
            con.close();
            Scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



