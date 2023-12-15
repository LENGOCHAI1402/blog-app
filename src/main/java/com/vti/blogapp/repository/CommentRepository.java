package com.vti.blogapp.repository;

import com.vti.blogapp.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // METHOD NAMES
    // findBy, deleteBy, existsBy, countBy
    // List<Comment> findByEmail(String email)
    // List<Comment> findByEmailAndName(String email, String name)
    // Page<Comment> findByPostId(Long postId, Pageable pageable);

    // @Query
//    @Query("FORM Comment WHERE postId = ?1")\
//    @Query("FORM Comment WHERE postId = :postId") HQL
//    @Query(value = "SELECT * FORM Comment WHERE post_id = :?1", nativeQuery = true)
    @Query(value = "SELECT * FROM Comment WHERE post_id = :postId", nativeQuery = true)
    Page<Comment> findByPostId(@Param(("postId")) Long postId, Pageable pageable);

    @Query("DELETE Comment WHERE email = ?1")
    @Modifying
    void deleteCmtByEmail(String email);
}
