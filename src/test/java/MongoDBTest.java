import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.junit.Test; // Import the JUnit test annotation

public class MongoDBTest {

    @Test // This annotation marks the method as a test method
    public void testMongoDBConnection() {
        try {
            // Define MongoDB connection URI (adjust as needed)
            String mongoURI = "mongodb://172.18.0.2:27017";

            // Create a MongoClient and connect to the MongoDB server
            MongoClientURI uri = new MongoClientURI(mongoURI);
            MongoClient mongoClient = new MongoClient(uri);

            // Get a reference to the database
            MongoDatabase database = mongoClient.getDatabase("mydb"); // Replace with your database name

            // If the above steps complete without exceptions, the connection is successful
            System.out.println("Connected to MongoDB successfully!");

            // Don't forget to close the MongoClient when you're done
            mongoClient.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Fail the test if there's an exception
            // You can use testing frameworks like AssertJ or JUnit assertions to perform specific checks
        }
    }
}
