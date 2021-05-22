package pojos;

import util.RequestStatus;

import java.util.Random;

public class ReimbursementRequest {

    private int amount;
    private String type;
    private String description;
    private RequestStatus status;
    private int id;
    private String username;

    public ReimbursementRequest() {
        status = RequestStatus.PENDING;
    }

    public void generateID() {
        Random rand = new Random();
        this.id = (int)(rand.nextDouble()*1000000);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
