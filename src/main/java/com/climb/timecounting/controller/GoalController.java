package com.climb.timecounting.controller;

import com.climb.timecounting.domain.Goal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.climb.timecounting.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    @GetMapping("/list")
    public List<Goal> goals() {
        var result = goalService.list();

        return result;
    }

    //목표 추가
    public void save(){
        goalService.save();

    }

    //목표 삭제
    public void delete(){

    }

    //목표 수정
    public void update(){

    }

    @GetMapping("/{goalId}")
    public Goal goal(@PathVariable String goalId) {
        var result = goalService.goal(goalId);

        return result;
    }
}
