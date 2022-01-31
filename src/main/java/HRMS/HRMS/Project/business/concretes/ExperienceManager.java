package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.ExperienceService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.ExperienceDao;
import HRMS.HRMS.Project.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {
    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        super();
        this.experienceDao = experienceDao;
    }

    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("İş deneyimi eklendi");
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(
                this.experienceDao.findAll(),"İş deneyimleri Listelendi"
        );
    }

    @Override
    public DataResult<List<Experience>> getAllCvByJobEndDate(int cv_id) {
        return new SuccessDataResult<List<Experience>>(
                this.experienceDao.getAllCvByJobEndDate(cv_id),"İş Deneyimleri Tarihe göre Listelendi"
        );
    }
}
