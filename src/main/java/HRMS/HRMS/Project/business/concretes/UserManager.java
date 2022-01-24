package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.UserService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.SuccessDataResult;
import HRMS.HRMS.Project.dataAccess.abstracts.UserDao;
import HRMS.HRMS.Project.entities.concretes.User;
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
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List>(
                this.userDao.findAll(),"Data Listed"
        );
    }
}
