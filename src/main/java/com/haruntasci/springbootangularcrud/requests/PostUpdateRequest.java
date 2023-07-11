package com.haruntasci.springbootangularcrud.requests;

import lombok.Data;

@Data
public class PostUpdateRequest {

    private String title;
    private String content;
    private Long viewCount;
    private Boolean isPublished;
}
