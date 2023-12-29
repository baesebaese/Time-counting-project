package com.climb.timecounting.controller;

import com.climb.timecounting.service.UserService;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/check")
    public void check(@RequestBody Map token){
        userService.check(token);
    }

    @PostMapping("/register")
    public void register(){

    }
}
