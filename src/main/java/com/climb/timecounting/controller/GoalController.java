package com.climb.timecounting.controller;

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

// @RequestMapping("/goal")
// @RestController
// public class GoalController {

   // private GoalService goalService;
   // @Autowired
   // public GoalController(GoalService goalService) {
   //     this.goalService = goalService;
   // }

    // 임시
    // @GetMapping({"/list"})
    // public ResponseEntity<List<goal>> getGoalList() {
     //   System.out.println("리스트조회");
     //   var goalList = goalService.getGoalList();
     //   return ResponseEntity.ok(goalList);
    //}
}
