package HRMS.HRMS.Project.api.controllers;

import HRMS.HRMS.Project.business.abstracts.UserService;
import HRMS.HRMS.Project.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return this.userService.getAll();
    }
}