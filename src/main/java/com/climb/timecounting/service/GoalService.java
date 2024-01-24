package com.climb.timecounting.service;


import com.climb.timecounting.domain.Goal;
import com.climb.timecounting.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class GoalService {

    private final GoalRepository goalRepository;

    @Transactional(readOnly = true)
    public List<Goal> list(){
        var result = goalRepository.findAll();

        return result;
    }

    public Goal goal(String id){
        var result =goalRepository.findById(id).orElse(null);

        return result;
    }

    public Goal saveOrUpdate(Goal goal) {
        final Optional<Goal> foundGoal = goalRepository.findById(goal.getGoal_id());

        if (foundGoal.isPresent()) {
            foundGoal.get().update(
                goal.getGoal_name(), goal.getGoal_detail()
            );
            return foundGoal.get();
        }

        return goalRepository.save(goal);
    }

    public void delete(Goal goal){
        goalRepository.delete(goal);
    }

}
