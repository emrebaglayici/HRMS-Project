package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Employee;
import HRMS.HRMS.Project.entities.concretes.Employer;

import java.util.List;

public interface EmployeeService {
    Result add(Employee employee);
    DataResult<List<Employee>> getAll();

}
