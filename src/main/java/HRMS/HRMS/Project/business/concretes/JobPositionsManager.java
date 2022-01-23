package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.JobPositionsService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.core.SuccessDataResult;
import HRMS.HRMS.Project.core.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.JobPositionsDao;
import HRMS.HRMS.Project.entities.concretes.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public DataResult<List<JobPositions>> getAll(){
        return new SuccessDataResult<List>(
                this.jobPositionsDao.findAll()
                ,"Data listed"
        );
    }

    @Override
    public Result add(JobPositions jobPositions){
        this.jobPositionsDao.save(jobPositions);
        return new SuccessResult("Data added");
    }

    @Override
    public DataResult<List<JobPositions>> findById(int user_id){
        return new SuccessDataResult<List>(
                //liste de döndürebiliriz,
                Collections.singletonList(this.jobPositionsDao.findById(user_id)),"Listed By Id"
        );
    }



}
