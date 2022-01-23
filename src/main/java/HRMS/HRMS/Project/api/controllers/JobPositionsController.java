package HRMS.HRMS.Project.api.controllers;


import HRMS.HRMS.Project.business.abstracts.JobPositionsService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.entities.concretes.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/JobPositions")
public class JobPositionsController {
    private JobPositionsService jobPositionsService;

    @Autowired
    public JobPositionsController(JobPositionsService jobPositionsService) {
        super();
        this.jobPositionsService = jobPositionsService;
    }



    @GetMapping("/getAll")
    public DataResult<List<JobPositions>> getAll(){
        return this.jobPositionsService.getAll();
    }



    @PostMapping("/add")
    public Result add(@RequestBody JobPositions jobPositions){
        return this.jobPositionsService.add(jobPositions);
    }

    @GetMapping("/1")
    public DataResult<List<JobPositions>> findById(){
        return this.jobPositionsService.findById(1);
    }



}
