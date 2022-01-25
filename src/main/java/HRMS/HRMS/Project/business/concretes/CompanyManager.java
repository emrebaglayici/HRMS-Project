package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.CompanyService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.core.SuccessDataResult;
import HRMS.HRMS.Project.core.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.CompanyDao;
import HRMS.HRMS.Project.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {
    private CompanyDao companyDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao) {
        super();
        this.companyDao = companyDao;
    }

    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<List<Company>>(
                this.companyDao.findAll(),"İş verenler listelendi"
        ) ;
    }

    @Override
    public Result add(Company company) {
        this.companyDao.save(company);
        return new SuccessResult("İş veren eklendi");
    }
}
