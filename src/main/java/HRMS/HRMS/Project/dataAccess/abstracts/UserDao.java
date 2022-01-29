package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
}
