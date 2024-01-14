package com.climb.timecounting.controller;

import com.climb.timecounting.dto.GoalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.climb.timecounting.domain.goal;
import com.climb.timecounting.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/goals")
@Controller
public class GoalController {

    private final GoalService goalService;

    @GetMapping
    public String goals(
            @PageableDefault(size = 20, direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map
    ) {
        map.addAttribute("goals", goalService.getListGoals(pageable));
        return "goals/index";
    }

    @GetMapping("/{goalId}")
    public String goal(@PathVariable String goalId, ModelMap map) {
        map.addAttribute("goal", goalService.getGoal(goalId));

        return "goals/detail";
    }
/*
    @GetMapping("/new")
    public String postNewGoal(GoalDto goalRequest) {
        goalService.saveGoal(goalRequest);
    }
    */
}
