package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.entities.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    /*List<User> getAll();*/
}
