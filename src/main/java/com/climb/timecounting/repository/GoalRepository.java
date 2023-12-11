package com.climb.timecounting.repository;

import com.climb.timecounting.domain.goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<goal, String> {

}