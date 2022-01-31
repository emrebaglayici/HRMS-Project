package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.CvService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.Project.entities.concretes.Cv;
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
@RequestMapping("/api/cv")
public class CvController {
    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        super();
        this.cvService = cvService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Cv cv ){
        return ResponseEntity.ok(this.cvService.add(cv));
    }

    @PostMapping("/uploadAvatar")
    public ResponseEntity<?> uploadAvatar(@RequestParam Integer cv_id, @RequestParam String file_path) {
        return ResponseEntity.ok(this.cvService.uploadAvatar(cv_id, file_path));
    }


    @GetMapping("/getAll")
    public DataResult<List<Cv>> getAll(){
        return this.cvService.getAll();
    }

    @GetMapping("/getAllByEmployeeId")
    public DataResult<List<Cv>> getAllByEmployeeId(@RequestParam int employee_id){
        return this.cvService.getAllByEmployeeId(employee_id);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Hata!, validationErrors");
        return errors;
    }
}
