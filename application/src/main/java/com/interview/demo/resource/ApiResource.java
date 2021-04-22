package com.interview.demo.resource;

import com.interview.demo.model.ResponseModel;
import com.interview.demo.model.User;
import com.interview.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApiResource {

    @Autowired
    private UserService userService;

    @GetMapping
//    @RequestMapping
    public ResponseModel<List<User>> getAllEmployees()
    {
        return new ResponseModel<List<User>>("List of users",HttpStatus.OK,userService.getAllUsers());
    }

    @PostMapping
//    @RequestMapping
    public ResponseModel<Boolean> addUser(@RequestBody User user)
    {
        return new ResponseModel<Boolean>("user saved",HttpStatus.OK,userService.addUser(user));
    }

}
