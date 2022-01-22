package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.UserService;
import HRMS.HRMS.Project.dataAccess.abstracts.UserDao;
import HRMS.HRMS.Project.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager  implements UserService {
    private UserDao userDao;


    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }
}
