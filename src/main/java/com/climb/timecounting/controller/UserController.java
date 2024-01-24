package com.climb.timecounting.controller;

import com.climb.timecounting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/check")
    public ResponseEntity<Map> check(@RequestBody Map token){
        var user = userService.check(token);

        Map result = new HashMap();
        result.put("User", user);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map body){

        userService.register(null);

        return ResponseEntity.ok(null);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody String userId){
        userService.delete(userId);
    }
}


