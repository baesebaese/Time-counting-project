package com.climb.timecounting.repository;

import com.climb.timecounting.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, String> {
}