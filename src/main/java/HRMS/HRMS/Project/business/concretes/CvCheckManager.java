package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.CvCheckService;
import HRMS.HRMS.Project.core.utilities.results.ErrorResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.CvDao;
import HRMS.HRMS.Project.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class CvCheckManager implements CvCheckService {
    private CvDao cvDao;

    @Autowired
    public CvCheckManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public Result checkCv(Cv cv) {
        if ((!Pattern.matches("^[a-zA-Z](\\s?[a-zA-Z]){2,35}$"
                ,cv.getCover_letter()))||(!Pattern.
                matches("https://github.com/\\?(.*)"
                ,cv.getGithub_link()))||(!cv.getImage().isEmpty())||(!Pattern
                .matches("https://www.linkedin.com/in/\\?(.*)",cv.getLinkedin_link()))){
            return new ErrorResult("Tüm Alanlar doğru şekilde doldurulmalıdır");
        }else{
            return new SuccessResult("Cv Doğrulandı");
        }
    }
}
