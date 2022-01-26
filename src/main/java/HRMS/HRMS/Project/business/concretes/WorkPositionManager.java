package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.WorkPositionService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.WorkPositionDao;
import HRMS.HRMS.Project.entities.concretes.WorkPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WorkPositionManager implements WorkPositionService {
    private WorkPositionDao workPositionDao;

    @Autowired
    public WorkPositionManager(WorkPositionDao workPositionDao) {
        super();
        this.workPositionDao = workPositionDao;
    }

    @Override
    public DataResult<List<WorkPosition>> getAll(){
        return new SuccessDataResult<List>(
                this.workPositionDao.findAll()
                ,"Data listed"
        );
    }

    @Override
    public Result add(WorkPosition workPosition){
        this.workPositionDao.save(workPosition);
        return new SuccessResult("Data added");
    }

    @Override
    public DataResult<List<WorkPosition>> findById(int id){
        return new SuccessDataResult<List>(
                //liste de döndürebiliriz,
                Collections.singletonList(this.workPositionDao.findById(id)),"Listed By Id"
        );
    }



}
