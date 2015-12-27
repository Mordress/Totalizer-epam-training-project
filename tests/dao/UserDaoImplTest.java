package dao;

import com.gmail.mordress.lab4.dao.mysql.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.mysql.UserDaoImpl;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.dao.interfaces.UserDao;
import com.gmail.mordress.lab4.entities.User;
public class UserDaoImplTest {

    public static void main(String[] args) {
        try {
            DaoFactory factory = new DaoFactoryImpl();
            UserDaoImpl ud = factory.createDao(UserDao.class);
            System.out.println(ud.read(2));
            System.out.println(ud.findUser("administrator", "4194D1706ED1F408D5E02D672777019F4D5385C766A8C6CA8ACBA3167D36A7B9"));
            System.out.println(ud.checkUniqueLogin("administrato"));
            System.out.println(ud.checkUniqueLogin("administrator"));

            User user = ud.read(2);
            user.setLogin("VasiaPupkin");
            ud.create(user);
            User userA = ud.read(3);
            userA.setLogin("Winter123");

            ud.update(userA);
            ud.delete(3);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
