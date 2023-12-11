package com.climb.timecounting.repository;

import com.climb.timecounting.domain.history;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<history, Integer> {
}