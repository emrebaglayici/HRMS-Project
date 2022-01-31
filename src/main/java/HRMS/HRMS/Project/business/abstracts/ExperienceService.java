package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    Result add(Experience experience);
    DataResult<List<Experience>> getAll();
    DataResult<List<Experience>> getAllCvByJobEndDate(int cv_id);

}
