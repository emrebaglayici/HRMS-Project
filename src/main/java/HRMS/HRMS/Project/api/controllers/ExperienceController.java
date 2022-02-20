package HRMS.HRMS.Project.api.controllers;
import HRMS.HRMS.Project.business.abstracts.ExperienceService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.Project.entities.concretes.Experience;
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
@RequestMapping("/api/experiences")
public class ExperienceController {
    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        super();
        this.experienceService = experienceService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Experience experience){
        return ResponseEntity.ok(this.experienceService.add(experience));
    }

    @GetMapping("/getAll")
    public DataResult<List<Experience>> getAll(){

        return this.experienceService.getAll();
    }

    @GetMapping("/getAllCvByJobEndDate")
    public DataResult<List<Experience>> getAllCvByJobEndDate(int cvId){
        return this.experienceService.getAllCvByJobEndDate(cvId);
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
