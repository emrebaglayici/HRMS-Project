package HRMS.HRMS.Project.dataAccess.abstracts;

import HRMS.HRMS.Project.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    @Query("from JobAdvertisement where is_activated=true")
    List<JobAdvertisement> getAllOpenPositions();

    @Query("from JobAdvertisement where is_activated=true ORDER BY creation_time desc")
    List<JobAdvertisement> getActivePositionsByCreationTime();

    @Query("from JobAdvertisement j inner join Employer e on e.id=:employer_id where j.is_activated=true")
    List<JobAdvertisement> getAllEmployersActiveAds(int employer_id);
}

