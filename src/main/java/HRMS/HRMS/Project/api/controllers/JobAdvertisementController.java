package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.JobAdvertisementService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobAdvertisement")
@CrossOrigin
public class JobAdvertisementController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/findById")
    public DataResult<JobAdvertisement> findById(int id){
        return this.jobAdvertisementService.findById(id);
    }

    @GetMapping("/findAllByActive")
    public DataResult<List<JobAdvertisement>> getAllOpenPositions(){
        return this.jobAdvertisementService.getAllOpenPositions();
    }

    @GetMapping("/getActivePositionsByCreationTime")
    public DataResult<List<JobAdvertisement>> getActivePositionsByCreationTime(){
        return this.jobAdvertisementService.getActivePositionsByCreationTime();
    }
    @GetMapping("/getAllEmployersActiveAds")
    public DataResult<List<JobAdvertisement>> getAllEmployersActiveAds(@RequestParam int employer_id){
        return this.jobAdvertisementService.getAllEmployersActiveAds(employer_id);
    }

    @PutMapping("/setActive")
    public Result setActivate(@RequestParam int id,@RequestParam boolean result){
        return this.jobAdvertisementService.setActivate(id,result);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hatası");
        return errors;
    }
}
