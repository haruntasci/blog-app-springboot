package com.haruntasci.springbootangularcrud.requests;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    private String comment;
    private Boolean isConfirmed;
}
