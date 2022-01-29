package HRMS.HRMS.Project.dataAccess.abstracts;
import HRMS.HRMS.Project.entities.concretes.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {
}
