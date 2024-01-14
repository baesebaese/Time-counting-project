package com.climb.timecounting.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Goal {

    private @Column(length = 100) String user_id; // 유저 고유번호

    @Id
    private @Column(nullable = false, length = 11) String goal_id; // 목표 고유번호

    @Setter @Column(nullable = false, length = 100) private String goal_name; // 목표명

    @Setter @Column(length = 1000) private String goal_detail; // 목표 상세
    @Setter @Column(nullable = false) private int goal_seconds; // 목표 설정 시간(초)
    private int accumulate_seconds; // 목표 누적 시간(초)
    private double goal_percent; // 목표 진척도
    @Setter
    private Character goal_stat ; // 목표 상태 I:진행중(ing), F:완료(fin), S:중지(stop), R:준비(ready)

    @Setter @Column(length = 6) private String color; // 목표 색상. 헥스 코드 a 빼고 6자리 저장함.

    @CreatedDate @Column(nullable = false) private LocalDateTime write_date; // 최초 입력일자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modify_date; // 수정일자

    protected Goal() {
    }

    private Goal(String user_id, String goal_id, String goal_name, String goal_detail, int goal_seconds, int accumulate_seconds, double goal_percent, Character goal_stat, String color) {

    }

    public static Goal of(String user_id, String goal_id, String goal_name, String goal_detail, int goal_seconds, int accumulate_seconds, double goal_percent, Character goal_stat, String color) {
        return new Goal(user_id, goal_id, goal_name, goal_detail, goal_seconds, accumulate_seconds, goal_percent, goal_stat, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        Goal goal = (Goal) o;
        return user_id != null && Objects.equals(user_id, goal.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
