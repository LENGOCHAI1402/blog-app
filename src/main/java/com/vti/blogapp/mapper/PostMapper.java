package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostCreateForm;

public class PostMapper {
    public static Post map(PostCreateForm form) {
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setTitle(form.getDescription());
        post.setTitle(form.getContent());
        return post;
    }

    public static PostDto map(Post post) {
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        dto.setCreateAt(post.getCreateAt());
        dto.setUpdateAt(post.getUpdateAt());
        return dto;
    }
}

