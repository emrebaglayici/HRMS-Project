package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.SkillService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.SkillDao;
import HRMS.HRMS.Project.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager  implements SkillService {
    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        super();
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Beceri eklendi");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(
                this.skillDao.findAll(),"Beceriler Listelendi"
        );
    }
}
