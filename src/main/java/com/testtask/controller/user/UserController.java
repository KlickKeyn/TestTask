package com.testtask.controller.user;

import com.testtask.dao.model.user.User;
import com.testtask.service.user_service.main_functional.UserAccountManagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserAccountManagmentService userAccountManagmentService;

    @PostMapping("/createUser")
    public Integer createUser(@RequestBody User user) {
        return userAccountManagmentService.addNewUser(user);
    }

    @GetMapping("/getUserInfo")
    public User getUser(@RequestParam Integer id) {
        return userAccountManagmentService.getUserInfo(id);
    }
}
