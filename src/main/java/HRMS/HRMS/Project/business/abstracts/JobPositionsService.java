package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.JobPositions;

import java.util.List;

public interface JobPositionsService {
    Result addJobPositions(JobPositions jobPositions);
    DataResult<List<JobPositions>> getAll();
}
