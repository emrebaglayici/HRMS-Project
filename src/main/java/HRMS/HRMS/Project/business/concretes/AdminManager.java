package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.AdminService;
import HRMS.HRMS.Project.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class AdminManager implements AdminService {
    @Override
    public boolean validateEmployer(Employer employer) {
        System.out.println("Emailiniz doğrulandı");
        return true;
    }
}
