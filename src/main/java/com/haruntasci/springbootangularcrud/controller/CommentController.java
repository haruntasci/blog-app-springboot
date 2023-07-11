package com.haruntasci.springbootangularcrud.controller;

import com.haruntasci.springbootangularcrud.model.Comment;
import com.haruntasci.springbootangularcrud.requests.CommentCreateRequest;
import com.haruntasci.springbootangularcrud.requests.CommentUpdateRequest;
import com.haruntasci.springbootangularcrud.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId) {
        return commentService.getAllComments(postId, userId);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        Comment comment1 = commentService.createComment(commentCreateRequest);
        return new ResponseEntity<>(comment1, HttpStatus.CREATED);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    //Update comment
    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateCommentById(@RequestBody CommentUpdateRequest commentUpdateRequest, @PathVariable Long id) {
        return new ResponseEntity<>(commentService.updateComment(commentUpdateRequest, id), HttpStatus.OK);
    }

    //Delete comment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


}
