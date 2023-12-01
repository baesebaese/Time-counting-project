package com.climb.timecounting.domain;

import java.time.LocalDateTime;

public class user {
    private String user_id; // 유저 고유번호
    private String user_name; // 유저 닉네임
    private Boolean user_stat; // 계정 사용 여부 TRUE:정상, FALSE:탈퇴

    private String login_stat; // 로그인 상태 A:애플로그인, G:구글로그인, NULL:로그아웃
    private LocalDateTime write_date; // 최초 입력일자
    private LocalDateTime modify_date; // 수정일자

}
