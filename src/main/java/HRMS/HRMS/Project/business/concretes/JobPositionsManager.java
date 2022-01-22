package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.JobPositionsService;
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
    public List<JobPositions> getAll() {
        return this.jobPositionsDao.findAll();
    }
}
