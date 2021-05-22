package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import pojos.AbstractUser;
import pojos.Employee;
import util.DatabaseConnector;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDao implements UserDao{


    private Map<String, AbstractUser> employeeMap = new HashMap<>();
    private MongoDatabase db;

    public EmployeeDao() {
        db = new DatabaseConnector("project1").getDb();

        // get a collection
        MongoCollection<Document> employeesColl = db.getCollection("employees");

        // put each document in the collection into the map
        // key: username, value: a generated employee object
        FindIterable<Document> docs = employeesColl.find();
        for (Document doc : docs) {
            employeeMap.put( doc.getString("username"), this.createEmployee(doc));
        }
    }

    private Employee createEmployee(Document doc) {
        Employee e = new Employee();
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
        return employeeMap;
    }

    @Override
    public AbstractUser getUser(String username) {
       return employeeMap.get(username);
    }

    public void updateUser(Employee user) {
        MongoCollection<Document> usersColl = db.getCollection("employees");
        usersColl.updateOne(Filters.eq("username", user.getUsername()),
                Updates.set("email", user.getEmail()));
        usersColl.updateOne(Filters.eq("username", user.getUsername()),
                Updates.set("phonenumber", user.getPhonenumber()));
        usersColl.updateOne(Filters.eq("username", user.getUsername()),
                Updates.set("username", user.getUsername()));
        this.employeeMap.replace(user.getUsername(), user);
        setEmployeeMap(this.employeeMap);
    }

    public void setEmployeeMap(Map<String, AbstractUser> employeeMap) {
        this.employeeMap = employeeMap;
    }

}
