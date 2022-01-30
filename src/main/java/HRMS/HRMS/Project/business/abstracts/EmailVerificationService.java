package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.entities.abstracts.User;

public interface EmailVerificationService {
    void sendEmail(User user);
    void verifyEmail(User user);
    boolean isVerified(User user);
}
