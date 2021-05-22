package services;

import com.mongodb.BasicDBObject;
import daos.EmployeeDao;
import daos.ReimbursementRequestDao;
import pojos.Employee;
import pojos.ReimbursementRequest;
import util.Logger;

import java.util.List;

public class EmployeeService implements LoginService, Logger {

    private EmployeeDao dao = new EmployeeDao();
    private ReimbursementRequestDao rDao = new ReimbursementRequestDao();


    /**
     * returns the employee
     * searched by its username
     *
     * @param username
     * @return
     */
    public Employee getUser(String username) {
        return (Employee) dao.getUser(username);
    }

    /**
     * takes info to update and a user to
     * update it for
     * @param username
     * @param email
     */
    public void updateEmailForUser(String username, String email) {
        Employee toUpdate = (Employee) dao.getUser(username);
        toUpdate.setEmail(email);
        dao.updateUser(toUpdate);
        logData("succesfully updated email");
    }

    /**
     * takes info to update and a user to
     * update it for
     * @param username
     * @param phonenumber
     */
    public void updatePhonenumberForUser(String username, String phonenumber) {
        Employee toUpdate = (Employee) dao.getUser(username);
        toUpdate.setPhonenumber(phonenumber);
        dao.updateUser(toUpdate);
        logData("succesfully updated phonenumber");
    }

    public void submitReimbursement(ReimbursementRequest request) {
        request.generateID();
        rDao.insertRequest(request);
        logData("succefully submitted request");
    }

    public List<ReimbursementRequest> getReimbursementsForUser(String username) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("username", username);
        logData("succesfully retrieved requests");
          return rDao.query(searchQuery);
    }

    @Override
    public boolean validate(String username, String password) {
        if (!dao.getAllUsers().containsKey(username))
            return false;
        if (!dao.getUser(username).getPassword().equals(password))
            return false;
        logData("succesfully logged in");
        return true;
    }

    @Override
    public void logData(String data) {
        rootLogger.info(data);
    }
}
