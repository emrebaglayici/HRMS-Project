package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.concretes.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPositionDao extends JpaRepository<WorkPosition,Integer> {
}
