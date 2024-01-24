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

    public void save() {
        Goal entity = new Goal();
        goalRepository.save(entity);
    }
}
