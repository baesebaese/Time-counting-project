package com.climb.timecounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/goals")
@Controller
public class GoalController {
    @GetMapping
    public String goals(ModelMap map) {
        map.addAttribute("goals", List.of());
        return "goals/index";
    }

    @GetMapping("/{goalId}")
    public String goal(@PathVariable Long goalId, ModelMap map) {
        map.addAttribute("goal", "goal");

        return "goals/detail";
    }
}
