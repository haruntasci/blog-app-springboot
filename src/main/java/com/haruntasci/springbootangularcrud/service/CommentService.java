package com.haruntasci.springbootangularcrud.service;

import com.haruntasci.springbootangularcrud.model.Comment;
import com.haruntasci.springbootangularcrud.model.Post;
import com.haruntasci.springbootangularcrud.model.User;
import com.haruntasci.springbootangularcrud.repository.CommentRepository;
import com.haruntasci.springbootangularcrud.requests.CommentCreateRequest;
import com.haruntasci.springbootangularcrud.requests.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;


    public List<Comment> getAllComments(Optional<Long> postId, Optional<Long> userId) {

        if (postId.isPresent() && userId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(postId.get(), userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        }
        return commentRepository.findAll();
    }

    public Comment createComment(CommentCreateRequest newCommentRequest) {

        User user = userService.getUserById(newCommentRequest.getUserId());
        Post post = postService.getPostById(newCommentRequest.getPostId());
        if (user == null || post == null) {
            return null;
        }
        Comment toSave = new Comment();
        toSave.setComment(newCommentRequest.getComment());
        toSave.setIsConfirmed(newCommentRequest.getIsConfirmed());
        toSave.setCreationDate(newCommentRequest.getCreationDate());
        toSave.setUser(user);
        toSave.setPost(post);
        return commentRepository.save(toSave);
    }


    public List<Comment> getComments() {
        return (List<Comment>) commentRepository.findAll();
    }


    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).get();
    }


    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }


    public Comment updateComment(CommentUpdateRequest comment, Long id) {
        Comment toUpdate = commentRepository.findById(id).get();
        toUpdate.setComment(comment.getComment());
        toUpdate.setIsConfirmed(comment.getIsConfirmed());
        return commentRepository.save(toUpdate);
    }
}
