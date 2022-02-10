package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Cv;

public interface CvCheckService {
    Result checkCv(Cv cv);
}
