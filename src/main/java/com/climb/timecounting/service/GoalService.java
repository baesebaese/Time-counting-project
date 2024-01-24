package com.climb.timecounting.service;


import com.climb.timecounting.domain.goal;
import com.climb.timecounting.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoalService {

    private GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    // 임시
    @Transactional(readOnly = true)
    public List<goal> getGoalList() {
        List<goal> result = goalRepository.findAll();
        System.out.println("리스트 출력 " + result.toString());
        return result;
    }

    public goal goal(String id){
        var result =goalRepository.findById(id).orElse(null);

        return result;
    }
}
