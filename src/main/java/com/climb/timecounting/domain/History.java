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
public class History {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int seq; // 이력 고유번호

    private @Column(length = 100) String user_id; // 유저 고유번호
    private @Column(nullable = false, length = 11) String goal_id; // 목표 고유번호

    @Setter  @Column(nullable = false) private int execute_seconds; // 수행 시간(초)

    @CreatedDate @Column(nullable = false) private LocalDateTime write_date; // 최초 입력일자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modify_date; // 수정일자

    protected History() {
    }

    private History(String user_id, String goal_id, int execute_seconds) {
        this.user_id = user_id;
        this.goal_id = goal_id;
        this.execute_seconds = execute_seconds;
    }

    public static History of(String user_id, String goal_id, int execute_seconds) {
        return new History(user_id, goal_id, execute_seconds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof History)) return false;
        History history = (History) o;
        return seq == history.seq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq);
    }
}
