package demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {

    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

            String sql = "UPDATE Student SET Course = ? WHERE Email = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "Physics");          
            ps.setString(2, "john@gmail.com");   

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No matching record found!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
