package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.EmployerCheckService;
import HRMS.HRMS.Project.business.abstracts.EmployerService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.EmployerDao;
import HRMS.HRMS.Project.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmployerCheckService employerCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService) {
        super();
        this.employerDao = employerDao;
        this.employerCheckService = employerCheckService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(
                this.employerDao.findAll(),"İş verenler listelendi"
        ) ;
    }

    @Override
    public Result add(Employer employer) {
        if(!this.employerCheckService.checkEmployer(employer).isSuccess()){
            return this.employerCheckService.checkEmployer(employer);
        }
        employerDao.save(employer);
        return new SuccessResult("İş veren eklendi");
    }
}
