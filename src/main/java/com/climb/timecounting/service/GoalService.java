package com.climb.timecounting.service;


import com.climb.timecounting.domain.Goal;
import com.climb.timecounting.dto.GoalDto;
import com.climb.timecounting.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class GoalService {

    private final GoalRepository goalRepository;

    @Transactional(readOnly = true)
    public Page<GoalDto> getListGoals(Pageable pageable) {
        return goalRepository.findAll(pageable).map(GoalDto::from);
    }

    @Transactional(readOnly = true)
    public GoalDto getGoal(String goalId) {
        return goalRepository.findById(goalId)
                .map(GoalDto::from)
                .orElseThrow(()-> new EntityNotFoundException("게시글이 없습니다 - goalId: " + goalId));
    }

    public void saveGoal(GoalDto dto) {
        goalRepository.save(dto.toEntity());

    }

    public void updateGoal(GoalDto dto) {
        try {
            Goal goal = goalRepository.getReferenceById(dto.goal_id());
            if(dto.goal_name() != null) { goal.setGoal_name(dto.goal_name()); }
            if(dto.goal_seconds() != 0) {goal.setGoal_seconds(dto.toEntity().getGoal_seconds());};
            goal.setGoal_stat(dto.goal_stat());
            goal.setGoal_detail(dto.goal_detail());
            goal.setColor(dto.color());

        } catch(EntityNotFoundException e) {
            log.warn("목표 업데이트 실패. - dto: {}", dto);
        }

    }

    public void deleteGoal(long goalId) {
    }
}
