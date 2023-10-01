import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Modify these with your database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb";
    private static final String DB_USER = "srikanth";
    private static final String DB_PASSWORD = "Rajini@123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Implement validation logic here
        if (isValidRegistrationData(username, phoneNumber, email, password)) {
            // Insert data into the database
            if (insertUserDataIntoDatabase(username, phoneNumber, email, password)) {
                // Registration success, redirect to success.jsp
                response.sendRedirect("success.jsp");
            } else {
                // Database insert failed, handle the error
                response.sendRedirect("registration.jsp?error=database");
            }
        } else {
            // Invalid registration data, handle the error
            response.sendRedirect("registration.jsp?error=validation");
        }
    }

    private boolean isValidRegistrationData(String username, String phoneNumber, String email, String password) {
        // Implement validation logic here
        // For example, check if fields are not empty and username is unique
        return !username.isEmpty() && !phoneNumber.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }

    private boolean insertUserDataIntoDatabase(String username, String phoneNumber, String email, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (username, phoneNumber, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
