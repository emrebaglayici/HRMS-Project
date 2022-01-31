package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result add(School school);
    DataResult<List<School>> getAll();
    DataResult<List<School>> getAllCvByGraduationYear(int cv_id);
}
