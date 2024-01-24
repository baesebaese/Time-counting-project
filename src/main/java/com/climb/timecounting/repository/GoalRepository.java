package com.climb.timecounting.repository;

import com.climb.timecounting.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GoalRepository extends
        JpaRepository<Goal, String>
{

}