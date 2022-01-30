package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.JobPositionsService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.JobPositionsDao;
import HRMS.HRMS.Project.entities.concretes.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionsManager implements JobPositionsService {
    private JobPositionsDao jobPositionsDao;

    @Autowired
    public JobPositionsManager(JobPositionsDao jobPositionsDao) {
        super();
        this.jobPositionsDao = jobPositionsDao;
    }

    @Override
    public Result addJobPositions(JobPositions jobPositions) {
        this.jobPositionsDao.save(jobPositions);
        return new SuccessResult("İş pozisyonu eklendi");
    }

    @Override
    public DataResult<List<JobPositions>> getAll() {
        return new SuccessDataResult<List<JobPositions>>(
                this.jobPositionsDao.findAll(),"İş pozisyonları listelendi"
        );
    }
}
