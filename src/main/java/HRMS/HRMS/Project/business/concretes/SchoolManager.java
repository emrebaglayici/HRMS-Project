package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.SchoolService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.SchoolDao;
import HRMS.HRMS.Project.dataAccess.abstracts.UserDao;
import HRMS.HRMS.Project.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        super();
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Okul bilgileri eklendi");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAll(),"Okul bilgileri listelendi"
        );
    }

    @Override
    public DataResult<List<School>> getAllCvByGraduationYear(int cv_id) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.getAllCvByGraduationYear(cv_id),"Mezuniyet tarihine göre listelendi"
        );
    }
}
