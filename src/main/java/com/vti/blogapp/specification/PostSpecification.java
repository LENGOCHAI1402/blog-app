package com.vti.blogapp.specification;

import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            var search = form.getSearch();
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var predicate = builder.like(root.get("title"), pattern);
                // search LIKE '%java%'
                predicates.add(predicate);
            }

            var minCreateDate = form.getMinCreateDate();
            if (minCreateDate !=null) {
                // create_at >= '2020-09-20 00:00:00'
                var minCreateAt = LocalDateTime.of(minCreateDate, LocalTime.MIN);
                var predicate = builder.greaterThanOrEqualTo(root.get("createAt"), minCreateAt);
                predicates.add(predicate);
            }
            var maxCreateDate = form.getMaxCreateDate();
            if (maxCreateDate != null) {
                // create_at <= '2023-09-20 00:00:00'
                var maxCreateAt = LocalDateTime.of(maxCreateDate, LocalTime.MAX);
                var predicate = builder.lessThanOrEqualTo(root.get("createAt"), maxCreateAt);
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
