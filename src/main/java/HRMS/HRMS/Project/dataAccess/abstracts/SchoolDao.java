package HRMS.HRMS.Project.dataAccess.abstracts;
import HRMS.HRMS.Project.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolDao extends JpaRepository<School,Integer> {
    @Query("from School s inner join Cv c on c.id=:cv_id order by s.graduation_year desc ")
    List<School> getAllCvByGraduationYear(int cv_id);
}
