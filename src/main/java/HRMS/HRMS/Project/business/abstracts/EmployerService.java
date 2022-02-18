package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    DataResult<List<Employer>> getById(int employer_id);
}
