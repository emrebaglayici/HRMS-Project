package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.entities.User;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
