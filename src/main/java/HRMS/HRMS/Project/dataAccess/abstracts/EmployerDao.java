package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    List<Employer> getById(int employer_id);
}
