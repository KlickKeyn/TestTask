package com.testtask.controller.user;

import com.testtask.dao.model.user.User;
import com.testtask.dao.model.user.UserStatusInfo;
import com.testtask.service.user_service.main_functional.UserAccountManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserAccountManagementService userAccountManagementService;

    @PostMapping("/createUser")
    public Integer createUser(@RequestBody User user) {
        return userAccountManagementService.addNewUser(user);
    }

    @GetMapping("/getUserInfo")
    public User getUser(@RequestParam Integer id) {
        return userAccountManagementService.getUserInfo(id);
    }

    @PatchMapping("/changeStatus")
    public UserStatusInfo changeUserStatus(@RequestBody UserStatusInfo userStatusInfo) {
        return userAccountManagementService.changeUserStatus(userStatusInfo);
    }
}
