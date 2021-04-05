package com.testtask.controller.user;

import com.testtask.dao.model.User;
import com.testtask.service.user_service.UserDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserDBService userDBService;

    @PostMapping("/createUser")
    public Integer createUser(@RequestBody User user) {
        return null;
    }

    @GetMapping("/getUserInfo")
    public User getUser(@RequestParam Integer id) {
        return null;
    }
}
