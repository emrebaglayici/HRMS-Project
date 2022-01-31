package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.SchoolService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.Project.entities.concretes.School;
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
@RequestMapping("/api/schools")
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody School school){

        return ResponseEntity.ok(this.schoolService.add(school));
    }

    @GetMapping("/getAll")
    public DataResult<List<School>> getAll(){
        return this.schoolService.getAll();
    }

    @GetMapping("/getAllCvByGraduationYear")
    public DataResult<List<School>> getAllCvByGraduationYear(int cvId){
        return this.schoolService.getAllCvByGraduationYear(cvId);
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
