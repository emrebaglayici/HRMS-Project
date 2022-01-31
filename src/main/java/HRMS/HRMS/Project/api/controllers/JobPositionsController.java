package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.JobPositionsService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.Project.entities.concretes.JobPositions;
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
@RequestMapping("/api/jobPositions")
@CrossOrigin
public class JobPositionsController {
    private JobPositionsService jobPositionsService;
    @Autowired
    public JobPositionsController(JobPositionsService jobPositionsService) {
        super();
        this.jobPositionsService = jobPositionsService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobPositions jobPositions) {
        return ResponseEntity.ok(this.jobPositionsService.addJobPositions(jobPositions));
    }

    @GetMapping("/getall")
    public DataResult<List<JobPositions>> getAll(){
        return this.jobPositionsService.getAll();
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
