package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.entities.concretes.JobPositions;

import java.util.List;

public interface JobPositionsService {
    List<JobPositions> getAll();
}
