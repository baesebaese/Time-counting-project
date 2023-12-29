package com.climb.timecounting.service;

import com.climb.timecounting.domain.User;
import com.climb.timecounting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User check(Map token){
        var user = userRepository.findById("213").orElse(null);

        return user;
    }

    public boolean register(User user){
        var result = userRepository.save(user);

        if(result == null){
            return false;
        }

        return true;
    }
}
