package com.climb.timecounting.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "object_name"),
        @Index(columnList = "object_detail"),
        @Index(columnList = "modify_date")
})
@Entity
public class object {

    @ManyToOne(optional = false) private user user_id; // 유저 고유번호

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String object_id; // 목표 고유번호

    @Setter @Column(nullable = false, length = 20) private String object_name; // 목표명

    @Setter private String object_detail; // 목표 상세
    @Setter private int object_seconds; // 목표 설정 시간(초)
    private int accumulate_seconds; // 목표 누적 시간(초)
    private double object_percent; // 목표 진척도

    @CreatedDate @Column(nullable = false) private LocalDateTime write_date; // 최초 입력일자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modify_date; // 수정일자

    protected object() {
    }

    private object(String object_name, String object_detail, int object_seconds, int accumulate_seconds, double object_percent) {
        this.object_name = object_name;
        this.object_detail = object_detail;
        this.object_seconds = object_seconds;
        this.accumulate_seconds = accumulate_seconds;
        this.object_percent = object_percent;
    }

    public static object of(String object_name, String object_detail, int object_seconds, int accumulate_seconds, double object_percent) {
        return new object(object_name, object_detail, object_seconds, accumulate_seconds, object_percent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof object)) return false;
        object object = (object) o;
        return user_id != null && Objects.equals(user_id, object.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
