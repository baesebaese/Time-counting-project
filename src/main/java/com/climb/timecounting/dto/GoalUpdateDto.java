package com.climb.timecounting.dto;

import java.time.LocalDateTime;

public record GoalUpdateDto(

         String goal_name,

         String goal_detail,
         int goal_seconds,

         char goal_stat,

         String color,

         LocalDateTime modify_date

)
{

    public static GoalUpdateDto of(String goal_name, String goal_detail, int goal_seconds, char goal_stat, String color, LocalDateTime modify_date) {
        return new GoalUpdateDto(goal_name, goal_detail, goal_seconds, goal_stat, color, modify_date);
    }
}
