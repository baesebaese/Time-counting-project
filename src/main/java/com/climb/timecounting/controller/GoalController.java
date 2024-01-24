package com.climb.timecounting.controller;

import com.climb.timecounting.domain.Goal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.climb.timecounting.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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

    @PostMapping("/save")
    public void saveOrUpdate(@RequestBody Goal goal){
        goalService.saveOrUpdate(goal);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Goal goal){
        goalService.delete(goal);
    }

    @GetMapping("/{goalId}")
    public Goal goal(@PathVariable String goalId) {
        var result = goalService.goal(goalId);

        return result;
    }
}
