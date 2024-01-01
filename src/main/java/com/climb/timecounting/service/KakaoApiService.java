package com.climb.timecounting.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KakaoApiService {

    public String info(Map token){
        var url = "https://kapi.kakao.com/v2/user/me";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token.get("access_token"));
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        HttpEntity request = new HttpEntity(headers);

        var response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class).getBody();

        return (String) response.get("id");
    }
}
