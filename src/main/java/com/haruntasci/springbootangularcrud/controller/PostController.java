package com.haruntasci.springbootangularcrud.controller;

import com.haruntasci.springbootangularcrud.model.Post;
import com.haruntasci.springbootangularcrud.requests.PostCreateRequest;
import com.haruntasci.springbootangularcrud.requests.PostUpdateRequest;
import com.haruntasci.springbootangularcrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> categoryId) {
        return postService.getAllPosts(userId, categoryId);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> createPost(@RequestBody PostCreateRequest post) {
        Post post1 = postService.createPost(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    //Update post
    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePostById(@RequestBody PostUpdateRequest post, @PathVariable Long id) {
        return new ResponseEntity<>(postService.updatePost(post, id), HttpStatus.OK);
    }

    //Delete post
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


}
