package com.climb.timecounting.repository;

import com.climb.timecounting.domain.Qgoal;
import com.climb.timecounting.domain.goal;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GoalRepository extends
        JpaRepository<goal, String>
        , QuerydslPredicateExecutor<goal>
        , QuerydslBinderCustomizer<Qgoal>
{

    @Override
    default void customize(QuerydslBindings bindings, Qgoal root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.goal_id, root.user_id, root.goal_name, root.modify_date, root.write_date);
        bindings.bind(root.goal_name).first(StringExpression::containsIgnoreCase); // like'%goal_name%'
        bindings.bind(root.goal_id).first(StringExpression::eq);
        bindings.bind(root.user_id).first(StringExpression::eq);
        bindings.bind(root.modify_date).first(DateTimeExpression::eq); // like'%goal_name%'
        bindings.bind(root.write_date).first(DateTimeExpression::eq);
    }
}