package com.climb.timecounting.login.service;

import com.climb.timecounting.login.db.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    LoginRepository loginRepository;

    public void login(){

    }
}
