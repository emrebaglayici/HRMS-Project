package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.concretes.Experience;
import HRMS.HRMS.Project.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Integer> {
    @Query("from Experience e inner join Cv c on c.id=:cv_id order by e.job_endDate desc ")
    List<Experience> getAllCvByJobEndDate(int cv_id);
}
