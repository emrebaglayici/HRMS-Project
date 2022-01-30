package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.AdminService;
import HRMS.HRMS.Project.business.abstracts.EmailVerificationService;
import HRMS.HRMS.Project.business.abstracts.EmployerCheckService;
import HRMS.HRMS.Project.core.utilities.results.ErrorResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.UserDao;
import HRMS.HRMS.Project.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerCheckManager implements EmployerCheckService {
    private UserDao userDao;
    private EmailVerificationService emailVerificationService;
    private AdminService adminService;

    @Autowired
    public EmployerCheckManager(UserDao userDao, EmailVerificationService emailVerificationService, AdminService adminService) {
        this.userDao = userDao;
        this.emailVerificationService = emailVerificationService;
        this.adminService = adminService;
    }




    @Override
    public Result checkEmployer(Employer employer) {
        String[] split=employer.getEmail().split("@");
        if(employer.getPhone().isEmpty()|| employer.getEmail().isEmpty()||employer.getWebsite().isEmpty()
        ||employer.getCompany_name().isEmpty()||employer.getPassword().isEmpty()||employer.getPassword_again().isEmpty())
        {
            return new ErrorResult("Tüm alanlar doldurulmalıdır");
        }
        else if(!split[1].equals(employer.getWebsite())){
            return new ErrorResult("Kurumsal mail adresi kullanmalısınız");
        }
        else if(!this.emailVerificationService.isVerified(employer)){
            return new ErrorResult("Emailinizi doğrulamalısınız");
        }
        else if(!employer.getPassword().equals(employer.getPassword_again())){
            return new ErrorResult("Girilen parolalar eşleşmiyor");
        }
        else if(this.userDao.existsByEmail(employer.getEmail())){
            return new ErrorResult("Bu email adresi kullanıldır");
        }
        else if(!this.adminService.validateEmployer(employer)){
            return new ErrorResult("Sistem personeli onaylamadı");
        }
        else{
            this.emailVerificationService.sendEmail(employer);
            this.emailVerificationService.verifyEmail(employer);
            return new SuccessResult("Employer Doğrulandı");
        }
    }
}
