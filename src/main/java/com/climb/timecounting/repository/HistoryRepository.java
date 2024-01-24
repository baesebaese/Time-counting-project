package com.climb.timecounting.repository;

import com.climb.timecounting.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HistoryRepository extends
        JpaRepository<History, Integer>

{
    //List<History> findAllByUser_id(String user_id);

}