package com.login;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerAddress;
import java.util.Arrays;



public class MongoDBManager {
    private static final String DATABASE_NAME = "mydb"; // Change to your desired database name

    public static MongoClient connect() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                .build();

        return MongoClients.create(settings);
    }

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = connect();
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
