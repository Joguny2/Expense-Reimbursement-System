package daos;

import pojos.AbstractUser;

import java.util.Map;

public interface UserDao {

    Map<String, AbstractUser> getAllUsers();
    AbstractUser getUser(String username);
}
