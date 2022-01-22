package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
