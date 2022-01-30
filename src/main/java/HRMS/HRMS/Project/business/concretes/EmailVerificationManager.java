package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.EmailVerificationService;
import HRMS.HRMS.Project.entities.abstracts.User;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    @Override
    public void sendEmail(User user) {
        System.out.println(user.getEmail()+" mailinize doğrulama kodu gönderildi");
    }

    @Override
    public void verifyEmail(User user) {
        System.out.println(user.getEmail()+" hesabınız doğrulandı");
    }

    @Override
    public boolean isVerified(User user) {
        return true;
    }
}
