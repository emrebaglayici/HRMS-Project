package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Employer;

public interface EmployerCheckService {
    Result checkEmployer(Employer employer);
}
