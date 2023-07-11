package com.haruntasci.springbootangularcrud.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentCreateRequest {
    private Long userId;
    private Long postId;
    private String comment;
    private Boolean isConfirmed;
    private LocalDate creationDate = LocalDate.now();
}
