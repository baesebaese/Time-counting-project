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
    private final KakaoApiService kakaoApiService;

    public User check(Map token){
        var id = kakaoApiService.info(token);
        var user = userRepository.findById(id).orElse(null);

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
