package com.climb.timecounting.repository;

import com.climb.timecounting.domain.QUser;
import com.climb.timecounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends
        JpaRepository<User, String>
    , QuerydslPredicateExecutor<User>
    , QuerydslBinderCustomizer<QUser>
{

    @Override
    default void customize(QuerydslBindings bindings, QUser root) {

        bindings.excludeUnlistedProperties(true);
        bindings.including(root.user_id);
    }
}