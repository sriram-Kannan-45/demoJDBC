package demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrievingDemo {

    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

            String sql = "SELECT * FROM Student";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int c = 0;

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String course = rs.getString("Course");
                String email = rs.getString("Email");

                String output = "Student #%d: %d %s - %s - %s";
                System.out.println(String.format(output, ++c, id, name, course, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
