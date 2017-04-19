package com.seed.Service;

import com.seed.DAO.UserDao;
import com.seed.DAO.UserDaoImpl;
import com.seed.Model.User;
import java.util.List;
import java.util.Iterator;

public class BusinessLogic {

    private List<User> user;

    public BusinessLogic() {
    }

    /**
     * @param username
     * @return person object if logged in successfully, otherwise {@code null}
     */
    public User login(String username) {
        if (username == null || username.isEmpty()) {
            // Could also: throw new IllegalArgumentException();
            return null;
        } else {
            // Should call Dao
            UserDao dao = new UserDaoImpl();
            user = dao.retrieveUsers();

            Iterator<User> iter = user.listIterator();
            while (iter.hasNext()) {
                User currentUser = iter.next();
                if (currentUser.getUserName().equals(username)) {
                    return currentUser;
                }
            }
            return null;
        }
    }
}
