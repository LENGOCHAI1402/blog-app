package com.vti.blogapp.sevice;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.form.PostCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {
    Page<PostDto> findAll(Pageable pageable);

    PostDto create(PostCreateForm form);

}
