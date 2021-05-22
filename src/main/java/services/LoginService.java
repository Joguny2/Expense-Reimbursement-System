package services;

public interface LoginService {
    /**
     * Takes a username and password to validate
     * returns true if the username and password
     * combo is in the db.
     * otherwise returns false
     * @param username
     * @param password
     * @return
     */
    boolean validate(String username, String password);
}
