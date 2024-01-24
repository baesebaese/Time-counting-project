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
        // 닉네임 고유한지 select 해서 체크
        
        var result = userRepository.save(user);

        if(result == null){
            return false;
        }

        return true;
    }

    //유저 탈퇴 처리
    //사용중단 업데이트 처리
    public void delete(){
        userRepository.save(null);
    }
}
