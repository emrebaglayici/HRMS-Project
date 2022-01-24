package HRMS.HRMS.Project.api.controllers;


import HRMS.HRMS.Project.business.abstracts.WorkPositionService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.entities.concretes.WorkPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/WorkPosition")
public class WorkPositionController {
    private WorkPositionService workPositionService;

    @Autowired
    public WorkPositionController(WorkPositionService workPositionService) {
        super();
        this.workPositionService = workPositionService;
    }



    @GetMapping("/getAll")
    public DataResult<List<WorkPosition>> getAll(){
        return this.workPositionService.getAll();
    }



    @PostMapping("/add")
    public Result add(@RequestBody WorkPosition positionName){
        return this.workPositionService.add(positionName);
    }

    @GetMapping("/1")
    public DataResult<List<WorkPosition>> findById(){
        return this.workPositionService.findById(1);
    }



}
