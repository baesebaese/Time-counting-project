package com.climb.timecounting.service;

import com.climb.timecounting.domain.goal;
import com.climb.timecounting.dto.GoalDto;
import com.climb.timecounting.dto.GoalUpdateDto;
import com.climb.timecounting.repository.GoalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.time.LocalDateTime;

@DisplayName("비즈니스 로직 - 목표")
@ExtendWith(MockitoExtension.class)
class GoalServiceTest {
    @InjectMocks private GoalService sut;
    @Mock private GoalRepository goalRepository;
    
    @DisplayName("목표를 조회하면, 목표리스트를 반환한다.")
    @Test
    void givenNothing_whenGetGoal_thenReturnsGoalList() {
        //given
        Pageable pageable = Pageable.ofSize(20);
        given(goalRepository.findAll(pageable)).willReturn(Page.empty());

        //when
        Page<GoalDto> goals = sut.getListGoals(pageable);
        //then
        assertThat(goals).isEmpty();
        then(goalRepository).should().findAll(pageable);
    }

    @DisplayName("목표를 조회하면, 목표를 반환한다.")
    @Test
    void givenGoalId_whenGetGoal_thenReturnsGoal() {
        //given
        String goalId = "1";

        //when
        GoalDto goal = sut.getGoal("1");
        //then
        assertThat(goal).isNotNull();
    }



    @DisplayName("목표 정보를 입력하면, 신규 목표를 생성한다")
    @Test
    public void givenGoalInfo_whenSavingGoal_thenSavesGoal() {
        //Given
        given(goalRepository.save(any(goal.class))).willReturn(null);

        //When
        sut.saveGoal(GoalDto.of("A0001",333, "백준 코딩테스트 순위권들기", "매일 알고리즘 세문제 풀기", 10000, 44, LocalDateTime.now(), "morendo90@gmail.com" , LocalDateTime.now(), 'I', "#121212"));
        //Then
        then(goalRepository).should().save(any(goal.class));
    }

/*
    @DisplayName("목표 ID와 수정정보를 입력하면, 목표를 수정한다")
    @Test
    public void givenGoalIdAndModifiedInfo_whenUpdatingGoal_thenUpdateGoal() {
        //Given
        given(goalRepository.save(any(goal.class))).willReturn(null);

        //When

        sut.updateGoal(GoalDto.fGoalUpdateDto.of( "백준 코딩테스트 순위권들기", "매일 알고리즘 세문제 풀기", 444, 'I',"#121212",LocalDateTime.now()));
        //Then
        then(goalRepository).should().save(any(goal.class));
    }
*/


    @DisplayName("목표 ID를 입력하면, 목표를 삭제한다")
    @Test
    public void givenGoalId_whenDeletingGoal_thenDeleteGoal() {
        //Given
        willDoNothing().given(goalRepository).delete(any(goal.class));

        //When

        sut.deleteGoal(1L);
        //Then
        then(goalRepository).should().save(any(goal.class));
    }


}