package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    @Query("select (count(e) > 0) from Employee e where e.nationality_number = ?1")
    boolean existsByNationality_number(String nationalityId);
}
