package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    Result add(Skill skill);
    DataResult<List<Skill>> getAll();
}
