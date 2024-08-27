package com.example.taskmanager.specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.taskmanager.model.Task;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class TaskSpecification {

    public static Specification<Task> hasDescriptionLike(String keyword) {
        return (Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            if (keyword == null || keyword.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(root.get("description"), "%" + keyword + "%");
        };
    }
}
