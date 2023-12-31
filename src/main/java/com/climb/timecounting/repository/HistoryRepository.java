package com.climb.timecounting.repository;

import com.climb.timecounting.domain.QHistory;
import com.climb.timecounting.domain.History;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HistoryRepository extends
        JpaRepository<History, Integer>
        , QuerydslPredicateExecutor<History>
        , QuerydslBinderCustomizer<QHistory>
{
    @Override
    default void customize(QuerydslBindings bindings, QHistory root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.goal_id, root.user_id, root.modify_date, root.write_date);
        bindings.bind(root.goal_id).first(StringExpression::eq);
        bindings.bind(root.user_id).first(StringExpression::eq);
        bindings.bind(root.modify_date).first(DateTimeExpression::eq); // like'%goal_name%'
        bindings.bind(root.write_date).first(DateTimeExpression::eq);
    }

    List<History> findAllByUser_id(String user_id);


}