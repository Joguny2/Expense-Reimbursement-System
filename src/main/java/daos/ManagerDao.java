package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pojos.AbstractUser;
import pojos.Manager;
import util.DatabaseConnector;

import java.util.HashMap;
import java.util.Map;

public class ManagerDao implements UserDao {

    private Map<String, AbstractUser> managerMap = new HashMap<>();
    private MongoDatabase db;

    public ManagerDao() {
        db = new DatabaseConnector("project1").getDb();

        // get a collection
        MongoCollection<Document> managersColl = db.getCollection("managers");

        // put each document in the collection into the map
        // key: username, value: a generated manager object
        FindIterable<Document> docs = managersColl.find();
        for (Document doc : docs) {
            managerMap.put( doc.getString("username"), this.createManager(doc));
        }
    }

    private Manager createManager(Document doc) {
        Manager e = new Manager();
        e.setUsername(doc.getString("username"));
        e.setPassword(doc.getString("password"));
        e.setFirstname(doc.getString("firstname"));
        e.setLastname(doc.getString("lastname"));
        e.setEmail(doc.getString("email"));
        e.setPhonenumber(doc.getString("phonenumber"));
        //  e.setAddress(doc.getString("address"));

        return e;
    }

    @Override
    public Map<String, AbstractUser> getAllUsers() {
        return managerMap;
    }

    @Override
    public AbstractUser getUser(String username) {
        return managerMap.get(username);
    }
}
