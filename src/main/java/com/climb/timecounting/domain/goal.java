package com.climb.timecounting.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Entity
public class goal {

    @ManyToOne(optional = false) private user user_id; // 유저 고유번호

    @Id
    private @Column(nullable = false, length = 11) String goal_id; // 목표 고유번호

    @Setter @Column(nullable = false, length = 20) private String goal_name; // 목표명

    @Setter @Column(length = 1000) private String goal_detail; // 목표 상세
    @Setter @Column(nullable = false) private int goal_seconds; // 목표 설정 시간(초)
    private int accumulate_seconds; // 목표 누적 시간(초)
    private double goal_percent; // 목표 진척도

    @ToString.Exclude
    @OneToMany
    private final Set<com.climb.timecounting.domain.history> history = new LinkedHashSet<>();

    @CreatedDate @Column(nullable = false) private LocalDateTime write_date; // 최초 입력일자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modify_date; // 수정일자

    protected goal() {
    }

    private goal(String goal_name, String goal_detail, int goal_seconds, int accumulate_seconds, double goal_percent) {
        this.goal_name = goal_name;
        this.goal_detail = goal_detail;
        this.goal_seconds = goal_seconds;
        this.accumulate_seconds = accumulate_seconds;
        this.goal_percent = goal_percent;
    }

    public static goal of(String goal_name, String goal_detail, int goal_seconds, int accumulate_seconds, double goal_percent) {
        return new goal(goal_name, goal_detail, goal_seconds, accumulate_seconds, goal_percent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof goal)) return false;
        goal goal = (com.climb.timecounting.domain.goal) o;
        return user_id != null && Objects.equals(user_id, goal.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
