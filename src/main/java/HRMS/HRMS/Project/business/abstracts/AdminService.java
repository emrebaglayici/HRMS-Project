package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.entities.concretes.Employer;

public interface AdminService {
    boolean validateEmployer(Employer employer);
}
