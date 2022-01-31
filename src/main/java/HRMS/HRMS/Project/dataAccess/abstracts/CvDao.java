package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao extends JpaRepository<Cv,Integer> {
    List<Cv> getAllByEmployeeId(int employee_id);
}
