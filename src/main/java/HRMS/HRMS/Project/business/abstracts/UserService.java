package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.core.SuccessDataResult;
import HRMS.HRMS.Project.entities.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(User user);
    /*List<User> getAll();*/
}
