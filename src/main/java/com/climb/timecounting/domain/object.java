package com.climb.timecounting.domain;

import java.time.LocalDateTime;

public class object {
    private user user_id; // 유저 고유번호
    private String object_id; // 목표 고유번호

    private String object_name; // 목표명
    private String object_detail; // 목표 상세
    private int object_seconds; // 목표 설정 시간(초)
    private int accumulate_seconds; // 목표 누적 시간(초)
    private double object_percent; // 목표 진척도
    private LocalDateTime write_date; // 최초 입력일자
    private LocalDateTime modify_date; // 수정일자


}
