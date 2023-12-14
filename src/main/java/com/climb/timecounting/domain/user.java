package com.climb.timecounting.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class user {

    @Id
    private @Column(length = 100) String user_id; // 유저 고유번호

    @Setter @Column(nullable = false, length = 20) private String user_name; // 유저 닉네임
    @Setter private Boolean user_stat; // 계정 사용 여부 TRUE:정상, FALSE:탈퇴

    private Character login_stat; // 로그인 상태 A:애플로그인, G:구글로그인, NULL:로그아웃

    @CreatedDate @Column(nullable = false) private LocalDateTime write_date; // 최초 입력일자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modify_date; // 수정일자

    protected user() {
    }

    private user(String user_name, Boolean user_stat, Character login_stat) {
        this.user_name = user_name;
        this.user_stat = user_stat;
        this.login_stat = login_stat;
    }

    public static user of(String user_name, Boolean user_stat, Character login_stat) {
        return new user(user_name, user_stat, login_stat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof user)) return false;
        user user = (com.climb.timecounting.domain.user) o;
        return user_id != null && Objects.equals(user_id, user.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
