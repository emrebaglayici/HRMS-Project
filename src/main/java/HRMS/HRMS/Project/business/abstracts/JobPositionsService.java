package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.entities.concretes.JobPositions;

import java.util.List;

public interface JobPositionsService {
    DataResult<List<JobPositions>> getAll();
    Result add(JobPositions jobPositions);
    DataResult<List<JobPositions>> findById(int user_id);
}
