package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.entities.concretes.WorkPosition;

import java.util.List;

public interface WorkPositionService {
    DataResult<List<WorkPosition>> getAll();
    Result add(WorkPosition workPosition);
    DataResult<List<WorkPosition>> findById(int id);
}
