package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.CityService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.SuccessDataResult;
import HRMS.HRMS.Project.dataAccess.abstracts.CityDao;
import HRMS.HRMS.Project.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(
                this.cityDao.findAll(),"Şehirler Listelendi"
        );
    }
}
