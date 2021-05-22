package daos;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pojos.ReimbursementRequest;
import util.DatabaseConnector;
import util.RequestStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReimbursementRequestDao {
    private Map<Integer, ReimbursementRequest> dataMap = new HashMap<>();
    private MongoDatabase db;

    public ReimbursementRequestDao() {
        db = new DatabaseConnector("project1").getDb();

        // get a collection
        MongoCollection<Document> employeesColl = db.getCollection("requests");

        // put each document in the collection into the map
        // key: username, value: a generated employee object
        FindIterable<Document> docs = employeesColl.find();
        for (Document doc : docs) {
            dataMap.put( doc.getInteger("ID"), this.createReimbursement(doc));
        }
    }

    public void insertRequest(ReimbursementRequest request) {
        MongoCollection<Document> requestsColl = db.getCollection("requests");
        Document doc = new Document();
        doc.put("ID", request.getId());
        doc.put("type", request.getType());
        doc.put("username", request.getUsername());
        doc.put("amount", request.getAmount());
        doc.put("description", request.getDescription());
        doc.put("status", request.getStatus().toString());
        requestsColl.insertOne(doc);
        dataMap.put(request.getId(), request);
    }

    private ReimbursementRequest createReimbursement(Document doc) {
        ReimbursementRequest r = new ReimbursementRequest();
        r.setId(doc.getInteger("ID"));
        r.setDescription(doc.getString("description"));
        r.setType(doc.getString("type"));
        r.setStatus(RequestStatus.valueOf(doc.getString("status")));
        r.setAmount(doc.getInteger("amount"));
        r.setUsername(doc.getString("username"));
        return r;
    }

    ReimbursementRequest getRequest(int ID) {
        System.out.println(dataMap.get(ID));
        return dataMap.get(ID);
    }

    public List<ReimbursementRequest> query(BasicDBObject searchQuery) {
        List<ReimbursementRequest> list = new ArrayList<>();

        // get a collection
        MongoCollection<Document> requestsColl = db.getCollection("requests");

        // put each request doc into list
        // that belongs to specified user
       /*BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("username", username);*/
        FindIterable<Document> specificDocs = requestsColl.find(searchQuery);

        for (Document doc : specificDocs) {
            // this.accountMap.put( doc.getLong("accNum"), this.createAccount(doc));
            list.add(getRequest(doc.getInteger("ID")));
        }

        return list;
    }
}
