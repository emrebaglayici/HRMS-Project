package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.CompanyService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    //İş verenler listelendi
    @GetMapping("/getall")
    public DataResult<List<Company>> getAll(){
        return this.companyService.getAll();
    }

    //İş veren eklendi
    @PostMapping("/add")
    public Result add(@RequestBody Company company){
        return this.companyService.add(company);
    }
}
