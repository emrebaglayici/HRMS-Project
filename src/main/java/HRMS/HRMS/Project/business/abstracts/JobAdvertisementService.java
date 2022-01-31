package HRMS.HRMS.Project.business.abstracts;

import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.JobAdvertisement;

import javax.xml.crypto.Data;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllOpenPositions();
    DataResult<List<JobAdvertisement>> getActivePositionsByCreationTime();
    DataResult<List<JobAdvertisement>> getAllEmployersActiveAds(int employer_id);
    Result setActivate(int job_ads_id,boolean result);
    DataResult<JobAdvertisement> findById(int job_ads_id);
}
