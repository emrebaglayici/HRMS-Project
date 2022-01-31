package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    Result add(Cv cv);
    Result uploadAvatar(int cv_id,String file_path);

    DataResult<List<Cv>> getAll();
    DataResult<List<Cv>> getAllByEmployeeId(int employee_id);
}
