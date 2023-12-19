package com.vti.blogapp.controller;

import com.vti.blogapp.Validation.CommentIdExists;
import com.vti.blogapp.Validation.PostIdExists;
import com.vti.blogapp.dto.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateForm;
import com.vti.blogapp.form.CommentFilterForm;
import com.vti.blogapp.form.CommentUpdateForm;
import com.vti.blogapp.sevice.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        return commentService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    Page<CommentDto> findAllPostId(@PathVariable("postId") @PostIdExists Long postId, Pageable pageable) {
        return commentService.findByPostId(postId, pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @RequestBody @Valid CommentCreateForm form,
            @PathVariable("postId") Long postId
    ) {
        return commentService.create(form, postId);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") @CommentIdExists Long id){
        return commentService.findById(id);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(@RequestBody @Valid @CommentIdExists CommentUpdateForm form, @PathVariable("id") Long id) {
        return commentService.update(form, id);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteCmtById(@PathVariable("id") @CommentIdExists Long id) {
        commentService.deleteCmtById(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteCmtByEmail(@PathVariable("email") String email) {
        commentService.deleteCmtByEmail(email);
    }
}
