package com.fptu.swp.ppr.user.controller;

import com.fptu.swp.ppr.entities.UserInfo;
import com.fptu.swp.ppr.user.services.UserInfoService;
import com.fptu.swp.ppr.util.APIPath;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIPath.USER_INFO)
@AllArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping("/{userId}")
    public UserInfo findByUserID(@PathVariable String userId){
        return userInfoService.getUserById(userId);
    }
}
