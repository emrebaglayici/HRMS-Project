package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.UserService;
import HRMS.HRMS.Project.core.DataResult;
import HRMS.HRMS.Project.core.Result;
import HRMS.HRMS.Project.core.SuccessDataResult;
import HRMS.HRMS.Project.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //İş arayanlar listelendi
    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    //İş arayanlar sisteme kayıt oldu
    @PostMapping( "/UserRegister")
    public Result add(@RequestBody User user){
        return this.userService.add(user);
    }
}
