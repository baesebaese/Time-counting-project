package com.climb.timecounting.login.controller;

import com.climb.timecounting.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    LoginService loginService;

    @PostMapping("/login")
    public void login(){
        loginService.login();
    }
}
