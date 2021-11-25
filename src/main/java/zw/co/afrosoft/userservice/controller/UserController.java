package zw.co.afrosoft.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.userservice.ValueObjects.ResponseTemplate;
import zw.co.afrosoft.userservice.domain.User;
import zw.co.afrosoft.userservice.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return new ResponseEntity<>(userService.saveUser(user),
                HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplate> getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return new ResponseEntity<>(userService.getUserWithDepartment(userId),
                HttpStatus.FOUND);
    }
}
