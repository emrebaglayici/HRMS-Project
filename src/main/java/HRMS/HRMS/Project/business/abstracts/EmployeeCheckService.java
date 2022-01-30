package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Employee;

public interface EmployeeCheckService {
    Result checkEmployee(Employee employee);
}
