package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.EmployerService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
import HRMS.HRMS.Project.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class EmployerController {
    private EmployerService employerService;
    @Autowired
    public EmployerController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    //İş verenler listelendi
    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    //İş veren eklendi
    @PostMapping("/add")
    public Result add(@RequestBody Employer company){
        return this.employerService.add(company);
    }
}
