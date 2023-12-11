package com.climb.timecounting.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString

@Entity
public class History {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int seq; // 이력 고유번호

    @ManyToOne(optional = false) private user user_id; // 유저 고유번호
    @ManyToOne(optional = false) private Goal goal_id; // 목표 고유번호

    @Setter  @Column(nullable = false) private int execute_seconds; // 수행 시간(초)

    @CreatedDate @Column(nullable = false) private LocalDateTime write_date; // 최초 입력일자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modify_date; // 수정일자

    protected history() {
    }

    private history(user user_id, Goal goal_id, int execute_seconds) {
        this.user_id = user_id;
        this.goal_id = goal_id;
        this.execute_seconds = execute_seconds;
    }

    public static history of(user user_id, Goal goal_id, int execute_seconds) {
        return new history(user_id, goal_id, execute_seconds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof history)) return false;
        history history = (history) o;
        return seq == history.seq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq);
    }
}
