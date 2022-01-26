package HRMS.HRMS.Project.api.controllers;


import HRMS.HRMS.Project.business.abstracts.WorkPositionService;
import HRMS.HRMS.Project.core.utilities.results.DataResult;
import HRMS.HRMS.Project.core.utilities.results.Result;
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


    //İş pozisyonları listelendi
    @GetMapping("/getAll")
    public DataResult<List<WorkPosition>> getAll(){
        return this.workPositionService.getAll();
    }



    @PostMapping("/add")
    public Result add(@RequestBody WorkPosition workPosition){
        return this.workPositionService.add(workPosition);
    }

    @GetMapping("/1")
    public DataResult<List<WorkPosition>> findById(){
        return this.workPositionService.findById(1);
    }



}
