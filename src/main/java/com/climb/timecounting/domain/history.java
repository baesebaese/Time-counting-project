package com.climb.timecounting.domain;


import java.time.LocalDateTime;

public class history {
    private int seq; // 이력 고유번호
    private user user_id; // 유저 고유번호
    private object object_id; // 목표 고유번호
    private int execute_seconds; // 수행 시간(초)
    private LocalDateTime write_date; // 최초 입력일자
    private LocalDateTime modify_date; // 수정일자
}
