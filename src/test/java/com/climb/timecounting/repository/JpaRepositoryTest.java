package com.climb.timecounting.repository;

import com.climb.timecounting.config.JpaConfig;
import com.climb.timecounting.domain.goal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaRepositoryTest {

    @Autowired private final GoalRepository goalRepository;
    @Autowired private final HistoryRepository historyRepository;
    @Autowired private final UserRepository userRepository;

    public JpaRepositoryTest(
            @Autowired GoalRepository goalRepository,
            @Autowired HistoryRepository historyRepository,
            @Autowired UserRepository userRepository
    ) {
        this.goalRepository = goalRepository;
        this.historyRepository = historyRepository;
        this.userRepository = userRepository;
    }

    @DisplayName("select test")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        //Given

        //When
        List<goal> goals = goalRepository.findAll();

        //Then
        assertThat(goals)
                .isNotNull()
                .hasSize(30);
    }

    @DisplayName("insert test")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        //Given
        long previousCount = goalRepository.count();

       //When
        goal savedGoal = goalRepository.saveAndFlush(goal.of("morendo90@gmail.com", "A00001","보라 클라이머 되기", "클라이밍으로 인스타 셀럽이 될거다", 8000, 120, 10.1));

        //Then
        assertThat(goalRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("update test")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        //Given
        goal goalData =  goalRepository.findById("1").orElseThrow();
        String updatedGoalName = "천재개발자 되기";

        goalData.setGoal_name(updatedGoalName);
        //When
        goal savedGoal = goalRepository.saveAndFlush(goalData);

        //Then
        assertThat(savedGoal).hasFieldOrPropertyWithValue("goal_name", updatedGoalName);
    }

    @DisplayName("delete test")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        //Given
        goal goalData =  goalRepository.findById("1").orElseThrow();
        long previousCount = goalRepository.count();

        //When
        goalRepository.delete(goalData);

        //Then
        assertThat(goalRepository.count()).isEqualTo(previousCount-1);
    }
}
