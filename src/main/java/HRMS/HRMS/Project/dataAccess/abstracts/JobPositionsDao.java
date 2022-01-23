package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.entities.concretes.JobPositions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPositionsDao extends JpaRepository<JobPositions,Integer> {
}
