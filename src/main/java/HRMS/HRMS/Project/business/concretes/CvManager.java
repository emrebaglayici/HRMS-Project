package HRMS.HRMS.Project.business.concretes;

import HRMS.HRMS.Project.business.abstracts.CvService;
import HRMS.HRMS.Project.core.concretes.CloudinaryServiceAdapter;
import HRMS.HRMS.Project.core.utilities.results.*;
import HRMS.HRMS.Project.dataAccess.abstracts.CvDao;
import HRMS.HRMS.Project.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    private CloudinaryServiceAdapter cloudinaryServiceAdapter;

    @Autowired
    public CvManager(CvDao cvDao, CloudinaryServiceAdapter cloudinaryServiceAdapter) {
        this.cvDao = cvDao;
        this.cloudinaryServiceAdapter = cloudinaryServiceAdapter;
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv eklendi");
    }

    @Override
    public Result uploadAvatar(int cv_id, String file_path) {
        File file=new File(file_path);
        Object object=this.cloudinaryServiceAdapter.uploadAvatar(file).get("secure_url");
        if(object==null) {
            return new ErrorDataResult<String>(
                    null, "Resim bulunamadı");
        }else if(!this.cvDao.existsById(cv_id)){
            return new ErrorDataResult<String>(null,"Girilen id ile eşleşen cv bulunamadı");
        }else{
            String secure_url=object.toString();
            Cv cv=this.cvDao.findById(cv_id).get();
            cv.setImage(secure_url);
            this.cvDao.save(cv);
            return new SuccessDataResult<String>(secure_url,"Resim yüklendi");
        }
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Cvler listelendi");
    }

    @Override
    public DataResult<List<Cv>> getAllByEmployeeId(int employee_id) {
        return new SuccessDataResult<List<Cv>>(this.cvDao.getAllByEmployeeId(employee_id),"Cv ler iş arayanlara göre listelendi");
    }
}
