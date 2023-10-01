import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test; // Import the JUnit test annotation

public class MySQLTest {

    @Test // This annotation marks the method as a test method
    public void testMySQLConnection() {
        Connection connection = null;
        try {
            // Define database connection parameters (adjust as needed)
            String dbUrl = "jdbc:mysql://localhost:3306/yourdb"; // Replace with your MySQL database URL
            String dbUser = "root"; // Replace with your MySQL username
            String dbPassword = "Rajini@123"; // Replace with your MySQL password

            // Establish a connection to the database
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // If the above steps complete without exceptions, the connection is successful
            System.out.println("Connected to MySQL successfully!");

            // Don't forget to close the connection when you're done
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Fail the test if there's an exception
            // You can use testing frameworks like AssertJ or JUnit assertions to perform specific checks
        }
    }
}
