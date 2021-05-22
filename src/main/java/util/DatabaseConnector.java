package util;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnector {

    private final MongoClient mongo;
    //private final MongoCredential credential;

    private final MongoDatabase db;

    /**
     * when instantiated, a connection to a
     * mongodb database will be established
     * @param dbName name of the database being connected
     */
    public DatabaseConnector(String dbName) {
        // Creating a Mongo client
        this.mongo = MongoClients.create();

        // Creating Credentials
        //this.credential = MongoCredential.createCredential("sampleUser", dbName, "password".toCharArray());
        // System.out.println("Connected to the database successfully");

        //Accessing the database
        this.db = mongo.getDatabase(dbName);
    }

    public MongoDatabase getDb() {
        return db;
    }
}
