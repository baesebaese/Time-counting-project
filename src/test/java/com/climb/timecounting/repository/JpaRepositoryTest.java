package com.climb.timecounting.repository;

import com.climb.timecounting.config.JpaConfig;
import com.climb.timecounting.domain.goal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
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

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        //Given

        //When
        List<goal> goals = goalRepository.findAll();

        //Then
        assertThat(goals)
                .isNotNull()
                .hasSize(0);
    }


}
