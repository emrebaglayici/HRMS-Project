package HRMS.HRMS.Project.core.concretes;

import HRMS.HRMS.Project.core.abstracts.MernisService;
import HRMS.HRMS.Project.entities.concretes.Employee;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService {

    @Override
    public boolean isHuman(Employee employee) {
        return true;
    }
}
