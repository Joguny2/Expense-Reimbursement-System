package services;

import com.mongodb.BasicDBObject;
import daos.EmployeeDao;
import daos.ManagerDao;
import daos.ReimbursementRequestDao;
import pojos.AbstractUser;
import pojos.Manager;
import util.Logger;
import util.RequestStatus;

import java.util.ArrayList;
import java.util.List;

public class ManagerService implements LoginService, Logger {

    private ManagerDao dao = new ManagerDao();
    private ReimbursementRequestDao rDao = new ReimbursementRequestDao();
    private EmployeeDao eDao = new EmployeeDao();

    /**
     * returns the Manager
     * searched by its username
     *
     * @param username
     * @return
     */
    public Manager getUser(String username) {
        return (Manager) dao.getUser(username);
    }

    public List<AbstractUser> getAllEmployees() {
        List<AbstractUser> list = new ArrayList<>(eDao.getAllUsers().values());
        return list;
    }

    public List getAllPendingRequests() {
        //return rDao.getAllPendingRequests();
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("status", RequestStatus.PENDING.toString());
        logData("succesfully retrieved all pending requests");
        return rDao.query((searchQuery));
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
