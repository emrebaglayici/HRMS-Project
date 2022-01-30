package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.EmployerService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Employer;
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
@RequestMapping("/api/employers")
public class EmployerController {
    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(this.employerService.add(employer));
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hatası");
        return errors;
    }

}
