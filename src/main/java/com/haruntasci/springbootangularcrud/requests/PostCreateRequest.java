package com.haruntasci.springbootangularcrud.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostCreateRequest {

    private Long userId;
    private Long categoryId;
    private String title;
    private String content;
    private Long viewCount;
    private LocalDate creationDate = LocalDate.now();
    private Boolean isPublished;

}
