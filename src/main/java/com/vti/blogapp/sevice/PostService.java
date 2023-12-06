package com.vti.blogapp.sevice;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.form.PostCreateForm;

public interface PostService {
    PostDto create(PostCreateForm form);

}
