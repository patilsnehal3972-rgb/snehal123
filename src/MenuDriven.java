//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class MenuDriven {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String dbUser = "root";
        String dbPass = "snehalpatil21";
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    PreparedStatement ps = con.prepareStatement("Insert into students values(?, ?, ?,?,?)");
                    System.out.print(" id ");
                    ps.setInt(1, sc.nextInt());
                    System.out.print(" name: ");
                    ps.setString(2, sc.next());
                    System.out.print("Age: ");
                    ps.setInt(3, sc.nextInt());
                    System.out.println("Marks");
                    ps.setInt(4, sc.nextInt());
                    System.out.println("course");
                    ps.setString(5, sc.next());
                    ps.executeUpdate();
                    System.out.println("Inserted");
                    break;
                case 2:
                    PreparedStatement cs = con.prepareStatement("update students_table set Age = ? where id = ?");
                    System.out.print("New Age: ");
                    cs.setInt(1, sc.nextInt());
                    System.out.print("Student ID: ");
                    cs.setInt(2, sc.nextInt());
                    cs.executeUpdate();
                    System.out.println(" Updated");
                    break;
                case 3:
                    PreparedStatement gs = con.prepareStatement("delete from students_table where id = ?");
                    System.out.print("id");
                    gs.setInt(1, sc.nextInt());
                    gs.executeUpdate();
                    System.out.println(" Delete");
                    break;
                case 4:
                    PreparedStatement bs=con.prepareStatement("select *from Students");
                    rs=bs.executeQuery();
                default:
                    System.out.println(" Choice");
            }

            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
