package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.dataAccess.abstracts.UserDao;
import HRMS.HRMS.Project.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.HRMS.Project.business.abstracts.UserService;


@Service
public class UserManager  implements UserService {
    //Normalde dataAccess in içindeki UserDao yu implement ediyordu değiştirdim.
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        return null;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return null;
    }


   /* @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }*/


}
