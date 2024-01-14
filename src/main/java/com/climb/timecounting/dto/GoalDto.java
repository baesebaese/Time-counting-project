package com.climb.timecounting.dto;

import com.climb.timecounting.domain.goal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

public record GoalDto(
         String goal_id,
         int accumulate_seconds,
         String goal_detail,
         String goal_name,
         double goal_percent,
         int goal_seconds,
         LocalDateTime modify_date,
         String user_id,
         LocalDateTime write_date,
         Character goal_stat, // 목표 상태 I:진행중(ing), F:완료(fin), S:중지(stop), R:준비(ready)

         String color // 목표 색상
) {
    public static GoalDto of(String goal_id, int accumulate_seconds, String goal_name, String goal_detail, double goal_percent, int goal_seconds, LocalDateTime modify_date, String user_id, LocalDateTime write_date, Character goal_stat, String color) {

        return new GoalDto(goal_id, accumulate_seconds, goal_name, goal_detail,  goal_percent, goal_seconds, modify_date, user_id, write_date, goal_stat, color);
    }

    public static GoalDto from(goal entity) {
        return new GoalDto(
                entity.getGoal_id(),
                entity.getAccumulate_seconds(),
                entity.getGoal_name(),
                entity.getGoal_detail(),
                entity.getGoal_percent(),
                entity.getGoal_seconds(),
                entity.getModify_date(),
                entity.getUser_id(),
                entity.getWrite_date(),
                entity.getGoal_stat(),
                entity.getColor()
        );
    }

    public goal toEntity() {
        return goal.of(
                user_id,
                goal_id,
                goal_name,
                goal_detail,
                goal_seconds,
                accumulate_seconds,
                goal_percent,
                goal_stat,
                color
        );
    }
}
