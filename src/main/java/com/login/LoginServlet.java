<<<<<<< HEAD
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Modify these with your database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb";
    private static final String DB_USER = "srikanth";
    private static final String DB_PASSWORD = "Rajini@123";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate login credentials against the database
        if (isValidLoginCredentials(username, password)) {
            // Successful login, set session attributes if needed
            request.getSession().setAttribute("username", username);
            // Redirect to the dashboard or another page
            response.sendRedirect("dashboard.jsp");
        } else {
            // Authentication failed, handle the error
            response.sendRedirect("login.jsp?error=authentication");
        }
    }

    private boolean isValidLoginCredentials(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // User exists with the given username and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
=======
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Modify these with your database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb";
    private static final String DB_USER = "srikanth";
    private static final String DB_PASSWORD = "Rajini@123";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate login credentials against the database
        if (isValidLoginCredentials(username, password)) {
            // Successful login, set session attributes if needed
            request.getSession().setAttribute("username", username);
            // Redirect to the dashboard or another page
            response.sendRedirect("dashboard.jsp");
        } else {
            // Authentication failed, handle the error
            response.sendRedirect("login.jsp?error=authentication");
        }
    }

    private boolean isValidLoginCredentials(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // User exists with the given username and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
>>>>>>> 339cc29b2214dab22c18ad17cedd3b6b18ee7622
