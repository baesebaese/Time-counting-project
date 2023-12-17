package com.climb.timecounting.repository;

import com.climb.timecounting.domain.history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HistoryRepository extends JpaRepository<history, Integer> {
}