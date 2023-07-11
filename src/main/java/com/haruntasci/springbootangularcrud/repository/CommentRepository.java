package com.haruntasci.springbootangularcrud.repository;

import com.haruntasci.springbootangularcrud.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserIdAndPostId(Long userId, Long postId);
}
