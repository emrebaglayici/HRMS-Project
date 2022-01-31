package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.JobAdvertisementService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessResult;
import HRMS.HRMS.Project.dataAccess.abstracts.JobAdvertisementDao;
import HRMS.HRMS.Project.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İlan eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAll(),"İlanlar Listelendi"
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllOpenPositions() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getAllOpenPositions(),"Aktif olan iş ilanları listelendi"
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActivePositionsByCreationTime() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getActivePositionsByCreationTime(),"Aktif olan iş ilanları tarihe göre listelendi"
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllEmployersActiveAds(int employer_id) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getAllEmployersActiveAds(employer_id),"Spesifik şirketin iş ilanları listelendi"
        );
    }

    /*@Override
    public DataResult<List<JobAdvertisement>> getAllByEmployer_IdAndIsActivatedTrue(int employer_id) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getAllByEmployer_IdAndIsActivatedTrue(employer_id),"Spesifik şirketin iş ilanları listelendi"
        );
    }*/
    /*@Override
    public DataResult<List<JobAdvertisement>> getAllByIs_activedTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getAllByIs_activedTrue(),"Aktif olan iş ilanları listelendi"
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByIs_activedTrueOrderByCreation_timeDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getAllByIs_activedTrueOrderByCreation_timeDesc(),"Aktif olan iş ilanları tarihe göre listelendi"
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByEmployer_IdAndIs_activedTrue(int employer_id) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getAllByEmployer_IdAndIs_activedTrue(employer_id),"Spesifik şirketin iş ilanları listelendi"
        );
    }*/

    @Override
    public Result setActivate(int job_ads_id, boolean result) {
        JobAdvertisement jobAdvertisement;
        jobAdvertisement=this.jobAdvertisementDao.findById(job_ads_id).get();
        jobAdvertisement.set_activated(result);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İlan aktiflik durumu = "+result);
    }

    @Override
    public DataResult<JobAdvertisement> findById(int job_ads_id) {
        return new SuccessDataResult<JobAdvertisement>(
                this.jobAdvertisementDao.findById(job_ads_id).get(),"Id ye göre sıralandı"
        );
    }
}
