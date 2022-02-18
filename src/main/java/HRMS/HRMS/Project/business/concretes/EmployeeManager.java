package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.EmployeeCheckService;
import HRMS.HRMS.Project.business.abstracts.EmployeeService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.EmployeeDao;
import HRMS.HRMS.Project.entities.concretes.Employee;
import HRMS.HRMS.Project.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeCheckService employeeCheckService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, EmployeeCheckService employeeCheckService) {
        super();
        this.employeeDao = employeeDao;
        this.employeeCheckService = employeeCheckService;
    }

    @Override
    public Result add(Employee employee) {
        if(!this.employeeCheckService.checkEmployee(employee).isSuccess()){
            return this.employeeCheckService.checkEmployee(employee);
        }
        this.employeeDao.save(employee);
        return new SuccessResult("İş Arayan Eklendi");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(
                this.employeeDao.findAll(),"İş Arayanlar Listelendi"
        );
    }


}
