package com.vti.blogapp.repository;

import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface PostRepository extends JpaRepository<Post, Long>,
        JpaSpecificationExecutor<Post> {

    boolean existsByTitle (String title);

}
