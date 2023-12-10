package com.vti.blogapp.repository;

import com.vti.blogapp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // findBy, deleteBy, existsBy, countBy
    // List<Comment> findByEmail(String email)
    // List<Comment> findByEmailAndName(String email, String name)
    Page<Comment> findByPostId(Long postId, Pageable pageable);
}
