package com.climb.timecounting.repository;

import com.climb.timecounting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends
        JpaRepository<User, String>
    , QuerydslPredicateExecutor<User>
    //, QuerydslBinderCustomizer<Quser>
{

//    @Override
//    default void customize(QuerydslBindings bindings, Quser root) {
//
//        bindings.excludeUnlistedProperties(true);
//        bindings.including(root.user_id);
//    }
}