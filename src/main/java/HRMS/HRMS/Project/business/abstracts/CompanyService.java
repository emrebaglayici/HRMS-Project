package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Company;

import java.util.List;

public interface CompanyService {
    DataResult<List<Company>> getAll();
    Result add(Company company);
}
