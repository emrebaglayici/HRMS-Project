package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.EmailVerificationService;
import HRMS.HRMS.Project.business.abstracts.EmployeeCheckService;
import HRMS.HRMS.Project.core.abstracts.MernisService;
import HRMS.HRMS.Project.core.utilities.results.ErrorResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.EmployeeDao;
import HRMS.HRMS.Project.dataAccess.abstracts.UserDao;
import HRMS.HRMS.Project.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCheckManager implements EmployeeCheckService {
    private UserDao userDao;
    private EmployeeDao employeeDao;
    private EmailVerificationService emailVerificationService;
    private MernisService mernisService;

    @Autowired
    public EmployeeCheckManager(UserDao userDao, EmployeeDao employeeDao,
                                EmailVerificationService emailVerificationService, MernisService mernisService) {
        this.userDao = userDao;
        this.employeeDao = employeeDao;
        this.emailVerificationService = emailVerificationService;
        this.mernisService = mernisService;
    }


    @Override
    public Result checkEmployee(Employee employee) {
        if(employee.getBirth_year().equals(null)|| employee.getEmail().isEmpty()||employee.getFirst_name().isEmpty()
                ||employee.getLast_name().isEmpty()||employee.getNationality_number().isEmpty()||employee.getPassword().isEmpty()||employee.getPassword_again().isEmpty())
        {
            return new ErrorResult("Tüm alanlar doldurulmalıdır");
        }
        else if(this.userDao.existsByEmail(employee.getEmail())){
            return new ErrorResult("Mail adresi daha önceden kullanıldı");
        }
        else if(this.employeeDao.existsByNationality_number(employee.getNationality_number())){
            return new ErrorResult("Bu Tc no kullanılmıştır");
        }else if(!employee.getPassword().equals(employee.getPassword_again())){
            return new ErrorResult("Parola eşleşmedi");
        }else if(!this.mernisService.isHuman(employee)){
            return new ErrorResult("Bilgileriniz doğrulanamadı");
        }else if(!this.emailVerificationService.isVerified(employee)){
            return new ErrorResult("Email adresi doğrulanamadı");
        }else{
            this.emailVerificationService.sendEmail(employee);
            this.emailVerificationService.verifyEmail(employee);
            return new SuccessResult("Kimlik bilgileri doğrulandı");
        }
    }
}
