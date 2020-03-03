import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import springbook.user.dao.DUserDao;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;


public class TestUserDao {
    public User user = new User();

    @Before
    public void setUp() {
        user.setId("1000");
        user.setName("bbubbush");
        user.setPassword("bbubbush");
    }

    @Test
    public void addUser() {
        UserDao dao = new DUserDao();
        try {
            dao.add(this.user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }

    @After
    public void clean() throws SQLException, ClassNotFoundException {
        UserDao dao = new DUserDao();

        dao.delete(user.getId());

        Assert.assertNotNull(dao.get(user.getId()));
    }
}
