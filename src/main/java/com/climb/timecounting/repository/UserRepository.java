package com.climb.timecounting.repository;

import com.climb.timecounting.domain.Quser;
import com.climb.timecounting.domain.user;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends
        JpaRepository<user, String>
    , QuerydslPredicateExecutor<user>
    , QuerydslBinderCustomizer<Quser>
{

    @Override
    default void customize(QuerydslBindings bindings, Quser root) {

        bindings.excludeUnlistedProperties(true);
        bindings.including(root.user_id);
    }
}