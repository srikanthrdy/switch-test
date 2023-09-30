import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.login.MongoDBManager;

@WebServlet(name = "YourServlet", urlPatterns = {"/login", "/register"})
public class YourServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if ("/register".equals(action)) {
            // Registration logic
            String username = request.getParameter("username");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Validate and insert user data into MongoDB
            if (isValidRegistrationData(username, phoneNumber, email, password)) {
                insertUserDataIntoMongoDB(username, phoneNumber, email, password);
                request.setAttribute("registrationSuccess", true);
        
        // Forward the request to success.jsp
                 request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
        // Handle invalid registration data (e.g., display an error message)
                response.sendRedirect("registration.jsp"); // Redirect back to registration page
            }
            } else if ("/login".equals(action)) {
            // Login logic
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Validate login credentials (check against MongoDB)
            if (isValidLoginCredentials(username, password)) {
                // Set attributes for dashboard.jsp
                request.setAttribute("username", username);

                // Redirect to dashboard.jsp upon successful login
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                // Handle invalid login (e.g., display an error message)
                response.sendRedirect("index.jsp"); // Redirect back to login page
            }
        }
    }

    private boolean isValidRegistrationData(String username, String phoneNumber, String email, String password) {
        // Implement your validation logic here (e.g., check if the username is unique)
        // Return true if data is valid, false otherwise
        return true; // Placeholder, replace with actual validation logic
    }

    private void insertUserDataIntoMongoDB(String username, String phoneNumber, String email, String password) {
        // Connect to MongoDB
        MongoDatabase database = MongoDBManager.getDatabase();

        // Get a collection (e.g., "users") where user data will be stored
        MongoCollection<Document> usersCollection = database.getCollection("users");

        // Create a document to represent the user data
        Document userDocument = new Document("username", username)
                .append("phoneNumber", phoneNumber)
                .append("email", email)
                .append("password", password);

        // Insert the document into the collection
        usersCollection.insertOne(userDocument);
    }

    private boolean isValidLoginCredentials(String username, String password) {
        // Connect to MongoDB
        MongoDatabase database = MongoDBManager.getDatabase();

        // Get the users collection
        MongoCollection<Document> usersCollection = database.getCollection("users");

        // Query MongoDB to check if the username and password match
        Document query = new Document("username", username)
                .append("password", password);

        return usersCollection.countDocuments(query) == 1;
    }
}
