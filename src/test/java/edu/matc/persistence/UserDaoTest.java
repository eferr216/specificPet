package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class UserDaoTest {

    /**
     * The Dao.
     */
    GenericDao userDao;

    /**
     * Sets up the user table with fresh data, and instantiates the userdao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new GenericDao<>(User.class);
    }

    /**
     * Verifies getById successfully runs.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) userDao.getById(3);
        assertEquals("george", retrievedUser.getUserName());
    }

    /**
     * Insert.
     */
    @Test
    void insertSuccess() {
        User userToInsert = new User("lloyd@gmail.com");
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = (User) userDao.getById(insertedUserId);
        assertEquals("lloyd@gmail.com", insertedUser.getUserName());

    }

    /**
     * Save or update.
     */
    @Test
    void updateSuccess() {
        User userToUpdate = (User) userDao.getById(1);
        userToUpdate.setUserName("newemail@gmail.com");
        userDao.update(userToUpdate);

        User actualUser = (User) userDao.getById(1);
        assertEquals("newemail@gmail.com", actualUser.getUserName());

    }

    /**
     * Delete.
     */
    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(2));
        assertNull(userDao.getById(2));
    }

    /**
     * Gets all.
     */
    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(10, users.size());
    }

    /**
     * Get by specific value.
     */
    @Test
    void getByPropertyEqual() {
        List<User> users = userDao.getByPropertyEqual("userName", "someguy");
        assertEquals(1, users.size());
        assertEquals(7, users.get(0).getId());
    }

    /**
     * Get by value that is is LIKE a specified value.
     */
    @Test
    void getByPropertyLike() {
        List<User> users = userDao.getByPropertyLike("userName", "george");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

}
